package ModeloDao;

import Control.Variables;
import Modelo.ProdAplicados;
import Modelo.RotacionCultivo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProAplicadosDao {
    //variables para la conexion 

    Variables global = new Variables();
    private Conexion con;
    private Connection connection;

    public ProAplicadosDao() {
    }

    //Constuctor de la clase DAO 
    public ProAplicadosDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS
    public boolean insertarProduc(ProdAplicados pro) throws SQLException {
        String sql = "INSERT INTO prodaplicados (tipoProducto,nomProducto,funcionalidad,cantConcentracion,observacion,"
                + "fecha,asInstalacion,asInsumo,origen, fk_cultivo)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        System.out.println(pro.getTipoProducto());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pro.getTipoProducto());
        statement.setString(2, pro.getNomProducto());
        statement.setString(3, pro.getFuncionalidad());
        statement.setString(4, pro.getCanConsertracion());
        statement.setString(5, pro.getObservacion());
        statement.setString(6, pro.getFecha());
        statement.setString(7, pro.getAsInstalacion());
        statement.setString(8, pro.getAsInsumo());
        statement.setString(9, pro.getOrigen());
        statement.setString(10, pro.getFk_cultivo());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar ID LOTE
    public List<ProdAplicados> listarProdID() throws SQLException {

        List<ProdAplicados> listarPro = new ArrayList<ProdAplicados>();
        String sql = "select * from prodaplicados WHERE fk_cultivo='" + global.idCultivo + "' ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            ProdAplicados prod = new ProdAplicados();
            prod.setPk_proAplicados(res.getInt("pk_proAplicados"));
            prod.setTipoProducto(res.getString("tipoProducto"));
            prod.setNomProducto(res.getString("nomProducto"));
            prod.setFuncionalidad(res.getString("funcionalidad"));
            prod.setCanConsertracion(res.getString("cantConcentracion"));
            prod.setObservacion(res.getString("observacion"));
            prod.setFecha(res.getString("fecha"));
            prod.setAsInstalacion(res.getString("asInstalacion"));
            prod.setAsInsumo(res.getString("asInsumo"));
            prod.setOrigen(res.getString("origen"));
            prod.setFk_cultivo(res.getString("fk_cultivo"));

            listarPro.add(prod);
        }
        con.desconectar();
        return listarPro;
    }

    // Obtener por PK
    public ProdAplicados obtenerPorId(int pk) throws SQLException {
        ProdAplicados productos = null;
        String sql = "SELECT * FROM prodaplicados WHERE pk_proAplicados= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            productos = new ProdAplicados(
                    res.getInt("pk_proAplicados"),
                    res.getString("tipoProducto"),
                    res.getString("nomProducto"),
                    res.getString("funcionalidad"),
                    res.getString("cantConcentracion"),
                    res.getString("observacion"),
                    res.getString("fecha"),
                    res.getString("asInstalacion"),
                    res.getString("asInsumo"),
                    res.getString("origen"),
                    res.getString("fk_cultivo")
            );
        }
        res.close();
        con.desconectar();
        return productos;
    }

    //eliminar
    public boolean eliminarProd(ProdAplicados prod) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM prodaplicados WHERE pk_proAplicados=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, prod.getPk_proAplicados());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
