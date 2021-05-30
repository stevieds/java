package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Destroyer extends WindowAdapter {
    public void windowClosing(WindowEvent e) {
        e.getWindow().removeAll();
        e.getWindow().dispose();
        //

    }
}
