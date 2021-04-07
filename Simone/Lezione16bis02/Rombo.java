import java.util.Scanner;

public class Rombo {
    public static void main(String args[]) {
        Scanner readInput = new Scanner(System.in);
        int base, altezza, col, row;
        System.out.println("Inserire la base:");
        base = readInput.nextInt();
        System.out.println("Inserire l'altezza:");
        altezza = readInput.nextInt();
        /*
        System.out.println("Inserire il numero di colonne:");
        col = readInput.nextInt();
        System.out.println("Inserire il numero di righe:");
        row = readInput.nextInt();
        */
        int b = base;
        int h = altezza;
        // int c = col;
        // int r = row;
        int count = 1;
        int w=b/2;

        for (; h > 1; h--) {
            for (; w > 1; w--) {
                int count2 = count;
                    System.out.print(' ');
                    
                    while (count2 > 0) {
                        System.out.print('*');
                        count2--;
                    }
                }


            }

            System.out.println();
        }
    }

