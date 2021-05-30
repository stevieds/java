package view.film;

import Controller.FilmController;
import db.DbAnello;
import db.DbCastCouple;
import javafx.util.Pair;
import model.Anello;
import model.Coppia;
import model.Film;
import view.Destroyer;
import view.GraphicsElements;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class PopUpFilmDetails extends JDialog implements ActionListener, GraphicsElements {
    JLabel oTitle;
    JLabel length;
    JPanel top;
    JPanel middle;
    JPopupMenu status;
    JPanel couples;
    JPanel timeFrames;
    JPanel couplesList;
    JPanel timeFramesList;
    Film film;



    public PopUpFilmDetails (Film film) {
        this.film = film;


        UIManager.put("Panel.background", lightGray);
        UIManager.put("Label.background", lightGray);
        UIManager.put("TextField.inactiveBackground", lightGray);
        UIManager.put("TextField.foreground", darkGray);





        this.setTitle(film.getoTitle());
        this.setSize(1024, 576);
        this.setLayout(new BorderLayout());
        top = new JPanel();
        GridLayout grid = new GridLayout(2, 1);
        grid.setVgap(5);
        grid.setHgap(5);
        top.setLayout(grid);
        oTitle = new JLabel(this.film.getoTitle());
        oTitle.setFont(peignotBig);
        oTitle.setHorizontalAlignment(SwingConstants.CENTER);
        top.add(oTitle);
        length = new JLabel( this.film.lengthToString());
        length.setHorizontalAlignment(SwingConstants.CENTER);
        length.setFont(berlin);
        top.add(length);
        this.add(top, BorderLayout.NORTH);

        middle = new JPanel();
        middle.setLayout(new GridLayout(1, 2));

        JLayeredPane first = new JLayeredPane();
        first.setLayout(new OverlayLayout(first));
        JLayeredPane second = new JLayeredPane();
        second.setLayout(new OverlayLayout(second));

        couples = new JPanel();
        //couples.setSize(400, 250);

        first.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(BorderFactory.createLineBorder(midGray)
                                , "Doppiatori"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
        couples.setLayout(new FlowLayout());
        JButton addCouple = new JButton("Aggiungi personaggio");

        addCouple.setFont(peignotMedium);
        addCouple.setBackground(darkGray);
        addCouple.setForeground(lightGray);
        addCouple.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));
        addCouple.addActionListener(this);
        couples.add(addCouple);

        couplesList = new JPanel();
        couplesList.setLayout(new GridLayout(this.film.getCoppie().size()+1, 3));
        JLabel pers = new JLabel("Personaggio");
        pers.setFont(berlin);
        pers.setForeground(darkGray);
        couplesList.add(pers);

        JLabel vc = new JLabel("Voce");
        vc.setFont(berlin);
        vc.setForeground(darkGray);
        couplesList.add(vc);
        couplesList.add(new JLabel(""));

        for (Coppia couple : this.film.getCoppie()) {
            JTextField perso = new JTextField(couple.getPersName());
            perso.setEditable(false);

            perso.setBorder(BorderFactory.createLineBorder(midGray));
            couplesList.add(perso);
            if (couple.getDopp()!=null) {
                JTextField dopp = new JTextField(couple.getDopp().getFName()+" "+couple.getDopp().getLName());

                dopp.setBorder(BorderFactory.createLineBorder(midGray));
                dopp.setEditable(false);
                couplesList.add(dopp);
            } else {
                JTextField dopp = new JTextField("");

                dopp.setBorder(BorderFactory.createLineBorder(midGray));
                dopp.setEditable(false);
                couplesList.add(dopp);
            }
        JButton btnMod = new JButton("Modifica");
            btnMod.setBackground(midGray);
            btnMod.setForeground(darkGray);
            btnMod.setBorder(BorderFactory.createLineBorder(lightGray));

            btnMod.setAction(new AbstractAction("Modifica") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        first.add(new PopUpAddVoiceToCouple(film, couple),
                                JLayeredPane.POPUP_LAYER);
                        couples.revalidate();
                        couples.repaint();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });

            couplesList.add(btnMod);
        }
        couples.add(couplesList);

        timeFrames = new JPanel();
        second.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder(BorderFactory.createLineBorder(midGray)
                                , "Anelli"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));
        timeFrames.setLayout(new FlowLayout());
        JButton addTimeFrame = new JButton("Aggiungi anello");
        addTimeFrame.setFont(peignotMedium);
        addTimeFrame.setForeground(lightGray);
        addTimeFrame.setBackground(darkGray);
        addTimeFrame.addActionListener(this);

        addTimeFrame.setBorder(BorderFactory.createEmptyBorder(7, 7, 7, 7));


        timeFrames.add(addTimeFrame);

        timeFramesList = new JPanel();
        timeFramesList.setLayout(new GridLayout(this.film.getAnelli().size()+1, 5));
        JLabel startL = new JLabel("Inizio");
        startL.setFont(berlin);
        startL.setForeground(darkGray);



        timeFramesList.add(startL);
        timeFramesList.add(new JLabel("Fine"));
        timeFramesList.add(new JLabel("Righe"));
        timeFramesList.add(new JLabel("Voce"));
        timeFramesList.add(new JLabel(""));

        for (Anello anello : this.film.getAnelli()) {
            JTextField start = new JTextField(anello.getStart().toString());
            start.setBorder(BorderFactory.createLineBorder(midGray));
            start.setEditable(false);
            timeFramesList.add(start);
            JTextField end = new JTextField(anello.getEnd().toString());
            end.setBorder(BorderFactory.createLineBorder(midGray));
            end.setEditable(false);
            timeFramesList.add(end);
            JTextField rws = new JTextField(String.valueOf(anello.getRighe()));
            rws.setBorder(BorderFactory.createLineBorder(midGray));
            rws.setEditable(false);
            timeFramesList.add(rws);
            JTextField voice = new JTextField("");
            voice.setBorder(BorderFactory.createLineBorder(midGray));

            if (anello.getCouple() != null) {
                if(anello.getCouple().getDopp() != null) {
                    voice.setText(anello.getCouple().getDopp().getFullName());
                }
            }
            voice.setEditable(false);
            timeFramesList.add(voice);

            JButton btnMod = new JButton("Modifica anello");

            btnMod.setBackground(midGray);
            btnMod.setForeground(darkGray);
            btnMod.setBorder(BorderFactory.createLineBorder(lightGray));

            btnMod.setAction(new AbstractAction("Modifica") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        second.add(new LayerEditAnello(film, anello), JLayeredPane.POPUP_LAYER);
                        //new LayerEditAnello(film, anello).setVisible(true);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            });

            timeFramesList.add(btnMod);
        }
        timeFrames.add(timeFramesList);
        //****

        first.add(couples,JLayeredPane.DEFAULT_LAYER);
        second.add(timeFrames, JLayeredPane.DEFAULT_LAYER);
        middle.add(first);
        middle.add(second);




        this.add(middle, BorderLayout.CENTER);

        //this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.addWindowListener(new Destroyer());


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Aggiungi anello")) {
            PopUpNewTimeFrame popUpNewTimeFrame = new PopUpNewTimeFrame (film);
            popUpNewTimeFrame.setVisible(true);
        }
        else if (command.equals("Aggiungi personaggio")) {
            PopUpNewChar popUpNewChar = new PopUpNewChar (film);
            popUpNewChar.setVisible(true);


            this.revalidate();
            this.repaint();
        }

    }

}



