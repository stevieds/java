package soluzione;

public class Node extends List {
    private String value;
    private List next;

    public Node(String value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }

    @Override
    public List add(String x, int i) {
        if(i==0) {
            this.next = new Node(this.value, this.next);
            this.value = x;
        }else{
            this.next = this.next.add(x, i-1);
        }
        return this;
    }

    @Override
    public List remove(String x) {
        if(this.value.equals(x))
            return this.next.remove(x);
        else {
            this.next = this.next.remove(x);
            return this;
        }
    }

    @Override
    public int countEndsWith(String suffix) {
        return value.endsWith(suffix) ? 1 + next.countEndsWith(suffix) : next.countEndsWith(suffix);

        /* questo è un modo compatto per scrivere:
        if(value.endsWith(suffix)
            return 1 + next.countEndsWith(suffix);
        else
            return next.countEndsWith(suffix);
        */
    }

    @Override
    public List getNext(){
        return next;
    }

    public String getValue() {
        return value;
    }

}
