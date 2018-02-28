package source;

import java.sql.*;

public class Database {
    private static final String url = "jdbc:h2:mem:test";
    private static Connection conn = null;

    private static Connection instance() {
        if(conn != null)
            return conn;

        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            conn = DriverManager.
                    getConnection(url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet execute(String query) {
        try {
            Statement stmt = instance().createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
