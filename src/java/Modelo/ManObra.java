package Modelo;

public class ManObra {

    private int pk_manObra;
    private String familia;
    private String edad;
    private String sexo;
    private String cantidad;
    private String fk_lotem;

    public ManObra() {
    }

    public ManObra(int pk_manObra, String familia, String edad, String sexo, String cantidad, String fk_lotem) {
        this.pk_manObra = pk_manObra;
        this.familia = familia;
        this.edad = edad;
        this.sexo = sexo;
        this.cantidad = cantidad;
        this.fk_lotem = fk_lotem;
    }

    public int getPk_manObra() {
        return pk_manObra;
    }

    public void setPk_manObra(int pk_manObra) {
        this.pk_manObra = pk_manObra;
    }


    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFk_lotem() {
        return fk_lotem;
    }

    public void setFk_lotem(String fk_lotem) {
        this.fk_lotem = fk_lotem;
    }
    
    

}
