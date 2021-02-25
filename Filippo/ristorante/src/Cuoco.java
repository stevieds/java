public class Cuoco extends Personale{
    public Cuoco(String nome, Coda coda) {
        super(nome, coda);
    }


    public void inserisciOrdine(){
        getCoda().accoda(this);
    }


}
