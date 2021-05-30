package db;

import com.mysql.cj.conf.ConnectionUrlParser;
import model.*;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javafx.util.Pair;

public class DbCastCouple {

    public static HashMap rawCouples () {
        ResultSet rs;
        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT * FROM couple;";
        rs = conn.queryToSelect(sql);
        HashMap <String, Pair> couples = new HashMap();



            try {
                while (rs.next()) {
                    couples.put(rs.getString("coupleid"), new Pair (rs.getString("voiceid"), rs.getString(
                            "castid")));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }



        conn.disconnect();
        sql = "";
        return couples;
    }



    public static ArrayList<Pair> getAllCharactersInPairs () {
        ResultSet rs;
        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT * FROM cast;";
        rs = conn.queryToSelect(sql);
        ArrayList <Pair> cast = new ArrayList();


            try {
                while (rs.next()) {
                    Personaggio pers = new Personaggio(rs.getString("castname"), rs.getString("castid") );
                    cast.add(new Pair(rs.getString("filmid"), pers));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        conn.disconnect();
        sql = "";
        return cast;
    }

    public static ArrayList getAllCharacters () {
        ResultSet rs;
        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT * FROM cast;";
        rs = conn.queryToSelect(sql);
        ArrayList cast = new ArrayList();


            try {
                while (rs.next()) {
                    Personaggio pers = new Personaggio(rs.getString("castname"), rs.getString("castid") );
                    cast.add(pers);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        conn.disconnect();
        sql = "";
        return cast;
    }

    public static ArrayList<Pair> allCast () throws SQLException {
        ResultSet rs;
        ArrayList<Pair> cast = new ArrayList<>();
        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT cast.castid, cast.castname, cast.filmid, couple.coupleid, couple.voiceid FROM cast LEFT JOIN couple ON cast.castid = couple.castid;";
        rs = conn.queryToSelect(sql);
        Vector<Doppiatore> voices = DbStaff.allVoices();


        while (rs.next()) {
            Personaggio pers = new Personaggio(rs.getString("castname"), rs.getString("castid"));
            if (rs.getString("coupleid") != null) {
                for (int i=0; i<voices.size(); i++) {
                    if (voices.get(i).getStaffId().equals(rs.getString("voiceid"))) {
                        Coppia couple = new Coppia(voices.get(i), pers, rs.getString("coupleid"));
                        cast.add(new Pair(rs.getString("filmid"), couple));
                    }
                }
            }
            else {
                cast.add(new Pair(rs.getString("filmid"), new Coppia(pers)));
            }

        }
        return cast;
    }


    public static ArrayList<Coppia> allCouples () throws SQLException {
        ResultSet rs;
        ArrayList<Coppia> couples = new ArrayList<>();
        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT cast.castid, cast.castname, cast.filmid, couple.coupleid, couple.voiceid FROM cast LEFT JOIN couple ON cast.castid = couple.castid;";
        rs = conn.queryToSelect(sql);
        Vector<Doppiatore> voices = DbStaff.allVoices();


        while (rs.next()) {
            Personaggio pers = new Personaggio(rs.getString("castname"), rs.getString("castid"));
            if (rs.getString("coupleid") != null) {
                for (int i=0; i<voices.size(); i++) {
                    if (voices.get(i).getStaffId().equals(rs.getString("voiceid"))) {
                        Coppia couple = new Coppia(voices.get(i), pers, rs.getString("coupleid"));
                        couples.add(couple);
                    }
                }
            }
            else {
                couples.add(new Coppia(pers));
            }

        }
        return couples;
    }


    public static boolean addCastInFilm (Film film, Personaggio pers) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String filmId = "'"+ film.getFilmId() +"'";
        String castId = "'"+ pers.getId() +"'";
        String castName = "'"+ pers.getName() +"'";
        String sql = "";
            sql += "INSERT INTO cast VALUES ("+
                    castId.concat(", ").concat(castName).concat(", ").concat(filmId).concat(");");

          sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        sql = "";
        return result;
    }




    public static boolean deleteFromCast (Film film, Coppia couple) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String filmId = "'"+ film.getFilmId() +"'";
        String castId = "'"+ couple.getPers().getId() +"'";
        String sql = "DELETE FROM `cast` WHERE `cast`.`castid` = " + castId;
        System.out.println(sql);

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        sql = "";
        return result;
    }

    public static boolean addCouple(Coppia couple) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String coupleId = "'"+ couple.getCoupleId() + "'";
        String voiceId = "'" + couple.getDopp().getStaffId() + "'";
        String castId = "'" + couple.getPers().getId() + "'";

        String sql = "INSERT into couple VALUES (" + coupleId + ", " + voiceId + ", " + castId + ");";

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        sql = "";
        return result;
    }

    public static boolean addCouple(Coppia couple, Doppiatore voice) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String coupleId = "'"+ couple.getCoupleId() + "'";
        String voiceId = "'" + voice.getStaffId() + "'";
        String castId = "'" + couple.getPers().getId() + "'";

        String sql = "INSERT into couple VALUES (" + coupleId + ", " + voiceId + ", " + castId + ");";

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        sql = "";
        return result;
    }

    public static boolean updateCouple(Coppia couple, Doppiatore doppiatore) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String coupleId = "'"+ couple.getCoupleId() +"'";
        String voiceId = "'" + doppiatore.getStaffId() + "'";
        String sql = "UPDATE couple SET voiceid =" + voiceId + "WHERE coupleid =" + coupleId +";";

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        sql = "";
        return result;
    }

    public static boolean updatePersName(Coppia couple, String persName) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String persId = "'" + couple.getPers().getId() + "'";

        String sql =
        "UPDATE cast SET castName =" + "'" + persName + "'" + " WHERE castId =" + persId +";";
        System.out.println(sql);

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        sql = "";
        return result;
    }


    public static boolean deleteFromCouple(Coppia couple) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String coupleId = "'"+ couple.getCoupleId() +"'";
        String sql = "DELETE FROM `couple` WHERE `couple`.`coupleid` = " + coupleId;

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        sql = "";
        return result;
    }


}
