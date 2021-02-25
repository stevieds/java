import java.util.Arrays;

public class Coda {
    private Ordine[] ordini;
    private int nextDaOrdinare;
    private int nextDaCucinare;

    /*Constructor */
    public Coda() {
        this.ordini = new Ordine[100];
        this.nextDaOrdinare = 0;
        this.nextDaCucinare = 0;
    }


    public void aggiungiOrdine(Ordine ordine){
        this.ordini[this.nextDaOrdinare] = ordine;
        this.nextDaOrdinare++;
    }

    public void accoda(Cuoco cuoco){
        this.ordini[this.nextDaCucinare].cucina(cuoco);
    }

    public void serviOrdine (Cameriere cameriere) {
        this.ordini[this.nextDaCucinare].consegnato(cameriere);
        nextDaCucinare++;
    }




    @Override
    public String toString() {

        String s = "";
        for(int i = 0; i < this.nextDaOrdinare; i++)
            s += this.ordini[i] + "\n";
            s+="In lavorazione: "+(nextDaCucinare-1)+"\n"+"Evasi: "+nextDaCucinare;

        return s;
    }
}
