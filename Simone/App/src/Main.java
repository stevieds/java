import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {

    public static void main(String[] args) {



        MyTime e = new MyTime ("2:45:11.3");



        Film f = new Film("Ciao", e);
        f.setPersonaggi("Mimi");
        f.setPersonaggi("Coco");

        Anello w = new Anello ("0:00:0.0", "0:45:11.3" );
        Anello y = new Anello ("0:50:0.0", "1:00:11.3" );
        MyTime x = new MyTime ("1:30:0.0");
        MyTime z = new MyTime ("1:45:11.3");

        f.addAnello(w);

        f.addAnello(y);

        f.addAnello("1:30:0.0", "1:45:11.3");

        boolean bool = f.checkPers("Lulu");
        System.out.println(bool);

        f.getAnelli();

        f.addCoupleToSub("Coco", "Sonia Mazza");

        /*

        System.out.println("0:00:0.0", "0:45:11.3");

        f.replacePersonaggio("Coco", "Cricket");
        System.out.println("*********************");
        System.out.println(a.length());

*/



        }
}

