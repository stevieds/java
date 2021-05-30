package view.staff;

import Controller.StaffController;
import model.Personale;
import view.PopUp;
import view.PopUpFail;
import view.PopUpSimple;
import view.PopUpSuccess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PopUpNewDir extends PopUp {
    JTextField jFname;
    JTextField jLname;
    JTextField jContact;
    JLabel lFname;
    JLabel lLname;
    JLabel lContact;
    JPanel centre;
    JPanel centreContent;


    public PopUpNewDir() {
        super();
        this.setSize(411, 280);
        this.setTitle("Aggiungi nuovo direttore");



        this.data.setLayout(new FlowLayout());
        this.centre = new JPanel();
        this.centreContent = new JPanel();
        this.centre.setLayout(new FlowLayout());
        this.descr.setText("Aggiungi un nuovo direttore di doppiaggio");
        descr.setFont(peignotBig);
        descr.setHorizontalAlignment(SwingConstants.CENTER);
        this.top.add(descr);


        this.centreContent.setLayout(new GridLayout(8, 1));

        this.centreContent.setPreferredSize(new Dimension(256, 188));


        this.lFname = new JLabel("Nome");
        this.centreContent.add(this.lFname);
        this.jFname = new JTextField(50);
        this.centreContent.add(this.jFname);

        this.lLname = new JLabel("Cognome");
        this.centreContent.add(this.lLname);
        this.jLname = new JTextField(50);
        this.centreContent.add(this.jLname);

        this.lContact = new JLabel("Recapito");
        this.centreContent.add(this.lContact);
        this.jContact = new JTextField(50);
        this.centreContent.add(this.jContact);



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
            String fname = this.jFname.getText();
            String lname = this.jLname.getText();
            String contact = this.jContact.getText();

            result = StaffController.insert(fname, lname, contact, "dir");

            if (result) {
                new PopUpSimple("Operazione eseguita correttamente").setVisible(true);
                this.jFname.setText("");
                this.jLname.setText("");
                this.jContact.setText("");
            } else if (!result) {
                new PopUpSimple("Attenzione! \n Si è verificato un errore").setVisible(true);
            }
        }
        else if (command.equals("Reset")) {
            this.jFname.setText("");
            this.jLname.setText("");
            this.jContact.setText("");


        }

        else if (command.equals("Annulla")) {
            this.dispose();
        }
    }
}
