package Modelo;

public class RiesgoContam {
    //zona de atributo

    private int pk_riesgoContam;
    private String tamaCultivo;
    private String tipoCultivo;
    private String tipoAplicacion;
    private String situacionVecino;
    private String tAgOrganica;
    private String poProductivo;
    private String recFruta;
    private String total;
    private String selecCultivo;
    private String obCultivo;
    private String tipoRiesgo;
    private int fk_cultivor;

    public RiesgoContam() {
    }

    public RiesgoContam(int pk_riesgoContam, String total, String selecCultivo, String obCultivo, String tipoRiesgo) {
        this.pk_riesgoContam = pk_riesgoContam;
        this.total = total;
        this.selecCultivo = selecCultivo;
        this.obCultivo = obCultivo;
        this.tipoRiesgo = tipoRiesgo;
    }

   


    public RiesgoContam(int pk_riesgoContam, String tamaCultivo, String tipoCultivo, String tipoAplicacion, String situacionVecino, String tAgOrganica, String poProductivo, String recFruta, String total, String selecCultivo, String obCultivo, String tipoRiesgo, int fk_cultivor) {
        this.pk_riesgoContam = pk_riesgoContam;
        this.tamaCultivo = tamaCultivo;
        this.tipoCultivo = tipoCultivo;
        this.tipoAplicacion = tipoAplicacion;
        this.situacionVecino = situacionVecino;
        this.tAgOrganica = tAgOrganica;
        this.poProductivo = poProductivo;
        this.recFruta = recFruta;
        this.total = total;
        this.selecCultivo = selecCultivo;
        this.obCultivo = obCultivo;
        this.tipoRiesgo = tipoRiesgo;
        this.fk_cultivor = fk_cultivor;
    }

    public int getPk_riesgoContam() {
        return pk_riesgoContam;
    }

    public void setPk_riesgoContam(int pk_riesgoContam) {
        this.pk_riesgoContam = pk_riesgoContam;
    }

    public String getTamaCultivo() {
        return tamaCultivo;
    }

    public void setTamaCultivo(String tamaCultivo) {
        this.tamaCultivo = tamaCultivo;
    }

    public String getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(String tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public String getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(String tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }

    public String getSituacionVecino() {
        return situacionVecino;
    }

    public void setSituacionVecino(String situacionVecino) {
        this.situacionVecino = situacionVecino;
    }

    public String gettAgOrganica() {
        return tAgOrganica;
    }

    public void settAgOrganica(String tAgOrganica) {
        this.tAgOrganica = tAgOrganica;
    }

    public String getPoProductivo() {
        return poProductivo;
    }

    public void setPoProductivo(String poProductivo) {
        this.poProductivo = poProductivo;
    }

    public String getRecFruta() {
        return recFruta;
    }

    public void setRecFruta(String recFruta) {
        this.recFruta = recFruta;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getSelecCultivo() {
        return selecCultivo;
    }

    public void setSelecCultivo(String selecCultivo) {
        this.selecCultivo = selecCultivo;
    }

    public String getObCultivo() {
        return obCultivo;
    }

    public void setObCultivo(String obCultivo) {
        this.obCultivo = obCultivo;
    }

    public String getTipoRiesgo() {
        return tipoRiesgo;
    }

    public void setTipoRiesgo(String tipoRiesgo) {
        this.tipoRiesgo = tipoRiesgo;
    }

    public int getFk_cultivor() {
        return fk_cultivor;
    }

    public void setFk_cultivor(int fk_cultivor) {
        this.fk_cultivor = fk_cultivor;
    }

}
