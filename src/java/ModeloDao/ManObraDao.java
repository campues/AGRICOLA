package ModeloDao;

import Control.Variables;
import Modelo.Animales;
import Modelo.ManObra;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ManObraDao {
    //variables para la conexion 

    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public ManObraDao() {
    }

    //Constuctor de la clase DAO 
    public ManObraDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS

    public boolean insertarManObra(ManObra m) throws SQLException {
        String sql = "INSERT INTO manobra (pk_manObra, familia, edad,sexo,cantidad, fk_lotem)"
                + " VALUES (?,?,?,?,?,?)";
        System.out.println(m.getFamilia());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, m.getFamilia());
        statement.setString(3, m.getEdad());
        statement.setString(4, m.getSexo());
        statement.setString(5, m.getCantidad());
        statement.setString(6, m.getFk_lotem());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar ID LOTE
    public List<ManObra> listarManObraID() throws SQLException {

        List<ManObra> listarMan = new ArrayList<ManObra>();
        String sql = "select * from manobra WHERE fk_lotem='" + global.idLote + "' ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            ManObra her = new ManObra();
            her.setPk_manObra(res.getInt("pk_manObra"));
            her.setFamilia(res.getString("familia"));
            her.setEdad(res.getString("edad"));
            her.setSexo(res.getString("sexo"));
            her.setCantidad(res.getString("cantidad"));
            her.setFk_lotem(res.getString("fk_lotem"));

            listarMan.add(her);
        }
        con.desconectar();
        return listarMan;
    }

    // Obtener por PK
    public ManObra obtenerPorId(int pk) throws SQLException {
        ManObra manobra = null;
        String sql = "SELECT * FROM manobra WHERE pk_manObra= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            manobra = new ManObra(
                    res.getInt("pk_manObra"),
                    res.getString("familia"),
                    res.getString("edad"),
                    res.getString("sexo"),
                    res.getString("cantidad"),
                    res.getString("fk_lotem")
            );
        }
        res.close();
        con.desconectar();
        return manobra;
    }

    //eliminar
    public boolean eliminarManObra(ManObra man) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM manobra WHERE pk_manObra=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, man.getPk_manObra());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
