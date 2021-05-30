package db;

import javafx.util.Pair;
import model.*;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class DbShift {

    public static boolean insert (Turno turno) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();
        String sid ="'" + turno.getTurnoId() + "'";
        String type = "'" + turno.getType().name() + "'";
        String date = "'" + turno.getGiorno() + "'";
        String dirid = "'" + turno.getDir().getStaffId() + "'";
        String soundid = "'" + turno.getSound().getStaffId() + "'";
        String filmid = "'" + turno.getFilm().getFilmId() + "'";
        String room = "'" + turno.getSala().getName() + "'";
        String coupleid = "'" + turno.getCoppia().getCoupleId() + "'";
        String rows = "'" + turno.getRighe() + "'";

        String sql = "INSERT INTO shift VALUES (" +
                sid + ", " + type  + ", " + date  + ", " + dirid  + ", " + soundid +  ", " + filmid
                + ", " + room  + ", " + coupleid  + ", " + rows +")";

        System.out.println(sql);
        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

    public static boolean deleteShiftAnello (Turno trn) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();
        String id = "'" + trn.getTurnoId() + "'";
        String sql = "DELETE FROM `shift_anelli` WHERE `sid` LIKE " + id;

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;

    }
    public static boolean update (Turno turno, TypeTurno typeT, MyDate myDate, Personale dir,
                                  Personale sound, Room rm, Coppia couple, int rows) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();
        String sid ="'" + turno.getTurnoId() + "'";
        String type = "'" + typeT.name() + "'";
        String date = "'" + myDate.toString() + "'";
        String dirid = "'" + dir.getStaffId() + "'";
        String soundid = "'" + sound.getStaffId() + "'";
        String filmid = "'" + turno.getFilm().getFilmId() + "'";
        String room = "'" + rm.getName() + "'";
        String coupleid = "'" + couple.getCoupleId() + "'";

        String sql = "UPDATE shift SET " +
                "type=" + type  + ", date=" + date  + ", dirid=" + dirid  + ", " +
                "soundid=" + soundid +
                ", filmid = " + filmid
                + ", room =" + room  + ", coupleid = " + coupleid  + ", `rows`=" + rows +" WHERE " +
                "sid" +
                " =" + sid;

        System.out.println(sql);
        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

    public static boolean delete (Turno turno) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String sId = "'" + turno.getTurnoId() + "'";

        String sql =
                "DELETE FROM shift WHERE sid = " + sId + ";";
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
                "DELETE FROM shift_anelli WHERE aid = " + aId + ";";
        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

    public static boolean deleteTurnoAnello (Turno turno) {
        Conn conn = new Conn();
        conn.connect();
        boolean result = false;

        String sId = "'" + turno.getTurnoId() + "'";

        String sql =
                "DELETE FROM shift_anelli WHERE sid = " + sId + ";";
        int sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

    public static boolean insertAnelli(Turno turno, ArrayList<Anello> anelli) {
        boolean result = false;
        int sql_res;
        String sid = turno.getTurnoId();
        Batch b = new Batch("INSERT into shift_anelli VALUES (?, ?, ?)");

        for (Anello a : anelli) {
            try {
                b.pStatement.setString(1, sid);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                b.pStatement.setString(2, a.getCouple().getCoupleId());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                b.pStatement.setString(3, a.getAnelloId());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                b.pStatement.addBatch();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        int[] results = new int[0];
        try {
            results = b.batchStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        for (int r : results) {
            if (r<=0) {
                return false;
            }
        }
            return true;

    }


    public static ArrayList <Pair> allTurniAnelli () throws SQLException {
        Conn conn = new Conn();
        conn.connect();
        ArrayList<Pair> turniAnelli = new ArrayList<>();
        String sql = "SELECT * FROM shift_anelli";
        ResultSet rs = conn.queryToSelect(sql);
        while (rs.next()) {
            turniAnelli.add(new Pair <String, String> (rs.getString("sid"), rs.getString("aid")));
        }
        return turniAnelli;

    }

    public static ArrayList<Turno> allTurni ()  {

        ArrayList turni = new ArrayList<>();

        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT * FROM shift;";
        ResultSet rs = conn.queryToSelect(sql);


            try {
                while (rs.next()) {
                    Turno turno = new Turno();
                    turno.setTurnoId(rs.getString("sid"));
                    turno.getDir().setStaffId(rs.getString("dirid"));
                    turno.setType(TypeTurno.valueOf(rs.getString("type")));
                    turno.setGiorno(new MyDate(rs.getDate("date")));
                    turno.getSound().setStaffId(rs.getString("soundid"));
                    turno.getFilm().setFilmId(rs.getString("filmid"));
                    turno.setSala(new Room(rs.getString("room")));
                    turno.getCoppia().setCoupleId(rs.getString("coupleid"));
                    turno.setRighe(rs.getInt("rows"));
                    turni.add(turno);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }





        conn.disconnect();
        sql = "";
        return turni;
    }





}


