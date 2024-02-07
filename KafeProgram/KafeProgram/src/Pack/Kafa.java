package Pack;
//Klasa za kafu
public class Kafa {
    private String[] kafaNiz;
    private int[] indeksKafa;
    private String ime;
    private double cena;

  //Konstruktor
    public Kafa(String[] kafaNiz) {
        this.kafaNiz = kafaNiz;
    }

  //F-ja koja vraca indeks izabrane stavke
    public void getSelectedButton(int[] indeks, String[] niz) {
        indeksKafa = indeks;
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
        cena = 180;
    }

    public double getCena() {
        return cena;
    }

  //Praznjenje selekcije
    public void clear() {
        indeksKafa = null;
        ime = null;
        cena = 0;
    }
}

