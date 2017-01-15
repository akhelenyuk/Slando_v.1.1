package pack;

import pack.classes.*;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class start {
    public static void main(String[] args) {
//        Address address = new Address("Украина","03012", "Киев", "Драгоманова", "6/1","2");
//        User adPlacer = new User("John", "Snow", address, "snow@gmail.com", "098-123-12-23");

        Advertisement ad1 = new Advertisement("testtest", "description", 54.00, "UAH", 20);
//        AdsToDb adsToDb = new AdsToDb();
//        ResultSetMetaData resultSetMetaData = adsToDb.selectAll();
//        try {
//            for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
//                System.out.println("OK" + i);
//            }
//        } catch (SQLException e) {
//            System.out.println("Error!");
//            e.printStackTrace();
//        }
//        adsToDb.insert(ad1);
    }
}
