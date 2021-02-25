public class Ordine {

    /* Una specie di boolean con più valori  */
    public enum Stato{
        RICEVUTO, IN_ELABORAZIONE, EVASO
    }

    private Piatto piatto;
    private Tavolo tavolo;
    private Cameriere cameriere;
    private Cuoco cuoco;
    private Stato stato;

    public Ordine(Piatto piatto, Tavolo tavolo, Cameriere cameriere) {
        this.piatto = piatto;
        this.tavolo = tavolo;
        this.cameriere = cameriere;
        this.stato = Stato.RICEVUTO;// un ordine appena creato acquisisce lo stato RICEVUTO di default 
    }

    public void cucina(Cuoco cuoco){
        this.stato = Stato.IN_ELABORAZIONE;
        this.cuoco = cuoco;
    }

    public void consegnato (Cameriere cameriere) {
        this.stato = Stato.EVASO;
        this.cameriere = cameriere;
    }

    public Piatto getPiatto() {
        return piatto;
    }

    public Tavolo getTavolo() {
        return tavolo;
    }

    public Cameriere getCameriere() {
        return cameriere;
    }

    public Stato getStato() {
        return stato;
    }

    @Override
    public String toString() {
        return piatto +
                ", " + tavolo +
                ", " + stato;
    }
}
