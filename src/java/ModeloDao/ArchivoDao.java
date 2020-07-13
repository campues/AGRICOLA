package ModeloDao;

import Control.Variables;
import Modelo.Archivo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArchivoDao {

    //INSTANCIAS DEL LOS OBJETOS
    Variables global = new Variables();
    private Conexion con;
    private Connection connection;

    public ArchivoDao() {
    }

    public ArchivoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // listar todos Agricultores
    public List<Archivo> listarArchivo() throws SQLException {
        List<Archivo> listarAr = new ArrayList<Archivo>();
        String sql = "SELECT * FROM archivo";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_archivo");
            String nom = res.getString("nomArchivo");
            String tip = res.getString("tipo");
            String rut = res.getString("ruta");
            String fk = res.getString("fk_agricultord");

            Archivo archivo = new Archivo(pk, nom, tip, rut, fk);
            listarAr.add(archivo);
        }
        con.desconectar();
        return listarAr;
    }
    // listar ID

    public List<Archivo> listarArchivoID() throws SQLException {

        List<Archivo> listarArID = new ArrayList<Archivo>();
        String sql = "SELECT * FROM archivo WHERE fk_agricultord='" + global.idAgricultor + "' ";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_archivo");
            String nom = res.getString("nomArchivo");
            String tip = res.getString("tipo");
            String rut = res.getString("ruta");
            String fk = res.getString("fk_agricultord");

            Archivo archivo = new Archivo(pk, nom, tip, rut, fk);
            listarArID.add(archivo);
        }
        con.desconectar();
        return listarArID;
    }

    // Insertar Empleado
    public boolean insertarArchivo(Archivo ar) throws SQLException {
        String sql = "INSERT INTO archivo (nomArchivo,tipo,ruta,fk_agricultord)VALUES(?,?,?,?)";
        System.out.println(ar.getNomArchivo());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, ar.getNomArchivo());
        statement.setString(2, ar.getTipo());
        statement.setString(3, ar.getRuta());
        statement.setString(4, ar.getFk_agricultord());
        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // Obtener por PK
    public Archivo obtenerPorId(int pk) throws SQLException {
        Archivo archivo = null;
        String sql = "SELECT * FROM archivo WHERE pk_archivo= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            archivo = new Archivo(
                    res.getInt("pk_archivo"),
                    res.getString("nomArchivo"),
                    res.getString("tipo"),
                    res.getString("ruta"),
                    res.getString("fk_agricultord")
            );
        }
        res.close();
        con.desconectar();
        return archivo;

    }

    //eliminar
    public boolean eliminarArchivo(Archivo a) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM archivo WHERE pk_archivo=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, a.getPk_archivo());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
