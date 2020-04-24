package Modelo;

public class Herramientas {
    //zona de atributo

    private int pk_herramientas;
    private String nomHerramienta;
    private String cantidad;
    private String fk_loteh;
    // Constructor vacio
    public Herramientas() {
    }
    // zona de constructor
    public Herramientas(int pk_herramientas, String nomHerramienta, String cantidad, String fk_loteh) {
        this.pk_herramientas = pk_herramientas;
        this.nomHerramienta = nomHerramienta;
        this.cantidad = cantidad;
        this.fk_loteh = fk_loteh;
    }

    // GETS Y SETS
    public int getPk_herramientas() {
        return pk_herramientas;
    }

    public void setPk_herramientas(int pk_herramientas) {
        this.pk_herramientas = pk_herramientas;
    }

    public String getNomHerramienta() {
        return nomHerramienta;
    }

    public void setNomHerramienta(String nomHerramienta) {
        this.nomHerramienta = nomHerramienta;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFk_loteh() {
        return fk_loteh;
    }

    public void setFk_loteh(String fk_loteh) {
        this.fk_loteh = fk_loteh;
    }

}
