import java.util.Scanner;

public class Pin {
    public static void main(String args[]) {
        int read, i, length;
        Scanner readInput = new Scanner(System.in);
        System.out.println("Inserire PIN:");
        //Read PIN as int 
        read=readInput.nextInt();
        //Count how many digit the PIN has
        length=count(read);
        int [] pin = new int [length];
        //Convert PIN to array
        pin=intToArray(read);
        int [] random = new int [10];
        //Generate array of 9 random int, ranging from 1 to 3
        random=randomArray (10);
        //Create a dummy pin 
        int [] dummy = new int [pin.length];
        dummy=dummy(pin, random);
        //Print the random array and numbers from 0 to 9
        for (i=0; i<10; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (i=0; i<random.length; i++) {
            System.out.print(random[i]+" ");
        }
        //Ask to check the PIN
        System.out.println("Inserire PIN:");
        read=readInput.nextInt();
        length=count(read);
        int [] pin2 = new int [length];
        pin2=intToArray(read);

        //Check if the pin is correct
        boolean check=pinCheck(dummy, pin2);
        //Based on the above check, return the appropriate answer
        System.out.println(answer(check));
    }


   // Convert int into an array
    public static int [] intToArray (int num) {
        int i;
        int length=count(num);
        int [] array = new int [length];
        for (i=array.length-1; i>=0; i--) {
            array[i]=num%10;
            num=num/10;
        }
        return array;
    }

    //Count the digits of an integer
    public static int count (int num) {
        int readLength=0, pinCount=num;
        while (pinCount>0) {
            pinCount=pinCount/10;
            readLength++;
        };
        return readLength;
    }

    //Create a random array
    public static int [] randomArray (int amount) {
        int i;
        int [] random = new int [amount];
        for (i=0; i<random.length; i++){
            random[i]=(int) (Math.random() * 3)+1;
        }
        return random;
    }

    //Create a dummy pin using the random array 
    public static int [] dummy (int [] pin, int random[]) {
        int i;
        int [] dummyPin = new int [pin.length];
        for (i=0; i<dummyPin.length; i++) {
            dummyPin[i]=random[pin[i]];
        }
        return dummyPin;
    }

    //Check if the original pin and the dummy pin match
    public static boolean pinCheck (int []dummy, int[]pin2) {
        boolean check=true;
        int i;
        for (i=0; i<pin2.length && check==true; i++) {
            if (pin2[i]!=dummy[i]) {
                check=false;
            }
        }
        return check;
    }

    //Return a String depending on the value of check (true / false)
    public static String answer (boolean check) {
        String answer;
        if (check==false) {
            answer="Il PIN non è stato inserito correttamente";
        }
        else {
            answer="PIN corretto";
        }
        return answer;
    }
}