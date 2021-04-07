public class Email extends Mezzo implements Ascoltatore  {


    @Override
    public void notifyMezzi(String msg) {
        System.out.println("EMAIL: " + msg);
    }
}
