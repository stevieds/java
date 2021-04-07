public class Posta extends Mezzo implements Ascoltatore   {


    @Override
    public void notifyMezzi(String msg) {
        System.out.println("POSTA: " + msg);
    }
}
