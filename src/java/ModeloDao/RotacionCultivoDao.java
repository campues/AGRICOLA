package ModeloDao;

import Control.Variables;
import Modelo.RotacionCultivo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RotacionCultivoDao {
    //variables para la conexion 

    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public RotacionCultivoDao() {
    }

    //Constuctor de la clase DAO 
    public RotacionCultivoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS

    public boolean insertarRotacion(RotacionCultivo ro) throws SQLException {
        String sql = "INSERT INTO rotacioncultivo (pk_rotacionCultivo,anio,nomCultivo,observacion, fk_cultivoc)"
                + " VALUES (?,?,?,?,?)";
        System.out.println(ro.getAnio());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, ro.getAnio());
        statement.setString(3, ro.getNombre());
        statement.setString(4, ro.getObservacion());
        statement.setString(5, ro.getFk_cultivoc());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar ID LOTE
    public List<RotacionCultivo> listarRotacionID() throws SQLException {

        List<RotacionCultivo> listarRo = new ArrayList<RotacionCultivo>();
        String sql = "select * from rotacioncultivo WHERE fk_cultivoc='" + global.idCultivo + "' ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            RotacionCultivo rot = new RotacionCultivo();
            rot.setPk_rotacionCultivo(res.getInt("pk_rotacionCultivo"));
            rot.setAnio(res.getString("anio"));
            rot.setNombre(res.getString("nomCultivo"));
            rot.setObservacion(res.getString("observacion"));
            rot.setFk_cultivoc(res.getString("fk_cultivoc"));

            listarRo.add(rot);
        }
        con.desconectar();
        return listarRo;
    }

    // Obtener por PK
    public RotacionCultivo obtenerPorId(int pk) throws SQLException {
        RotacionCultivo rotacion = null;
        String sql = "SELECT * FROM rotacioncultivo WHERE pk_rotacionCultivo=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            rotacion = new RotacionCultivo(
                    res.getInt("pk_rotacionCultivo"),
                    res.getString("anio"),
                    res.getString("nomCultivo"),
                    res.getString("observacion"),
                    res.getString("fk_cultivoc")
            );
        }
        res.close();
        con.desconectar();
        return rotacion;
    }

    //eliminar
    public boolean eliminarRotacion(RotacionCultivo rot) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM rotacioncultivo WHERE pk_rotacionCultivo=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, rot.getPk_rotacionCultivo());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
