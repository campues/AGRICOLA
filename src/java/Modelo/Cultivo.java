package Modelo;

import java.util.Date;

public class Cultivo {
    //zona de atributo
    private int pk_cultivo;
    private String nom_cultivo;
    private String area;
    private String densidadSiembra;
    private String numPlantas;
    private String fecha_insumo;
    private String es_cosecha;
    private String estatus;
    private String anio_organica;
    private String anio_inspeccion;
    private int fk_visitas;
    
    //zona de contructores

    public Cultivo(int pk_cultivo, String nom_cultivo, String area, String densidadSiembra, String numPlantas, String fecha_insumo, String es_cosecha, String estatus, String anio_organica, String anio_inspeccion, int fk_visitas) {
        this.pk_cultivo = pk_cultivo;
        this.nom_cultivo = nom_cultivo;
        this.area = area;
        this.densidadSiembra = densidadSiembra;
        this.numPlantas = numPlantas;
        this.fecha_insumo = fecha_insumo;
        this.es_cosecha = es_cosecha;
        this.estatus = estatus;
        this.anio_organica = anio_organica;
        this.anio_inspeccion = anio_inspeccion;
        this.fk_visitas = fk_visitas;
    }

    public Cultivo(int pk_cultivo, String nom_cultivo) {
        this.pk_cultivo = pk_cultivo;
        this.nom_cultivo = nom_cultivo;
    }
    public Cultivo() {
    }
    //zona de gett y setts

    public int getPk_cultivo() {
        return pk_cultivo;
    }

    public void setPk_cultivo(int pk_cultivo) {
        this.pk_cultivo = pk_cultivo;
    }

    public String getNom_cultivo() {
        return nom_cultivo;
    }

    public void setNom_cultivo(String nom_cultivo) {
        this.nom_cultivo = nom_cultivo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDensidadSiembra() {
        return densidadSiembra;
    }

    public void setDensidadSiembra(String densidadSiembra) {
        this.densidadSiembra = densidadSiembra;
    }

    public String getNumPlantas() {
        return numPlantas;
    }

    public void setNumPlantas(String numPlantas) {
        this.numPlantas = numPlantas;
    }

    public  String getFecha_insumo() {
        return fecha_insumo;
    }

    public void setFecha_insumo( String fecha_insumo) {
        this.fecha_insumo = fecha_insumo;
    }

    public String getEs_cosecha() {
        return es_cosecha;
    }

    public void setEs_cosecha(String es_cosecha) {
        this.es_cosecha = es_cosecha;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getAnio_organica() {
        return anio_organica;
    }

    public void setAnio_organica(String anio_organica) {
        this.anio_organica = anio_organica;
    }

    public String getAnio_inspeccion() {
        return anio_inspeccion;
    }

    public void setAnio_inspeccion(String anio_inspeccion) {
        this.anio_inspeccion = anio_inspeccion;
    }

    public int getFk_visitas() {
        return fk_visitas;
    }

    public void setFk_visitas(int fk_visitas) {
        this.fk_visitas = fk_visitas;
    }

    
    
    
    
    
}
