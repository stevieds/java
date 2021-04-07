import java.util.ArrayList;

public class GestoreMessaggi {
    private ArrayList<Mezzo> ascoltatori;

    public GestoreMessaggi () {
        ascoltatori = new ArrayList<Mezzo>();
    }

    public void addAscoltatore(Mezzo m) {
        this.ascoltatori.add(m);
    }

    public void newMsg (String msg) {
        for (Mezzo listener : ascoltatori) {
            listener.notifyMezzi(msg);
        }
    }

}