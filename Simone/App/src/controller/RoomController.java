package Controller;

import db.DbRoom;
import db.DbStaff;
import model.Personale;
import model.Room;

import java.sql.SQLException;
import java.util.Vector;

public class RoomController {

    public static boolean addRoom (String name) {
        Room room = new Room(name);
        return DbRoom.insert(room);
    }


    public static Vector <Room> allRooms () {
        return DbRoom.allRooms();
    }

}
