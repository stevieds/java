package view.film;

import Controller.AnelloController;
import model.*;
import view.LayerPanel;
import view.PopUpSimple;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

public class LayerEditAnello extends LayerPanel implements ItemListener {
    JLabel startL;
    JLabel endL;
    JLabel persL;


    JPanel times;


    JComboBox persList;

    JPanel peopleP;

    JPanel jStartPanel;
    JPanel jEndPanel;
    JSpinner hhS;
    JSpinner mmS;
    JSpinner ssS;
    JSpinner sssS;

    JSpinner hhE;
    JSpinner mmE;
    JSpinner ssE;
    JSpinner sssE;

    JButton delete;

    Coppia copp;

    Anello anello;
    Film film;

    MyTime newEnd;
    MyTime newStart;


    public LayerEditAnello(Film film, Anello anello)  throws SQLException {
        this.anello = anello;
        this.film = film;

        this.top.setLayout(new BorderLayout());
        JLabel title = new JLabel("Modifica abbinamento");
        title.setFont(peignotBig);
        title.setForeground(darkGray);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(title, BorderLayout.NORTH);

        JTextArea descr = new JTextArea();
        descr.setText("Da qui è possibile cambiare il nome di un dato personaggio " +
                "oppure il doppiatore ad esso associato");
        descr.setFont(simple);
        descr.setSize(300, 50);
        descr.setEditable(false);
        descr.setForeground(darkGray);
        descr.setBackground(lightGray);
        descr.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        descr.setLineWrap(true);

        top.add(descr, BorderLayout.CENTER);

        times = new JPanel();
        times.setLayout(new GridLayout(2, 2));
        this.data.setLayout(new FlowLayout());
        JPanel main = new JPanel(new GridLayout(6, 1));

        persL = new JLabel("Personaggio");

        persList = new JComboBox(film.getCoppie().toArray());
        persList.setSelectedItem(anello.getCouple());
        persList.setName("Coppie");
        persList.setUI(new BasicComboBoxUI());
        persList.setBackground(Color.WHITE);
        persList.addItemListener(this);
        main.add(persL);
        main.add(persList);


        jStartPanel = new JPanel();
        jStartPanel.setLayout(new FlowLayout());

        this.hhS = new JSpinner(new SpinnerNumberModel(0, 0, 12, 1));
        hhS.setValue(anello.getStart().getHour());
        this.jStartPanel.add(this.hhS);
        this.mmS = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        mmS.setValue(anello.getStart().getMin());
        this.jStartPanel.add(this.mmS);
        this.ssS = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        ssS.setValue(anello.getStart().getSec());
        this.jStartPanel.add(this.ssS);
        this.sssS = new JSpinner(new SpinnerNumberModel(000, 000, 999, 001));
        sssS.setValue(anello.getStart().getSss());
        this.jStartPanel.add(this.sssS);

        main.add(new JLabel("Inizio"));
        main.add(jStartPanel);

        jEndPanel = new JPanel();
        jEndPanel.setLayout(new FlowLayout());

        this.hhE = new JSpinner(new SpinnerNumberModel(0, 0, 12, 1));
        hhE.setValue(anello.getEnd().getHour());
        this.jEndPanel.add(this.hhE);
        this.mmE = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        mmE.setValue(anello.getEnd().getMin());
        this.jEndPanel.add(this.mmE);
        this.ssE = new JSpinner(new SpinnerNumberModel(0, 0, 59, 1));
        ssE.setValue(anello.getEnd().getSec());
        this.jEndPanel.add(this.ssE);
        this.sssE = new JSpinner(new SpinnerNumberModel(000, 000, 999, 001));
        sssE.setValue(anello.getEnd().getSss());
        this.jEndPanel.add(this.sssE);

        main.add(new JLabel("Fine"));
        main.add(jEndPanel);

        this.data.add(main);

        this.ex.setText("Annulla");
        this.ex.setActionCommand("Annulla");
        this.ok.setActionCommand("Salva");
        this.ok.setText("Salva");
        this.ok.setName("SalvaAnello");
        this.ko.setText("Elimina");

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox combo = (JComboBox) e.getSource();
        this.copp = (Coppia) combo.getSelectedItem();
    }



    public void actionPerformed(ActionEvent e) {
        JLayeredPane parent = (JLayeredPane) this.getParent();
        String result = "";

        if (e.getActionCommand().equals("Salvaa")) {
            if (this.copp != null) {
                result = AnelloController.editAnelloCouple(anello, this.copp);
            }

            // Time


            newEnd = new MyTime(hhE.getValue().toString() + ":" + mmE.getValue().toString() +
                    ":" + ssE.getValue().toString() + "." + ssE.getValue().toString());

            newStart = new MyTime(hhS.getValue().toString() + ":" + mmS.getValue().toString() +
                    ":" + ssS.getValue().toString() + "." + ssS.getValue().toString());


            // End time


            result += AnelloController.editTime(anello, newStart,
                    newEnd, film);









            this.copp = null;

            new PopUpSimple(result).setVisible(true);



            this.removeAll();
            parent.setLayer(this, -1);
            parent.revalidate();
            parent.repaint();

        }

        else if (e.getActionCommand().equals("Annulla")) {
            this.copp = null;
            this.removeAll();
            parent.setLayer(this, -1);
            parent.revalidate();
            parent.repaint();

        } else if (e.getActionCommand().equals("Elimina")) {
            result = AnelloController.deleteAnello(anello, film);
            this.copp = null;
            this.removeAll();
            parent.setLayer(this, -1);
            parent.revalidate();
            parent.repaint();
            new PopUpSimple(result).setVisible(true);


        }
    }


}


