package Modelo;

import java.util.Date;

public class InsumoLote {
    //zona de atributo

    private int pk_insumo;
    private String tipoInsumo;
    private String nomInsumo;
    private String cantidad;
    private String fk_lotei;

    //zona de constructores

    public InsumoLote() {
    }

    public InsumoLote(int pk_insumo, String tipoInsumo, String nomInsumo, String cantidad, String fk_lotei) {
        this.pk_insumo = pk_insumo;
        this.tipoInsumo = tipoInsumo;
        this.nomInsumo = nomInsumo;
        this.cantidad = cantidad;
        this.fk_lotei = fk_lotei;
    }




    public int getPk_insumo() {
        return pk_insumo;
    }

    public void setPk_insumo(int pk_insumo) {
        this.pk_insumo = pk_insumo;
    }

    public String getTipoInsumo() {
        return tipoInsumo;
    }

    public void setTipoInsumo(String tipoInsumo) {
        this.tipoInsumo = tipoInsumo;
    }

    public String getNomInsumo() {
        return nomInsumo;
    }

    public void setNomInsumo(String nomInsumo) {
        this.nomInsumo = nomInsumo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFk_lotei() {
        return fk_lotei;
    }

    public void setFk_lotei(String fk_lotei) {
        this.fk_lotei = fk_lotei;
    }

   
    
}