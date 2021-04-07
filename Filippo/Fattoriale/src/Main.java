public class Main {

    public static int fattoriale(int num) {
        if (num == 1) {
            return num;
        }
	    else
        {return num * (num - 1) * fattoriale(num - 2);}
    }

    public static int fibonacci(int num) {
        if (num == 0) {
            return 1;
        } else if (num == 1) {
            return 1;
        } else
        {
            return fibonacci(num-1) + fibonacci(num-2);
        }
        }

        public static void stringaContrario (String s, int i) {
        if (i==0) {
            System.out.print(s.charAt(i));
        } else {
            System.out.print(s.charAt(i));
            stringaContrario(s, i-1);
        }
        }


    public static void main(String[] args) {
        System.out.println(fattoriale(5));

        System.out.println(fibonacci(5));

        String s = "Ciao";

        stringaContrario(s, s.length()-1);

    }
}
