package Pack;

import java.util.ArrayList;

//Klasa za stavku narudzbine
public class StavkaNarudzbine {
    private String naziv;
    private int kolicina;
    private double cena;

  //Konstruktor
    public StavkaNarudzbine(String naziv, int kolicina, double cena) {
        this.naziv = naziv;
        this.kolicina = kolicina;
        this.cena = cena;
    }
    

  //Geteri i seteri
    public String getNaziv() {
        return naziv;
    }

    public int getKolicina() {
        return kolicina;
    }

    public double getCena() {
        return cena;
    }
}

