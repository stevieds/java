public class Node extends List {
    private int value;
    private List next;

    public Node (int value, List next) {
        this.value=value;
        this.next=next;
    }

    @Override
    public String toString() {
        return this.value+", "+next.toString();
    }


    @Override
    public List addLast(int x) {
        this.next=next.addLast(x);
        return this;
    }
}
