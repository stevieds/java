public class Sms extends Mezzo implements Ascoltatore  {


    @Override
    public void notifyMezzi(String msg) {
        System.out.println("SMS: " + msg);
    }
}