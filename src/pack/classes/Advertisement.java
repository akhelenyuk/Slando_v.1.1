package pack.classes;

import java.time.LocalDateTime;

/**
 * Created by okhelenyuk on 24.11.2016.
 */
public class Advertisement {
    private int id;
    private LocalDateTime dateOfAdPlacing;
    private String description;
    private double price;
    private Currency currency;
    private int adViewsNumber;
    private AdPlacer adPlacer;

    public Advertisement(LocalDateTime dateOfAdPlacing, String description, double price, Currency currency, AdPlacer adPlacer) {
        this.dateOfAdPlacing = dateOfAdPlacing;
        this.description = description;
        this.price = price;
        this.currency = currency;
        this.adPlacer = adPlacer;
    }
}
