package Modelo;

public class Provincia {
    //zona de atributo

    private int pk_provincia;
    private String nom_provincia;
    //zona de contructores

    public Provincia() {
    }

    public Provincia(int pk_provincia, String nom_provincia) {
        this.pk_provincia = pk_provincia;
        this.nom_provincia = nom_provincia;
    }
//zona de getts y setts

    public int getPk_provincia() {
        return pk_provincia;
    }

    public void setPk_provincia(int pk_provincia) {
        this.pk_provincia = pk_provincia;
    }

    public String getNom_provincia() {
        return nom_provincia;
    }

    public void setNom_provincia(String nom_provincia) {
        this.nom_provincia = nom_provincia;
    }
    
}
