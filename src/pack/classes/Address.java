package pack.classes;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class Address {
    private String country;
    private String index;
    private String city;
    private String street;
    private String building;
    private String apartment;

    public Address(String country, String index, String city, String street, String building, String apartment) {
        this.country = country;
        this.index = index;
        this.city = city;
        this.street = street;
        this.building = building;
        this.apartment = apartment;
    }
}
