
package ModeloDao;

import Modelo.Herramientas;
import Modelo.Provincia;
import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProvinciaDao {
     //variables para la conexion 

    private Conexion con;
    private Connection connection;

    public ProvinciaDao() {
    }

    //Constuctor de la clase DAO 
    public ProvinciaDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    // listar todos los empleados
    public List<Provincia> listarProvincia() throws SQLException {

       List<Provincia> listarPro = new ArrayList<Provincia>();
        String sql = "SELECT * FROM provincia ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            Provincia pro = new Provincia();
            pro.setPk_provincia(res.getInt("pk_provincia"));
            pro.setNomProvincia(res.getString("nomProvincia"));
            listarPro.add(pro);
        }
        con.desconectar();
        return listarPro;
    }
}
