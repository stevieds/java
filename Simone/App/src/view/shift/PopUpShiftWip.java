package view.shift;

import model.*;
import view.CheckB;
import view.PopUp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class PopUpShiftWip extends PopUp implements ItemListener {
    Turno shift;
    Film film;

    JLabel dirLabel;
    JLabel soundLabel;
    JLabel studioLabel;
    JLabel typeLabel;
    JLabel filmLabel;
    JLabel coppiaLabel;
    JLabel anelliLabel;
    JLabel rowsLabel;

    JPanel timeFramesPanel;
    JPanel infoPanel;

    GridLayout grid;

    JTextField dirText;
    JTextField soundText;
    JTextField studioText;
    JTextField typeText;
    JTextField filmText;
    JTextField coppiaText;
    JTextField rowsText;

    ArrayList<Anello> completedAnelli;





    public PopUpShiftWip(Turno shift) throws SQLException {
        this.shift = shift;
        this.setSize(512, 576);
        this.data.setLayout(new BoxLayout(this.data, BoxLayout.Y_AXIS));

        this.infoPanel = new JPanel();
        this.infoPanel.setLayout(new GridLayout(7, 2));
        this.infoPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Panoramica"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));

        this.dirLabel = new JLabel("Direttore del doppiaggio");
        this.dirLabel.setHorizontalTextPosition(JLabel.RIGHT);
        this.dirLabel.setBackground(Color.cyan);
        this.dirText = new JTextField();
        this.dirText.setText(this.shift.getDir().getFullName());
        this.dirText.setEditable(false);

        this.infoPanel.add(this.dirLabel);
        this.infoPanel.add(this.dirText);

        this.soundLabel = new JLabel("Fonico");
        this.soundText = new JTextField();
        this.soundText.setText("this.shift.getSound()");
        this.soundText.setEditable(false);
        this.infoPanel.add(this.soundLabel);
        this.infoPanel.add(this.soundText);

        this.studioLabel = new JLabel("Studio di registrazione");
        this.studioText = new JTextField();
        this.studioText.setText("this.shift.getSala()");
        this.studioText.setEditable(false);
        this.infoPanel.add(this.studioLabel);
        this.infoPanel.add(this.studioText);


        this.typeLabel = new JLabel("Turno");
        this.typeText = new JTextField();
        this.typeText.setText("this.shift.getType()");
        this.typeText.setEditable(false);
        this.infoPanel.add(this.typeLabel);
        this.infoPanel.add(this.typeText);

        this.filmLabel = new JLabel("Film");
        this.filmText = new JTextField();
        this.filmText.setText("this.shift.getFilm().getoTitle()");
        this.filmText.setEditable(false);
        this.infoPanel.add(this.filmLabel);
        this.infoPanel.add(this.filmText);

        this.coppiaLabel = new JLabel("Doppiatore");
        this.coppiaText = new JTextField();
        this.coppiaText.setText("this.shift.getCoppia().getDopp().getFullName()");
        this.coppiaText.setEditable(false);
        this.infoPanel.add(this.coppiaLabel);
        this.infoPanel.add(this.coppiaText);

        this.rowsLabel = new JLabel("Righe");
        this.rowsText = new JTextField();
        this.rowsText.setText("this.shift.getCoppia().getDopp().getFullName()");
        this.rowsText.setEditable(false);
        this.infoPanel.add(this.rowsLabel);
        this.infoPanel.add(this.rowsText);

        this.data.add(this.infoPanel);

        this.timeFramesPanel = new JPanel();
        this.timeFramesPanel.setLayout(new BoxLayout(timeFramesPanel, BoxLayout.Y_AXIS));
        this.timeFramesPanel.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createTitledBorder("Anelli"),
                        BorderFactory.createEmptyBorder(5,5,5,5)));

        for (Anello a : this.shift.getAnelli()) {
            this.timeFramesPanel.add(new CheckB(a));
        }










        this.data.add(this.timeFramesPanel);



        this.completedAnelli = null;







    }
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
