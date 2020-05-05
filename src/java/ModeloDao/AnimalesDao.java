package ModeloDao;

import Control.Variables;
import Modelo.Animales;
import Modelo.Herramientas;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalesDao {
    //variables para la conexion 

    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public AnimalesDao() {
    }

    //Constuctor de la clase DAO 
    public AnimalesDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS

    public boolean insertarAnimales(Animales a) throws SQLException {
        String sql = "INSERT INTO crianzaanimales (pk_animales, especie, cantidad, fk_lotea)"
                + " VALUES (?,?,?,?)";
        System.out.println(a.getEspecie());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, a.getEspecie());
        statement.setString(3, a.getCantidad());
        statement.setString(4, a.getFk_lotea());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar ID LOTE
    public List<Animales> listarAnimalesID() throws SQLException {

        List<Animales> listarAn = new ArrayList<Animales>();
        String sql = "select * from crianzaanimales WHERE fk_lotea='" + global.idLote + "' ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            Animales her = new Animales();
            her.setPk_animales(res.getInt("pk_animales"));
            her.setEspecie(res.getString("especie"));
            her.setCantidad(res.getString("cantidad"));
            her.setFk_lotea(res.getString("fk_lotea"));
            listarAn.add(her);
        }
        con.desconectar();
        return listarAn;
    }

    // Obtener por PK
    public Animales obtenerPorId(int pk) throws SQLException {
        Animales animales= null;
        String sql = "SELECT * FROM crianzaanimales WHERE pk_animales= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            animales= new Animales(
                    res.getInt("pk_animales"),
                    res.getString("especie"),
                    res.getString("cantidad"),
                    res.getString("fk_lotea")
            );
        }
        res.close();
        con.desconectar();
        return animales;
    }

    //eliminar
    public boolean eliminarAnimal(Animales ani) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM crianzaanimales WHERE pk_animales=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ani.getPk_animales());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
