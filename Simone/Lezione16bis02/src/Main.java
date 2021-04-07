import java.net.SocketOption;
import java.net.SocketTimeoutException;

public class Main {
    public static void main (String args[]) {
        Arma ak47= new Arma (3.72f, 11.32f, 120);



        Arma revolver = new Arma(20.2f, 32.2f, 120);




        System.out.println(ak47);
        System.out.println(revolver);
        System.out.println(Arma.maxCaricatore);
        revolver.maxCaricatore=123;
        System.out.println(ak47);
        System.out.println(revolver);
        System.out.println(Arma.maxCaricatore);
        ak47.maxCaricatore=85;
        System.out.println(ak47);
        System.out.println(revolver);
        System.out.println(Arma.maxCaricatore);




    }
}
