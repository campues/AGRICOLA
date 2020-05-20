package ModeloDao;

import Modelo.Empleado;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {
    //variables para la conexion 

    private Conexion con;
    private Connection connection;
    private ResultSet rs = null;//contiene los resultados de una consulta SQL
    private PreparedStatement ps = null;

    public EmpleadoDao() {
    }

    //Constuctor de la clase DAO 
    public EmpleadoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    

//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS
    public Empleado validar(String user, String dni) throws SQLException {
        String sql = "select * from empleado where usuario=? and contrasena=?";
        Empleado emple = null;
        con.conectar();
        connection = con.getJdbcConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, dni);
        rs = ps.executeQuery();
        if (rs.next()) {
            emple = new Empleado(
                    rs.getInt("pk_empleado"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("usuario"),
                    rs.getString("contrasena"),
                    rs.getString("tipo")
            );
        }
        rs.close();
        con.desconectar();
        return emple;
    }

    // Insertar Empleado
    public boolean insertarEm(Empleado em) throws SQLException {
        String sql = "INSERT INTO empleado (nombre, apellido, usuario, contrasena, tipo)"
                + " VALUES (?, ?,?,?,?)";
        System.out.println(em.getNombre());
        con.conectar();
        connection = con.getJdbcConnection();
        ps = connection.prepareStatement(sql);
        ps.setString(1, em.getNombre());
        ps.setString(2, em.getApellido());
        ps.setString(3, em.getUsuario());
        ps.setString(4, em.getContrasena());
        ps.setString(5, em.getTipo());

        boolean rowInserted = ps.executeUpdate() > 0;
        ps.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos los empleados
    public List<Empleado> listarEmpleados() throws SQLException {
        List<Empleado> listarEm = new ArrayList<Empleado>();
        String sql = "SELECT * FROM empleado ";
        con.conectar();
        connection = con.getJdbcConnection();
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            int pk = rs.getInt("pk_empleado");
            String nom = rs.getString("nombre");
            String ape = rs.getString("apellido");
            String user = rs.getString("usuario");
            String pass = rs.getString("contrasena");
            String fk = rs.getString("tipo");
            Empleado empleado = new Empleado(pk, nom, ape, user, pass, fk);
            listarEm.add(empleado);
        }
        con.desconectar();
        return listarEm;
    }

    // LISTAR POR BUSQUEDA 
    public List<Empleado> buscarNom(String nombre) throws SQLException {
        List<Empleado> listarEm = new ArrayList<Empleado>();
        String sql = "SELECT * FROM empleado WHERE nombre= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombre);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            Empleado em = new Empleado();
            em.setPk_empleado(res.getInt(1));
            em.setNombre(res.getString(2));
            em.setApellido(res.getString(3));
            em.setUsuario(res.getString(4));
            em.setContrasena(res.getString(5));
            em.setTipo(res.getString(6));
            listarEm.add(em);
        }
        res.close();
        con.desconectar();
        return listarEm;
    }

    // Obtener por PK
    public Empleado obtenerPorId(int pk_empleado) throws SQLException {
        Empleado empleado = null;
        String sql = "SELECT * FROM empleado WHERE pk_empleado= ? ";
        // String sql2 = "SELECT  pk_empleado,nombre,apellido, usuario, contrasena, tipo "
        //       + "FROM empleado JOIN tipo_empleado ON tipo_empleado.pk_tipo = empleado.fk_tipo "
        //     + "WHERE pk_empleado=?";

        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_empleado);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            empleado = new Empleado(
                    res.getInt("pk_empleado"),
                    res.getString("nombre"),
                    res.getString("apellido"),
                    res.getString("usuario"),
                    res.getString("contrasena"),
                    res.getString("tipo")
            );
        }
        res.close();
        con.desconectar();
        return empleado;
    }

    // actualizar
    public boolean actualizar(Empleado em) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE empleado SET nombre=?,apellido=?,usuario=?,contrasena=?, tipo=? WHERE pk_empleado=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, em.getNombre());
        statement.setString(2, em.getApellido());
        statement.setString(3, em.getUsuario());
        statement.setString(4, em.getContrasena());
        statement.setString(5, em.getTipo());
        statement.setInt(6, em.getPk_empleado());
        System.out.println(em.getNombre());

        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

    //eliminar
    public boolean eliminarEm(Empleado pk) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM empleado WHERE pk_empleado=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk.getPk_empleado());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
