package view.shift;

import Controller.FilmController;
import Controller.RoomController;
import Controller.StaffController;
import Controller.TurnoController;
import model.*;
import view.PopUp;
import view.PopUpSimple;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class PopUpEditShift extends PopUp implements ItemListener, ListSelectionListener, ChangeListener {
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
    JSpinner day;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JPanel panel4;
    JPanel panel5;
    JButton availability;
    Turno trn;
    Personale dir;
    Personale sound;
    Room studio;
    TypeTurno type;
    MyDate date;
    Film film;
    Coppia coppia;
    ArrayList<Anello> anelli;
    ArrayList<Turno> turni;




    public PopUpEditShift(ArrayList<Turno> turni, Turno trn) {
        this.trn = trn;
        this.turni = turni;
        this.date = trn.getGiorno();
        this.film=trn.getFilm();


        this.setSize(411, 700);


        this.data.setLayout(new FlowLayout());

        this.top.setLayout(new GridLayout(2, 1));
        this.descr.setText("Modifica turno");
        descr.setFont(peignotBig);
        descr.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel day = new JLabel(this.trn.getGiorno().toString());
        day.setHorizontalAlignment(SwingConstants.CENTER);
        day.setForeground(darkGray);


        this.top.add(descr);
        this.top.add(day);
        GridLayout grid2 = new GridLayout(5, 1);
        grid2.setHgap(5);
        this.centreContent.setLayout(grid2);
        this.centreContent.setPreferredSize(new Dimension(256, 670));
        this.centre.setLayout(new FlowLayout());






        this.panel1 = new JPanel(new GridLayout(4, 1));

        this.dirLabel = new JLabel("Direttore di doppiaggio");
        this.dirText = new JComboBox(StaffController.allStaff("dir"));

        Vector <Personale> allDirs = StaffController.allStaff("dir");
        for (int i=0; i<allDirs.size(); i++) {
            if (allDirs.get(i).compareTo(trn.getDir())) {
                this.dirText.setSelectedIndex(i);
            }
        }

        this.dirText.setActionCommand("Direttore");
        this.dirText.addItemListener(this);
        this.soundLabel = new JLabel("Fonico");
        this.soundText = new JComboBox(StaffController.allStaff("sound"));

        Vector <Personale> allSounds = StaffController.allStaff("sound");
        for (int i=0; i<allSounds.size(); i++) {
            if (allSounds.get(i).compareTo(trn.getSound())) {
                this.soundText.setSelectedIndex(i);
            }
        }

        this.soundText.setActionCommand("Fonico");
        this.soundText.addItemListener(this);
        this.panel1.add(dirLabel);
        this.panel1.add(dirText);
        this.panel1.add(soundLabel);
        this.panel1.add(soundText);
        this.centreContent.add(panel1);


        this.panel2 = new JPanel(new GridLayout(4, 1));

        this.studioLabel = new JLabel("Studio");
        Vector<Room> allRooms = RoomController.allRooms();
        this.studioText = new JComboBox(allRooms);

        for (int i=0; i<allRooms.size(); i++) {
            if (trn.getSala().compareTo(allRooms.get(i))) {
                this.studioText.setSelectedIndex(i);
            }
        }

        this.studioText.setActionCommand("Studio");
        this.studioText.addItemListener(this);
        this.typeLabel = new JLabel("Turno");
        this.typeText = new JComboBox(TypeTurno.values());
        this.typeText.setActionCommand("Turno");
        this.typeText.addItemListener(this);

        TypeTurno[] allTypes = TypeTurno.values();

        for (int i=0; i<allTypes.length; i++) {
            if (trn.getType().name().equals(allTypes[i].name())) {
                this.typeText.setSelectedIndex(i);
            }
        }


        this.panel2.add(studioLabel);
        this.panel2.add(studioText);
        this.panel2.add(typeLabel);
        this.panel2.add(typeText);
        this.centreContent.add(panel2);



        this.panel4 = new JPanel(new GridLayout(4, 1));
        this.filmLabel = new JLabel("Film");

        ArrayList <Film> films = FilmController.listAllFilms();




        this.filmText = new JComboBox(films.toArray());
        this.filmText.setActionCommand("Film");
        this.filmText.addItemListener(this);

        for (int i=0; i<films.size(); i++) {
            if (films.get(i).getFilmId().equals(trn.getFilm())) {
                this.filmText.setSelectedIndex(i);
            }
        }

        this.coppiaLabel = new JLabel("Doppiatore");
        this.coppiaText = new JComboBox(trn.getFilm().getCoppie().toArray());
        this.coppiaText.setActionCommand("Doppiatore");
        this.coppiaText.addItemListener(this);
        ArrayList<Coppia> allC = trn.getFilm().getCoppie();
        for (int i=0; i<allC.size(); i++) {
            if (trn.getCoppia().getCoupleId().equals(allC.get(i).getCoupleId())) {
                this.coppiaText.setSelectedIndex(i);
            }
        }





        this.panel4.add(filmLabel);
        this.panel4.add(filmText);
        this.panel4.add(coppiaLabel);
        this.panel4.add(coppiaText);
        this.centreContent.add(panel4);

        this.panel5 = new JPanel();
        this.panel5.setLayout(new GridLayout(2, 1));
        this.anelliLabel = new JLabel("Anelli");
        this.anelliList = new JList();
        this.anelliList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        this.anelliList.setLayoutOrientation(JList.VERTICAL_WRAP);
        this.anelliList.setVisibleRowCount(10);
        anelliList.setListData(trn.getFilm().getAnelli().toArray());

        int [] count = new int[trn.getAnelli().size()];
        int l = 0;
        for (int i=0; i<trn.getFilm().getAnelli().size(); i++) {
            for (int j=0; j<trn.getAnelli().size(); j++) {
                if (trn.getFilm().getAnelli().get(i).getAnelloId().equals(trn.getAnelli().get(j).getAnelloId())) {
                    count[l] = i;
                    l++;
                }
            }

        }

        anelliList.setSelectedIndices(count);

        this.anelliList.addListSelectionListener(this);
        // listener
        this.panel5.add(anelliLabel);

        JScrollPane listScroller = new JScrollPane(anelliList);
        listScroller.setPreferredSize(new Dimension(250, 80));
        this.panel5.add(listScroller);

        this.centreContent.add(panel5);

        this.centre.add(centreContent);
        this.data.add(centre);

        this.ok.setText("Salva");
        this.ko.setText("Annulla");

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
                this.dir= (Personale) this.dirText.getSelectedItem();
                this.sound = (Personale) this.soundText.getSelectedItem();
                this.studio = (Room) this.studioText.getSelectedItem();
                this.type = (TypeTurno) this.typeText.getSelectedItem();
                this.coppia = (Coppia) this.coppiaText.getSelectedItem();
                this.anelli = (ArrayList<Anello>) this.anelliList.getSelectedValuesList();

                String result = TurnoController.updateTurno(trn, this.dir, this.sound, this.date,
                        this.studio, this.type, this.coppia, this.anelli, this.turni);
                new PopUpSimple(result).setVisible(true);

                this.revalidate();
                this.repaint();
                break;
            case "Annulla":

                this.dispose();
                break;
            case "avail":
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
            case "Doppiatore":
                if (e.getStateChange()==1) {
                    Coppia c = (Coppia) e.getItem();
                    if (!c.getCoupleId().equals(trn.getCoppia().getCoupleId())) {
                        Vector<Anello> list = new Vector<>();
                        this.coppia = (Coppia) source.getSelectedItem();
                        if (this.coppia != null) {
                            for (Anello a : this.film.getAnelli()) {
                                if (a.getCouple().getDopp() != null) {
                                    if (a.getCouple().getCoupleId().equals(this.coppia.getCoupleId())) {
                                        list.add(a);
                                    }
                                }
                            }
                            anelliList.setListData(list);
                            this.panel5.revalidate();
                            this.panel5.repaint();
                        }

                    } else {
                        if (anelliList!=null) {
                            anelliList.setListData(trn.getFilm().getAnelli().toArray());
                            int[] count = new int[trn.getAnelli().size()];
                            int l = 0;
                            for (int i = 0; i < trn.getFilm().getAnelli().size(); i++) {
                                for (int j = 0; j < trn.getAnelli().size(); j++) {
                                    if (trn.getFilm().getAnelli().get(i).getAnelloId().equals(trn.getAnelli().get(j).getAnelloId())) {
                                        count[l] = i;
                                        l++;
                                    }
                                }

                            }
                            anelliList.setSelectedIndices(count);
                        }
                    }
                }

                break;


        }
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {


    }

    @Override
    public void stateChanged(ChangeEvent e) {
        this.date = new MyDate((Date) day.getValue());
    }
}
