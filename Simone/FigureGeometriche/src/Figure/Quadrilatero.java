package Figure;

public class Quadrilatero extends Figura{
    private double base;
    private double altezza;


    public Quadrilatero(double base, double altezza) {
        this.base = base;
        this.altezza = altezza;
    }

    public double calcArea (double base, double altezza) {
        double area=(this.base * this.altezza) / 2;
        return area;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }
}
