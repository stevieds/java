public class Tavolo {
    private int id;

    public Tavolo(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tavolo "+ id ;
    }
}
