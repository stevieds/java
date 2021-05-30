package view.room;

import Controller.RoomController;
import db.DbRoom;
import model.Room;
import view.PopUp;
import view.PopUpFail;
import view.PopUpSimple;
import view.PopUpSuccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpNewRoom extends PopUp implements ActionListener {
    JTextField jName;
    JLabel lName;

    public PopUpNewRoom() {
        super();
        this.setSize(390, 190);
        this.setTitle("Aggiungi nuova sala");

        this.data.setLayout(new FlowLayout());

        this.centre.setLayout(new FlowLayout());
        this.descr.setText("Aggiungi un nuovo studio di registrazione");
        descr.setFont(peignotBig);
        descr.setHorizontalAlignment(SwingConstants.CENTER);
        this.top.add(descr);

        this.centreContent.setLayout(new GridLayout(8, 1));

        this.centreContent.setPreferredSize(new Dimension(256, 188));

        this.lName = new JLabel("Nome");
        this.centreContent.add(this.lName);
        this.jName = new JTextField(50);
        this.centreContent.add(this.jName);




        this.centre.add(centreContent);
        this.add(centre, BorderLayout.CENTER);

        this.ok.setText("Invia");
        this.ex.setText("Annulla");
        this.ko.setText("Reset");


        this.buttons.add(this.ex);

        this.ok.setPreferredSize(new Dimension(75, 30));
        this.ok.setBackground(buttonGr);

        this.ok.setForeground(lightGray);
        this.ok.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        this.ko.setPreferredSize(new Dimension(75, 30));
        this.ko.setBackground(darkGray);

        this.ko.setForeground(lightGray);
        this.ko.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));



        this.ex.setPreferredSize(new Dimension(75, 30));
        this.ex.setBackground(buttonRed);
        this.ex.setForeground(lightGray);
        this.ex.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean result;
        String command = e.getActionCommand();
        if (command.equals("Invia")) {

            result = RoomController.addRoom(this.jName.getText());

            if (result) {
                new PopUpSimple("Operazione eseguita correttamente").setVisible(true);
                this.jName.setText("");
            } else if (!result) {
                new PopUpSimple("Attenzione! \n Si è verificato un errore").setVisible(true);
            }
        }
        else if (command.equals("Reset")) {
            this.jName.setText("");
        }
        else if (command.equals("Annulla")) {
            this.dispose();
        }
    }
}
