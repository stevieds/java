//Es1a: Si scriva un programma con i seguenti metodi: 
import java.util.Scanner;
public class Es1a {
    public static void main (String args[]) {
        /* bisestile: dato un anno ritorna se è bisestile o no. Cercate su wikipedia la regola se non la conoscete.
        params: anno:int,
        return: boolean */

        //Ask user to input a year and assign such input to variable year
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert a year");
        int year = scan.nextInt();

        //Check whether year input is leap or not
        boolean leap=leapy(year);
        //Return and print answer
        System.out.println(year+leapText(leap));

        /* inverti: dato un array, restituisce l'array al contrario. Es: {1,2,3,4,5,6} ritorna: {6,5,4,3,2,1}
        params: array: int[]
        return: int[] */ 
        int [] arr = {1,2,3,4,5,6};
        int [] reversed = inverti(arr); 
        for (int i=0; i<reversed.length; i++) {
            System.out.println(reversed[i]);
        }
    }

    /* Check if year input is leap according to the following rules:
    -leap must be: a century year divisible by 400, 
        a non-secular year divisible by 4
    */
    public static boolean leapy (int year) {
        boolean isleap;
        if (year % 100 !=0 && year % 4 == 0) {
            isleap=true;
        }
        else if (year % 100 == 0 && year % 400 == 0) {
            isleap = true;
        }
        else {
            isleap = false;
        }
        return isleap;
    }

    /* Return an answer depending on the value of variable leap*/ 
    public static String leapText (boolean leap) {
        String answer;
        if (leap==false) {
            answer=" is not a leap year";
        }
        else {
            answer=" is a leap year";
        }
        return answer;
    }

    //Reverse the array
    public static int[] inverti (int[] original) {
        int [] reverse = new int [original.length];
        int i=0;
        int j=original.length-1;
        while (i<original.length && j>=0) {
            reverse[i]=original[j];
            i++;
            j--;
        }
        return reverse;
    }
}