package Modelo;

public class Colmenas {

    private int pk_colmenas;
    private String codColmena; //text codigo colmenas
    private String abejas;//checbox si no 
    private String reina; // checbox si no 
    private String piso; // numero
    private String alimentacion; // text
    private String cantidad;// numero
    private String descripcion;// texto
    private String actividad;// texto
    private String tratamiento;// texto
    private int fk_visitas;

    public Colmenas() {
    }

    public Colmenas(int pk_colmenas, String codColmena, String abejas, String reina, String piso, String alimentacion, String cantidad, String descripcion, String actividad, String tratamiento, int fk_visitas) {
        this.pk_colmenas = pk_colmenas;
        this.codColmena = codColmena;
        this.abejas = abejas;
        this.reina = reina;
        this.piso = piso;
        this.alimentacion = alimentacion;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.actividad = actividad;
        this.tratamiento = tratamiento;
        this.fk_visitas = fk_visitas;
    }

    public int getPk_colmenas() {
        return pk_colmenas;
    }

    public void setPk_colmenas(int pk_colmenas) {
        this.pk_colmenas = pk_colmenas;
    }

    public String getCodColmena() {
        return codColmena;
    }

    public void setCodColmena(String codColmena) {
        this.codColmena = codColmena;
    }

    public String getAbejas() {
        return abejas;
    }

    public void setAbejas(String abejas) {
        this.abejas = abejas;
    }

    public String getReina() {
        return reina;
    }

    public void setReina(String reina) {
        this.reina = reina;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public int getFk_visitas() {
        return fk_visitas;
    }

    public void setFk_visitas(int fk_visitas) {
        this.fk_visitas = fk_visitas;
    }
    
    
    
    

}
