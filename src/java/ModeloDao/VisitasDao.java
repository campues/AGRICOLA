package ModeloDao;

import Control.Variables;
import Modelo.Visitas;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VisitasDao {

    Variables global = new Variables();

    private Conexion con;
    private Connection connection;

    public VisitasDao(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
        System.out.println(jdbcURL);
        con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
    }

// Insertar Lote
    public boolean insertarVisita(Visitas visi) throws SQLException {
        String sql = "INSERT INTO visitas (pk_visitas,fecha,nom_informante,parentesco,tipo_auditoria,obHallasgosDetectados, "
                + "obPlazoAccionesCorr,certificacion,anexoCertificacion,tipoInspeccion,con_compromiso, "
                + "np_organica,rc_interno,elab_bocashi,pco_uvillas,cos_poscosecha,fk_lote,fk_empleadov)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        System.out.println(visi.getPk_visitas());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, null);
        stm.setString(2, visi.getFecha());
        stm.setString(3, visi.getNom_informante());
        stm.setString(4, visi.getParentesco());
        stm.setString(5, visi.getTipo_auditoria());
        stm.setString(6, visi.getObHalasgoDete());
        stm.setString(7, visi.getObPlazoAccion());
        stm.setString(8, visi.getCertificado());
        stm.setBlob(9, visi.getAnexoCertif());

        stm.setString(10, visi.getTipoInspeccion());

        stm.setString(11, visi.getCon_compromiso());
        stm.setString(12, visi.getNp_organica());
        stm.setString(13, visi.getRc_interno());
        stm.setString(14, visi.getElab_bocashi());
        stm.setString(15, visi.getPco_uvillas());
        stm.setString(16, visi.getCos_poscosecha());
        stm.setInt(17, visi.getFk_lote());
        stm.setInt(18, visi.getFk_empleadov());
        System.out.println(visi.getFecha());
        boolean rowInserted = stm.executeUpdate() > 0;
        stm.close();
        con.desconectar();
        return rowInserted;
    }
    
// Insertar Lote
    public boolean insertarVisitaSIN(Visitas visi) throws SQLException {
        String sql = "INSERT INTO visitas (pk_visitas,fecha,nom_informante,parentesco,tipo_auditoria,obHallasgosDetectados,"
                + "obPlazoAccionesCorr,certificacion,tipoInspeccion,con_compromiso,"
                + "np_organica,rc_interno,elab_bocashi,pco_uvillas,cos_poscosecha,fk_lote,fk_empleadov)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        System.out.println(visi.getPk_visitas());
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setString(1, null);
        stm.setString(2, visi.getFecha());
        stm.setString(3, visi.getNom_informante());
        stm.setString(4, visi.getParentesco());
        stm.setString(5, visi.getTipo_auditoria());
        stm.setString(6, visi.getObHalasgoDete());
        stm.setString(7, visi.getObPlazoAccion());
        stm.setString(8, visi.getCertificado());
        stm.setString(9, visi.getTipoInspeccion());

        stm.setString(10, visi.getCon_compromiso());
        stm.setString(11, visi.getNp_organica());
        stm.setString(12, visi.getRc_interno());
        stm.setString(13, visi.getElab_bocashi());
        stm.setString(14, visi.getPco_uvillas());
        stm.setString(15, visi.getCos_poscosecha());
        stm.setInt(16, visi.getFk_lote());
        stm.setInt(17, visi.getFk_empleadov());
        System.out.println(visi.getFecha());
        boolean rowInserted = stm.executeUpdate() > 0;
        stm.close();
        con.desconectar();
        return rowInserted;
    }

    // listar todos
    public List<Visitas> listarVisitas() throws SQLException {

        List<Visitas> listarVisi = new ArrayList<Visitas>();
        String sql = "SELECT * FROM visitas";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_visitas");
            String v2 = res.getString("fecha");
            String v3 = res.getString("nom_informante");
            String v4 = res.getString("tipoInspeccion");
            int v5 = res.getInt("fk_lote");
            int v6 = res.getInt("fk_empleadov");

            Visitas visita = new Visitas(pk, v2, v3, v4, v5, v6);
            listarVisi.add(visita);
        }
        con.desconectar();
        return listarVisi;
    }
    // listar ID

    public List<Visitas> listarVisitaID() throws SQLException {

        List<Visitas> listarVisitaID = new ArrayList<Visitas>();
        String sql = "select * from visitas WHERE fk_lote='" + global.idLote + "' ";
        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sql);
        while (res.next()) {
            int pk = res.getInt("pk_visitas");
            String fecha = res.getString("fecha");
            String nombre = res.getString("nom_informante");
            String tipo = res.getString("tipoInspeccion");
            int fklote = res.getInt("fk_lote");
            int fkempleado = res.getInt("fk_empleadov");
            Visitas vi = new Visitas(pk, fecha, nombre, tipo, fklote, fkempleado);
            listarVisitaID.add(vi);
        }
        con.desconectar();
        return listarVisitaID;
    }

    // Obtener por PK
    public Visitas obtenerPorId(int pk_visi) throws SQLException {
        Visitas visitas = null;

        String sql = "SELECT * FROM visitas WHERE pk_visitas= ? ";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pk_visi);
        ResultSet res = statement.executeQuery();
        if (res.next()) {
            visitas = new Visitas(
                    res.getInt("pk_visitas"),
                    res.getString("fecha"),
                    res.getString("nom_informante"),
                    res.getString("tipoInspeccion"),
                    res.getInt("fk_lote"),
                    res.getInt("fk_empleadov")
            );
        }
        res.close();
        con.desconectar();
        return visitas;
    }

    //eliminar
    public boolean eliminarVisitas(Visitas vis) throws SQLException {
        boolean rowEliminar = false;
        String sql = "DELETE FROM visitas WHERE pk_visitas=?";
        con.conectar();
        connection = con.getJdbcConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, vis.getPk_visitas());
        rowEliminar = statement.executeUpdate() > 0;
        statement.close();
        con.desconectar();
        return rowEliminar;
    }
}
