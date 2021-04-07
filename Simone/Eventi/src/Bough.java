public class Bough implements Listener{

    private float thickness;

    public Bough (float thickness) {
        this.thickness=thickness;
    }

    @Override
    public void action(ActionType action) {
        switch (action) {
            case LanciaLontano:
                break;
            case PremiBottone:
                System.out.println("Mi piego");
                break;
            case TiraLeva:
                System.out.println("Mi piego e mi ripiego");
                break;
        }
    }

    }
