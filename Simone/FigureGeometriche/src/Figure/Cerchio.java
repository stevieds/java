package Figure;

public class Cerchio extends Figura {
    private double raggio;
    private final double  piGreco=3.14;

    public Cerchio(double raggio) {
        this.raggio = raggio;
    }

    public double calcArea(double raggio, double piGreco) {
        double area=(this.raggio * this.raggio) * piGreco;
        return area;
    }

}