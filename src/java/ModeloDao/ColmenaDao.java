package ModeloDao;

import Control.Variables;
import Modelo.Colmenas;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ColmenaDao {

    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public ColmenaDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // listar todos las asociaciones
    public List<Colmenas> listarColmenas() throws SQLException {

        List<Colmenas> listarCul = new ArrayList<Colmenas>();
        String sql = "SELECT * FROM colmenas";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            Colmenas c = new Colmenas();
            c.setPk_colmenas(res.getInt("pk_colmenas"));
            c.setCodColmena(res.getString("codColmena"));
            c.setAbejas(res.getString("abejas"));
            c.setReina(res.getString("reina"));
            c.setPiso(res.getString("piso"));
            c.setAlimentacion(res.getString("alimentacion"));
            c.setCantidad(res.getString("cantidad"));
            c.setDescripcion(res.getString("descripcion"));
            c.setActividad(res.getString("actividad"));
            c.setTratamiento(res.getString("tratamiento"));
            c.setFk_visitas(res.getInt("fk_visitas"));
            listarCul.add(c);
        }
        con.desconectar();
        return listarCul;
    }
// Filtrar de visita

    public List<Colmenas> listarColmenaID() throws SQLException {

        List<Colmenas> listarCul = new ArrayList<Colmenas>();
        String sql = "SELECT * FROM colmenas WHERE fk_visitas='" + global.idVisitas + "' ";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            Colmenas c = new Colmenas();
            c.setPk_colmenas(res.getInt("pk_colmenas"));
            c.setCodColmena(res.getString("codColmena"));
            c.setAbejas(res.getString("abejas"));
            c.setPiso(res.getString("piso"));
            c.setCantidad(res.getString("cantidad"));
            listarCul.add(c);
        }
        con.desconectar();
        return listarCul;
    }

    // lista para busqueda de colmenas
    public List<Colmenas> listarCodigo(String nom) throws SQLException {
        List<Colmenas> listarCul = new ArrayList<Colmenas>();
        String sql = "SELECT * FROM colmenas WHERE codColmena=?  ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, nom);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            Colmenas c = new Colmenas();
            c.setPk_colmenas(res.getInt("pk_colmenas"));
            c.setCodColmena(res.getString("codColmena"));
            c.setAbejas(res.getString("abejas"));
            c.setPiso(res.getString("piso"));
            c.setCantidad(res.getString("cantidad"));
            listarCul.add(c);
        }
        con.desconectar();
        return listarCul;
    }

    // Insertar Cultivo
    public boolean insertarCol(Colmenas col) throws SQLException {
        String sql = " INSERT INTO colmenas(pk_colmenas,codColmena,abejas,reina,piso,alimentacion,cantidad,"
                + "descripcion,actividad,tratamiento,fk_visitas) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(col.getCodColmena());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, col.getCodColmena());
        statement.setString(3, col.getAbejas());
        statement.setString(4, col.getReina());
        statement.setString(5, col.getPiso());
        statement.setString(6, col.getAlimentacion());
        statement.setString(7, col.getCantidad());
        statement.setString(8, col.getDescripcion());
        statement.setString(9, col.getActividad());
        statement.setString(10, col.getTratamiento());
        statement.setInt(11, col.getFk_visitas());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }
    // actualizar

    public boolean actualizar(Colmenas col) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE colmenas SET codColmena=?,abejas=?,reina=?,piso=?,alimentacion=?,cantidad=?,"
                + "descripcion=?,actividad=?,tratamiento=?,fk_visitas=? WHERE pk_colmenas=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, col.getCodColmena());
        statement.setString(2, col.getAbejas());
        statement.setString(3, col.getReina());
        statement.setString(4, col.getPiso());
        statement.setString(5, col.getAlimentacion());
        statement.setString(6, col.getCantidad());
        statement.setString(7, col.getDescripcion());
        statement.setString(8, col.getActividad());
        statement.setString(9, col.getTratamiento());
        statement.setInt(10, col.getFk_visitas());
        statement.setInt(11, col.getPk_colmenas());

        rowActualizar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowActualizar;
    }

    // Obtener por PK
    public Colmenas obtenerPorId(int pk_col) throws SQLException {
        Colmenas colmenas = null;

        String sql = "SELECT * FROM colmenas WHERE pk_colmenas=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_col);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            colmenas = new Colmenas(
                    res.getInt("pk_colmenas"),
                    res.getString("codColmena"),
                    res.getString("abejas"),
                    res.getString("reina"),
                    res.getString("piso"),
                    res.getString("alimentacion"),
                    res.getString("cantidad"),
                    res.getString("descripcion"),
                    res.getString("actividad"),
                    res.getString("tratamiento"),
                    res.getInt("fk_visitas")
            );
        }
        res.close();
        con.desconectar();
        return colmenas;
    }

    //eliminar
    public boolean eliminarColmena(Colmenas col) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM colmenas WHERE pk_colmenas=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, col.getPk_colmenas());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }
}
