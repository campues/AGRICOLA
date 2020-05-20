package config;

public class GenerarSerie {

    int dato;
    String numero;

   
    public String NumeroSerie2(int dato) {
        this.dato = dato + 1;
        if ((this.dato >=1000) || (this.dato < 1000)) {
            numero = "" + this.dato;
        }
        if ((this.dato >= 100) || (this.dato < 100)) {
             numero = "0" + this.dato;
        }
        if ((this.dato >= 9) || (this.dato < 100)) {
             numero = "00"+ this.dato;
        }
        if (this.dato < 9) {
             numero = "000" + this.dato;
        }
        return this. numero;
    }

}
