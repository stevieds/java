package view.film;

import Controller.FilmController;
import db.DbFilm;
import model.Film;
import view.GraphicsElements;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmPanel extends JPanel implements GraphicsElements {
    JPanel main;
    JLabel titO;
    JLabel titI;
    JLabel status;

    public FilmPanel (ArrayList<Film> films)  {

        UIManager.put("Button.select", midGray);

        UIManager.put("TextArea.background", lightGray);

        //UIManager.put("TextArea.border", lightGray);

        int rows = films.toArray().length+1;
        this.setLayout(new FlowLayout());
        GridLayout grid = new GridLayout(rows, 4);
        grid.setHgap(10);
        grid.setVgap(10);

        this.main = new JPanel(grid);


        this.titO = new JLabel("Titolo originale");
        this.titO.setFont(berlin);

        this.titI = new JLabel("Titolo italiano");
        this.titI.setFont(berlin);

        this.status = new JLabel("Stato");
        this.status.setFont(berlin);

        this.main.add(this.titO);
        this.main.add(this.titI);
        this.main.add(this.status);
        this.main.add(new JLabel(""));
        for (Film film : films) {
            JTextField tO = new JTextField();
            tO.setEditable(false);
            tO.setText(film.getoTitle());
            tO.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            this.main.add(tO);

            JTextField tI = new JTextField();
            tI.setEditable(false);
            tI.setText(film.getiTitle());
            tI.setBorder(noBorder);
            this.main.add(tI);


            JTextField stat = new JTextField();
            stat.setEditable(false);

            stat.setBorder(noBorder);
            stat.setFont(berlin);

            switch (film.getStatus()) {
                case "WIP":
                    stat.setText("In lavorazione");
                    stat.setForeground(colorWip);
                    break;
                case "NEW":
                    stat.setForeground(colorNew);
                    stat.setText("Nuovo");
                    break;
                case "DONE":
                    stat.setForeground(colorDone);
                    stat.setText("Completato");
                    break;
            }

            this.main.add(stat);



            JButton open = new JButton();
            open.setBackground(darkGray);
            open.setForeground(lightGray);
            open.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            open.setAction(new FilmDetailsAction("Visualizza", film));
            open.setFont(peignotSmall);
            this.main.add(open);
        }
        this.add(this.main);


        this.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5,5,5,5),
                BorderFactory.createLineBorder(darkGray)));
    }
}
