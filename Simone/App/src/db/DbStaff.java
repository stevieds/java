package db;

import javafx.util.Pair;
import model.Doppiatore;
import model.Genere;
import model.Personaggio;
import model.Personale;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

public class DbStaff {

    public static boolean insertStaff (Personale personale, String string) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String fName = "'"+personale.getFName()+"'";
        String lName = "'"+personale.getLName()+"'";
        String contact = "'"+personale.getRecapito()+"'";
        String id = "'st"+ RandomStringUtils.random(9, true, true)+"'";
        String sql = "INSERT INTO staff VALUES ("+
                id.concat(", ").concat(fName).concat(", ").concat(lName).concat(", ").concat(contact).concat(", ").concat("'" + string + "'").concat(", ").concat("NULL").concat(")");

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

    public static boolean insertStaff (Doppiatore dopp) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();
        String fname = "'"+dopp.getFName()+"'";
        String lname = "'"+dopp.getLName()+"'";
        String recapito = "'"+dopp.getRecapito()+"'";
        String gender = "'"+dopp.getGenere().name()+"'";
        String id = "'"+dopp.getStaffId()+"'";
        String role = "'"+"voice"+"'";
        String sql = "INSERT INTO staff VALUES ("+
                id.concat(", ").concat(fname).concat(", ").concat(lname).concat(", ").concat(recapito).concat(
                        ", ").concat(role).concat(", ").concat(gender).concat(")");

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        sql = "";
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }





    public static Vector<Doppiatore> allVoices () {
        ResultSet rs;
        Vector<Doppiatore> voices = new Vector<>();
        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT * FROM staff WHERE role LIKE 'voice';";
        rs = conn.queryToSelect(sql);


            try {
                while (rs.next()) {
                    Doppiatore dopp = new Doppiatore(rs.getString("fname"), rs.getString(
                            "lname"),
                            rs.getString(
                                    "contact"), Genere.valueOf(rs.getString("gender")));
                    dopp.setStaffId(rs.getString("staffid"));
                    voices.add(dopp);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        conn.disconnect();
        return voices;
    }

    public static Vector<Personale> allStaff (String type)  {
        ResultSet rs;
        Vector<Personale> staff = new Vector<>();
        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT * FROM staff WHERE role LIKE '" + type + "';";
        rs = conn.queryToSelect(sql);


            try {
                while (rs.next()) {
                    Personale person = new Personale(rs.getString("fname"), rs.getString("lname"),
                            rs.getString("contact"));
                    person.setStaffId(rs.getString("staffid"));
                    staff.add(person);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


        try {
            rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        conn.disconnect();
        return staff;
    }

}
