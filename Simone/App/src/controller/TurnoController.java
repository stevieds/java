package Controller;

import db.DbAnello;
import db.DbCastCouple;
import db.DbShift;
import javafx.util.Pair;
import model.*;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class TurnoController {
    public static final HashMap<TypeTurno, String> orari = new HashMap<TypeTurno, String>(4) {{
        put(TypeTurno.A, "09:00 - 12:00");
        put(TypeTurno.B, "13:15 - 16:15");
        put(TypeTurno.C, "16:30 - 19:30");
        put(TypeTurno.D, "19:30 - 22:30");
    }};

    public static Turno populateAnelli (Turno turno) {
        ArrayList<Pair> anelliFromDb = null;
        ArrayList<Pair> anelliCouples = null;

        try {
            anelliCouples = AnelloController.populateWithCouples();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            anelliFromDb = DbShift.allTurniAnelli();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (Pair pair : anelliFromDb) {
            if (pair.getKey().equals(turno.getTurnoId())) {
                String id = (String) pair.getValue();
                Anello anello = new Anello();
                anello.setAnelloId(id);
                turno.getAnelli().add(anello);
            }
        }


        for (int i =0; i<anelliCouples.size(); i++) {
            for (int j=0; j<turno.getAnelli().size(); j++) {
                Anello a = (Anello) anelliCouples.get(i).getValue();
                if (turno.getAnelli().get(j).getAnelloId().equals(a.getAnelloId())) {
                    turno.getAnelli().remove(j);
                    turno.getAnelli().add(a);
                }
            }

        }
        return turno;
    }

    public static ArrayList<Turno> allTurni () {
        ArrayList <Turno> turni = DbShift.allTurni();
        ArrayList<Pair> turniAnelli = null;
        Vector <Personale> allDirs = StaffController.allStaff("dir");
        Vector <Personale> allSounds = StaffController.allStaff("sound");
        ArrayList <Coppia> couples = null;

        ArrayList <Film> films = FilmController.listAllFilms();





        // Coppie
        try {
            couples = DbCastCouple.allCouples();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (Turno turno : turni) {
            for (Coppia coppia : couples) {
                if (turno.getCoppia().getCoupleId().equals(coppia.getCoupleId())) {
                    turno.setCoppia(coppia);
                }
            }
        }


        for (Turno turno : turni) {
            for (Personale dir : allDirs) {
                if (turno.getDir().getStaffId().equals(dir.getStaffId())) {
                    turno.setDir(dir);
                }
            }
        }



        for (Turno turno : turni) {
            for (Personale sound : allSounds) {
                if (turno.getSound().getStaffId().equals(sound.getStaffId())) {
                    turno.setSound(sound);
                }
            }
        }

        // anelli
        try {
            turniAnelli = DbShift.allTurniAnelli();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (Turno turno : turni) {
            for (Pair turnoAnello : turniAnelli) {
                if (turno.getTurnoId().equals(turnoAnello.getKey())) {

                }
            }

        }

        // film
        for (Turno turno : turni) {
            for (Film film: films) {
                if (turno.getFilm().getFilmId().equals(film.getFilmId())) {
                    turno.setFilm(film);
                }
            }
        }

        for (Turno turno : turni) {
            TurnoController.populateAnelli(turno);

        }








        return turni;
    }




    public static int countRows (Turno turno) {
        int rows = 0;
        for (Anello a : turno.getAnelli()) {
            rows += a.getRighe();
        }
        return rows;
    }

    public static String newTurno (Personale dir, Personale sound,
                                   MyDate giorno, Room sala, Film film, TypeTurno type,
                                   Coppia coppia, ArrayList <Anello> anelli,
                                   ArrayList<Turno> turni) {
        Turno turno = new Turno(dir, sound, giorno, sala, film, type, coppia);
        int righe = TurnoController.countRows(turno);
        turno.setTurnoId("sh"+ RandomStringUtils.random(9, true, true)+"");
        turno.setRighe(righe);
        for (Anello anello:anelli) {
            anello.setStatus(Status.WIP);
        }
        turno.setAnelli(anelli);


        for (Turno tu : turni) {


            if (turno.getGiorno().compare(tu.getGiorno()) &&
                turno.getType().name().equals(tu.getType().name()) &&
                turno.getSala().getName().equals(tu.getSala().getName()) &&
                turno.getDir().compareTo(tu.getDir()) &&
                turno.getSound().compareTo(tu.getSound()) &&
                turno.getCoppia().getDopp().compareTo(tu.getCoppia().getDopp()) )



            {

                return "Attenzione!\n" +
                        "Un altro turno è già prenotato per questa combinazione di data, orario e" +
                        " " +
                        "studio";
            }
        }

        if (!DbShift.insert(turno)) {
            return "Errore";
        } else {
            if (!DbShift.insertAnelli(turno, anelli)) {
                return "Errore"; }
            else {
                for (Anello a : anelli) {
                    if (!DbAnello.singleEditAnello(a, a.getStatus().toString(), "status")) {
                       return "Errore";
                    } else {
                        if (turno.getFilm().getStatus().equals(Status.WIP)) {
                            if (!FilmController.singleEditAFilm(film, "Wip", "status")) {
                                return "Errore";
                            } else {
                                turno.getFilm().changeStatus(Status.WIP);
                            }
                            turni.add(turno);
                            return "OK";
                        }
                    }
                }
                return "Turno inserito correttamente";
            }
        }

    }

    public static String deleteTurno (Turno turno) {
        if (DbShift.deleteTurnoAnello(turno)) {
            if (DbShift.delete(turno)) {
                return "Turno eliminato correttamente.";
            } else {
                return "Errore";
            }
        } else {
            return "Errore";
        }

    }



    public static String briefSummary (Turno turno) {
        return
                "<html>" +
                        turno.getFilm().getoTitle() + "<br>" +
                        turno.getDir().getFullName() + "<br>" +
                        turno.getSound().getFullName() + "<br>" +
                        turno.getCoppia().getDopp().getFullName() +
                        "</html>";
    }

    public static String updateTurno (Turno trn, Personale dir, Personale sound,
                                   MyDate giorno, Room sala, TypeTurno type,
                                   Coppia coppia, ArrayList <Anello> anelli,
                                      ArrayList <Turno> turni) {
        //Turno turno = new Turno(dir, sound, giorno, sala, film, type, coppia);
        int righe = 0;
        for (Anello a : anelli) {
            righe += a.getRighe();
        }
        //turno.setTurnoId("sh"+ RandomStringUtils.random(9, true, true)+"");
        //turno.setRighe(righe);
        for (Anello anello:anelli) {
            anello.setStatus(Status.WIP);
        }


        for (Turno tu : turni) {


            if (    !trn.getTurnoId().equals(tu.getTurnoId()) &&
                    giorno.compare(tu.getGiorno()) &&
                    type.name().equals(tu.getType().name()) &&
                    sala.getName().equals(tu.getSala().getName()) &&
                    dir.compareTo(tu.getDir()) &&
                    sound.compareTo(tu.getSound()) &&
                    coppia.getDopp().compareTo(tu.getCoppia().getDopp()) )
            {

                return "Attenzione!\n" +
                        "Un altro turno è già prenotato per questa combinazione di data, orario e" +
                        " " +
                        "studio";
            }
        }

        if (!DbShift.update(trn, type, giorno, dir, sound, sala, coppia, righe)) {
            return "Errore";
        } else {
            if (!DbShift.deleteShiftAnello(trn)) {
                return "Errore";
            } else {
               for (Anello a: trn.getAnelli()) {
                   DbAnello.singleEditAnello(a, "New", "status");
               }
               if (!DbShift.insertAnelli(trn, anelli)) {
                return "Errore";
               } else {
                for (Anello a : anelli) {
                    if (!DbAnello.singleEditAnello(a, a.getStatus().toString(), "status")) {
                        return "Errore";
                    }
                }

                        trn.setDir(dir);
                        trn.setSound(sound);
                        trn.setGiorno(giorno);
                        trn.setSala(sala);
                        trn.setType(type);
                        trn.setCoppia(coppia);
                        trn.setAnelli(anelli);
                        return "Turno aggiornato correttamente";

                    }
                }

            }
        }

        public static void updateStatus (Turno turno, Anello anello, String status) {
        for (Anello a : turno.getAnelli()) {
            if (a.getAnelloId().equals(anello.getAnelloId())) {
                a.setStatus(Status.valueOf(status));
            }
        }
        }




}
