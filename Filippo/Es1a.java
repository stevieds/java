import java.util.Scanner;

public class Es1a {
    public static void main (String args[]) {
        /*params: anno:int,
        return: boolean */
        Scanner scan = new Scanner(System.in);
        System.out.println("Insert a year");
        int year = scan.nextInt();
        boolean leap=leapy(year);
        



        System.out.println(year+leapText(leap));
        


        

    }

    public static boolean leapy (int year) {
        boolean isleap;
        if (year % 4 != 0 || year % 400 != 0) {
            isleap = false;
        }
        else if (year % 100 != 0) {
            isleap = true;             
        }
        else {
            isleap = true;
        }
        return isleap;
    }

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
}