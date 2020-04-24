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

    public EmpleadoDao() {
    }

    //Constuctor de la clase DAO 
    public EmpleadoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS
    public Empleado validar(String user, String dni) throws SQLException {
        Empleado emple = null;
        String sql = "select * from empleado where usuario=? and contrasena=?";

        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement stament = connection.prepareStatement(sql);
        stament.setString(1, user);
        stament.setString(2, dni);
        ResultSet res = stament.executeQuery();
        if (res.next()) {
            emple = new Empleado(
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
        return emple;
    }

    // Insertar Empleado
    public boolean insertarEm(Empleado em) throws SQLException {
        String sql = "INSERT INTO empleado (pk_empleado, nombre, apellido, usuario, contrasena, tipo)"
                + " VALUES (?, ?, ?,?,?,?)";
        System.out.println(em.getNombre());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, em.getNombre());
        statement.setString(3, em.getApellido());
        statement.setString(4, em.getUsuario());
        statement.setString(5, em.getContrasena());
        statement.setString(6, em.getTipo());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos los empleados
    public List<Empleado> listarEmpleados() throws SQLException {
        List<Empleado> listarEm = new ArrayList<Empleado>();
        String sql = "SELECT * FROM empleado ";
        //String sql = "SELECT  pk_empleado,nombre,apellido, usuario, contrasena, tipo "
        //+"FROM empleado JOIN tipo_empleado ON tipo_empleado.pk_tipo = empleado.fk_tipo; ";
       
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int pk = resulSet.getInt("pk_empleado");
            String nom = resulSet.getString("nombre");
            String ape = resulSet.getString("apellido");
            String user = resulSet.getString("usuario");
            String pass = resulSet.getString("contrasena");
            String fk = resulSet.getString("tipo");
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
    public boolean eliminarEm(int pk) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM empleado WHERE pk_empleado="+pk;
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
