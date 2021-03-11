import java.util.Scanner;

public class Rombi {
    public static void main (String args []) {
        int base, altezza, b, h;
        Scanner readInput = new Scanner(System.in);
        System.out.println("Base");
        base=readInput.nextInt();
        System.out.println("Altezza");
        altezza=readInput.nextInt();
        b=base;
        h=altezza;
        int count=b/2;
        int count2=1;

            while (h>(h/2)) {

            while (count>(count/2)) {
                System.out.print(" ");
                count--;
            }

            for (int i=count2; i>0; i--) {
                System.out.print("*");
                count=count--;
            }
            count2+=2;


            while (count>0) {
                System.out.print("");
                count--;
            }
            b=b-2;
            count=b;
            System.out.println("");
            h--;
        }


    

        }

}