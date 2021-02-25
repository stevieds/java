public class Piatto {
    private String nome;

    /* Constructor */
    public Piatto(String nome) {
        this.nome = nome;
    }

    /* Getter */
    public String getNome() {
        return nome;
    }

    /* Indica che, per questa data classe, il metodo nativo toString() funziona diversamente, cioè viene overidden.
    Senza override toString() restituirebbe un valore simile a questo Piatto@5305068a */
    @Override
    public String toString() {
        return nome;
        
    }
    
}
