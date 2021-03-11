public abstract class List {

    public abstract List add(String x, int i);

    // rimuove tutte le occorrenze di x
    public abstract List remove(String x);

    // Utilizzando il metodo endsWith(String suffix) di String che restituisce true se una stringa termina con il suffix,
    // restituire il numero di nodi che terminano con suffix.
    public abstract int countEndsWith(String suffix);

    public abstract List getNext();



    public abstract String getValue();

    public abstract int length();


    public abstract String nAtIndex(int indice);
}
