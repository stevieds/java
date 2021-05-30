package view;

import Controller.RoomController;
import Controller.TurnoController;
import javafx.util.Pair;
import model.*;
import view.film.PopUpFilmDetails;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Vector;

public class MainPanel extends JPanel implements GraphicsElements {
    JPanel logoPanel;
    JPanel centre;
    JPanel calendarContainer;
    JPanel calendar;
    JPanel wip;
    JPanel wipTable;
    JPanel bottom;
    ArrayList<Film> films;
    ArrayList<Turno> shifts;
    Vector<Room> rooms;
    MyDate today;
    ImageIcon hd;
    ImageIcon mic;
    ImageIcon meg;
    ImageIcon logo;


    public MainPanel(ArrayList<Film> films, ArrayList<Turno> shifts, MyDate today)  {
        this.films = films;
        this.shifts = shifts;
        this.today = today;
        this.rooms = RoomController.allRooms();
        this.setBackground(lightGray);
        this.setLayout(new BorderLayout());
        this.logoPanel = new JPanel(new BorderLayout());


        ClassLoader cl= this.getClass().getClassLoader();

        URL u   = cl.getResource("img/hd.png");
        this.hd = new ImageIcon(u, "headphones");
        u   = cl.getResource("img/meg.png");
        this.meg = new ImageIcon(u, "headphones");
        u   = cl.getResource("img/mic.png");
        this.mic = new ImageIcon(u, "headphones");

        u   = cl.getResource("img/logo.png");
        this.logo = new ImageIcon(u, "logo");


        JLabel logoLabel = new JLabel(logo, JLabel.CENTER);
        this.logoPanel.add(logoLabel, BorderLayout.CENTER);
        this.add(logoPanel, BorderLayout.NORTH);

        this.centre = new JPanel(new GridLayout(1, 2));
        this.centre.setBackground(lightGray);






        calendarContainer = new JPanel(new BorderLayout());
        JLabel calendarLabel = new JLabel("Turni di oggi");
        calendarLabel.setForeground(darkGray);
        calendarLabel.setFont(peignotBig);
        calendarLabel.setHorizontalAlignment(SwingConstants.CENTER);
        calendarContainer.add(calendarLabel, BorderLayout.NORTH);

        this.calendar = new JPanel(new GridLayout(TypeTurno.values().length + 1,
                rooms.size() + 1));
        this.calendar.setBackground(lightGray);
        this.calendar.add(new JLabel(""));


        ArrayList<Pair<TypeTurno, Vector<Room>>> map = new ArrayList<>();

        for (TypeTurno type : TypeTurno.values()) {
            map.add(new Pair<TypeTurno, Vector<Room>>(type, rooms));
        }

        for (Room r : rooms) {
            JLabel rmName = new JLabel(r.getName());
            rmName.setForeground(darkGray);
            rmName.setFont(berlin);
            rmName.setHorizontalAlignment(SwingConstants.CENTER);
            rmName.setVerticalAlignment(SwingConstants.BOTTOM);
            this.calendar.add(rmName);
        }


        for (Pair<TypeTurno, Vector<Room>> p : map) {
            JLabel timeT = new JLabel(TurnoController.orari.get(p.getKey()));
            timeT.setForeground(darkGray);
            timeT.setFont(berlin);
            timeT.setHorizontalAlignment(SwingConstants.RIGHT);
            this.calendar.add(timeT);

            for (int i=0; i<p.getValue().size(); i++) {
                 JTextPane summary = new JTextPane();
                summary.setEditable(false);
                summary.setBackground(lightGray);
                summary.setBorder(BorderFactory.createLineBorder(midGray));
                summary.setForeground(darkGray);
                 for (Turno t: shifts) {
                     if (t.getGiorno().compare(today) && t.getSala().compareTo(p.getValue().get(i)) && t.getType().compareTo(p.getKey())==0) {


                         StyledDocument doc = summary.getStyledDocument();
                         Style s = doc.addStyle("bold", null);
                         StyleConstants.setBold(s, true);


                        Style icon = doc.addStyle("hd", null);
                        StyleConstants.setIcon(icon, this.hd);

                          icon = doc.addStyle("meg", null);
                         StyleConstants.setIcon(icon, this.meg);

                          icon = doc.addStyle("mic", null);
                         StyleConstants.setIcon(icon, this.mic);

                         try {
                             doc.insertString(doc.getLength(), t.getFilm().getoTitle() + "\n",
                                     doc.getStyle("bold"));
                         } catch (BadLocationException e) {
                             e.printStackTrace();
                         }

                         try {
                             doc.insertString(doc.getLength(), " ", doc.getStyle("mic"));

                         } catch (BadLocationException e) {
                             e.printStackTrace();
                         }


                             try {

                                 doc.insertString(doc.getLength(),
                                         t.getCoppia().getDopp().getFullName()  + "\n", null);
                             } catch (BadLocationException e) {
                                 e.printStackTrace();
                             }




                         try {
                             doc.insertString(doc.getLength(), " ", doc.getStyle("meg"));

                         } catch (BadLocationException e) {
                             e.printStackTrace();
                         }


                         try {

                             doc.insertString(doc.getLength(),
                                     t.getDir().getFullName()  + "\n", null);
                         } catch (BadLocationException e) {
                             e.printStackTrace();
                         }





                         try {
                             doc.insertString(doc.getLength(), " ", doc.getStyle("hd"));

                         } catch (BadLocationException e) {
                             e.printStackTrace();
                         }


                         try {

                             doc.insertString(doc.getLength(),
                                     t.getSound().getFullName(), null);
                         } catch (BadLocationException e) {
                             e.printStackTrace();
                         }









/*
                         summary.setText(
                                 t.getFilm().getoTitle() + "\n" +
                                 t.getDir().getFullName() + "\n" +
                                 t.getCoppia().getDopp().getFullName() + "\n" +
                                 t.getSound().getFullName()
                         );

 */
                     }
                 }
                 this.calendar.add(summary);
            }







        }
        int count = 0;
        for (Film f:films) {
            if (f.getStatus().equals("WIP")) {
                count ++;
            }
        }
        this.wip = new JPanel(new BorderLayout());
        this.wip.setBackground(lightGray);

        JLabel wipLabel = new JLabel("Film in lavorazione");
        wipLabel.setForeground(darkGray);
        wipLabel.setFont(peignotBig);
        wipLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.wip.add(wipLabel, BorderLayout.NORTH);



        GridLayout grid = new GridLayout(count, 3);
        grid.setVgap(5);

        this.wipTable = new JPanel(grid);

        for (Film film : films) {
            if (film.getStatus().equals("WIP")) {
                JButton btn = new JButton();
                btn.setBackground(lightGray);
                btn.setForeground(darkGray);
                btn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                btn.setAction(new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new PopUpFilmDetails(film).setVisible(true);
                    }
                });
                btn.setText(film.getoTitle());
                this.wipTable.add(btn);
            }
        }

        this.wip.add(wipTable);



        this.calendarContainer.add(this.calendar, BorderLayout.CENTER);
        this.centre.add(this.calendarContainer);
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(this.wip);
        panel.setBackground(lightGray);
        this.centre.add(panel);
        this.add(this.centre, BorderLayout.CENTER);


    }
}
