public abstract class Main {
    public static void main(String[] args) {
	Cibo pane = new Cibo(25);
	System.out.println(pane.cal);
    }
    public abstract int consuma(int cal);
}
