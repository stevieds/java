public class Main {

    public static void main(String[] args) {
	List li = new Node (1, new Node(2, new Node(3, new Nil ())));
	li=new Node (25, li);
	System.out.println(li);
    };

}
