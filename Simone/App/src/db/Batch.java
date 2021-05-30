package db;
import java.sql.*;

public class Batch {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost/java_app";
    static final String USER = "root";
    static final String PW = "";
    private Connection connection;
    public PreparedStatement pStatement;

    public Batch (String sql) {
        // Connessione
        try {
            Class.forName(this.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            this.connection = DriverManager.getConnection(this.URL, this.USER, this.PW);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            this.pStatement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int[] batchStatement () throws SQLException {
        int[] result = pStatement.executeBatch();
        pStatement.close();
        connection.close();
        return result;
    }
}
