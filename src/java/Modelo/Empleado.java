package Modelo;

public class Empleado {
    //zona de atributo
    private int pk_empleado;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;
    private String tipo;
// zona de constructor
// Constructor vacio
    public Empleado() { 
    }
    public Empleado(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
    // zona de encapsulamiento

    public Empleado(int pk_empleado, String nombre, String apellido, String usuario, String contrasena, String tipo) {
        this.pk_empleado = pk_empleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }
    
    
    
    public Empleado(int pk_empleado, String nombre) {
        this.pk_empleado = pk_empleado;
        this.nombre = nombre;
    }

    // GETS Y SETS
    public int getPk_empleado() {
        return pk_empleado;
    }

    public void setPk_empleado(int pk_empleado) {
        this.pk_empleado = pk_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   
}
