package db;

import javafx.util.Pair;
import model.*;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbAnello {


    public static boolean insert (Film film, Anello anello) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String start = "'"+anello.getStart().toString()+"'";
        String end = "'"+anello.getEnd().toString()+"'";
        String filmId = "'"+film.getFilmId()+"'";
        String status = "'"+anello.getStatus().toLowerCase()+"'";
        String id = "'an"+ RandomStringUtils.random(9, true, true)+"'";
        String rows = String.valueOf(anello.getRighe());

        String sql = "INSERT INTO anello VALUES ("+
                id.concat(", ").concat(start).concat(", ").concat(end).concat(", ").concat(rows).concat(", ").concat(filmId).concat(
                        ", ").concat(status).concat(")");

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }



    public static ArrayList<Pair> selectAnelli ()  {
        ArrayList<Pair> anelli = new ArrayList<>();
        Conn conn = new Conn();
        conn.connect();
        ResultSet rs;

        String sql = "SELECT * FROM anello LEFT JOIN anello_couple ON anello.aid = anello_couple.aid";

        rs = conn.queryToSelect(sql);


            try {
                while (rs.next()) {
                    Anello anello = new Anello(rs.getString("start"), rs.getString("end"),
                            Status.valueOf(rs.getString(
                                    "status").toUpperCase()));
                    anello.setRighe(rs.getInt("rows"));
                    anello.setAnelloId(rs.getString("aid"));

                    if (rs.getString("coupleid") != null) {
                        anello.addCouple(new Coppia(rs.getString("coupleid")));
                    }

                    anelli.add(new Pair (rs.getString("filmid"), anello));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        conn.disconnect();
        sql = "";
        return anelli;
    }


    public static boolean editAnelloCouple (Anello anello, Coppia couple) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String aId = "'" + anello.getAnelloId() + "'";
        String coupleId = "'" + couple.getCoupleId() + "'";

        String sql =
                "UPDATE anello_couple SET coupleid =" + coupleId + "WHERE aid =" + aId +
                        ";";
        System.out.println(sql);
        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

    public static boolean deleteAnelloCouple (Anello anello) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String aId = "'" + anello.getAnelloId() + "'";

        String sql =
                "DELETE FROM anello_couple WHERE aid = " + aId + ";";
        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

    public static boolean deleteAnello (Anello anello) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String aId = "'" + anello.getAnelloId() + "'";

        String sql =
                "DELETE FROM anello WHERE aid = " + aId + ";";
        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }


    public static boolean insertAnelloCouple (Anello anello, Coppia couple) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String aId = "'" + anello.getAnelloId() + "'";
        String coupleId = "'" + couple.getCoupleId() + "'";

        String sql = "INSERT INTO anello_couple VALUES(" +
                aId + ", " + coupleId + ");";

        int sql_res=conn.queryToInsert(sql);
        System.out.println(sql);
        conn.disconnect();

        if (sql_res != 0) {
            result = true;
        }
        return result;
    }


/*
    public static boolean editAnello (Anello anello, Film film) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String start = "'"+anello.getStart().toString()+"'";
        String end = "'"+anello.getEnd().toString()+"'";
        String filmId = "'"+film.getFilmId()+"'";
        String status = "'"+anello.getStatus().toLowerCase()+"'";
        String id = "'"+anello.getAnelloId()+"'";

        String sql = "UPDATE anello VALUES ("+
                id.concat(", ").concat(start).concat(", ").concat(end).concat(", ").concat(filmId).concat(
                        ", ").concat(status).concat(")");

        String sql = "UPDATE couple SET voiceid =" + voiceId + "WHERE coupleid =" + coupleId +";";


        String start = "'"+anello.getStart().toString()+"'";
        String end = "'"+anello.getEnd().toString()+"'";
        String filmId = "'"+film.getFilmId()+"'";
        String status = "'"+anello.getStatus().toLowerCase()+"'";
        String id = "'an"+ RandomStringUtils.random(9, true, true)+"'";

        String sql = "INSERT INTO anello VALUES ("+
                id.concat(", ").concat(start).concat(", ").concat(end).concat(", ").concat(filmId).concat(
                        ", ").concat(status).concat(")");

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

 */


    public static boolean editAnelloTime (Anello anello, MyTime start, MyTime end) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String aId = "'" + anello.getAnelloId() + "'";



        String sql =
                "UPDATE anello SET start = " + "'" + start.toString() + "'" + ", end = " + "'" + end.toString() + "'" +
                        " WHERE aid " +
                        "=" + aId +
                        ";";
        System.out.println(sql);
        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }





    public static boolean singleEditAnello (Anello anello, String param, String name) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String aId = "'" + anello.getAnelloId() + "'";

        String sql =
                "UPDATE anello SET " + name + " = " + "'" + param + "'" + " " +
                        " WHERE aid " +
                        "=" + aId +
                        ";";
        System.out.println(sql);
        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }



    public static boolean multiEditAnello (String value2, String param2, String param,
                                           String name) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String sql =
                "UPDATE anello SET " + name + " = " + "'" + param + "'" + " " +
                        " WHERE " + param2 +
                        " LIKE " + value2 +
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
