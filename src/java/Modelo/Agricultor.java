package Modelo;

import java.util.Date;

public class Agricultor {

    //zona de atributo
    private int pk_agricultor;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String cedula;
    private String direccion;
    private String telefono;
    private String fechaAfiliacion;
    private String estatus;
    private String liderAsociacion;

    // Constructor vacio
    public Agricultor() {
    }

    // zona de constructor

    public Agricultor(int pk_agricultor, String nombre1, String nombre2, String apellido1, String apellido2, String cedula, String direccion, String telefono, String fechaAfiliacion, String estatus, String liderAsociacion) {
        this.pk_agricultor = pk_agricultor;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaAfiliacion = fechaAfiliacion;
        this.estatus = estatus;
        this.liderAsociacion = liderAsociacion;
    }
    
    
    // zona de encapsulamiento
    
    public Agricultor(int pk_agricultor, String nombre1) {
        this.pk_agricultor = pk_agricultor;
        this.nombre1 = nombre1;
    }

    // GETS Y SETS
    public int getPk_agricultor() {
        return pk_agricultor;
    }

    public void setPk_agricultor(int pk_agricultor) {
        this.pk_agricultor = pk_agricultor;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public String getFechaAfiliacion() {
        return fechaAfiliacion;
    }

    public void setFechaAfiliacion(String fechaAfiliacion) {
        this.fechaAfiliacion = fechaAfiliacion;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getLiderAsociacion() {
        return liderAsociacion;
    }

    public void setLiderAsociacion(String liderAsociacion) {
        this.liderAsociacion = liderAsociacion;
    }

}
