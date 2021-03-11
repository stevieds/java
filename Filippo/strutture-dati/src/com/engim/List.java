package com.engim;

public abstract class List {

    public abstract List addLast(int x);
    public abstract void addLast2(int x);
    public abstract List add(int x, int i);
    public abstract int length();
    public abstract List remove(int x);
    public abstract List removeAtIndex(int i);
    public abstract List doppio();
    public abstract boolean pari();
    public abstract int nAtIndex(int i);
    public abstract boolean ordinata(int next);

        // Utilizzando il metodo endsWith(String suffix) di String che restituisce true se una stringa termina con il suffix,
    // restituire il numero di nodi che terminano con suffix.
    public abstract int countEndsWith(String suffix);






}
