import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Main {

    public static void main(String[] args) {
        String nomeFile = "output2.txt";
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(nomeFile);
        } catch (FileNotFoundException e ) {
            System.out.println("Errore");
        }
        pw.println("Ciao");
        pw.close();

    }
}
