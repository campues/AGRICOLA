package Modelo;

public class RotacionCultivo {
    //zona de atributo

    private int pk_rotacionCultivo;
    private String anio;
    private String observacion;
    private int fk_cultivoc;
    //zona de contructores

    public RotacionCultivo() {
    }
    public RotacionCultivo(int pk_rotacionCultivo, String anio, String observacion, int fk_cultivoc) {
        this.pk_rotacionCultivo = pk_rotacionCultivo;
        this.anio = anio;
        this.observacion = observacion;
        this.fk_cultivoc = fk_cultivoc;
    }

    public RotacionCultivo(int pk_rotacionCultivo, String anio) {
        this.pk_rotacionCultivo = pk_rotacionCultivo;
        this.anio = anio;
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

    public int getFk_cultivoc() {
        return fk_cultivoc;
    }

    public void setFk_cultivoc(int fk_cultivoc) {
        this.fk_cultivoc = fk_cultivoc;
    }

}
