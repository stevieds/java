import java.util.Scanner;
/* Scrivere un programma in una classe ConteggioFiori che calcoli il prezzo di vendita di mazzi di fiori. Ci sono cinque tipi di fiori (petunie, viole del pensiero, rose, violette e garofani) che vengono venduti, rispettivamente, a € 0.50, € 0.75, € 1.50, € 0.50 e € 0.80 per fiore. Creare un array di stringhe che memorizzi il nome di questi fiori. Creare un altro array che memorizzi i prezzi per ogni tipo di fiore. II programma dovrebbe leggere il nome del fiore e la quantità desiderata dal cliente. Localizzare il nome del fiore nelFarray e utilizzare l’indice per trovare il suo prezzo nelFarray dei prezzi. Calcolare e visualizzare il prezzo totale del mazzo dì fiori. 
Pag 255, Ex3*/

public class Pag255Ex3 {
    public static void main (String args[]) {
        int howMany;
        String which, print;
        double total;

        String [] flowers = {"petunie", "viole del pensiero", "rose", "violette", "garofani"};
        double [] prices = {0.50, 0.75, 1.50, 0.50, 0.80};
        Scanner scan = new Scanner(System.in);
        System.out.println ("Selezionare fiore tra:");
        for (int i=0; i<flowers.length; i++) {
            System.out.println (flowers[i]);
        }
        which = scan.nextLine();
        System.out.println ("Quanti?");
        howMany = scan.nextInt();
        total=ConteggioFiori(flowers, prices, howMany, which);
        print=Answer(flowers, prices, howMany, which, total);
        System.out.println(print);
    }



    public static double ConteggioFiori (String [] flowers, double [] prices, int howMany, String which) {
        double tot;
        int i=0;
        //Check which value of flowers[] is the same as which and assign the index of flowers[] to variable index
        while (flowers[i] == which) {
            i++;
        }
        tot = prices[i]*howMany;
        return tot;
        // calculate the total amount to pay[]
    }

    public static String Answer (String [] flowers, double [] prices, int howMany, String which, double tot) {
        String sentence = "Un mazzo di "+howMany+" "+which+" costa "+tot+" EUR";
        return sentence;
    }

    
    
}
