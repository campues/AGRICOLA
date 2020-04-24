package Modelo;


public class Detallespro {
//zona de atributo
    private int pk_detallesPro;
    private String fechaEntrega;
    private String cantidad;
    private String fk_agricutor;
    private String fk_producto;
    private String fk_empleado;

    public Detallespro() {
    }
    
//zona de constructores
   
    public Detallespro(int pk_detallesPro, String fechaEntrega, String cantidad, String fk_agricutor, String fk_producto, String fk_empleado) {
        this.pk_detallesPro = pk_detallesPro;
        this.fechaEntrega = fechaEntrega;
        this.cantidad = cantidad;
        this.fk_agricutor = fk_agricutor;
        this.fk_producto = fk_producto;
        this.fk_empleado = fk_empleado;
    }

    //zona de getts y setts

    public int getPk_detallesPro() {
        return pk_detallesPro;
    }

    public void setPk_detallesPro(int pk_detallesPro) {
        this.pk_detallesPro = pk_detallesPro;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFk_agricutor() {
        return fk_agricutor;
    }

    public void setFk_agricutor(String fk_agricutor) {
        this.fk_agricutor = fk_agricutor;
    }

    public String getFk_producto() {
        return fk_producto;
    }

    public void setFk_producto(String fk_producto) {
        this.fk_producto = fk_producto;
    }

    public String getFk_empleado() {
        return fk_empleado;
    }

    public void setFk_empleado(String fk_empleado) {
        this.fk_empleado = fk_empleado;
    }


   

}
