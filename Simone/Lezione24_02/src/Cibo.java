public abstract class Cibo {
    private int cal;

    public Cibo (int cal) {
        setCal(cal);
    }
    public int getCal() {
        return cal;
    }
    protected void setCal(int cal) {
        if (cal > 0) {
            this.cal=cal;
        }
        else {
            this.cal=0;
        }
        this.cal = cal;
    }

    public abstract void consuma (int cal);
}
