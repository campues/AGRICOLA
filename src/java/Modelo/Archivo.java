package Modelo;

public class Archivo {

    private int pk_archivo;
    private String nomArchivo;
    private String tipo;
    private String ruta;
    private String fk_agricultord;

    public Archivo() {
    }
//constructor

    public Archivo(int pk_archivo, String nomArchivo, String tipo, String ruta, String fk_agricultord) {
        this.pk_archivo = pk_archivo;
        this.nomArchivo = nomArchivo;
        this.tipo = tipo;
        this.ruta = ruta;
        this.fk_agricultord = fk_agricultord;
    }
    

    public String getTipo() {   
        return tipo;
    }

// gets y setts
    public void setTipo(String tipo) {    
        this.tipo = tipo;
    }

    public int getPk_archivo() {
        return pk_archivo;
    }

    public void setPk_archivo(int pk_archivo) {
        this.pk_archivo = pk_archivo;
    }

    public String getNomArchivo() {
        return nomArchivo;
    }

    public void setNomArchivo(String nomArchivo) {
        this.nomArchivo = nomArchivo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getFk_agricultord() {
        return fk_agricultord;
    }

    public void setFk_agricultord(String fk_agricultord) {
        this.fk_agricultord = fk_agricultord;
    }

}
