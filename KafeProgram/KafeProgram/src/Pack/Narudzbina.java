package Pack;

import java.util.ArrayList;

public class Narudzbina {
    private ArrayList<StavkaNarudzbine> stavke;

    public Narudzbina() {
        stavke = new ArrayList<>();
    }

    public void dodajStavku(StavkaNarudzbine stavka) {
        stavke.add(stavka);
    }

    public ArrayList<StavkaNarudzbine> getStavke() {
        return stavke;
    }

    public double izracunajUkupnuCenu() {
        double ukupnaCena = 0;
        for (StavkaNarudzbine stavka : stavke) {
            ukupnaCena += stavka.getCena() * stavka.getKolicina();
        }
        return ukupnaCena;
    }
}
