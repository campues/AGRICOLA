package ModeloDao;

import Control.Variables;
import Modelo.Empleado;
import Modelo.Herramientas;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class HerramientasDao {
    //variables para la conexion 
    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public HerramientasDao() {
    }

    //Constuctor de la clase DAO 
    public HerramientasDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS
    // Insertar Empleado

    public boolean insertarHerra(Herramientas h) throws SQLException {
        String sql = "INSERT INTO herramientas (pk_herramientas, nomHerramienta, cantidad, fk_loteh)"
                + " VALUES (?,?,?,?)";
        System.out.println(h.getNomHerramienta());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, h.getNomHerramienta());
        statement.setString(3, h.getCantidad());
        statement.setString(4, h.getFk_loteh());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos los empleados
    public List<Herramientas> listarHerramientas() throws SQLException {

        List<Herramientas> listarHe = new ArrayList<Herramientas>();
        String sql = "SELECT * FROM herramientas ";
        //String sql = "SELECT  pk_empleado,nombre,apellido, usuario, contrasena, tipo "
        //+"FROM empleado JOIN tipo_empleado ON tipo_empleado.pk_tipo = empleado.fk_tipo; ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            Herramientas her = new Herramientas();
            her.setPk_herramientas(res.getInt("pk_herramientas"));
            her.setNomHerramienta(res.getString("nomHerramienta"));
            her.setCantidad(res.getString("cantidad"));
            her.setFk_loteh(res.getString("fk_loteh"));
            listarHe.add(her);
        }
        con.desconectar();
        return listarHe;
    }
    // listar todos los empleados

    public List<Herramientas> listarHerramientasID() throws SQLException {

        List<Herramientas> listarHe = new ArrayList<Herramientas>();
        String sql = "select * from herramientas WHERE fk_loteh='" + global.idLote + "' ";
      
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            Herramientas her = new Herramientas();
            her.setPk_herramientas(res.getInt("pk_herramientas"));
            her.setNomHerramienta(res.getString("nomHerramienta"));
            her.setCantidad(res.getString("cantidad"));
            her.setFk_loteh(res.getString("fk_loteh"));
            listarHe.add(her);
        }
        con.desconectar();
        return listarHe;
    }

    // Obtener por PK
    public Herramientas obtenerPorId(int pk) throws SQLException {
        Herramientas herramienta = null;
        String sql = "SELECT * FROM herramientas WHERE pk_herramientas= ? ";
      
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            herramienta = new Herramientas(
                    res.getInt("pk_herramientas"),
                    res.getString("nomHerramienta"),
                    res.getString("cantidad"),
                    res.getString("fk_loteh")
            );
        }
        res.close();
        con.desconectar();
        return herramienta;
    }

    //eliminar
    public boolean eliminarHerr(Herramientas he) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM herramientas WHERE pk_herramientas=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, he.getPk_herramientas());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
