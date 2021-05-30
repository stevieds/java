package view.Calendario;

import Controller.RoomController;
import Controller.TurnoController;
import model.MyDate;
import model.Room;
import model.Turno;
import model.TypeTurno;
import view.shift.DialogShiftInfo;
import view.shift.PopUpEditShift;
import view.shift.PopUpEditShiftWip;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class CalendarioTurni extends JLayeredPane implements ChangeListener, MouseListener {
    MyDate date;
    JTable table;
    JPanel data;
    JPanel container;
    JPanel dateSet;
    ArrayList<Turno> turni;
    Vector<Room> studios;
    JSpinner day;
    int totStudios;
    int totTypes;
    JPanel main;
    PopUpEditShift shiftInfo;
    TypeTurno [] typeturni;
    String [] columns;


    public CalendarioTurni (MyDate date, ArrayList<Turno> turni) {

        this.date = date;
        this.setPreferredSize(new Dimension(700, 700));

        this.main = new JPanel();
        this.main.setLayout(new BorderLayout());
        this.turni = turni;
        this.studios = RoomController.allRooms();

        container = new JPanel();
        container.setLayout(new FlowLayout());

        typeturni = TypeTurno.values();
        columns = new String[5];
        columns[0]="X";

        for (int i=0; i<TypeTurno.values().length; i++) {
            columns[i+1] = typeturni[i].name();
        }

        this.table = new JTable(studios.size() + 1, columns.length);
        DefaultTableModel model = (DefaultTableModel) table.getModel();

        model.setColumnIdentifiers(columns);


        for (int i=0; i<studios.size(); i++) {
            table.setValueAt(studios.get(i).getName(), i+1, 0);
            for (int j=0; j<typeturni.length; j++) {
                table.setValueAt(typeturni[j].name(), 0, j+1);
                for (int k=0; k<turni.size(); k++) {
                    if (turni.get(k).getSala().getName().equals(studios.get(i).getName()) && turni.get(k).getType().name().equals(typeturni[j].name()) && turni.get(k).getGiorno().compare(date)) {

                        //table.setValueAt(TurnoController.briefSummary(turni.get(k)), i+1, j+1);
                        table.setValueAt(turni.get(k), i+1, j+1);



                    }

                }
            }
        }



        table.setRowHeight(110);

        table.setEnabled(false);

        table.addMouseListener(this);

        container.add(table);



        //this.add(container, BorderLayout.CENTER);
        this.main.add(container, BorderLayout.CENTER);

        this.day = new JSpinner(new SpinnerDateModel());
        this.day.setEditor(new JSpinner.DateEditor(this.day, "dd/MM/yyyy"));
        this.day.setName("Data");
        this.day.addChangeListener(this);

        this.dateSet = new JPanel();
        this.dateSet.setLayout(new FlowLayout());
        this.dateSet.add(new JLabel("Selezionare una data"));
        this.dateSet.add(day);


        //this.add(dateSet, BorderLayout.NORTH);
        this.main.add(dateSet, BorderLayout.NORTH);


        main.setBounds(0, 0, 700, 700);
        this.add(main, new Integer(0), 0);



    }


    @Override
    public void stateChanged(ChangeEvent e) {
        if (shiftInfo != null) {
            shiftInfo.dispose();
        }

        this.date = new MyDate((Date) day.getValue());

        DefaultTableModel dm = (DefaultTableModel)table.getModel();
        dm.getDataVector().removeAllElements();

        this.table.setModel(new DefaultTableModel(studios.size() + 1, columns.length));



        for (int i=0; i<studios.size(); i++) {
            table.setValueAt(studios.get(i).getName(), i+1, 0);
            for (int j=0; j<typeturni.length; j++) {
                table.setValueAt(typeturni[j].name(), 0, j+1);
                for (int k=0; k<turni.size(); k++) {
                    if (turni.get(k).getSala().getName().equals(studios.get(i).getName()) && turni.get(k).getType().name().equals(typeturni[j].name()) && turni.get(k).getGiorno().compare(date)) {

                        //table.setValueAt(TurnoController.briefSummary(turni.get(k)), i+1, j+1);
                        table.setValueAt(turni.get(k), i+1, j+1);



                    }

                }
            }
        }


    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable target = (JTable)e.getSource();
        int col = target.columnAtPoint(e.getPoint());
        int row = target.rowAtPoint(e.getPoint());
        if (target.getValueAt(row, col) != null) {
            if ((!table.getColumnModel().getColumn(col).getIdentifier().equals("X")) && row>0) {
                Turno t = (Turno) target.getValueAt(row, col);
                if (this.shiftInfo != null ) {
                    this.shiftInfo.dispose();
                }
                //this.shiftInfo = new PopUpEditShift(turni, t);
                //this.shiftInfo.setVisible(true);
                //this.shiftInfo = new DialogShiftInfo(t);
                //this.shiftInfo.setVisible(true);
                new PopUpEditShiftWip(t).setVisible(true);
            }

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
