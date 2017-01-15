package pack.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
