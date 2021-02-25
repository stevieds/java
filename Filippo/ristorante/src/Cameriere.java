/* Sottoclasse di perdonale, lo si deduce da extends*/
public class Cameriere extends Personale{
    /* Non ha nessuna variabile elencata perché prende quelle di personale*/ 

    public Cameriere(String nome, Coda coda) {
        super(nome, coda);
        /* Un costruttore di questo tipo indica che è identico a quello della classe genitrice*/
    }

    public void inserisciOrdine(Tavolo tavolo, Piatto piatto){
        Ordine ordine = new Ordine(piatto,tavolo,this);
        getCoda().aggiungiOrdine(ordine);
    }

    public void consegna () {
        getCoda().serviOrdine(this);

    }
}
