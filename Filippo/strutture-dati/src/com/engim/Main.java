package com.engim;

public class Main {

    public static void main(String[] args) {
        List lista = new Node(1,new Node(2,new Node(3,new Nil())));
/*
        Nil nil = new Nil();
        Node n3 = new Node(3, nil);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        List l1 = n1;*/

        System.out.println(lista);
        // 0 è un int che viene aggiunto all'inizio, 1 è il node stesso. 
        lista = new Node(0, lista);

        System.out.println(lista);

        lista = lista.addLast(4);
        System.out.println(lista);

        lista = new Node (25, lista);
        

        System.out.println(lista);

        System.out.println("Remove");
        lista=lista.remove(25);
        System.out.println(lista);

System.out.println("Add 5");
        lista.add(5, 3);
        System.out.println(lista);

        System.out.println("Remove at Index");

        lista=lista.removeAtIndex(0);
        System.out.println(lista);
        lista.doppio();
        System.out.println(lista);
        System.out.println(lista.pari());

        System.out.println("Ordinata");
        System.out.println(lista.ordinata((lista.nAtIndex(1))));

        System.out.println(lista.nAtIndex(1));


        System.out.println("New");




    }
}
