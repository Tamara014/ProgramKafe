package Pack;

//Klasa za negazirani sok
public class NegaziraniSok {
    private String[] negaziraniNiz;
    private int[] indeksNegazirani;
    private String ime;
    private double cena;

  //Konstruktor
    public NegaziraniSok(String[] negaziraniNiz) {
        this.negaziraniNiz = negaziraniNiz;
    }

  //F-ja koja vraca indeks izabrane stavke
    public void getSelectedButton(int[] indeks, String[] niz) {
        indeksNegazirani = indeks;
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
        cena = 120;
    }

    public double getCena() {
        return cena;
    }

  //Praznjenje selekcije
    public void clear() {
        indeksNegazirani = null;
        ime = null;
        cena = 0;
    }
}

