package Modelo;

import java.util.Date;

public class Insumo {
    //zona de atributo

    private int pk_insumo;
    private String nom_insumo;
    private String funcionalidad;
    private String cant_concetracion;
    private Date fecha;
    private String observacion;
    private int fk_cultivo;

    //zona de constructores
    public Insumo(int pk_insumo, String nom_insumo, String funcionalidad, String cant_concetracion, Date fecha, String observacion, int fk_cultivo) {
        this.pk_insumo = pk_insumo;
        this.nom_insumo = nom_insumo;
        this.funcionalidad = funcionalidad;
        this.cant_concetracion = cant_concetracion;
        this.fecha = fecha;
        this.observacion = observacion;
        this.fk_cultivo = fk_cultivo;
    }

    public Insumo(int pk_insumo, String nom_insumo) {
        this.pk_insumo = pk_insumo;
        this.nom_insumo = nom_insumo;
    }

    public Insumo() {
    }
    //zona de getts y setts

    public int getPk_insumo() {
        return pk_insumo;
    }

    public void setPk_insumo(int pk_insumo) {
        this.pk_insumo = pk_insumo;
    }

    public String getNom_insumo() {
        return nom_insumo;
    }

    public void setNom_insumo(String nom_insumo) {
        this.nom_insumo = nom_insumo;
    }

    public String getFuncionalidad() {
        return funcionalidad;
    }

    public void setFuncionalidad(String funcionalidad) {
        this.funcionalidad = funcionalidad;
    }

    public String getCant_concetracion() {
        return cant_concetracion;
    }

    public void setCant_concetracion(String cant_concetracion) {
        this.cant_concetracion = cant_concetracion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getFk_cultivo() {
        return fk_cultivo;
    }

    public void setFk_cultivo(int fk_cultivo) {
        this.fk_cultivo = fk_cultivo;
    }

}
