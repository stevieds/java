package Controller;
import db.DbCastCouple;
import db.DbStaff;
import model.*;
import org.apache.commons.lang.RandomStringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class VoiceController {

    public static Vector<Doppiatore> allVoices () {
        return DbStaff.allVoices();
    }





}
