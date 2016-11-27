package pack;

import pack.classes.AdPlacer;
import pack.classes.Address;
import pack.classes.Advertisement;
import pack.classes.Currency;

import java.time.LocalDateTime;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class start {
    public static void main(String[] args) {
        Address address = new Address("Украина","03012", "Киев", "Драгоманова", "6/1","2");
        AdPlacer adPlacer = new AdPlacer("John", "Snow", address, "snow@gmail.com", "098-123-12-23");

        Advertisement ad1 = new Advertisement(LocalDateTime.now(), "description", 54.00, Currency.UAH, adPlacer);
    }
}
