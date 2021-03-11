package soluzione;

public class Main_Soluzione {

    public static void main(String[] args) {

        List l = new Node("1N",new Node("2N",new Node("3",new Nil())));

        l = l.add("New",1);

        System.out.println(l.countEndsWith("N")); // questo dovrebbe stampare 2

        System.out.println("Inverti l'array");

        List reverse = new Nil();
        for(List list = l; l instanceof Node; l = l.getNext()){
            // Scrivere un ciclo per invertire la lista l
            String value = ((Node) l).getValue();
            reverse = new Node(value,reverse);
        }
        System.out.println(reverse);
    }
}
