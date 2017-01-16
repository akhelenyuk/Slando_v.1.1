package pack.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class Advertisement {
    private int id;
    private String name;
    private LocalDate dateOfAdPlacing;
    private String description;
    private double price;
    private String currency;
    private int adViewsNumber;
    private int userId;
//    private String mainImage;
    private ArrayList<String> images = null;

    public Advertisement(int id, String name, LocalDate dateOfAdPlacing, String description, double price, String currency, int adViewsNumber, int userId, ArrayList<String> images) {
        this.id = id;
        this.name = name;
        this.dateOfAdPlacing = dateOfAdPlacing;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.adViewsNumber = adViewsNumber;
        this.userId = userId;
        this.images = images;
    }

    public Advertisement(String name, String description, double price, String currency, int userId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.userId = userId;
    }

    public Advertisement(int id, String name, LocalDate dateOfAdPlacing, String description, double price, String currency, int adViewsNumber, int userId) {
        this.id = id;
        this.name = name;
        this.dateOfAdPlacing = dateOfAdPlacing;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.adViewsNumber = adViewsNumber;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public int getUserId() {
        return userId;
    }

    public String getMainImage() {
        if(images.size()>0)
            return images.get(0);
        else return null;
    }

    @Override
    public String toString() {
        return "Advertisement{" +
                "id=" + id +
                ",\n name='" + name + '\'' +
                ",\n dateOfAdPlacing=" + dateOfAdPlacing +
                ",\n description='" + description + '\'' +
                ",\n price=" + price +
                ",\n currency='" + currency + '\'' +
                ",\n adViewsNumber=" + adViewsNumber +
                ",\n userId=" + userId +
                '}';
    }
}
