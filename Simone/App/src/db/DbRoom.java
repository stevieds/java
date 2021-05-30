package db;

import model.Doppiatore;
import model.Genere;
import model.Personale;
import model.Room;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DbRoom {


    public static boolean insert (Room room) {
        boolean result = false;
        int sql_res;
        Conn conn = new Conn();
        conn.connect();

        String name = "'"+room.getName()+"'";
        String id = "'rm"+ RandomStringUtils.random(9, true, true)+"'";
        String sql = "INSERT INTO room VALUES ("+
                id.concat(", ").concat(name).concat(")");

        sql_res=conn.queryToInsert(sql);
        conn.disconnect();
        if (sql_res != 0) {
            result = true;
        }
        return result;
    }

    public static Vector<Room> allRooms()  {
        Vector<Room> rooms = new Vector<>();
        Conn conn = new Conn();
        conn.connect();
        String sql = "SELECT * FROM room;";
        ResultSet rs = conn.queryToSelect(sql);


            try {
                while (rs.next()) {
                    Room rm = new Room(rs.getString("roomname"));
                    rooms.add(rm);
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
        return rooms;
    }
}
