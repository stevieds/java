import java.util.Scanner;

public class Esercizio3 {
    public static void main (String args []) {
        int base, altezza, lato, superficie;
        Scanner readInput = new Scanner(System.in);
        System.out.println("Inserire base: ");
        base=readInput.nextInt();
        System.out.println("Inserire altezza: ");
        altezza=readInput.nextInt();
        superficie=areaRettangolo(altezza, base);
        System.out.println("La superficie del rettangolo è: "+ superficie);
        System.out.println("Inserire lato: ");
        lato=readInput.nextInt();
        superficie=areaQuadrato(lato);
        System.out.println("La superficie del quadrato è: "+superficie);
    }

    public static int areaRettangolo (int h, int b) {
        int area = h * b;
        return area;
    }

    public static int areaQuadrato (int l) {
        int area = areaRettangolo (l, l);
        return area;
    }
}