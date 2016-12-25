package pack.classes;

import java.time.LocalDateTime;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class Advertisement {
    private int id;
    private String name;
    private LocalDateTime dateOfAdPlacing;
    private String description;
    private double price;
    private Currency currency;
    private int adViewsNumber;
    private User user;

    public Advertisement(String name, String description, double price, Currency currency) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    double getPrice() {
        return price;
    }

    Currency getCurrency() {
        return currency;
    }
}
