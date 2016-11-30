package pack;

import pack.classes.*;

import java.time.LocalDateTime;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class start {
    public static void main(String[] args) {
//        Address address = new Address("Украина","03012", "Киев", "Драгоманова", "6/1","2");
//        AdPlacer adPlacer = new AdPlacer("John", "Snow", address, "snow@gmail.com", "098-123-12-23");

        Advertisement ad1 = new Advertisement("testtest", "description", 54.00, Currency.UAH);
        AdsToDb adsToDb = new AdsToDb();
//        adsToDb.insert(ad1);
    }
}
