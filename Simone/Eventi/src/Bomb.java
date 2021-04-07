public class Bomb implements Listener{

    private float force;

    public Bomb (float force) {
        this.force=force;
    }

    @Override
    public void action(ActionType action) {
        switch (action) {
            case LanciaLontano:
                break;
            case PremiBottone:
                System.out.println("Esplodooooooo");
                break;
            case TiraLeva:
                System.out.println("Esplodo-do-do");
                break;
        }
    }
}