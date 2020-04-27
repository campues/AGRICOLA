package Modelo;

import java.io.InputStream;

public class Lote {
    //zona de atributo 32 atributos

    private int pk_lote;
    private String ubi_Geografica; // longitud-latitud
    private String altura;// 2,850 m
    private String codigo; //LT01
    private String parroquia; //Desplegable
    private String observaciones; //Descrip
    private String recomendaciones; //Descrip
    private InputStream croquis; // Imagen
    private String certificado; // Check

    private String banio; // Check
    private String agua_potable; // Check
    private String luz_electrica;// Check
    private String agua_riego;// Check
    private String bodega;// Check
    private String poscosecha;// Check

    private String ob_bodega; // Descrip
    private String ob_poscosecha; // Descrip
    private String capacitacion;  //Check
    private String ob_capacitacion; // Descrip
    private String m_transporte; // Check
    private String ob_transporte; // Descrip

    private String inc_abono; // Descrip
    private String riesgo_erosion; // Descrip

    private String registr_lote; // SI-NO-LIBRE
    private String usopp;  // Check
    private String en_prdoduc; // Check
    private String cont_lateral;// Check
    private String agua_procesamiento;// Check
    private String des_produccion;// Descrip

    private int fk_provincia;
    private int fk_agricultorl;
    private int fk_asociacion;

      //zona de contructores 32 atributos
    public Lote() {
    }

    public Lote(int pk_lote, String ubi_Geografica, String codigo, String observaciones, String recomendaciones) {
        this.pk_lote = pk_lote;
        this.ubi_Geografica = ubi_Geografica;
        this.codigo = codigo;
        this.observaciones = observaciones;
        this.recomendaciones = recomendaciones;
    }

    public Lote(int pk_lote, String ubi_Geografica, String altura, String codigo, String parroquia, String observaciones, String recomendaciones, InputStream croquis, String certificado, String banio, String agua_potable, String luz_electrica, String agua_riego, String bodega, String poscosecha, String ob_bodega, String ob_poscosecha, String capacitacion, String ob_capacitacion, String m_transporte, String ob_transporte, String inc_abono, String riesgo_erosion, String registr_lote, String usopp, String en_prdoduc, String cont_lateral, String agua_procesamiento, String des_produccion, int fk_provincia, int fk_agricultorl, int fk_asociacion) {
        this.pk_lote = pk_lote;
        this.ubi_Geografica = ubi_Geografica;
        this.altura = altura;
        this.codigo = codigo;
        this.parroquia = parroquia;
        this.observaciones = observaciones;
        this.recomendaciones = recomendaciones;
        this.croquis = croquis;
        this.certificado = certificado;
        this.banio = banio;
        this.agua_potable = agua_potable;
        this.luz_electrica = luz_electrica;
        this.agua_riego = agua_riego;
        this.bodega = bodega;
        this.poscosecha = poscosecha;
        this.ob_bodega = ob_bodega;
        this.ob_poscosecha = ob_poscosecha;
        this.capacitacion = capacitacion;
        this.ob_capacitacion = ob_capacitacion;
        this.m_transporte = m_transporte;
        this.ob_transporte = ob_transporte;
        this.inc_abono = inc_abono;
        this.riesgo_erosion = riesgo_erosion;
        this.registr_lote = registr_lote;
        this.usopp = usopp;
        this.en_prdoduc = en_prdoduc;
        this.cont_lateral = cont_lateral;
        this.agua_procesamiento = agua_procesamiento;
        this.des_produccion = des_produccion;
        this.fk_provincia = fk_provincia;
        this.fk_agricultorl = fk_agricultorl;
        this.fk_asociacion = fk_asociacion;
    }

    public InputStream getCroquis() {
        return croquis;
    }

    //Zona getts y setss
    public void setCroquis(InputStream croquis) {
        this.croquis = croquis;
    }

    public int getPk_lote() {
        return pk_lote;
    }

    public void setPk_lote(int pk_lote) {
        this.pk_lote = pk_lote;
    }

    public String getUbi_Geografica() {
        return ubi_Geografica;
    }

    public void setUbi_Geografica(String ubi_Geografica) {
        this.ubi_Geografica = ubi_Geografica;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getCertificado() {
        return certificado;
    }

    public void setCertificado(String certificado) {
        this.certificado = certificado;
    }

    public String getBanio() {
        return banio;
    }

    public void setBanio(String banio) {
        this.banio = banio;
    }

    public String getAgua_potable() {
        return agua_potable;
    }

    public void setAgua_potable(String agua_potable) {
        this.agua_potable = agua_potable;
    }

    public String getLuz_electrica() {
        return luz_electrica;
    }

    public void setLuz_electrica(String luz_electrica) {
        this.luz_electrica = luz_electrica;
    }

    public String getAgua_riego() {
        return agua_riego;
    }

    public void setAgua_riego(String agua_riego) {
        this.agua_riego = agua_riego;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getPoscosecha() {
        return poscosecha;
    }

    public void setPoscosecha(String poscosecha) {
        this.poscosecha = poscosecha;
    }

    public String getOb_bodega() {
        return ob_bodega;
    }

    public void setOb_bodega(String ob_bodega) {
        this.ob_bodega = ob_bodega;
    }

    public String getOb_poscosecha() {
        return ob_poscosecha;
    }

    public void setOb_poscosecha(String ob_poscosecha) {
        this.ob_poscosecha = ob_poscosecha;
    }

    public String getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(String capacitacion) {
        this.capacitacion = capacitacion;
    }

    public String getOb_capacitacion() {
        return ob_capacitacion;
    }

    public void setOb_capacitacion(String ob_capacitacion) {
        this.ob_capacitacion = ob_capacitacion;
    }

    public String getM_transporte() {
        return m_transporte;
    }

    public void setM_transporte(String m_transporte) {
        this.m_transporte = m_transporte;
    }

    public String getOb_transporte() {
        return ob_transporte;
    }

    public void setOb_transporte(String ob_transporte) {
        this.ob_transporte = ob_transporte;
    }

    public String getInc_abono() {
        return inc_abono;
    }

    public void setInc_abono(String inc_abono) {
        this.inc_abono = inc_abono;
    }

    public String getRiesgo_erosion() {
        return riesgo_erosion;
    }

    public void setRiesgo_erosion(String riesgo_erosion) {
        this.riesgo_erosion = riesgo_erosion;
    }

    public String getRegistr_lote() {
        return registr_lote;
    }

    public void setRegistr_lote(String registr_lote) {
        this.registr_lote = registr_lote;
    }

    public String getUsopp() {
        return usopp;
    }

    public void setUsopp(String usopp) {
        this.usopp = usopp;
    }

    public String getEn_prdoduc() {
        return en_prdoduc;
    }

    public void setEn_prdoduc(String en_prdoduc) {
        this.en_prdoduc = en_prdoduc;
    }

    public String getCont_lateral() {
        return cont_lateral;
    }

    public void setCont_lateral(String cont_lateral) {
        this.cont_lateral = cont_lateral;
    }

    public String getAgua_procesamiento() {
        return agua_procesamiento;
    }

    public void setAgua_procesamiento(String agua_procesamiento) {
        this.agua_procesamiento = agua_procesamiento;
    }

    public String getDes_produccion() {
        return des_produccion;
    }

    public void setDes_produccion(String des_produccion) {
        this.des_produccion = des_produccion;
    }

    public int getFk_provincia() {
        return fk_provincia;
    }

    public void setFk_provincia(int fk_provincia) {
        this.fk_provincia = fk_provincia;
    }

    public int getFk_agricultorl() {
        return fk_agricultorl;
    }

    public void setFk_agricultorl(int fk_agricultorl) {
        this.fk_agricultorl = fk_agricultorl;
    }

    public int getFk_asociacion() {
        return fk_asociacion;
    }

    public void setFk_asociacion(int fk_asociacion) {
        this.fk_asociacion = fk_asociacion;
    }

}
