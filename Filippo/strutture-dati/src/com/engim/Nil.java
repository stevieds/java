package com.engim;

public class Nil extends List{

    @Override
    public String toString() {
        return "";
    }

    @Override
    public List addLast(int x) {
        return new Node(x, this);
    }

    @Override
    public void addLast2(int x) {
    }

    @Override
    public List remove(int x) {
        return this;
    }

    @Override
    public List removeAtIndex(int x) {
        return this;
    }

    @Override
    public List doppio() {
        return this;
    }

    @Override
    public boolean pari() {
        return true;
    }

    @Override
    public boolean ordinata(int n) {
        return true;
    }

}
