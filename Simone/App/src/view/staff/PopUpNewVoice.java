package view.staff;

import Controller.StaffController;
import db.DbStaff;
import model.Doppiatore;
import model.Genere;
import view.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PopUpNewVoice extends PopUp implements ActionListener, GraphicsElements {
    JTextField jFname;
    JTextField jLname;
    JTextField jContact;
    JComboBox jGender;
    JLabel lFname;
    JLabel lLname;
    JLabel lContact;
    JLabel lGender;

    private final String[] G = {"","M", "F"};




    public PopUpNewVoice() {
        super();
        this.setSize(411, 350);
        this.setTitle("Aggiungi nuova voce");
















        this.data.setLayout(new FlowLayout());


        this.descr.setText("Aggiungi un nuovo doppiatore");
        descr.setFont(peignotBig);
        descr.setHorizontalAlignment(SwingConstants.CENTER);
        this.top.add(descr);

        this.centreContent.setLayout(new GridLayout(8, 1));


        this.centreContent.setPreferredSize(new Dimension(256, 188));

        this.lFname = new JLabel("Nome");
        this.centreContent.add(this.lFname);
        this.jFname = new JTextField(25);
        this.jFname.setBounds(0, 0, 30, 5);
        this.centreContent.add(this.jFname);

        this.lLname = new JLabel("Cognome");
        this.centreContent.add(this.lLname);
        this.jLname = new JTextField(50);
        this.centreContent.add(this.jLname);

        this.lContact = new JLabel("Recapito");
        this.centreContent.add(this.lContact);
        this.jContact = new JTextField(50);
        this.centreContent.add(this.jContact);

        this.lGender = new JLabel("Genere");
        this.centreContent.add(this.lGender);

        this.jGender = new JComboBox(this.G);
        this.jGender.setUI(new BasicComboBoxUI());
        this.jGender.setBackground(Color.WHITE);


        this.centreContent.add(this.jGender);

        this.centre.add(centreContent);
        this.add(centre, BorderLayout.CENTER);






        this.ok.setText("Invia");
        this.ex.setText("Annulla");
        this.ko.setText("Reset");


        this.buttons.add(this.ex);






    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean result;
        String command = e.getActionCommand();
        if (command.equals("Invia")) {
            String fname = this.jFname.getText();
            String lname = this.jLname.getText();
            String contact = this.jContact.getText();
            String gender = (String)this.jGender.getSelectedItem();



            result = StaffController.insertVoice(fname, lname, contact, Genere.valueOf(gender));

            if (result) {
                new PopUpSimple("Oeperazione eseguita correttamente").setVisible(true);
                this.jFname.setText("");
                this.jLname.setText("");
                this.jContact.setText("");
                this.jGender.setSelectedItem(null);
            } else if (!result) {
                new PopUpSimple("Attenzione! \n Si è verificato un errore").setVisible(true);
            }
        }
        else if (command.equals("Reset")) {
            this.jFname.setText("");
            this.jLname.setText("");
            this.jContact.setText("");
            this.jGender.setSelectedItem(null);

        }

        else if (command.equals("Annulla")) {
            this.dispose();
        }
    }
}
