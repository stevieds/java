public class Main {

    public static void main (String[] args) {

        X obj1 = new X (1, 2); // OK
        System.out.println(obj1.metodo2()); // Stampa 1-2=-1
        X obj2 = new Y (3); // OK
        // System.out.println(obj2.metodo2()); NO, ha bisogno di un argomento
        // System.out.println(obj2.metodo2(2)); NO, perché il metodo del tipo apparente (X) non richiede argomenti
        Y obj3 = new Y (3); // OK
        // System.out.println(obj3.metodo2()); NO, ha bisogno di un argomento
        System.out.println(obj3.metodo2(3)); // stampa 3+metodo2() di X ovvero 3-3= 3
        // X obj4 = new W (3); No, W non estende X

        /* if (obj4.metodo2() % 2 == 0) {
            System.out.println("ciao");
        }
        else {
            System.out.println("Java");
        } No, non è stato possibile creare obj4 */


        // Z obj5 = new Y(3); NO, Z estende X e non Y
        Z obj6 = new Z (3); // OK
        // System.out.println(obj6.metodo1()); NO, ne X ne Z hanno metodo1
        //Z obj7 = new Interf(7);







    }
}
