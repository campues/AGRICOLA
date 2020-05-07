package Modelo;

public class RotacionCultivo {
    //zona de atributo

    private int pk_rotacionCultivo;
    private String anio;
    private String nombre;
    private String observacion;
    private String fk_cultivoc;
    //zona de contructores

    public RotacionCultivo() {
    }

    public RotacionCultivo(int pk_rotacionCultivo, String anio, String nombre, String observacion, String fk_cultivoc) {
        this.pk_rotacionCultivo = pk_rotacionCultivo;
        this.anio = anio;
        this.nombre = nombre;
        this.observacion = observacion;
        this.fk_cultivoc = fk_cultivoc;
    }

    //zona de getts y setts
    public int getPk_rotacionCultivo() {
        return pk_rotacionCultivo;
    }

    public void setPk_rotacionCultivo(int pk_rotacionCultivo) {
        this.pk_rotacionCultivo = pk_rotacionCultivo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getFk_cultivoc() {
        return fk_cultivoc;
    }

    public void setFk_cultivoc(String fk_cultivoc) {
        this.fk_cultivoc = fk_cultivoc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
