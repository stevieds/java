public class Arma {
    private float calibro;
    private float potenza;
    private int caricatore;
    public static int maxCaricatore;

    @Override
    public String toString() {
        return "Arma { potenza: "+potenza+" calibro: "+calibro+" caricatore:"+caricatore+"}";
    }

    public Arma(float calibro, float potenza, int caricatore) {
        this.calibro = calibro;
        this.potenza = potenza;
        this.caricatore = maxCaricatore;
    }

    public boolean sparo () {
        System.out.println("L'arma spara con "+potenza);
        return false;

    }

    public void ricarica () {    }

    public static void statico () {

    }


}
