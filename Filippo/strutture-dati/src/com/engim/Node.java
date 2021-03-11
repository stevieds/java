package com.engim;

public class Node extends List {
    private int value;
    private List next;

    public Node(int value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }

    @Override
    public List addLast(int x) {
        this.next = next.addLast(x);
        return this;
    }

    public void addLast2(int x) {
        if (this.next instanceof Nil)
            this.next = new Node(x, this.next);
        else
            this.next.addLast2(x);
    }

    @Override
    public List add(int x, int indice) {
        if (indice == 0) {
            // si crea un nuovo nodo: x corrisponde a value e next + la value precedente
            // diventano il next
            this.next = new Node(this.value, this.next);
            this.value = x;
        } else {
            this.next = this.next.add(x, indice - 1);
        }
        return this;
    }

    @Override
    public List removeAtIndex(int indice) {
        if (indice == 0) {
            return this.next.remove(indice);
        } else {
            this.next = this.next.removeAtIndex(indice - 1);
            return this;
        }
    }


    @Override
    public int nAtIndex(int indice) {
        if (indice == 0) {
            return this.value;
        } else {
            int ret=this.next.nAtIndex(indice - 1);
            return ret;
        }
    }






    @Override
    public List remove(int x) {
        if (this.value == x)
            return this.next.remove(x);
        // Rimuove X restituendo tutto ciò che segue x
        //Funziona come puntatore, lista=remove(n)
        else {
            this.next = this.next.remove(x);
            return this;
        }
    }

    @Override
    public List doppio() {
        this.value=this.value*2;
        return this.next.doppio();
    }

    @Override
    public boolean pari() {
        boolean pari;
        if (this.value%2==0) {
            pari=true;
            return this.next.pari();
        } else {
            return pari=false;
        }
    }

    @Override
    public boolean ordinata(int n) {
        boolean isOrdinata;
        if (this.value >= n) {
            isOrdinata=true;
            return this.next.ordinata(value);
        } else {
            return isOrdinata=false;
        }
    }


    @Override
    public int length() {
        return 1 + this.next.length();
    }





}
