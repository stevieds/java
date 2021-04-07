import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> values;

    public Stack() {
        this.values = new ArrayList<>();
    }

    public void push (T value) {
        values.add(value);
    }

    public T pop () {
        T v;
        if (!this.isEmpty()) {
            v = values.get(values.size()-1);
            return values.remove(values.size()-1);
        } else {
            return null;

        }

    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public void stampa() {
        if (this.isEmpty()) {
            System.out.println("[]");
        }
        for (T elem:values) {
            System.out.println(elem + " ");
        }
    }

    public int size () {
        return values.size();

    }






}
