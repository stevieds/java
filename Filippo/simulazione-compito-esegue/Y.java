public class Y extends X implements Interf {
    public Y(int a){
        super(a,a);
    }

    @Override
    public boolean metodo1() {
        return false;

        //return a % 2 == 0;
    }

    public int metodo2(int num){
        return num+metodo2();
    }


}
