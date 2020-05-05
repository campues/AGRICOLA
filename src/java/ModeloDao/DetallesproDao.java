package ModeloDao;

import Modelo.Detallespro;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DetallesproDao {
    //variables para la conexion 

    private Conexion con;
    private Connection connection;

    public DetallesproDao() {
    }

    //Constuctor de la clase DAO 
    public DetallesproDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    // Insertar Empleado

    public boolean insertarDetalle(Detallespro det) throws SQLException {
        String sql = " INSERT INTO detallespro (pk_detallesPro,fechaEntrega,cantidad,fk_agricultor,fk_producto,fk_empleado)"
                + " VALUES (?,?,?,?,?,?)";
        System.out.println(det.getCantidad());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, det.getFechaEntrega());
        statement.setString(3, det.getCantidad());
        statement.setString(4, det.getFk_agricutor());
        statement.setString(5, det.getFk_producto());
        statement.setString(6, det.getFk_empleado());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // actualizar
    public boolean actualizar(Detallespro det) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE detallespro SET fechaEntrega=?,cantidad=?,fk_agricultor=?,fk_producto=?, fk_empleado=? "
                + "WHERE pk_detallesPro=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, det.getFechaEntrega());
        statement.setString(2, det.getCantidad());
        statement.setString(3, det.getFk_agricutor());
        statement.setString(4, det.getFk_producto());
        statement.setString(5, det.getFk_empleado());
        statement.setInt(6, det.getPk_detallesPro());
        System.out.println(det.getCantidad());

        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

    // listar todos los empleados
    public List<Detallespro> listarDetalles() throws SQLException {

        List<Detallespro> listarDeta = new ArrayList<Detallespro>();
        String sql = " SELECT pk_detallesPro,fechaEntrega,cantidad,nombre1,nomInsumos,nombre FROM detallespro "
                + " JOIN agricultor on agricultor.pk_agricultor=detallespro.fk_agricultor "
                + " JOIN producto on producto.pk_producto=detallespro.fk_producto "
                + " JOIN empleado on empleado.pk_empleado=detallespro.fk_empleado ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement stat = connection.createStatement();
        ResultSet re = stat.executeQuery(sql);

        while (re.next()) {
            int pk = re.getInt("pk_detallesPro");
            String fecha = re.getString("fechaEntrega");
            String cantidad = re.getString("cantidad");
            String fk_agri = re.getString("nombre1");
            String fk_pro = re.getString("nomInsumos");
            String fk_emple = re.getString("nombre");
            Detallespro detalle = new Detallespro(pk, fecha, cantidad, fk_agri, fk_pro, fk_emple);
            listarDeta.add(detalle);
        }
        con.desconectar();
        return listarDeta;
    }

    // listar todos los empleados
    public List<Detallespro> listarDetalleAgri(String nombreAgri) throws SQLException {

        List<Detallespro> listarDeta = new ArrayList<Detallespro>();
        String sql = " SELECT pk_detallesPro,fechaEntrega,cantidad,nombre1,nomInsumos,nombre FROM detallespro "
                + " JOIN agricultor on agricultor.pk_agricultor=detallespro.fk_agricultor "
                + " JOIN producto on producto.pk_producto=detallespro.fk_producto "
                + " JOIN empleado on empleado.pk_empleado=detallespro.fk_empleado WHERE nombre1=? ";

        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombreAgri);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            Detallespro de = new Detallespro();
            de.setPk_detallesPro(res.getInt(1));
            de.setFechaEntrega(res.getString(2));
            de.setCantidad(res.getString(3));
            de.setFk_agricutor(res.getString(4));
            de.setFk_producto(res.getString(5));
            de.setFk_empleado(res.getString(6));

            listarDeta.add(de);
        }
        con.desconectar();
        return listarDeta;
    }

    // Obtener por PK
    public Detallespro obtenerPorId(int pk) throws SQLException {
        Detallespro detalles = null;
        String sql = "SELECT * FROM detallespro WHERE pk_detallesPro= ? ";

        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            detalles = new Detallespro(
                    res.getInt("pk_detallesPro"),
                    res.getString("fechaEntrega"),
                    res.getString("cantidad"),
                    res.getString("fk_agricultor"),
                    res.getString("fk_producto"),
                    res.getString("fk_empleado")
            );
        }
        res.close();
        con.desconectar();
        return detalles;
    }

    //eliminar
    public boolean eliminarDe(Detallespro de) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM detallespro WHERE pk_detallesPro=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, de.getPk_detallesPro());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
