import java.util.Scanner;
import java.util.ArrayList;

public class Calcolatrice {
    public static void main (String[] args) {
        Scanner tastiera = new Scanner(System.in);
        Stack<Double> stack = new Stack <>();
        String s= tastiera.nextLine();

        String[] buffer = s.split(" ");
        for (String elem: buffer) {
            try {
                double d = Double.parseDouble(elem);
                stack.push(d);
            } catch (Exception e) {
                switch (elem) {
                    case "+":
                        somma(stack);
                        break;
                    case "-":
                        sottrazione(stack);
                        break;
                    case "*":
                        moltiplicazione(stack);
                        break;
                    case "/":
                        divisione(stack);
                        break;
                    default:
                        System.out.println("Errore");
                        break;
                }
            }
        }
    }

    public static void somma (Stack<Double> stack) {
        if (stack.size()>1) {
            double a=stack.pop();
            double b=stack.pop();
            System.out.println(a+b);
            stack.push(a+b);
        }
        else {
            System.out.println("ERRORE nella sintassi");
        }
    }
    public static void sottrazione (Stack<Double> stack) {
        if (stack.size()>1) {
            double a=stack.pop();
            double b=stack.pop();
            stack.push(a-b);
        }
        else {
            System.out.println("ERRORE nella sintassi");
        }
    }
    public static void moltiplicazione (Stack<Double> stack) {
        if (stack.size()>1) {
            double a=stack.pop();
            double b=stack.pop();
            stack.push(a*b);
        }
        else {
            System.out.println("ERRORE nella sintassi");
        }
    }
    public static void divisione (Stack<Double> stack) {
        if (stack.size()>1) {
            double a=stack.pop();
            double b=stack.pop();
            stack.push(a/b);
        }
        else {
            System.out.println("ERRORE nella sintassi");
        }
    }
}
