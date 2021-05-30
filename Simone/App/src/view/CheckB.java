package view;

import model.Anello;
import model.Status;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CheckB extends JCheckBox implements ChangeListener {
    Anello anello;

    public CheckB (Anello anello) {
        super ();
        this.anello = anello;
        this.addChangeListener(this);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (this.isSelected()) {
            this.anello.setStatus(Status.DONE);
        } else {
            this.anello.setStatus(Status.WIP);
        }
    }
}
