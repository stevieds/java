public class Main {

    public static void main(String[] args) {

        List l = new Node("1N",new Node("2c",new Node("3N",new Nil())));
        l = l.add("A",1);
        l = l.add("E",1);
        l = l.add("N",1);
        l = l.add(l.getValue(),1);
        System.out.println(l);

        System.out.println(l.countEndsWith("N"));

        System.out.println(l.length());

        List reverse = new Nil();
      

        for (int i=0; i<l.length(); i++) {
            reverse=reverse.add(l.nAtIndex(i), 0);
            
        }

        System.out.println("Rev    "+reverse);

        


        /*

        l = l.add("New",1);

        ; // questo dovrebbe stampare 2

        

        ;
        // Scrivere un ciclo per invertire la lista l

        System.out.println(reverse);
        */
    }
}
