package pack.classes;

import java.util.List;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class AdPlacer {
    private String name;
    private String lastName;
    private String passportSeries;
    private String passportNumber;
    private Address residenceAddress;
    private String email;
    private String phone;
    private List<Advertisement> ads;

    public AdPlacer(String name, String lastName, Address residenceAddress, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.residenceAddress = residenceAddress;
        this.email = email;
        this.phone = phone;
    }
}
