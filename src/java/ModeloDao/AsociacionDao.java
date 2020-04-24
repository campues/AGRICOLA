package ModeloDao;

import Modelo.Asociacion;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AsociacionDao {

    private Conexion con;
    private Connection connection;

    public AsociacionDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public AsociacionDao() {
    }

    // Insertar Empleado
    public boolean insertarAso(Asociacion as) throws SQLException {
        String sql = "INSERT INTO asociacion (pk_asociacion, nom_asociacion, direccion, telefono) VALUES (?,?,?,?)";
        System.out.println(as.getNombre());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, as.getNombre());
        statement.setString(3, as.getDireccion());
        statement.setString(4, as.getTelefono());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos las asociaciones
    public List listarAsociacion() throws SQLException {
        List<Asociacion> listarAso = new ArrayList<Asociacion>();
        String sql = "SELECT * FROM asociacion";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_asociacion");
            String nom = res.getString("nom_asociacion");
            String dir = res.getString("direccion");
            String tel = res.getString("telefono");
            Asociacion asoc = new Asociacion(pk, nom, dir, tel);
            listarAso.add(asoc);
        }
        con.desconectar();
        return listarAso;
    }

    // listar Nombre
    public List<Asociacion> listarNom(String nomf) throws SQLException {
        List<Asociacion> listarAso = new ArrayList<Asociacion>();
        String sql = "SELECT * FROM asociacion where nom_asociacion= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nomf);
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_asociacion");
            String nomb = res.getString("nom_asociacion");
            String dir = res.getString("direccion");
            String tel = res.getString("telefono");
            Asociacion asociacion = new Asociacion(pk, nomb, dir, tel);
            listarAso.add(asociacion);
        }
        con.desconectar();
        return listarAso;
    }

    // Obtener por PK
    public Asociacion obtenerPorId(int pk_asociacion) throws SQLException {
        Asociacion asociacion = null;

        String sql = "SELECT * FROM asociacion WHERE pk_asociacion= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_asociacion);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            asociacion = new Asociacion(
                    res.getInt("pk_asociacion"),
                    res.getString("nom_asociacion"),
                    res.getString("direccion"),
                    res.getString("telefono")
            );
        }
        res.close();
        con.desconectar();
        return asociacion;
    }

    // actualizar
    public boolean actualizar(Asociacion as) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE asociacion SET nom_asociacion=?,direccion=?,telefono=? WHERE pk_asociacion=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, as.getNombre());
        statement.setString(2, as.getDireccion());
        statement.setString(3, as.getTelefono());
        statement.setInt(4, as.getPk_asociacion());
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

    //eliminar
    public boolean eliminarAso(Asociacion as) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM asociacion WHERE pk_asociacion=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, as.getPk_asociacion());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
