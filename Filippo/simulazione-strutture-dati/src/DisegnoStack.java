public class DisegnoStack {

    public static void main(String[] args) {
        List l = new Node("N1",new Node("N2",new Node("N3",new Nil())));

        List m = new Node("N1",new Node("N2",new Node("N3",new Nil())));
        m = m.add("New",1);

        List n = new Node("N1",new Node("N2",new Node("N3",new Nil())));
        n = n.add("New",1);
        n = n.remove("N1");
    }




}
