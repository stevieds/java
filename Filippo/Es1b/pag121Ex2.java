import java.util.Scanner;

public class pag121Ex2 {
    public static void main (String args[]) {
        /*Scrivere un frammento di codice che cambi il valore intero memorizzato nella varia-J bile X nel seguente modo: se x è pari, deve essere diviso per 2; se è dispari deve essere! moltiplicato per 3 e gli deve esser sottratto 1.*/
        int x;
        Scanner readInput = new Scanner(System.in);
        System.out.println("Insert a number");
        x=readInput.nextInt();
        if (x%2==0) {
            System.out.println(x/2);
        }
        else {
            System.out.println((x*3)-1);
        }
    }
}