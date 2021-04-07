public class Lattuga extends Verdura{
    public Lattuga(int cal) {
        super(cal);
    }

    @Override
    public void consuma(int cal) {
        this.setCal(this.getCal() - cal);

    }


}
