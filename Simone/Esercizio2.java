import java.util.Scanner;
import java.lang.String;

/* 
Si realizzi una classe Java Main che definisce:
a. il metodo contaVocali che accetta in ingresso una stringa e restituisce il numero di vocali presenti nella stringa;
b. il metodo main che iterativamente chiede all'utente di inserire una stringa se la stringa inserita ha un numero di vocali minore minore od uguale a 5. Stampa quindi il numero di vocali dell'ultima stringa inserita.
Domanda: il carattere vuole solo gli apici e non le viroglette?
*/

public class Esercizio2 {

    public static void main (String args[]) {
        System.out.println("Insert a string of text");
        Scanner readInput = new Scanner(System.in);
        String textString = readInput.next();
        System.out.println (contaVocali(textString));
        }

    public static int contaVocali (String vocals) {
        int i;
        int vocalsAmount = 0;
        String lowVocals=vocals.toLowerCase();
        for (i=0; i<vocals.length(); i++) {
            if (lowVocals.charAt(i)=='a' || lowVocals.charAt(i)=='e' || lowVocals.charAt(i)=='i' || lowVocals.charAt(i)=='o' || lowVocals.charAt(i)=='u' ) {
                vocalsAmount++;
            }
        }
        return vocalsAmount;
    }
}