package view.film;

import Controller.CoupleController;
import model.Film;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PopUpNewChar extends PopUp implements GraphicsElements {
    JTextField nameField;
    JLabel nameLabel;
    Film film;

    public PopUpNewChar(Film film) {
        super();
        this.film = film;
        this.setSize(390, 190);
        this.setTitle("Aggiungi personaggio");

        this.data.setLayout(new FlowLayout());

        this.centre.setLayout(new FlowLayout());
        this.descr.setText("Aggiungi un nuovo personaggio");
        descr.setFont(peignotBig);
        descr.setHorizontalAlignment(SwingConstants.CENTER);
        this.top.add(descr);

        this.centreContent.setLayout(new GridLayout(8, 1));

        this.centreContent.setPreferredSize(new Dimension(256, 188));




        this.nameField = new JTextField(25);
        this.nameField.setForeground(darkGray);
        this.nameLabel = new JLabel("Nome");
        this.nameLabel.setFont(berlin);
        this.nameLabel.setForeground(darkGray);
        this.centreContent.add(nameLabel);

        this.centreContent.add(nameField);

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
        System.out.println(this.getOwner());

        boolean result;
        String commSand = e.getActionCommand();
        if (commSand.equals("Invia")) {
            new PopUpSimple(CoupleController.addCastInFilm(this.film, this.nameField.getText())).setVisible(true);
            this.getOwner().revalidate();
            this.getOwner().repaint();
            this.getParent().revalidate();
            this.getParent().repaint();


        }
        else if (commSand.equals("Reset")) {
            this.nameField.setText("");



        }

        else if (commSand.equals("Annulla")) {
            this.dispose();
        }
    }




}
