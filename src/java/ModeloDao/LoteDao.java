package ModeloDao;

import Control.Variables;
import Modelo.Lote;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LoteDao {

    Variables global = new Variables();
    private Conexion con;
    private Connection connection;

    private ResultSet rs = null;//contiene los resultados de una consulta SQL
    private PreparedStatement ps = null;

    public LoteDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

    // listar todos 
    public List<Lote> listarLote() throws SQLException {
        List<Lote> listarLote = new ArrayList<Lote>();
        String sql = "SELECT * FROM lote";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_lote");
            String ubi = res.getString("ubi_Geografica");
            String cod = res.getString("codigo");
            String obs = res.getString("observaciones");
            String rec = res.getString("recomendaciones");
            Lote lote = new Lote(pk, ubi, cod, obs, rec);
            listarLote.add(lote);
        }
        con.desconectar();
        return listarLote;
    }

    // listar ID
    public List<Lote> listarLoteID() throws SQLException {

        List<Lote> listarLoteID = new ArrayList<Lote>();
        String sql = "select * from lote WHERE fk_agricultorl='" + global.idAgricultor + "' ";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_lote");
            String ubi = res.getString("ubi_Geografica");
            String cod = res.getString("codigo");
            String obs = res.getString("observaciones");
            String rec = res.getString("recomendaciones");
            Lote lote = new Lote(pk, ubi, cod, obs, rec);
            listarLoteID.add(lote);
        }
        con.desconectar();
        return listarLoteID;
    }
    // CONSULTA PARA GENERAR CODIGO

    public String GenerarSerie() throws SQLException {
        String numeroserie = "";
        String sql = "select max(codigo) from lote WHERE fk_agricultorl='" + global.idAgricultor + "' ";

        con.conectar();
        connection = con.getJdbcConnection();
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();
        if (rs.next()) {
            numeroserie = rs.getString(1);
        }
        return numeroserie;
    }

    public List<Lote> listarCod(String codi) throws SQLException {
        List<Lote> listarLoteID = new ArrayList<Lote>();
        String sql = "select * from lote WHERE codigo=? and fk_agricultorl='" + global.idAgricultor + "'  ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, codi);
        ResultSet res = statement.executeQuery();
        while (res.next()) {
            int pk = res.getInt("pk_lote");
            String ubi = res.getString("ubi_Geografica");
            String codd = res.getString("codigo");
            String obs = res.getString("observaciones");
            String rec = res.getString("recomendaciones");
            Lote lote = new Lote(pk, ubi, codd, obs, rec);
            listarLoteID.add(lote);
        }
        con.desconectar();
        return listarLoteID;
    }

    // Obtener por PK
    public Lote obtenerPorId(int pk_lote) throws SQLException {
        Lote lote = null;

        String sql = "SELECT * FROM lote WHERE pk_lote= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_lote);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            lote = new Lote(
                    res.getInt("pk_lote"),
                    res.getString("ubi_Geografica"),
                    res.getString("codigo"),
                    res.getString("observaciones"),
                    res.getString("recomendaciones")
            );
        }
        res.close();
        con.desconectar();
        return lote;
    }

    // Insertar Lote SIN IMAGEN
    public boolean insertarLoteSIN(Lote lot) throws SQLException {
        String sql = "INSERT INTO lote (pk_lote,ubi_Geografica,altura,codigo,parroquia,observaciones, "
                + "recomendaciones,certificacion,banio,agua_potable,luz_electrica,agua_riego, "
                + "bodega,poscosecha,ob_bodega,ob_poscosecha,capacitaciones,ob_capacitaciones, "
                + "m_transporte,ob_transporte,inc_abono,riesgo_erosion,registr_lote,usopp, "
                + "en_prdoduc,cont_lateral,agua_procesamiento,des_produccion,fk_provincia,fk_agricultorl,fk_asociacionl) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        System.out.println(lot.getPk_lote());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, null);
        stm.setString(2, lot.getUbi_Geografica());
        stm.setString(3, lot.getAltura());
        stm.setString(4, lot.getCodigo());
        stm.setString(5, lot.getParroquia());
        stm.setString(6, lot.getObservaciones());
        stm.setString(7, lot.getRecomendaciones());
        stm.setString(8, lot.getCertificado());
        stm.setString(9, lot.getBanio());
        stm.setString(10, lot.getAgua_potable());
        stm.setString(11, lot.getLuz_electrica());
        stm.setString(12, lot.getAgua_riego());
        stm.setString(13, lot.getBodega());
        stm.setString(14, lot.getPoscosecha());
        stm.setString(15, lot.getOb_bodega());
        stm.setString(16, lot.getOb_poscosecha());
        stm.setString(17, lot.getCapacitacion());
        stm.setString(18, lot.getOb_capacitacion());
        stm.setString(19, lot.getM_transporte());
        stm.setString(20, lot.getOb_transporte());
        stm.setString(21, lot.getInc_abono());
        stm.setString(22, lot.getRiesgo_erosion());
        stm.setString(23, lot.getRegistr_lote());
        stm.setString(24, lot.getUsopp());
        stm.setString(25, lot.getEn_prdoduc());
        stm.setString(26, lot.getCont_lateral());
        stm.setString(27, lot.getAgua_procesamiento());
        stm.setString(28, lot.getDes_produccion());
        stm.setInt(29, lot.getFk_provincia());
        stm.setInt(30, lot.getFk_agricultorl());
        stm.setInt(31, lot.getFk_asociacion());
        boolean rowInserted = stm.executeUpdate() > 0;
        stm.close();
        con.desconectar();
        return rowInserted;
    }

    // actualizar
    public boolean actualizar(Lote lote) throws SQLException {
        boolean rowActualizar = false;
        String sql = "UPDATE lote SET ubi_Geografica=?,altura=?,codigo=?,parroquia=?,observaciones=?,"
                + " recomendaciones=?,cerficacion=?,banio=?,agua_potable=?,luz_electrica=?,agua_riego=?,"
                + " bodega=?,poscosecha=?,ob_bodega=?,ob_poscosecha=?,capacitaciones=?,ob_capacitaciones=?,"
                + " m_transporte=?,ob_transporte=?,inc_abono=?,riesgo_erosion=?,registr_lote=?,usopp=?,"
                + " en_prdoduc=?,cont_lateral=?,agua_procesamiento=?,des_produccion=?,fk_provincia=?,fk_agricultorl=?,"
                + " fk_asociacionl=? WHERE pk_lote=? ";

        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, lote.getUbi_Geografica());
        stm.setString(2, lote.getAltura());
        stm.setString(3, lote.getCodigo());
        stm.setString(4, lote.getParroquia());
        stm.setString(5, lote.getObservaciones());
        stm.setString(6, lote.getRecomendaciones());
        stm.setString(7, lote.getCertificado());
        stm.setString(8, lote.getBanio());
        stm.setString(9, lote.getAgua_potable());
        stm.setString(1, lote.getLuz_electrica());
        stm.setString(10, lote.getAgua_riego());
        stm.setString(11, lote.getBodega());
        stm.setString(12, lote.getPoscosecha());
        stm.setString(13, lote.getOb_bodega());
        stm.setString(14, lote.getOb_poscosecha());
        stm.setString(15, lote.getCapacitacion());
        stm.setString(16, lote.getOb_capacitacion());
        stm.setString(17, lote.getM_transporte());
        stm.setString(18, lote.getOb_transporte());
        stm.setString(19, lote.getInc_abono());
        stm.setString(20, lote.getRiesgo_erosion());
        stm.setString(21, lote.getRegistr_lote());
        stm.setString(22, lote.getUsopp());
        stm.setString(23, lote.getEn_prdoduc());
        stm.setString(24, lote.getCont_lateral());
        stm.setString(25, lote.getAgua_procesamiento());
        stm.setString(26, lote.getDes_produccion());
        stm.setInt(27, lote.getFk_provincia());
        stm.setInt(28, lote.getFk_agricultorl());
        stm.setInt(29, lote.getFk_asociacion());
        stm.setInt(30, lote.getPk_lote());

        System.out.println(lote.getUbi_Geografica());
        rowActualizar = stm.executeUpdate() > 0;
        stm.close();
        con.desconectar();
        return rowActualizar;
    }

    //eliminar
    public boolean eliminarLote(Lote lo) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM lote WHERE pk_lote=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, lo.getPk_lote());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }
}
