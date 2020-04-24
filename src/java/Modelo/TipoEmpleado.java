package Modelo;

public class TipoEmpleado {

    //zona de variables
    private int pk_tipo;
    private String tipo;
// zona de contructores

    public TipoEmpleado() {
    }

    public TipoEmpleado(int pk_tipo, String tipo) {
        this.pk_tipo = pk_tipo;
        this.tipo = tipo;
    }

   
    public int getPk_tipo() {
        return pk_tipo;
    }

    //zona de getts y settts
    public void setPk_tipo(int pk_tipo) {
        this.pk_tipo = pk_tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo_empleado(String tipo) {
        this.tipo = tipo;
    }

}
