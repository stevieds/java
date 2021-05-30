package view.film;

import Controller.FilmController;
import model.MyTime;
import view.PopUp;
import view.PopUpSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PopUpNewFilm extends PopUp {
    JTextField jITitle;
    JTextField jOTitle;

    JPanel jLength;
    JSpinner hh;
    JSpinner mm;
    JSpinner ss;
    JSpinner sss;


    JLabel lITitle;
    JLabel lOTitle;
    JLabel lLength;

    public PopUpNewFilm () {
        this.setTitle("Aggiungi film");
        this.setSize(411, 350);





        this.data.setLayout(new FlowLayout());

        this.centre = new JPanel(new FlowLayout());
        this.descr.setText("Aggiungi un nuovo film");
        descr.setFont(peignotBig);
        descr.setHorizontalAlignment(SwingConstants.CENTER);
        this.top.add(descr);


        this.centreContent = new JPanel(new GridLayout(6, 1));




        lITitle = new JLabel("Titolo italiano");
        this.centreContent.add(this.lITitle);
        jITitle = new JTextField();
        this.centreContent.add(jITitle);
        lOTitle = new JLabel("Titolo originale");
        this.centreContent.add(this.lOTitle);
        jOTitle = new JTextField();
        this.centreContent.add(jOTitle);
        lLength = new JLabel("Durata");
        this.centreContent.add(lLength);
        jLength = new JPanel();
        jLength.setLayout(new FlowLayout());

        this.hh = new JSpinner(new SpinnerNumberModel(0, 0, 12, 1));
        this.jLength.add(this.hh);
        this.mm = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        this.jLength.add(this.mm);
        this.ss = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        this.jLength.add(this.ss);
        this.sss = new JSpinner(new SpinnerNumberModel(000, 000, 999, 001));
        this.jLength.add(this.sss);




        this.centreContent.add(jLength);
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
        String result;
        String command = e.getActionCommand();
        if (command.equals("Invia")) {
            String iTitle = this.jITitle.getText();
            String oTitle = this.jOTitle.getText();
            MyTime length = new MyTime(
                    this.hh.getValue().toString() + ":" +
                            this.mm.getValue().toString() + ":" +
                            this.ss.getValue().toString() + "." +
                            this.sss.getValue().toString()
            );
            result = FilmController.newFilm(oTitle, iTitle, length);
            new PopUpSimple(result).setVisible(true);
                this.jITitle.setText("");
                this.jOTitle.setText("");
                this.hh.setValue(0);
                this.mm.setValue(0);
                this.ss.setValue(0);
                this.sss.setValue(0);

        }
        else if (command.equals("Reset")) {
            this.jITitle.setText("");
            this.jOTitle.setText("");
            this.hh.setValue(0);
            this.mm.setValue(0);
            this.ss.setValue(0);
            this.sss.setValue(0);

        }
        else if (command.equals("Annulla")) {
            this.dispose();
        }
    }




}
