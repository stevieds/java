
public class Z extends X {
    public Z(int x){
        super(2*x,x);
    }

    @Override
    public int metodo2() {
        return super.metodo2()*2;
    }
}
