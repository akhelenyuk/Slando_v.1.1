package pack.classes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    private ArrayList<String> images;

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

    public Advertisement() {
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

    public int getId(){
        return this.id;
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

    public HttpServletRequest showAdvert(HttpServletRequest request){
        // получаем id объявления из request
        int advertId = Integer.parseInt(request.getParameter("id"));

        // получаем из базы данных информацию об объявлении по id
        AdsToDb adsToDb = new AdsToDb();
        ResultSet resultSet = adsToDb.getAdvert(advertId);
        System.out.println("ResultSet" + resultSet);

//        //------------------
//        try {
//            while(resultSet.next()){
//                System.out.println(resultSet.getInt("id"));
//                System.out.println(resultSet.getString("adName"));
//                System.out.println(resultSet.getDate("dateOfAdPlacing").toLocalDate());
//                System.out.println(resultSet.getString("description"));
//                System.out.println(resultSet.getDouble("price"));
//                System.out.println(resultSet.getString("currency"));
//                System.out.println(resultSet.getInt("adViewNumber"));
//                System.out.println(resultSet.getInt("adPlacerId"));
//            }
//            //------------------



//        } catch (SQLException e) {
//
        // получаем сессию и записываем в неё наше объявление
        HttpSession session = request.getSession();
        session.setAttribute("currentAdvert", resultSetToAdvertisement(resultSet));

        return request;

    }

    public Advertisement resultSetToAdvertisement(ResultSet resultSet){
        Advertisement adTemp = null;

        try {
            while(resultSet.next()) {
                adTemp = new Advertisement(
                        resultSet.getInt("id"),
                        resultSet.getString("adName"),
                        resultSet.getDate("dateOfAdPlacing").toLocalDate(),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("currency"),
                        resultSet.getInt("adViewNumber"),
                        resultSet.getInt("adPlacerId"),
                        null
                );
            }
            System.out.println(adTemp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adTemp;
    }




}

































