package view.shift;

import Controller.FilmController;
import Controller.RoomController;
import Controller.StaffController;
import Controller.TurnoController;
import model.*;
import view.PopUp;
import view.PopUpFail;
import view.PopUpSimple;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicListUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class PopUpNewShift extends PopUp implements ItemListener, ListSelectionListener, ChangeListener {
    JLabel dirLabel;
    JLabel soundLabel;
    JLabel studioLabel;
    JLabel typeLabel;
    JLabel dateLabel;
    JLabel filmLabel;
    JLabel coppiaLabel;
    JLabel anelliLabel;
    GridLayout grid;
    JComboBox dirText;
    JComboBox soundText;
    JComboBox studioText;
    JComboBox typeText;
    JComboBox filmText;
    JComboBox coppiaText;
    JList anelliList;
    SpinnerD day;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JButton availability;

    Personale dir;
    Personale sound;
    Room studio;
    TypeTurno type;
    MyDate date;
    Film film;
    Coppia coppia;
    ArrayList<Anello> anelli;
    ArrayList<Turno> turni;




    public PopUpNewShift(ArrayList<Turno> turni) {





        this.turni = turni;
        this.setSize(411, 700);


        this.data.setLayout(new FlowLayout());

        this.descr.setText("Aggiungi un nuovo turno");
        descr.setFont(peignotBig);
        descr.setHorizontalAlignment(SwingConstants.CENTER);
        this.top.add(descr);

        GridLayout grid2 = new GridLayout(6, 1);
        grid2.setHgap(5);
        this.centreContent.setLayout(grid2);
        this.centreContent.setPreferredSize(new Dimension(256, 670));
        this.centre.setLayout(new FlowLayout());


















        this.panel1 = new JPanel(new GridLayout(4, 1));
        this.dirLabel = new JLabel("Direttore di doppiaggio");
        this.dirText = new JComboBox(StaffController.allStaff("dir"));
        this.dirText.setActionCommand("Direttore");
        this.dirText.addItemListener(this);
        this.dirText.setSelectedItem(null);
        this.dirText.setUI(new BasicComboBoxUI());
        this.dirText.setBackground(Color.WHITE);
        this.soundLabel = new JLabel("Fonico");
        this.soundText = new JComboBox(StaffController.allStaff("sound"));
        this.soundText.setSelectedItem(null);
        this.soundText.setActionCommand("Fonico");
        this.soundText.addItemListener(this);
        this.soundText.setUI(new BasicComboBoxUI());
        this.soundText.setBackground(Color.WHITE);
        this.panel1.add(dirLabel);
        this.panel1.add(dirText);
        this.panel1.add(soundLabel);
        this.panel1.add(soundText);
        this.centreContent.add(panel1);



        this.panel2 = new JPanel(new GridLayout(4, 1));
        this.studioLabel = new JLabel("Studio");
        this.studioText = new JComboBox(RoomController.allRooms());
        this.studioText.setSelectedItem(null);
        this.studioText.setActionCommand("Studio");
        this.studioText.addItemListener(this);
        this.studioText.setUI(new BasicComboBoxUI());
        this.studioText.setBackground(Color.WHITE);
        this.typeLabel = new JLabel("Turno");
        this.typeText = new JComboBox(TypeTurno.values());
        this.typeText.setActionCommand("Turno");
        this.typeText.addItemListener(this);
        this.typeText.setSelectedItem(null);
        this.typeText.setUI(new BasicComboBoxUI());
        this.typeText.setBackground(Color.WHITE);
        this.panel2.add(studioLabel);
        this.panel2.add(studioText);
        this.panel2.add(typeLabel);
        this.panel2.add(typeText);
        this.centreContent.add(panel2);

        // data
        this.panel3 = new JPanel(new GridLayout(2, 1));
        JPanel panel3B = new JPanel(new FlowLayout());

        this.dateLabel = new JLabel("Data");

        this.day = new SpinnerD(new SpinnerDateModel());
        this.day.setEditor(new JSpinner.DateEditor(this.day, "dd/MM/yyyy"));
        this.day.setName("Data");
        this.day.addChangeListener(this);
        this.panel3.add(dateLabel);
        panel3B.add(day);
        this.availability = new JButton("Verifica disponibilità");
        this.availability.setActionCommand("avail");
        this.availability.setBackground(darkGray);
        this.availability.setForeground(lightGray);
        this.availability.setFont(berlin);
        this.availability.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.availability.setEnabled(false);
        this.availability.addActionListener(this);
        panel3B.add(availability);
        this.panel3.add(panel3B);
        this.centreContent.add(panel3);

        this.panel4 = new JPanel(new GridLayout(4, 1));

        this.filmLabel = new JLabel("Film");

        ArrayList <Film> films = FilmController.listAllFilms();

        this.filmText = new JComboBox(films.toArray());
        this.filmText.setActionCommand("Film");
        this.filmText.addItemListener(this);
        this.filmText.setSelectedItem(null);
        this.filmText.setUI(new BasicComboBoxUI());
        this.filmText.setBackground(Color.WHITE);
        this.coppiaLabel = new JLabel("Doppiatore");
        this.coppiaText = new JComboBox();
        this.coppiaText.setEnabled(false);
        this.coppiaText.setActionCommand("Doppiatore");
        this.coppiaText.addItemListener(this);
        this.coppiaText.setUI(new BasicComboBoxUI());
        this.coppiaText.setBackground(Color.WHITE);
        this.panel4.add(filmLabel);
        this.panel4.add(filmText);
        this.panel4.add(coppiaLabel);
        this.panel4.add(coppiaText);
        this.centreContent.add(panel4);

        this.panel5 = new JPanel();
        this.panel5.setLayout(new GridLayout(2, 1));
        this.anelliLabel = new JLabel("Anelli");
        this.anelliLabel.setHorizontalAlignment(SwingConstants.LEFT);

        this.anelliList = new JList();
        this.anelliList.setUI(new BasicListUI());
        this.anelliList.setEnabled(false);
        this.anelliList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.anelliList.setLayoutOrientation(JList.VERTICAL_WRAP);
        this.anelliList.setFixedCellHeight(20);
        this.anelliList.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.anelliList.setVisibleRowCount(20);


        this.anelliList.addListSelectionListener(this);
        // listener
        this.panel5.add(anelliLabel);

        JScrollPane listScroller = new JScrollPane(anelliList);
        listScroller.setSize(new Dimension(600, 600));
        listScroller.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.panel5.add(listScroller);

        this.centreContent.add(panel5);

        this.centre.add(centreContent);
        this.data.add(centre);

        this.ok.setText("Salva");
        this.ko.setText("Annulla");
        this.ex.setText("Reset");
        this.buttons.add(ex);
        this.anelli = new ArrayList<>();


        this.dirText.setUI(new BasicComboBoxUI());;
        this.dirText.setBackground(Color.WHITE);


        this.soundText.setUI(new BasicComboBoxUI());
        this.soundText.setBackground(Color.WHITE);


        this.studioText.setUI(new BasicComboBoxUI());
        this.typeText.setUI(new BasicComboBoxUI());
        this.filmText.setUI(new BasicComboBoxUI());
        this.coppiaText.setUI(new BasicComboBoxUI());

        this.studioText.setBackground(Color.WHITE);
        this.typeText.setBackground(Color.WHITE);
        this.filmText.setBackground(Color.WHITE);
        this.coppiaText.setBackground(Color.WHITE);

    }



    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Salva":
                this.date = new MyDate((Date) day.getValue());
                if (this.dir == null) {
                    new PopUpFail("Selezionare un direttore di doppiaggio").setVisible(true);
                    break;
                }
                if (this.sound == null) {
                    new PopUpFail("Selezionare un fonico").setVisible(true);
                    break;
                }
                if (this.studio == null) {
                    new PopUpFail("Inserire lo studio di doppiaggio").setVisible(true);
                    break;
                }
                if (this.type == null) {
                    new PopUpFail("Inserire il tipo di turno").setVisible(true);
                    break;
                }
                if (this.coppia == null) {
                    new PopUpFail("Selezionare un doppiatore").setVisible(true);
                    break;
                }
                if (this.anelli.size() == 0) {
                    new PopUpFail("Selezionare gli anelli da doppiare").setVisible(true);
                    break;
                }
                String result = TurnoController.newTurno(this.dir, this.sound, this.date,
                        this.studio, this.film, this.type, this.coppia, this.anelli, this.turni);
                new PopUpSimple(result).setVisible(true);
                this.dir = null;
                this.sound = null;
                this.studio = null;
                this.type = null;
                this.date = null;
                this.film = null;
                this.coppia = null;
                this.revalidate();
                this.repaint();
                break;
            case "Annulla":
                this.dir = null;
                this.sound = null;
                this.studio = null;
                this.type = null;
                this.date = null;
                this.film = null;
                this.coppia = null;
                this.dispose();
                break;
            case "avail":
                System.out.println("dddd");
                new Availability(turni, this.date).setVisible(true);
                break;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JComboBox source = (JComboBox) e.getSource();
        switch (source.getActionCommand()) {
            case ("Film"):
                if (e.getStateChange() == 1) {
                    if (source.getSelectedItem() != null) {
                        this.film = (Film) source.getSelectedItem();
                        for (Coppia couple : film.getCoppie()) {
                            this.coppiaText.addItem(couple);
                        }
                        this.coppiaText.setEnabled(true);
                        this.coppiaText.setSelectedItem(null);
                    }
                }
                break;
            case "Direttore":
                this.dir = (Personale) source.getSelectedItem();
                break;
            case "Fonico":
                this.sound = (Personale) source.getSelectedItem();
                break;
            case "Studio":
                this.studio = (Room) source.getSelectedItem();
                break;
            case "Turno":
                this.type = (TypeTurno) source.getSelectedItem();
                break;
            case "Doppiatore":
                Vector <Anello> list = new Vector<>();
                this.coppia = (Coppia) source.getSelectedItem();
                if (e.getStateChange() == 1) {
                    if (this.coppia != null) {
                        for (Anello a : this.film.getAnelli()) {
                            if (a.getCouple().getDopp() != null) {
                                if (a.getCouple().getCoupleId().equals(this.coppia.getCoupleId())) {
                                    list.add(a);
                                }
                            }
                        }
                        anelliList.setListData(list);
                        anelliList.setEnabled(true);
                    }
                }
                break;
        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList l = (JList) e.getSource();
        this.anelli.add((Anello) l.getSelectedValue());
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.date = new MyDate((Date) day.getValue());
        this.availability.setEnabled(true);

    }
}
