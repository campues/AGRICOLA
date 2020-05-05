package Modelo;

public class Provincia {
    //zona de atributo

    private int pk_provincia;
    private String nomProvincia;
    //zona de contructores

    public Provincia() {
    }

    public Provincia(int pk_provincia, String nomProvincia) {
        this.pk_provincia = pk_provincia;
        this.nomProvincia = nomProvincia;
    }

    
//zona de getts y setts

    public int getPk_provincia() {
        return pk_provincia;
    }

    public void setPk_provincia(int pk_provincia) {
        this.pk_provincia = pk_provincia;
    }

    public String getNomProvincia() {
        return nomProvincia;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }

   
    
}
