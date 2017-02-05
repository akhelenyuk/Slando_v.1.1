package pack.classes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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

    public ArrayList<String> getImages() {
        return images;
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

    public void showAdvert(HttpServletRequest request){
        // получаем id объявления из request
        int advertId = Integer.parseInt(request.getParameter("id"));

        // получаем из базы данных информацию об объявлении по id
        AdsToDb adsToDb = new AdsToDb();
        ResultSet resultSet = adsToDb.getAdvert(advertId);
        ResultSet resultSetImages = adsToDb.getAdvertImages(advertId);

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
        session.setAttribute("currentAdvert", resultSetToAdvertisement(resultSet, resultSetImages));
    }

    public Advertisement resultSetToAdvertisement(ResultSet resultSet, ResultSet resultSetImages){
        Advertisement adTemp = null;
        ArrayList<String> images = getImagesArrayListFromResultSet(resultSetImages);

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
                        images
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return adTemp;
    }

    public ArrayList<String> getImagesArrayListFromResultSet(ResultSet resultSetImages){
        ArrayList<String> images = new ArrayList<>();
        String imagePath;
        try {
            while (resultSetImages.next()){
                imagePath = resultSetImages.getInt("ad_id") + "/" + resultSetImages.getInt("image_id") + "." + resultSetImages.getString("extension");
                images.add(imagePath);
                System.out.println(images);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return images;
    }

    public void zoomImage (HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletOutputStream out = response.getOutputStream();
        FileInputStream fin = new FileInputStream("D:/SlandoImages/" + request.getParameter("imagePath"));

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        int ch =0;
        while((ch=bin.read())!=-1)
        {
            bout.write(ch);
        }

        bin.close();
        fin.close();
        bout.close();
        out.close();
    }

    public ArrayList<Advertisement> resultSetToArray(ResultSet resultSetAdvert) {
        AdsToDb adsToDb = new AdsToDb();
        ResultSet resultSetImages = null;
        String imagePath;

        ArrayList<Advertisement> adsList = new ArrayList<>();

        try {
            while (resultSetAdvert.next()) {
                // получаю id каждого объявления
                int adId = resultSetAdvert.getInt("id");

                // выбираю все фото из базы данных, относящиеся к этому объявлению
                resultSetImages = adsToDb.getAdvertImages(adId);

                // создаю список адресов фоток, относящиеся к этому объявлению в формате "3/45.jpg", где
                // 3 - это id объявления и папка, в которой хранятся фото;
                // 45 - id фото и имя файла
                ArrayList<String> images = new ArrayList<>();
                while (resultSetImages.next()) {
                    imagePath = adId + "/" + resultSetImages.getInt("image_id") + "." + resultSetImages.getString("extension");
                    images.add(imagePath);
                }

                // создаю объект класса Advertisement и добавляю его в ArrayList
                Advertisement adTemp = new Advertisement(
                        adId,
                        resultSetAdvert.getString("adName"),
                        resultSetAdvert.getDate("dateOfAdPlacing").toLocalDate(),
                        resultSetAdvert.getString("description"),
                        resultSetAdvert.getDouble("price"),
                        resultSetAdvert.getString("currency"),
                        resultSetAdvert.getInt("adViewNumber"),
                        resultSetAdvert.getInt("adPlacerId"),
                        images
                );
                adsList.add(adTemp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return adsList;

    }




    public void getAllAdverts(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        AdsToDb adsToDb = new AdsToDb();
        ResultSet resultSetAdvert = adsToDb.getAllAdverts();

        if (resultSetAdvert==null)
            return;

        ArrayList<Advertisement> adsList = resultSetToArray(resultSetAdvert);
        System.out.println("adslist" + adsList);

        // записываю ArrayList объявлений в сессию и перенаправляю на стартовую страницу
        request.getSession().setAttribute("adsList", adsList);
        response.sendRedirect("index.jsp");


    }
    public void findAdverts(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        AdsToDb adsToDb = new AdsToDb();
        ResultSet resultSetAdvert = adsToDb.getAdverts(request.getParameter("searchText"));

        if (resultSetAdvert==null)
            return;

        ArrayList<Advertisement> adsList = resultSetToArray(resultSetAdvert);
        System.out.println("adslist" + adsList);

        // записываю ArrayList объявлений в сессию и перенаправляю на стартовую страницу
        request.getSession().setAttribute("adsList", adsList);
        response.sendRedirect("index.jsp");


    }


}

































