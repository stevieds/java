import java.util.ArrayList;

public class Player {
    private final String name;
    private ArrayList<Listener> listeners;

    public Player(String name) {
        this.name=name;
        listeners = new ArrayList<>();
    }

    public void addL(Listener listener) {
        listeners.add(listener);
    }

    public void removeL(Listener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners(ActionType actionT) {
        for (Listener listener : listeners) {
            listener.action(actionT);
        }
    }
    public void doAction (ActionType aType) {
        System.out.println("Azione: "+aType.name());
        this.notifyListeners(aType);
    }
}