public class Personale {
    private String nome;
    private Coda coda;

    /* Costruttore, in questo caso è default perché ci sono tutte le variabili*/ 
    public Personale(String nome, Coda coda) {
        this.nome = nome;
        this.coda = coda;
    }

    /* Siccome nome è private e quindi 'invisibile' è necessario creare un metodo ad-hoc se si desidera conoscere il nome */
    public String getNome() {
        return nome;
    }

    /* Siccome nome è private è necessario creare un metodo per cambiare il nome */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /* Idem per coda */
    public Coda getCoda() {
        return coda;
    }
}
