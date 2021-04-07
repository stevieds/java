public class Main {

    public static void main(String[] args) {
	Player giocatore = new Player ("John");
	Bough rametto = new Bough (23);
	Bomb mina = new Bomb (230);
	giocatore.addL(rametto);
        giocatore.addL(mina);
        giocatore.doAction(ActionType.PremiBottone);
    }
}
