package Modelo;

public class ProdAplicados {
    //zona de atributo

    private int pk_proAplicados;
    private String tipoProducto;
    private String nomProducto;
    private String funcionalidad;
    private String canConsertracion;
    private String observacion;
    private String fecha;
    private String asInstalacion;
    private String asInsumo;
    private String origen;
    private String fk_cultivo;
    //zona de contructores

    public ProdAplicados() {
    }

    public ProdAplicados(int pk_proAplicados, String tipoProducto, String nomProducto, String funcionalidad, String canConsertracion, String observacion, String fecha, String asInstalacion, String asInsumo, String origen, String fk_cultivo) {
        this.pk_proAplicados = pk_proAplicados;
        this.tipoProducto = tipoProducto;
        this.nomProducto = nomProducto;
        this.funcionalidad = funcionalidad;
        this.canConsertracion = canConsertracion;
        this.observacion = observacion;
        this.fecha = fecha;
        this.asInstalacion = asInstalacion;
        this.asInsumo = asInsumo;
        this.origen = origen;
        this.fk_cultivo = fk_cultivo;
    }

 
   
    public int getPk_proAplicados() {
        return pk_proAplicados;
    }

    public void setPk_proAplicados(int pk_proAplicados) {
        this.pk_proAplicados = pk_proAplicados;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String getCanConsertracion() {
        return canConsertracion;
    }

    public void setCanConsertracion(String canConsertracion) {
        this.canConsertracion = canConsertracion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAsInstalacion() {
        return asInstalacion;
    }

    public void setAsInstalacion(String asInstalacion) {
        this.asInstalacion = asInstalacion;
    }

    public String getAsInsumo() {
        return asInsumo;
    }

    public void setAsInsumo(String asInsumo) {
        this.asInsumo = asInsumo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getFk_cultivo() {
        return fk_cultivo;
    }

    public void setFk_cultivo(String fk_cultivo) {
        this.fk_cultivo = fk_cultivo;
    }

    
    
    
}
