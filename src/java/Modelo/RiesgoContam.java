package Modelo;

public class RiesgoContam {
    //zona de atributo

    private int pk_riesgoContam;
    private int tamaCultivo;
    private int tipoCultivo;
    private int tipoAplicacion;
    private int situacionVecino;
    private int tAgOrganica;
    private int poProductivo;
    private int recFruta;
    private int total;
    private String selecCultivo;
    private String obCultivo;
    private String tipoRiesgo;
    private int fk_cultivor;

    public RiesgoContam() {
    }

    public RiesgoContam(String selecCultivo, String obCultivo, String tipoRiesgo) {
        this.selecCultivo = selecCultivo;
        this.obCultivo = obCultivo;
        this.tipoRiesgo = tipoRiesgo;
    }
    

    public RiesgoContam(int pk_riesgoContam, int tamaCultivo, int tipoCultivo, int tipoAplicacion, int situacionVecino, int tAgOrganica, int poProductivo, int recFruta, int total, String selecCultivo, String obCultivo, String tipoRiesgo, int fk_cultivor) {
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

    public RiesgoContam(int tamaCultivo, int tipoCultivo, int tipoAplicacion, int situacionVecino, int tAgOrganica, int poProductivo, int recFruta, int total, String selecCultivo, String obCultivo, String tipoRiesgo, int fk_cultivor) {
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

    public int getTamaCultivo() {
        return tamaCultivo;
    }

    public void setTamaCultivo(int tamaCultivo) {
        this.tamaCultivo = tamaCultivo;
    }

    public int getTipoCultivo() {
        return tipoCultivo;
    }

    public void setTipoCultivo(int tipoCultivo) {
        this.tipoCultivo = tipoCultivo;
    }

    public int getTipoAplicacion() {
        return tipoAplicacion;
    }

    public void setTipoAplicacion(int tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }

    public int getSituacionVecino() {
        return situacionVecino;
    }

    public void setSituacionVecino(int situacionVecino) {
        this.situacionVecino = situacionVecino;
    }

    public int gettAgOrganica() {
        return tAgOrganica;
    }

    public void settAgOrganica(int tAgOrganica) {
        this.tAgOrganica = tAgOrganica;
    }

    public int getPoProductivo() {
        return poProductivo;
    }

    public void setPoProductivo(int poProductivo) {
        this.poProductivo = poProductivo;
    }

    public int getRecFruta() {
        return recFruta;
    }

    public void setRecFruta(int recFruta) {
        this.recFruta = recFruta;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
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

