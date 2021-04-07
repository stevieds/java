import Figure.Cerchio;
import Figure.Figura;
import Figure.Quadrato;
import Figure.Quadrilatero;

public class Main {

    public static void main(String[] args) {
	Figura[] lista = {
	        new Quadrato(15),
	        new Quadrilatero(5.5, 9),
	        new Cerchio(5)
    };
    for (Figura item : lista) {
        System.out.println(item.calcArea());
    }
    }
}
