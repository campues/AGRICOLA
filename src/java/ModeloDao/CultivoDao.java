package ModeloDao;

import Modelo.Cultivo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CultivoDao {

    private Conexion con;
    private Connection connection;

    public CultivoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // listar todos las asociaciones
    public List<Cultivo> listarCultivo() throws SQLException {

        List<Cultivo> listarCul = new ArrayList<Cultivo>();
        String sql = "SELECT * FROM cultivo";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_cultivo");
            String nom = res.getString("nom_cultivo");
            String are = res.getString("area");
            String den = res.getString("densidadSiembra");
            String numP = res.getString("numPlantas");
            String fec = res.getString("fecha_insumo");
            String esC = res.getString("es_cosecha");
            String est = res.getString("estatus");
            String anio1 = res.getString("anio_organica");
            String anio2 = res.getString("anio_inspeccion");
            int fkV = res.getInt("fk_visitass");
            Cultivo cul = new Cultivo(pk, nom, are, den, numP, fec, esC, est, anio1, anio2, fkV);
            listarCul.add(cul);
        }
        con.desconectar();
        return listarCul;
    }

    // Obtener por PK
    public Cultivo obtenerPorId(int pk_cul) throws SQLException {
        Cultivo cultivo = null;

        String sql = "SELECT * FROM cultivo WHERE pk_cultivo= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_cul);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            cultivo = new Cultivo(
                    res.getInt("pk_cultivo"),
                    res.getString("nom_cultivo"),
                    res.getString("area"),
                    res.getString("densidadSiembra"),
                    res.getString("numPlantas"),
                    res.getString("fecha_insumo"),
                    res.getString("es_cosecha"),
                    res.getString("estatus"),
                    res.getString("anio_organica"),
                    res.getString("anio_inspeccion"),
                    res.getInt("fk_visitass")
            );
        }
        res.close();
        con.desconectar();
        return cultivo;
    }

    //eliminar
    public boolean eliminarCult(Cultivo culti) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM cultivo WHERE pk_cultivo=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, culti.getPk_cultivo());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }
}
