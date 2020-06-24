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
    public boolean insertarVisitaSIN(Visitas visi) throws SQLException {
        String sql = "INSERT INTO visitas (pk_visitas,fecha,nom_informante,parentesco,tipo_auditoria,obHallasgosDetectados, "
                + "obPlazoAccionesCorr,certificacion,tipoInspeccion,con_compromiso, "
                + "np_organica,rc_interno,elab_bocashi,pco_uvillas,cos_poscosecha, "
                + "tamaCultivo,tipoCultivo,tipoAplicacion,situacionVecino,tAgOrganica, "
                + "poProductivo,recFruta,total,selecCultivo,obCultivo,tipoRiesgo,fk_lote,fk_empleadov) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        System.out.println(visi.getFecha());
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

        stm.setString(16, visi.getTamaCultivo());
        stm.setString(17, visi.getTipoCultivo());
        stm.setString(18, visi.getTipoAplicacion());
        stm.setString(19, visi.getSituacionVecino());
        stm.setString(20, visi.gettAgOrganica());
        stm.setString(21, visi.getPoProductivo());
        stm.setString(22, visi.getRecFruta());
        stm.setString(23, visi.getTotal());
        stm.setString(24, visi.getSelecCultivo());
        stm.setString(25, visi.getObCultivo());
        stm.setString(26, visi.getTipoRiesgo());

        stm.setString(27, visi.getFk_lote());
        stm.setString(28, visi.getFk_empleadov());
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
            String v5 = res.getString("fk_lote");
            String v6 = res.getString("fk_empleadov");

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

        String sqljoin = "select visitas.pk_visitas,visitas.fecha,visitas.nom_informante,visitas.tipoInspeccion, "
                + "lote.cod,empleado.nombre from visitas "
                + "JOIN lote ON lote.pk_lote=visitas.fk_lote "
                + "JOIN empleado ON empleado.pk_empleado=visitas.fk_empleadov "
                + "WHERE fk_lote='" + global.idLote + "' ";

        con.conectar();
        connection = con.getJdbcConnection();
        Statement statement = connection.createStatement();
        ResultSet res = statement.executeQuery(sqljoin);
        while (res.next()) {
            int pk = res.getInt("pk_visitas");
            String fecha = res.getString("fecha");
            String nombre = res.getString("nom_informante");
            String tipo = res.getString("tipoInspeccion");
            String fklote = res.getString("cod");
            String fkempleado = res.getString("nombre");
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
                    res.getString("fk_lote"),
                    res.getString("fk_empleadov")
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
