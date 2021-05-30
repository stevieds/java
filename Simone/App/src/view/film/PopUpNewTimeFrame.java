package view.film;

import Controller.AnelloController;
import model.Film;
import model.MyTime;
import view.PopUp;
import view.PopUpSimple;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PopUpNewTimeFrame extends PopUp implements ChangeListener {
    JTextField jITitle;
    JTextField jOTitle;

    JPanel jStartPanel;
    JPanel jEndPanel;
    JPanel rowsPanel;
    SpinnerN hhS;
    SpinnerN mmS;
    SpinnerN ssS;
    SpinnerN sssS;

    SpinnerN hhE;
    SpinnerN mmE;
    SpinnerN ssE;
    SpinnerN sssE;


    SpinnerN rowsSpinner;


    JLabel lITitle;
    JLabel lOTitle;
    JLabel lLength;
    JLabel rowsLabel;

    Film film;

    int rows;

    public PopUpNewTimeFrame(Film film) {
        this.setSize(390, 330);

        this.rows = 0;
        this.film = film;
        this.setTitle("Aggiungi anello");

        //this.data.setLayout(new GridLayout(3, 2));


        this.data.setLayout(new FlowLayout());

        this.centre.setLayout(new FlowLayout());
        this.descr.setText("Aggiungi un nuovo anello");
        descr.setFont(peignotBig);
        descr.setHorizontalAlignment(SwingConstants.CENTER);
        this.top.add(descr);

        GridLayout grid = new GridLayout(6, 1);
        grid.setHgap(5);
        this.centreContent.setLayout(grid);

        //this.centreContent.setPreferredSize(new Dimension(256, 188));
















        jStartPanel = new JPanel();
        jStartPanel.setLayout(new FlowLayout());














        this.hhS = new SpinnerN(new SpinnerNumberModel(0, 0, 12, 1));
        this.jStartPanel.add(this.hhS);
        this.mmS = new SpinnerN(new SpinnerNumberModel(0, 0, 59, 1));
        this.jStartPanel.add(this.mmS);
        this.ssS = new SpinnerN(new SpinnerNumberModel(0, 0, 59, 1));
        this.jStartPanel.add(this.ssS);
        this.sssS = new SpinnerN(new SpinnerNumberModel(000, 000, 999, 001));
        this.jStartPanel.add(this.sssS);

        JLabel inizio = new JLabel("Inizio");
        inizio.setHorizontalAlignment(SwingConstants.CENTER);
        this.centreContent.add(inizio);
        this.centreContent.add(jStartPanel);

        jEndPanel = new JPanel();
        jEndPanel.setLayout(new FlowLayout());

        this.hhE = new SpinnerN(new SpinnerNumberModel(0, 0, 12, 1));
        this.jEndPanel.add(this.hhE);
        this.mmE = new SpinnerN(new SpinnerNumberModel(0, 0, 59, 1));
        this.jEndPanel.add(this.mmE);
        this.ssE = new SpinnerN(new SpinnerNumberModel(0, 0, 59, 1));
        this.jEndPanel.add(this.ssE);
        this.sssE = new SpinnerN(new SpinnerNumberModel(000, 000, 999, 001));
        this.jEndPanel.add(this.sssE);
        JLabel fine = new JLabel("Fine");
        fine.setHorizontalAlignment(SwingConstants.CENTER);
        this.centreContent.add(fine);
        this.centreContent.add(jEndPanel);

        this.rowsLabel = new JLabel("Righe");
        this.rowsSpinner = new SpinnerN(new SpinnerNumberModel(000, 000, 999, 001));



        this.rowsSpinner.setName("Righe");
        this.rowsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.rowsSpinner.addChangeListener(this);
        this.centreContent.add(rowsLabel);
        rowsPanel = new JPanel(new FlowLayout());
        this.rowsPanel.add(rowsSpinner);

        this.centreContent.add(rowsPanel);

        this.centre.add(centreContent);
        this.data.add(centre);


        this.ok.setText("Invia");
        this.ex.setText("Reset");
        this.ko.setText("Annulla");

        this.buttons.add(this.ex);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String result;
        String commSand = e.getActionCommand();
        if (commSand.equals("Invia")) {
            MyTime start = new MyTime(
                    this.hhS.getValue().toString() + ":" +
                            this.mmS.getValue().toString() + ":" +
                            this.ssS.getValue().toString() + "." +
                            this.sssS.getValue().toString()
            );
            MyTime end = new MyTime(
                    this.hhE.getValue().toString() + ":" +
                            this.mmE.getValue().toString() + ":" +
                            this.ssE.getValue().toString() + "." +
                            this.sssE.getValue().toString()
            );
            System.out.println("ciao");
            if (rows > 0) {

                result = AnelloController.addNewAnello(this.film, start, end, rows);
                new PopUpSimple(result).setVisible(true);
                this.hhS.setValue(0);
                this.mmS.setValue(0);
                this.ssS.setValue(0);
                this.sssS.setValue(0);
                this.hhE.setValue(0);
                this.mmE.setValue(0);
                this.ssE.setValue(0);
                this.sssE.setValue(0);
                rows = 0;
            } else {
                new PopUpSimple("Inserire righe");
            }

        }
        else if (commSand.equals("Reset")) {
            this.hhS.setValue(0);
            this.mmS.setValue(0);
            this.ssS.setValue(0);
            this.sssS.setValue(0);
            this.hhE.setValue(0);
            this.mmE.setValue(0);
            this.ssE.setValue(0);
            this.sssE.setValue(0);
            this.rows = 0;

        }

        else if (commSand.equals("Annulla")) {
            this.dispose();
        }
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        JSpinner source = (JSpinner) e.getSource();
        if (source.getName().equals("Righe")) {
            this.rows = (int) source.getValue();
        }
    }
}
