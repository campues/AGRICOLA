package Modelo;

import java.io.InputStream;
public class Visitas {
    //zona de atributo

    private int pk_visitas;
    private String fecha; //  text - cultivo/colmenas SCI 
    private String nom_informante; //text - cultivo/colmenas 
    private String parentesco; //text cultivo/colmenas 
    private String tipo_auditoria; //Seleccion - auditoria - normal/extraordinario
    private String obHalasgoDete;// text- observacion de inspeccion
    private String obPlazoAccion;// text- plazo de implementacion
    private String certificado;// texboxk -aprobarla certificacion SI/NO
    private InputStream anexoCertif;// imagen- foto de anexo de certificacion
    private String tipoInspeccion; //Seleccion-  NUEVO LOTE/INSPECCION SCI

    private String con_compromiso;//texboxk -  contrato de compromiso
    private String np_organica;//texboxk -  normas de producion organica
    private String rc_interno;//texboox - reglamento de control interno
    private String elab_bocashi; //texbox -  elaboraación de estractos, bocashi
    private String pco_uvillas; //texbox -  protodolo de cultivo orgánico de uvillas
    private String cos_poscosecha; //texbox - cosecha y poscosecha 
    private int fk_lote;
    private int fk_empleadov;

    //zona de contructores 18 atributos
    public Visitas() {
    }

    public Visitas(int pk_visitas, String fecha, String nom_informante, String tipoInspeccion, int fk_lote, int fk_empleadov) {
        this.pk_visitas = pk_visitas;
        this.fecha = fecha;
        this.nom_informante = nom_informante;
        this.tipoInspeccion = tipoInspeccion;
        this.fk_lote = fk_lote;
        this.fk_empleadov = fk_empleadov;
    }

    public Visitas(int pk_visitas, String fecha, String nom_informante, String parentesco, String tipo_auditoria, String obHalasgoDete, String obPlazoAccion, String certificado, String tipoInspeccion, String con_compromiso, String np_organica, String rc_interno, String elab_bocashi, String pco_uvillas, String cos_poscosecha, int fk_lote, int fk_empleadov) {
        this.pk_visitas = pk_visitas;
        this.fecha = fecha;
        this.nom_informante = nom_informante;
        this.parentesco = parentesco;
        this.tipo_auditoria = tipo_auditoria;
        this.obHalasgoDete = obHalasgoDete;
        this.obPlazoAccion = obPlazoAccion;
        this.certificado = certificado;
        this.tipoInspeccion = tipoInspeccion;
        this.con_compromiso = con_compromiso;
        this.np_organica = np_organica;
        this.rc_interno = rc_interno;
        this.elab_bocashi = elab_bocashi;
        this.pco_uvillas = pco_uvillas;
        this.cos_poscosecha = cos_poscosecha;
        this.fk_lote = fk_lote;
        this.fk_empleadov = fk_empleadov;
    }

    public int getPk_visitas() {
        return pk_visitas;
    }

    public void setPk_visitas(int pk_visitas) {
        this.pk_visitas = pk_visitas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNom_informante() {
        return nom_informante;
    }

    public void setNom_informante(String nom_informante) {
        this.nom_informante = nom_informante;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getTipo_auditoria() {
        return tipo_auditoria;
    }

    public void setTipo_auditoria(String tipo_auditoria) {
        this.tipo_auditoria = tipo_auditoria;
    }

    public String getObHalasgoDete() {
        return obHalasgoDete;
    }

    public void setObHalasgoDete(String obHalasgoDete) {
        this.obHalasgoDete = obHalasgoDete;
    }

    public String getObPlazoAccion() {
        return obPlazoAccion;
    }

    public void setObPlazoAccion(String obPlazoAccion) {
        this.obPlazoAccion = obPlazoAccion;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getTipoInspeccion() {
        return tipoInspeccion;
    }

    public void setTipoInspeccion(String tipoInspeccion) {
        this.tipoInspeccion = tipoInspeccion;
    }

    public String getCon_compromiso() {
        return con_compromiso;
    }

    public void setCon_compromiso(String con_compromiso) {
        this.con_compromiso = con_compromiso;
    }

    public String getNp_organica() {
        return np_organica;
    }

    public void setNp_organica(String np_organica) {
        this.np_organica = np_organica;
    }

    public String getRc_interno() {
        return rc_interno;
    }

    public void setRc_interno(String rc_interno) {
        this.rc_interno = rc_interno;
    }

    public String getElab_bocashi() {
        return elab_bocashi;
    }

    public void setElab_bocashi(String elab_bocashi) {
        this.elab_bocashi = elab_bocashi;
    }

    public String getPco_uvillas() {
        return pco_uvillas;
    }

    public void setPco_uvillas(String pco_uvillas) {
        this.pco_uvillas = pco_uvillas;
    }

    public String getCos_poscosecha() {
        return cos_poscosecha;
    }

    public void setCos_poscosecha(String cos_poscosecha) {
        this.cos_poscosecha = cos_poscosecha;
    }

    public int getFk_lote() {
        return fk_lote;
    }

    public void setFk_lote(int fk_lote) {
        this.fk_lote = fk_lote;
    }

    public int getFk_empleadov() {
        return fk_empleadov;
    }

    public void setFk_empleadov(int fk_empleadov) {
        this.fk_empleadov = fk_empleadov;
    }



}
