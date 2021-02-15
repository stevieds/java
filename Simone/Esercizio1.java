import java.net.Socket;
import java.util.Scanner;

/*
Definire un metodo che accetta in ingresso 3 interi  min,  max  e  valore . Tale metodo deve verificare se  valore  è all’interno dell'intervallo  min  -  max  (estremi inclusi). Se è all’interno, il metodo restituisce true, false in caso contrario. Testare il corretto funzionamento nel metodo main.
*/

public class Esercizio1 {

    public static void main (String args[]) {
        Scanner readInput = new Scanner(System.in);
        System.out.println("Insert max value");
        int max = readInput.nextInt();
        System.out.println("Insert min value");
        int min = readInput.nextInt();
        System.out.println("Insert value to check");
        int val = readInput.nextInt();
        System.out.println(CheckRange(max, min, val));
        }

    public static boolean CheckRange (int a, int b, int c) {
        int difference = a - b;
        boolean inRange=false;
        if (difference >= c) 
        inRange = true;

        else
        inRange = false;

        return inRange;
    }
}
