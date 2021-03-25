import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EsempioPrintWriter {
    public static void main (String[] args) {
        String nomeFile = "output3.txt";
        PrintWriter pw = null;

        try {
            pw = new PrintWriter(nomeFile);
        } catch (FileNotFoundException e ) {
            System.out.println("Errore");
        }
        pw.println("Uno due tre.");
        pw.close();



        Scanner file = null;
        try {
            file = new Scanner(new File(nomeFile));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(file.nextLine());
    }
}
