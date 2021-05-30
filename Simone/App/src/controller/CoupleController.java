package Controller;

import db.Conn;
import db.DbAnello;
import db.DbCastCouple;
import javafx.util.Pair;
import model.*;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CoupleController {

    public static boolean addCouple (Coppia coppia, Film film) {
        if (DbCastCouple.addCouple(coppia)) {
            film.addCouple(coppia);
            return true;
        };
        return false;
    }




    public static ArrayList allCouples ()  {

       ArrayList<Personaggio> characters = DbCastCouple.getAllCharacters();
       Vector <Doppiatore> voices = VoiceController.allVoices();
       HashMap rawCouples = DbCastCouple.rawCouples();
       ArrayList <Coppia> temp = new ArrayList<>();

        Set entrySet = rawCouples.entrySet();
        Iterator it = entrySet.iterator();

        while(it.hasNext()){
            Coppia c = null;
            Map.Entry me = (Map.Entry)it.next();
            Pair p = (Pair) me.getValue();
            for (int i=0; i<characters.size(); i++) {
                if (p.getValue().equals(characters.get(i).getId())) {
                    c = new Coppia((characters.get(i)));
                    c.setCoupleId(me.getKey().toString());
                    for (int j=0; j<voices.size(); j++) {
                        if (p.getKey().equals(voices.get(j).getStaffId())) {
                            c.setDopp(voices.get(j));
                        }
                    }

                }
            }

            temp.add(c);
        }
        return temp;
    }

    public static ArrayList getAllCharacters () {
        return DbCastCouple.getAllCharacters();
    }

    public static ArrayList getAllCharactersPairs ()  {
        return DbCastCouple.getAllCharactersInPairs();
    }

    public static String modifyCastInFilm(Film film, String persName, Coppia couple) {
            if (!FilmController.checkPersonaggio(film, persName)) {
                if (DbCastCouple.updatePersName(couple, persName)) {

                    for (Coppia c : film.getCoppie()) {
                        if (c.getCoupleId().equals(couple.getCoupleId())) {
                            c.getPers().changeName(persName);

                        }
                    }

                    //couple.getPers().changeName(persName);
                    return "Operazione eseguita correttamente.";
                } else {
                    return "Si è verificato un errore";
                }
            } else {
                return "ERRORE \n Il personaggio esiste già.";
            }

    }

    public static String addVoiceToCouple (Coppia couple, Doppiatore voice) {
        if (couple.getDopp() == null) {
            couple.setCoupleId("co"+ RandomStringUtils.random(9, true, true));
            if (DbCastCouple.addCouple(couple, voice)) {
                couple.setDopp(voice);
                return "Operazione eseguita correttamente";
            } else {
                return "ATTENZIONE! \n Si è verificato un errore.";
            }
        } else if (!voice.getStaffId().equals(couple.getDopp().getStaffId())) {
            if (DbCastCouple.updateCouple(couple, voice)) {
                couple.setDopp(voice);
                return "Operazione eseguita correttamente";
            } else {
                return "ATTENZIONE! \n Si è verificato un errore.";
            }
        }
        return "";
    }

    public static String addCastInFilm(Film film, String persName) {
        if (!FilmController.checkPersonaggio(film, persName)) {
            Personaggio pers = new Personaggio(persName, "ca"+ RandomStringUtils.random(9, true,
                    true));
            if (DbCastCouple.addCastInFilm(film, pers)) {
                film.addCouple(new Coppia(pers));
                return "Operazione eseguita correttamente.";
            } else {
                return "Si è verificato un errore";
            }
        } else {
            return "ERRORE \n Il personaggio esiste già.";
        }
    }








}
