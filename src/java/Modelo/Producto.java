package Modelo;

public class Producto {
   
 //zona de atributo

    private int pk_producto;
    private String nomInsumos;
    private String stock;
    private String tipoInsumo;

    //zona de constructores
    
    public Producto(int pk_producto, String nomInsumos, String stock, String tipoInsumo) {
        this.pk_producto = pk_producto;
        this.nomInsumos = nomInsumos;
        this.stock = stock;
        this.tipoInsumo = tipoInsumo;
    }

    public Producto() {
    }
    //zona de getts y setts

    public int getPk_producto() {
        return pk_producto;
    }

    public void setPk_producto(int pk_producto) {
        this.pk_producto = pk_producto;
    }

    public String getNomInsumos() {
        return nomInsumos;
    }

    public void setNomInsumos(String nomInsumos) {
        this.nomInsumos = nomInsumos;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(String tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

}
