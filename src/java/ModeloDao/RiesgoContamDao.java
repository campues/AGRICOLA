package ModeloDao;

import Control.Variables;
import Modelo.RiesgoContam;
import Modelo.RotacionCultivo;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RiesgoContamDao {
    //variables para la conexion 

    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public RiesgoContamDao() {
    }

    //Constuctor de la clase DAO 
    public RiesgoContamDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }
//METODO DE CONSULTA DEL DATO DESDE LA BASE DE DATOS

    public boolean insertarRiesgo(RiesgoContam ries) throws SQLException {
        String sql = "INSERT INTO riesgocontam (pk_riesgoContam,tamaCultivo,tipoCultivo,tipoAplicacion,situacionVecino,tAgOrganica, "
                + "poProductivo,recFruta,total,selecCultivo,obCultivo,tipoRiesgo,fk_cultivor)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        System.out.println(ries.getFk_cultivor());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, null);
        statement.setString(2, ries.getTamaCultivo());
        statement.setString(3, ries.getTipoCultivo());
        statement.setString(4, ries.getTipoAplicacion());
        statement.setString(5, ries.getSituacionVecino());
        statement.setString(6, ries.gettAgOrganica());
        statement.setString(7, ries.getPoProductivo());
        statement.setString(8, ries.getRecFruta());
        statement.setString(9, ries.getTotal());
        statement.setString(10, ries.getSelecCultivo());
        statement.setString(11, ries.getObCultivo());
        statement.setString(12, ries.getTipoRiesgo());
        statement.setInt(13, ries.getFk_cultivor());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowInserted;
    }

    // listar ID LOTE
    public List<RiesgoContam> listarRiesgoID() throws SQLException {

        List<RiesgoContam> listarRiesg = new ArrayList<RiesgoContam>();
        String sql = "select * from riesgocontam WHERE fk_cultivor='" + global.idCultivo + "' ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);

        while (res.next()) {
            RiesgoContam ries = new RiesgoContam();
            ries.setPk_riesgoContam(res.getInt("pk_riesgoContam"));
            ries.setSelecCultivo(res.getString("selecCultivo"));
            ries.setTotal(res.getString("total"));
            ries.setObCultivo(res.getString("obCultivo"));
            ries.setTipoRiesgo(res.getString("tipoRiesgo"));
            listarRiesg.add(ries);
        }
        con.desconectar();
        return listarRiesg;
    }

    // Obtener por PK
    public RiesgoContam obtenerPorId(int pk) throws SQLException {
        RiesgoContam riesgo = null;
        String sql = "SELECT * FROM riesgocontam  WHERE pk_riesgoContam= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            riesgo = new RiesgoContam(
                    res.getInt("pk_riesgoContam"),
                    res.getString("tamaCultivo"),
                    res.getString("tipoCultivo"),
                    res.getString("tipoAplicacion"),
                    res.getString("situacionVecino"),
                    res.getString("tAgOrganica"),
                    res.getString("poProductivo"),
                    res.getString("recFruta"),
                    res.getString("total"),
                    res.getString("selecCultivo"),
                    res.getString("obCultivo"),
                    res.getString("tipoRiesgo"),
                    res.getInt("fk_cultivor")
            );
        }
        res.close();
        con.desconectar();
        return riesgo;
    }

    //eliminar
    public boolean eliminarRiesgo(RiesgoContam ri) throws SQLException {
        
        boolean rowEliminar = false;
        String sql = "DELETE FROM riesgocontam WHERE pk_riesgoContam=? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, ri.getPk_riesgoContam());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }

}
