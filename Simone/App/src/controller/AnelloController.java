package Controller;

import db.Conn;
import db.DbAnello;
import db.DbCastCouple;
import javafx.util.Pair;
import model.*;

import java.sql.SQLException;
import java.util.ArrayList;

public class AnelloController {



    public static ArrayList <Pair> populateWithCouples () throws SQLException {
        ArrayList<Pair> allAnelli = DbAnello.selectAnelli();
        ArrayList<Pair> allCouples = DbCastCouple.allCast();
        for (int i=0; i<allAnelli.size(); i++) {
            for (int j=0; j<allCouples.size(); j++ ) {
                Anello a = (Anello) allAnelli.get(i).getValue();
                Coppia c = (Coppia) allCouples.get(j).getValue();
                if (a.getCouple() != null) {
                    if (a.getCouple().getCoupleId().equals(c.getCoupleId())) {
                        a.addCouple(c);
                    }
                }

            }
        }
        return allAnelli;
    }

    public static ArrayList <Pair> allAnelli ()  {
        return DbAnello.selectAnelli();
    }

    public static String deleteAnello (Anello anello, Film film) {
        String result;
        if (DbAnello.deleteAnelloCouple(anello)) {
            if (DbAnello.deleteAnello(anello)) {
                film.getAnelli().remove(anello);
                return "Anello eliminato";
            } else {
                return "Si è verificato un errore";
            }
        } else {
            return "Si è verificato un errore";
        }
    }

    public static String addNewAnello(Film film, MyTime start, MyTime end, int rows) {
        if (film.lengthInMilli() >= (FilmController.durataTotAnelli(film) + (end.milliSec() - start.milliSec()))) {
            Anello a = new Anello(start, end, rows);
            if (DbAnello.insert(film, a)) {
                film.getAnelli().add(a);
                long difference = film.lengthInMilli() - FilmController.durataTotAnelli(film);
                MyTime n = MyTime.milliConvert(difference);
                return "L'anello è stato aggiunto correttamente. La durata rimanente è di: " + n.toString();
            } else {
                return "ERRORE";
            }
        } else {
            long difference =
                    ((FilmController.durataTotAnelli(film) + (end.milliSec() - start.milliSec()) - film.lengthInMilli()));
            MyTime n = MyTime.milliConvert(difference);
            return "Errore. L'anello eccede la durata totale del film di " + n.toString();
        }
    }







    public static String editAnelloCouple (Anello anello, Coppia coppia) {
        if (anello.getCouple() != null) {
            System.out.println(anello.getCouple() + " fffffffffff");
            anello.addCouple(coppia);
            if (DbAnello.editAnelloCouple(anello, coppia)) {
                return "Anello modificato correttamente";
            } else {
                return "2Si è verificato un errore";
            }
        } else {
            anello.addCouple(coppia);
            if (DbAnello.insertAnelloCouple(anello, coppia)) {
                return "Anello modificato correttamente";
            } else {
                return "1Si è verificato un errore";
            }
        }
    }


    public static String editTime (Anello a, MyTime start, MyTime end, Film film) {
        if (film.lengthInMilli() >= (FilmController.durataTotAnelli(film) + (end.milliSec() - start.milliSec()))) {
            if (DbAnello.editAnelloTime(a, start, end)) {
                a.setStart(start);
                a.setEnd(end);
                long difference = film.lengthInMilli() - FilmController.durataTotAnelli(film);
                MyTime n = MyTime.milliConvert(difference);
                return "L'anello è stato modificato correttamente. La durata rimanente è di: " + n.toString();
            } else {
                return "ERRORE";
            }
        } else {
            long difference =
                    ((FilmController.durataTotAnelli(film) + (end.milliSec() - start.milliSec()) - film.lengthInMilli()));
            MyTime n = MyTime.milliConvert(difference);
            return "Errore. L'anello eccede la durata totale del film di " + n.toString();
        }
    }

    public Boolean changeStatus (Film film, Anello anello, Status status) {
        Boolean check = false;
        if (DbAnello.singleEditAnello(anello, status.name(), "status")) {
            anello.setStatus(status);
            for (Anello a: film.getAnelli()) {
                if (a.getStatus().toString().equals("Done")) {
                    check = true;
                }
            }
            if (check == true) {
                if (FilmController.singleEditAFilm(film, "Done", "status")) {
                    film.changeStatus(Status.DONE);
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }




    public static boolean simpleEdit (Anello a, String param, String name) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String aId = "'" + a.getAnelloId() + "'";



        String sql =
                "UPDATE anello SET " + name + " = " + param + " " +
                        " WHERE aid " +
                        "=" + aId +
                        ";";

        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }


    public static boolean changeStatus (Anello a, String newStatus) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String aId = "'" + a.getAnelloId() + "'";



        String sql =
                "UPDATE anello SET status = " + "'" + newStatus + "'" +
                        " WHERE aid " +
                        "=" + aId +
                        ";";

        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }







}
