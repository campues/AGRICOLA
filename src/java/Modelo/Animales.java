package Modelo;

public class Animales {

    private int pk_animales;
    private String especie;
    private String cantidad;
    private String fk_lotea;

    public Animales() {
    }

    public Animales(int pk_animales, String especie, String cantidad, String fk_lotea) {
        this.pk_animales = pk_animales;
        this.especie = especie;
        this.cantidad = cantidad;
        this.fk_lotea = fk_lotea;
    }

    public int getPk_animales() {
        return pk_animales;
    }

    public void setPk_animales(int pk_animales) {
        this.pk_animales = pk_animales;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFk_lotea() {
        return fk_lotea;
    }

    public void setFk_lotea(String fk_lotea) {
        this.fk_lotea = fk_lotea;
    }

}
