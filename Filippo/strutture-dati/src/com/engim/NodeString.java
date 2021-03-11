package com.engim;

public class NodeString extends List {
    private String value;
    private List next;

    public NodeString(String value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }

    @Override
    public List add(String x, int i) {
        if(i==0) {
            this.next = new NodeString(this.value, this.next);
            this.value = x;
        }else{
            this.next = this.next.add(x, i-1);
        }
        return this;
    }

    @Override
    public List remove(String x) {
        if(this.value.equals(x))
            return this.next.remove(x);
        else {
            this.next = this.next.remove(x);
            return this;
        }
    }


    // Utilizzando il metodo endsWith(String suffix) di String che restituisce true se una stringa termina con il suffix,
    // restituire il numero di nodi che terminano con suffix.
    @Override
    public int countEndsWith(String suffix) {

    }

    @Override
    public List getNext(){
        return next;
    }

    public String getValue() {
        return value;
    }
 
}
