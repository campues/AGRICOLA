package ModeloDao;

import Control.Variables;
import Modelo.Cultivo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CultivoDao {

    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public CultivoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // listar todos las asociaciones
    public List<Cultivo> listarCultivo() throws SQLException {

        List<Cultivo> listarCul = new ArrayList<Cultivo>();
        String sql = "SELECT * FROM cultivo";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            Cultivo c = new Cultivo();
            c.setPk_cultivo(res.getInt("pk_cultivo"));
            c.setNomCultivo(res.getString("nomCultivo"));
            c.setArea(res.getString("area"));
            c.setDensidadSiembra(res.getString("densSiembra"));
            c.setNumPlantas(res.getString("numPlantas"));
            c.setFechaPro(res.getString("fechaPro_prohibido"));
            c.setEs_cosecha(res.getString("estiCosecha"));
            c.setEstatus(res.getString("estatus"));
            c.setAnio_organica(res.getString("anioOrganico"));
            c.setAnio_inspeccion(res.getString("anioInspeccion"));
            c.setFk_visitasc(res.getInt("fk_visitasc"));
            listarCul.add(c);
        }
        con.desconectar();
        return listarCul;
    }

    public List<Cultivo> listarCultivoID() throws SQLException {

        List<Cultivo> listarCul = new ArrayList<Cultivo>();
        String sql = "SELECT * FROM cultivo WHERE fk_visitasc='" + global.idVisitas + "' ";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            Cultivo c = new Cultivo();
            c.setPk_cultivo(res.getInt("pk_cultivo"));
            c.setNomCultivo(res.getString("nomCultivo"));
            c.setNumPlantas(res.getString("numPlantas"));
            c.setEstatus(res.getString("estatus"));
            listarCul.add(c);
        }
        con.desconectar();
        return listarCul;
    }
  // listar ID

    public List<Cultivo> listarNom(String nom) throws SQLException {
          List<Cultivo> listarCul = new ArrayList<Cultivo>();
        String sql = "select * from cultivo WHERE nomCultivo=?  ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nom);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
             Cultivo c = new Cultivo();
            c.setPk_cultivo(res.getInt("pk_cultivo"));
            c.setNomCultivo(res.getString("nomCultivo"));
            c.setNumPlantas(res.getString("numPlantas"));
            c.setEstatus(res.getString("estatus"));
            listarCul.add(c);
        }
        con.desconectar();
        return  listarCul;
    }

    // Insertar Cultivo
    public boolean insertarCul(Cultivo cu) throws SQLException {
        String sql = "INSERT INTO cultivo (pk_cultivo,nomCultivo,area,densSiembra,numPlantas,fechaPro_prohibido,"
                + "estiCosecha,estatus,anioOrganico,anioInspeccion,fk_visitasc) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(cu.getNomCultivo());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, cu.getNomCultivo());
        statement.setString(3, cu.getArea());
        statement.setString(4, cu.getDensidadSiembra());
        statement.setString(5, cu.getNumPlantas());
        statement.setString(6, cu.getFechaPro());
        statement.setString(7, cu.getEs_cosecha());
        statement.setString(8, cu.getEstatus());
        statement.setString(9, cu.getAnio_organica());
        statement.setString(10, cu.getAnio_inspeccion());
        statement.setInt(11, cu.getFk_visitasc());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }
    // actualizar

    public boolean actualizar(Cultivo cu) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE cultivo SET nomCultivo=?,area=?,densSiembra=?,numPlantas=?,fechaPro_prohibido=?, "
                + "estiCosecha=?,estatus=?,anioOrganico=?,anioInspeccion=?,fk_visitasc=? WHERE pk_cultivo=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, cu.getNomCultivo());
        statement.setString(2, cu.getArea());
        statement.setString(3, cu.getDensidadSiembra());
        statement.setString(4, cu.getNumPlantas());
        statement.setString(5, cu.getFechaPro());
        statement.setString(6, cu.getEs_cosecha());
        statement.setString(7, cu.getEstatus());
        statement.setString(8, cu.getAnio_organica());
        statement.setString(9, cu.getAnio_inspeccion());
        statement.setInt(10, cu.getFk_visitasc());
        statement.setInt(11, cu.getPk_cultivo());
        System.out.println(cu.getNomCultivo());

        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

    // Obtener por PK
    public Cultivo obtenerPorId(int pk_cul) throws SQLException {
        Cultivo cultivo = null;

        String sql = "SELECT * FROM cultivo WHERE pk_cultivo=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_cul);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            cultivo = new Cultivo(
                    res.getInt("pk_cultivo"),
                    res.getString("nomCultivo"),
                    res.getString("area"),
                    res.getString("denSiembra"),
                    res.getString("numPlantas"),
                    res.getString("fechaPro_prohibido"),
                    res.getString("estiCosecha"),
                    res.getString("estatus"),
                    res.getString("anioOrganico"),
                    res.getString("anioInspeccion"),
                    res.getInt("fk_visitasc")
            );
        }
        res.close();
        con.desconectar();
        return cultivo;
    }

    //eliminar
    public boolean eliminarCult(Cultivo culti) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM cultivo WHERE pk_cultivo=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, culti.getPk_cultivo());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }
}
