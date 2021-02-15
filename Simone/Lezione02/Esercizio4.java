import java.util.Scanner;

public class Esercizio4 {
    public static void main (String args []) {
        int base, altezza, lato, superficie=0, raggio;
        String figura;
        Scanner readInput = new Scanner(System.in);
        System.out.println("Selezionare figura: quadrato, triangolo, cerchio, rettangolo");
        figura=readInput.next();
        switch (figura) {
            case "quadrato":
            System.out.println("Inserire lato: ");
            lato=readInput.nextInt();
            superficie=areaQuadrato(lato);
            break;
            case "cerchio":
            System.out.println("Inserire raggio: ");
            raggio=readInput.nextInt();
            superficie=areaCerchio(raggio);
            break;
            case "rettangolo":
            System.out.println("Inserire base: ");
            base=readInput.nextInt();
            System.out.println("Inserire altezza: ");
            altezza=readInput.nextInt();
            superficie=areaRettangolo(altezza, base);
            break;
            case "triangolo":
            System.out.println("Inserire base: ");
            base=readInput.nextInt();
            System.out.println("Inserire altezza: ");
            altezza=readInput.nextInt();
            superficie=areaTriangolo(altezza, base);
            break;
            default:
            System.out.println("Invalid");
        }
        System.out.println("La superficie è: "+superficie);





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
        int area = l*l;
        return area;
    }
    public static int areaCerchio (int r) {
        double piGreco=3.14;
        double area=(r*r)*piGreco;
        return (int)area;
    }

    public static int areaTriangolo (int h, int b) {
        int area = (h * b)/2;
        return area;
    }
}