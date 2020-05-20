package ModeloDao;

import Modelo.Agricultor;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AgricultorDao {

    private Conexion con;
    private Connection connection;

    public AgricultorDao() {
    }
    
    
    public AgricultorDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // listar todos Agricultores
    public List<Agricultor> listarAgricultor() throws SQLException {

        List<Agricultor> listarAgri = new ArrayList<Agricultor>();
        String sql = "SELECT * FROM agricultor";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_agricultor");
            String nom1 = res.getString("nombre1");
            String nom2 = res.getString("nombre2");
            String ape1 = res.getString("apellido1");
            String ape2 = res.getString("apellido2");
            String ced = res.getString("cedula");
            String dir = res.getString("direccion");
            String tel = res.getString("telefono");
            String fec = res.getString("fechaAfiliacion");
            String est = res.getString("estatus");
            String lid = res.getString("liderAsociacion");
            Agricultor agricultor = new Agricultor(pk, nom1, nom2, ape1, ape2, ced, dir, tel, fec, est, lid);
            listarAgri.add(agricultor);
        }
        con.desconectar();
        return listarAgri;
    }
   
    
  // LISTAR POR BUSQUEDA
    public Agricultor buscarCed(String cedula) throws SQLException {
        Agricultor agricultor = null;
        String sql = "SELECT * FROM agricultor WHERE cedula= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cedula);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            agricultor = new Agricultor(
                    res.getInt("pk_agricultor"),
                    res.getString("nombre1"),
                    res.getString("nombre2"),
                    res.getString("apellido1"),
                    res.getString("apellido2"),
                    res.getString("cedula"),
                    res.getString("direccion"),
                    res.getString("telefono"),
                    res.getString("fechaAfiliacion"),
                    res.getString("estatus"),
                    res.getString("liderAsociacion")
            );
        }
        res.close();
        con.desconectar();
        return agricultor;
    }
    // Insertar Empleado
    public boolean insertarAgr(Agricultor agri) throws SQLException {
        String sql = "INSERT INTO agricultor (pk_agricultor, nombre1, nombre2, apellido1, apellido2, cedula, "
                + "direccion, telefono, fechaAfiliacion, estatus, liderAsociacion) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(agri.getNombre1());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, agri.getNombre1());
        statement.setString(3, agri.getNombre2());
        statement.setString(4, agri.getApellido1());
        statement.setString(5, agri.getApellido2());
        statement.setString(6, agri.getCedula());
        statement.setString(7, agri.getDireccion());
        statement.setString(8, agri.getTelefono());
        statement.setString(9, agri.getFechaAfiliacion());
        statement.setString(10, agri.getEstatus());
        statement.setString(11, agri.getLiderAsociacion());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }
// actualizar

    public boolean actualizarAg(Agricultor ag) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE agricultor SET nombre1=?,nombre2=?,apellido1=?,apellido2=?,cedula=?, "
                + " direccion=?,telefono=?,fechaAfiliacion=?,estatus=?,liderAsociacion=? "
                + "  WHERE pk_agricultor=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, ag.getNombre1());
        statement.setString(2, ag.getNombre2());
        statement.setString(3, ag.getApellido1());
        statement.setString(4, ag.getApellido2());
        statement.setString(5, ag.getCedula());
        statement.setString(6, ag.getDireccion());
        statement.setString(7, ag.getTelefono());
        statement.setString(8, ag.getFechaAfiliacion());
        statement.setString(9, ag.getEstatus());
        statement.setString(10, ag.getLiderAsociacion());
        statement.setInt(11, ag.getPk_agricultor());

        System.out.println(ag.getNombre1());
        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

    
    // Obtener por PK
    public Agricultor obtenerPorId(int pk_agricultor) throws SQLException {
        Agricultor agricultor = null;
        String sql = "SELECT * FROM agricultor WHERE pk_agricultor= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_agricultor);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            agricultor = new Agricultor(
                    res.getInt("pk_agricultor"),
                    res.getString("nombre1"),
                    res.getString("nombre2"),
                    res.getString("apellido1"),
                    res.getString("apellido2"),
                    res.getString("cedula"),
                    res.getString("direccion"),
                    res.getString("telefono"),
                    res.getString("fechaAfiliacion"),
                    res.getString("estatus"),
                    res.getString("liderAsociacion")
            );
        }
        res.close();
        con.desconectar();
        return agricultor;

    }
   
    // listar todos las asociaciones
    public List<Agricultor> listarAgriCed(String cedula) throws SQLException {
        List<Agricultor> listarAgri = new ArrayList<Agricultor>();
        String sql = "SELECT * FROM agricultor WHERE cedula= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cedula);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            int pk = res.getInt("pk_agricultor");
            String nom1 = res.getString("nombre1");
            String nom2 = res.getString("nombre2");
            String ape1 = res.getString("apellido1");
            String ape2 = res.getString("apellido2");
            String ced = res.getString("cedula");
            String dir = res.getString("direccion");
            String tel = res.getString("telefono");
            String fec = res.getString("fechaAfiliacion");
            String est = res.getString("estatus");
            String lid = res.getString("liderAsociacion");
            Agricultor agricultor = new Agricultor(pk, nom1, nom2, ape1, ape2, ced, dir, tel, fec, est, lid);
            listarAgri.add(agricultor);
        }
        con.desconectar();
        return listarAgri;
    }

    //eliminar
    public boolean eliminarAgri(Agricultor agr) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM agricultor WHERE pk_agricultor=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, agr.getPk_agricultor());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }
}
