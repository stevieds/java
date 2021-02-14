import java.util.Scanner;

/* Si realizzi una classe Java che abbia definito un metodo chiamato divisibile che accetta in ingresso due interi e restituisce true se il primo intero è divisibile per il secondo, false in caso contrario */

public class Pag205Ex3 {
    public static void main (String args[]) {
        Scanner scan = new Scanner(System.in);
        int first, second;
        boolean isDivisible;
        System.out.println ("Insert first integer");
        first=scan.nextInt();
        System.out.println ("Insert second integer");
        second=scan.nextInt();
        isDivisible=divisibile(first, second);
        System.out.println (isDivisible);
    }

    public static boolean divisibile (int first, int second) {
        boolean answer;
        if (first % second == 0) {
            answer = true;
        }
        else {
            answer = false;
        }
        return answer;
    }
}