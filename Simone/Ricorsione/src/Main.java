public class Main {

    public static void main(String[] args) {

        System.out.println(exp(3, 4));

    }


        public static int exp(int b, int e) {
            return (e==0) ? 1 : b * exp(b, e-1);
        }
}
