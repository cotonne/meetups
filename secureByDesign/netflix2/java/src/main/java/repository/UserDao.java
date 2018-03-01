package repository;

import source.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    /**
     * Register a user to the system.
     * The user identifier is unique.
     *
     * @param userId identifier of a user
     * @param password password
     * @return true if the user has been successfully registered, false otherwise
     */
    public static boolean register(String userId, String password) {
        return DB.insert(String.format("INSERT INTO USERS(ID, PASSWORD) values('%s', '%s')", userId, password));
    }

    /**
     * Check if a user
     * @param userId identifier of a user
     * @param password password
     * @return true if the user exists, false otherwise
     */
    public static boolean exist(String userId, String password) {
        ResultSet rs = DB.execute(String.format("SELECT count(1) FROM USERS where id='%s' AND password='%s'", userId, password));
        try {
            return rs.getInt("total") > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

}
