package Modelo;

import java.util.Date;

public class Cultivo {

    //zona de atributo
    private int pk_cultivo;
    private String nomCultivo;  // texto   Nuevo / SCI  
    private String area;        // texto Nuevo/SCI
    private String densidadSiembra;// texto SCI
    private String numPlantas; // numero SCI
    private String fechaPro; // texto SCI
    private String es_cosecha;// numero SCI estimacion de cosecha
    private String estatus;// combobox SCI
    private String anio_organica;  // texto  Nuevo
    private String anio_inspeccion; // texto Nuevo
    private String rotacion1; // texto 1ra rotacion
    private String rotacion2; // texto 2ra rotacion
    private String rotacion3; // texto 3ra rotacion
    private String obCultivo; // texto observacion del cultivo
    private int fk_visitasc;

    public Cultivo() {
    }

    //zona de contructores

    public Cultivo(int pk_cultivo, String nomCultivo, String area, String densidadSiembra, String numPlantas, String fechaPro, String es_cosecha, String estatus, String anio_organica, String anio_inspeccion, String rotacion1, String rotacion2, String rotacion3, String obCultivo, int fk_visitasc) {
        this.pk_cultivo = pk_cultivo;
        this.nomCultivo = nomCultivo;
        this.area = area;
        this.densidadSiembra = densidadSiembra;
        this.numPlantas = numPlantas;
        this.fechaPro = fechaPro;
        this.es_cosecha = es_cosecha;
        this.estatus = estatus;
        this.anio_organica = anio_organica;
        this.anio_inspeccion = anio_inspeccion;
        this.rotacion1 = rotacion1;
        this.rotacion2 = rotacion2;
        this.rotacion3 = rotacion3;
        this.obCultivo = obCultivo;
        this.fk_visitasc = fk_visitasc;
    }
  

    //zona de gett y setts
    public int getPk_cultivo() {
        return pk_cultivo;
    }

    public void setPk_cultivo(int pk_cultivo) {
        this.pk_cultivo = pk_cultivo;
    }

    public String getNomCultivo() {
        return nomCultivo;
    }

    public void setNomCultivo(String nomCultivo) {
        this.nomCultivo = nomCultivo;
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

    public String getFechaPro() {
        return fechaPro;
    }

    public void setFechaPro(String fechaPro) {
        this.fechaPro = fechaPro;
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

    public String getRotacion1() {
        return rotacion1;
    }

    public void setRotacion1(String rotacion1) {
        this.rotacion1 = rotacion1;
    }

    public String getRotacion2() {
        return rotacion2;
    }

    public void setRotacion2(String rotacion2) {
        this.rotacion2 = rotacion2;
    }

    public String getRotacion3() {
        return rotacion3;
    }

    public void setRotacion3(String rotacion3) {
        this.rotacion3 = rotacion3;
    }

    public String getObCultivo() {
        return obCultivo;
    }

    public void setObCultivo(String obCultivo) {
        this.obCultivo = obCultivo;
    }

    
    
    
    public int getFk_visitasc() {
        return fk_visitasc;
    }

    public void setFk_visitasc(int fk_visitasc) {
        this.fk_visitasc = fk_visitasc;
    }
    
    

}
