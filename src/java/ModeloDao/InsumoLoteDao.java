package ModeloDao;

import Control.Variables;
import Modelo.InsumoLote;
import Modelo.RotacionCultivo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InsumoLoteDao {
    //variables para la conexion 

    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public InsumoLoteDao() {
    }

    //Constuctor de la clase DAO 
    public InsumoLoteDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS

    public boolean insertarInsumo(InsumoLote ins) throws SQLException {
        String sql = "INSERT INTO insumoslotes (pk_insumo,tipoInsumo,nomInsumo,cantidad, fk_lotei)"
                + " VALUES (?,?,?,?,?)";
        System.out.println(ins.getTipoInsumo());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, ins.getTipoInsumo());
        statement.setString(3, ins.getNomInsumo());
        statement.setString(4, ins.getCantidad());
        statement.setString(5, ins.getFk_lotei());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar ID LOTE
    public List<InsumoLote> listarRotacionID() throws SQLException {

        List<InsumoLote> listarInsumo = new ArrayList<InsumoLote>();
        String sql = "select * from insumoslotes WHERE fk_lotei='" + global.idLote + "' ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            InsumoLote in = new InsumoLote();
            in.setPk_insumo(res.getInt("pk_insumo"));
            in.setTipoInsumo(res.getString("tipoInsumo"));
            in.setNomInsumo(res.getString("nomInsumo"));
            in.setCantidad(res.getString("cantidad"));
            in.setFk_lotei(res.getString("fk_lotei"));
            listarInsumo.add(in);
        }
        con.desconectar();
        return listarInsumo;
    }

    // Obtener por PK
    public InsumoLote obtenerPorId(int pk) throws SQLException {
        InsumoLote insumo = null;
        String sql = "SELECT * FROM insumoslotes WHERE pk_insumo= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            insumo = new InsumoLote(
                    res.getInt("pk_insumo"),
                    res.getString("tipoInsumo"),
                    res.getString("nomInsumo"),
                    res.getString("cantidad"),
                    res.getString("fk_lotei")
            );
        }
        res.close();
        con.desconectar();
        return insumo;
    }

    //eliminar
    public boolean eliminarInsumo(InsumoLote ins) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM insumoslotes WHERE pk_insumo=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ins.getPk_insumo());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
