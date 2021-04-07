public class Main {

    public static void main(String[] args) {
        GestoreMessaggi gest = new GestoreMessaggi();
        gest.addAscoltatore(new Sms());
        gest.addAscoltatore(new Email());
        gest.addAscoltatore(new Posta());
        gest.newMsg("Ciao Ciao");
    }
}
