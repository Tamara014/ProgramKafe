package Pack;
//Klasa za gazirani sok
public class GaziraniSok {
    private String[] gaziraniNiz;
    private int[] indeksGazirani;
    private String ime;
    private double cena;

    //Konstruktor
    public GaziraniSok(String[] gaziraniNiz) {
        this.gaziraniNiz = gaziraniNiz;
    }

    //F-ja koja vraca indeks izabrane stavke
    public void getSelectedButton(int[] indeks, String[] niz) {
        indeksGazirani = indeks;
        StringBuilder sb = new StringBuilder();
        for (int index : indeks) {
            sb.append(niz[index]).append(" ");
        }
        ime = sb.toString().trim();
    }

    //Geteri i seteri
    public String getIme() {
        return ime;
    }

    public void Cena() {
        cena = 250;
    }

    public double getCena() {
        return cena;
    }

    //Praznjenje selekcije
    public void clear() {
        indeksGazirani = null;
        ime = null;
        cena = 0;
    }
}

