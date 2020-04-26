package Modelo;

public class Asociacion {
    //zona de atributo

    private int pk_asociacion;
    private String nombre;
    private String direccion;
    private String telefono;

    // Constructor vacio
    public Asociacion() {
    }
    // zona de constructor
public Asociacion(int pk_asociacion, String nombre, String direccion, String telefono) {
        this.pk_asociacion = pk_asociacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    // GETS Y SETS

    public int getPk_asociacion() {
        return pk_asociacion;
    }

    public void setPk_asociacion(int pk_asociacion) {
        this.pk_asociacion = pk_asociacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    

}
