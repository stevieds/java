package Controller;

import db.Conn;
import db.DbAnello;
import db.DbCastCouple;
import db.DbFilm;
import javafx.util.Pair;
import model.*;
import org.apache.commons.lang.RandomStringUtils;
import view.film.FilmDetailsAction;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmController {

    public static Film populateCoppie (Film film) {

        ArrayList<Pair> couplesFromDb = null;

        try {
            couplesFromDb = DbCastCouple.allCast();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (int i =0; i<couplesFromDb.size(); i++) {
            if (film.getFilmId().equals(couplesFromDb.get(i).getKey())) {
                film.addCouple((Coppia) couplesFromDb.get(i).getValue());
            }
        }
        return film;
    }

    public static Film populateCoppieComplete (Film film) {

        ArrayList<Pair> couplesFromDb = null;

        try {
            couplesFromDb = DbCastCouple.allCast();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (int i =0; i<couplesFromDb.size(); i++) {
            Coppia c = (Coppia)couplesFromDb.get(i).getValue();
            if (c.getDopp() != null) {
                if (film.getFilmId().equals(couplesFromDb.get(i).getKey())) {
                film.addCouple((Coppia) couplesFromDb.get(i).getValue());
                }
            }
        }
        return film;
    }




    public static String newFilm ( String oTitle, String iTitle, MyTime length) {
        Film film = new Film(oTitle, iTitle, length);
        film.setFilmId("'fi"+ RandomStringUtils.random(9, true, true)+"'");
        if (DbFilm.insert(film)) {
            return "Film aggiunto correttamente.";
        } else {
            return "ERRORE.";
        }

    }
    public static Film populateAnelli (Film film) {
        ArrayList<Pair> anelliFromDb = null;
        try {
            anelliFromDb = AnelloController.populateWithCouples();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        for (int i =0; i<anelliFromDb.size(); i++) {
            if (film.getFilmId().equals(anelliFromDb.get(i).getKey())) {
                film.getAnelli().add((Anello)anelliFromDb.get(i).getValue());
            }
        }
        return film;
    }

    public static ArrayList<Film> listAllFilms () {
        ArrayList<Film> allFilms = DbFilm.allFilm();
        ArrayList <Pair> allAnelli = AnelloController.allAnelli();
        ArrayList <Personaggio> allChars = CoupleController.getAllCharacters();
        ArrayList <Pair> charactersPairs = CoupleController.getAllCharactersPairs();
        ArrayList <Coppia> allCouples = CoupleController.allCouples();
        ArrayList <Pair> temp = new ArrayList<>();

        for (int i=0; i<allCouples.size(); i++) {
            for (int j=0; j<charactersPairs.size(); j++) {
                Personaggio pers = (Personaggio) charactersPairs.get(j).getValue();
                if (allCouples.get(i).getPers().getId().equals(pers)) {
                    temp.add(new Pair(charactersPairs.get(j).getKey(), allCouples.get(i)));
                }
            }
        }

        for (int k=0; k<allFilms.size(); k++) {
            for (int l=0; l<temp.size(); l++) {
                if (allFilms.get(k).equals(temp.get(l).getKey())) {
                    Coppia c = (Coppia) temp.get(l).getValue();
                    allFilms.get(k).addCouple(c);
                }
            }
        }

        for (Film film : allFilms) {
            FilmController.populateCoppie(film);
            FilmController.populateAnelli(film);
        }

        return allFilms;
    }





    public static long durataTotAnelli(Film film) {
        long durata = 0;
        for (Anello anello : film.getAnelli()) {
            durata+= anello.lengthInMilli();
        }
        return durata;
    }


    public static boolean checkPersonaggio(Film film, String nomePers) {
        Personaggio pers = new Personaggio(nomePers);
        boolean ret = false;
        for (Coppia coppia : film.getCoppie()) {
            if (coppia.getPers().getName().equals(nomePers)) {
                ret = true;
                break;
            } else if (!coppia.getPers().equals(nomePers)) {
                ret = false;
            }
        }
        return ret;
    }






    public static boolean singleEditAFilm (Film film, String param, String name) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String fId = "'" + film.getFilmId() + "'";



        String sql =
                "UPDATE film SET " + name + " = " + param + " " +
                        " WHERE aid " +
                        "=" + fId +
                        ";";
        System.out.println(sql);
        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }







}
