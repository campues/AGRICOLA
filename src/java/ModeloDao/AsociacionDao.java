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
        String sql = "INSERT INTO asociacion (pk_asociacion,nomAsociacion,ruc,responsable,geolocalizacion, "
                + "direccion,telefono,parroquia,fk_provinciaa) VALUES (?,?,?,?,?,?,?,?,?)";
        System.out.println(as.getNomAsociacion());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, as.getNomAsociacion());
        statement.setString(3, as.getRuc());
        statement.setString(4, as.getResponsable());
        statement.setString(5, as.getGeolocalizacion());
        statement.setString(6, as.getDireccion());
        statement.setString(7, as.getTelefono());
        statement.setString(8, as.getParroquia());
        statement.setString(9, as.getFk_provinciaa());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos las asociaciones
    public List listarAsociacion() throws SQLException {
        List<Asociacion> listarAso = new ArrayList<Asociacion>();
        String sql = "select pk_asociacion,nomAsociacion,ruc,responsable,geolocalizacion, "
                + "direccion,telefono,parroquia,nomProvincia from asociacion "
                + "JOIN provincia ON provincia.pk_provincia=asociacion.fk_provinciaa";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            Asociacion aso = new Asociacion();
            aso.setPk_asociacion(res.getInt("pk_asociacion"));
            aso.setNomAsociacion(res.getString("nomAsociacion"));
            aso.setRuc(res.getString("ruc"));
            aso.setFk_provinciaa(res.getString("nomProvincia"));
            aso.setTelefono(res.getString("telefono"));
            listarAso.add(aso);
        }
        con.desconectar();
        return listarAso;
    }

    // listar Nombre
    public List<Asociacion> BuscarNombre(String nombre) throws SQLException {
        List<Asociacion> listarAsoc = new ArrayList<Asociacion>();
        String sql = "SELECT pk_asociacion,nomAsociacion,ruc,nomProvincia,telefono from asociacion "
                + "join provincia on provincia.pk_provincia=asociacion.fk_provinciaa"
                + " WHERE nomAsociacion=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nombre);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            Asociacion as = new Asociacion();
            as.setPk_asociacion(res.getInt(1));
            as.setNomAsociacion(res.getString(2));
            as.setRuc(res.getString(3));
            as.setFk_provinciaa(res.getString(4));
            as.setTelefono(res.getString(5));
            listarAsoc.add(as);
        }
        res.close();
        con.desconectar();
        return listarAsoc;
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
                    res.getString("nomAsociacion"),
                    res.getString("ruc"),
                    res.getString("responsable"),
                    res.getString("geolocalizacion"),
                    res.getString("direccion"),
                    res.getString("telefono"),
                    res.getString("parroquia"),
                    res.getString("fk_provinciaa")
            );
        }
        res.close();
        con.desconectar();
        return asociacion;
    }

    // actualizar
    public boolean actualizar(Asociacion as) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE asociacion SET nomAsociacion=?,ruc=?,responsable=?,geolocalizacion=?,"
                + "direccion=?,telefono=?,parroquia=?,fk_provinciaa=? WHERE pk_asociacion=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, as.getNomAsociacion());
        statement.setString(2, as.getRuc());
        statement.setString(3, as.getResponsable());
        statement.setString(4, as.getGeolocalizacion());
        statement.setString(5, as.getDireccion());
        statement.setString(6, as.getTelefono());
        statement.setString(7, as.getParroquia());
        statement.setString(8, as.getFk_provinciaa());
        statement.setInt(9, as.getPk_asociacion());

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
