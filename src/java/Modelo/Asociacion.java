package Modelo;

public class Asociacion {
    //zona de atributo

    private int pk_asociacion;
    private String nomAsociacion;
    private String ruc;
    private String responsable;
    private String geolocalizacion;
    private String direccion;
    private String telefono;
    private String parroquia;
    private String fk_provinciaa;

    // Constructor vacio
    public Asociacion() {
    }
    // zona de constructor

    public Asociacion(int pk_asociacion, String nomAsociacion, String ruc, String telefono, String fk_provinciaa) {
        this.pk_asociacion = pk_asociacion;
        this.nomAsociacion = nomAsociacion;
        this.ruc = ruc;
        this.telefono = telefono;
        this.fk_provinciaa = fk_provinciaa;
    }

    public Asociacion(int pk_asociacion, String nomAsociacion, String ruc, String responsable, String geolocalizacion, String direccion, String telefono, String parroquia, String fk_provinciaa) {
        this.pk_asociacion = pk_asociacion;
        this.nomAsociacion = nomAsociacion;
        this.ruc = ruc;
        this.responsable = responsable;
        this.geolocalizacion = geolocalizacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.parroquia = parroquia;
        this.fk_provinciaa = fk_provinciaa;
    }

    // GETS Y SETS
    public int getPk_asociacion() {
        return pk_asociacion;
    }

    public void setPk_asociacion(int pk_asociacion) {
        this.pk_asociacion = pk_asociacion;
    }

    public String getNomAsociacion() {
        return nomAsociacion;
    }

    public void setNomAsociacion(String nomAsociacion) {
        this.nomAsociacion = nomAsociacion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(String geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getParroquia() {
        return parroquia;
    }

    public void setParroquia(String parroquia) {
        this.parroquia = parroquia;
    }

    public String getFk_provinciaa() {
        return fk_provinciaa;
    }

    public void setFk_provinciaa(String fk_provinciaa) {
        this.fk_provinciaa = fk_provinciaa;
    }

}
