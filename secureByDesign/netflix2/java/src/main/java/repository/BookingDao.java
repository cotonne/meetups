package repository;

import source.DB;

import java.sql.ResultSet;

public class BookingDao {

    public static boolean book(String dvdId, int quantity, String userId) {
        return DB.insert(String.format("INSERT INTO BOOKINGS(DVD_ID, QUANTITY, USER_ID) values('%s', %s, '%s')", dvdId, quantity, userId));
    }
}
