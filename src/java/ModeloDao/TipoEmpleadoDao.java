package ModeloDao;

import Modelo.Empleado;
import Modelo.TipoEmpleado;
import config.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoEmpleadoDao {

    //variables para la conexion 
    private Conexion con;
    private Connection connection;

    //Constuctor de la clase DAO 
    public TipoEmpleadoDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
    // listar todos los empleados

    public List<TipoEmpleado> listarTipo() throws SQLException {

        ArrayList<TipoEmpleado> listarEm = new ArrayList<TipoEmpleado>();
        String sql = "SELECT pk_tipo,tipo FROM tipo_empleado ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet resulSet = statement.executeQuery(sql);

        while (resulSet.next()) {
            int pk = resulSet.getInt("pk_tipo");
            String nom = resulSet.getString("tipo");

            TipoEmpleado tipo = new TipoEmpleado(pk, nom);
            listarEm.add(tipo);
        }
        con.desconectar();
        return listarEm;
    }
}
