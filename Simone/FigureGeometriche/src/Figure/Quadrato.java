package Figure;

public class Quadrato extends Figura {
    private double lato;


    public Quadrato(double lato) {
        this.lato = lato;
    }

    public double calcArea () {
        double area = this.lato*this.lato;
        return area;
    }
}
