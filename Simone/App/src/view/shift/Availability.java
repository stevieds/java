package view.shift;

import Controller.RoomController;
import Controller.TurnoController;
import model.MyDate;
import model.Room;
import model.Turno;
import model.TypeTurno;
import view.GraphicsElements;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Vector;

public class Availability extends JDialog implements GraphicsElements {


    ArrayList <Turno> turni;
    MyDate date;
    Vector<Room> studios;
    JPanel container;

    public Availability (ArrayList <Turno> turni, MyDate date) {


        this.date = date;

        this.setSize(411, 690);
        this.turni = turni;
        this.studios = RoomController.allRooms();
        this.setLayout(new BorderLayout());

        container = new JPanel();
        container.setLayout(new FlowLayout());


        int totStudios = studios.size();
        int totTypes = TypeTurno.values().length;
        TypeTurno [] typeturni = TypeTurno.values();

        JTable table = new JTable(totStudios+1, totTypes+1);

        CellEditor c = table.getCellEditor(1, 3);
        TableCellRenderer cr = table.getCellRenderer(1, 3);
        table.getValueAt(1, 3);



        for (int i=0; i<studios.size(); i++) {



            Object cell = table.getValueAt(i+1, 0);

            table.setValueAt(studios.get(i).getName(), i+1, 0);
            for (int j=0; j<typeturni.length; j++) {
                table.setValueAt(typeturni[j].name(), 0, j+1);
                for (int k=0; k<turni.size(); k++) {
                    if (turni.get(k).getSala().getName().equals(studios.get(i).getName()) && turni.get(k).getType().name().equals(typeturni[j].name()) && turni.get(k).getGiorno().compare(date)) {
                        table.setValueAt(TurnoController.briefSummary(turni.get(k)), i+1, j+1);

                    }

                    }
            }
        }

        table.setRowHeight(90);
        table.setEnabled(false);
        container.add(table);
        this.add(container, BorderLayout.CENTER);
        JLabel dt = new JLabel(date.toString());
        dt.setFont(peignotBig);
        dt.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(dt, BorderLayout.NORTH);


    }

}
