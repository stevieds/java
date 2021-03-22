
public class W implements Interf {

    private int a;

    public W(int a){
        this.a = a;
    }

    @Override
    public boolean metodo1() {
        return a % 2 != 0;
    }

}
