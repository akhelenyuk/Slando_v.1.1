package pack.classes;

import java.sql.*;
import java.util.List;

/**
 * Created by Oleksandr on 27.11.2016.
 */
public class AdsToDb {
    Connection connection, connection2;
    Statement statement, statement2;

    public AdsToDb(){
        connection = ConnectionConfig.getConnection();
        if(connection!=null){
            System.out.println("AdsToDb constructor. Connected successfully!");
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else System.out.println("AdsToDb constructor. Error. No connection");
    }
    void createAdsTable(){

    }
    public void insertAd(Advertisement advertisement){
         try{
            statement.execute("INSERT " +
                                    "INTO ads(adName,description, price, currency, adPlacerId) " +
                                    "VALUES('" + advertisement.getName() + "', " +
                                    "'" + advertisement.getDescription() +"', " +
                                    advertisement.getPrice()+", " +
                                    "'" + advertisement.getCurrency()+"', " +
                                    advertisement.getUserId() + ");" +
                    "");

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void insertImage(int adId){
        try{
            statement.execute("INSERT INTO ads_images (ad_id, extension) VALUES (" + adId + ", 'jpg');");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getImageExtension(int imageId){
        String extension = null;
        ResultSet resultSet = null;
        String table = "ads_images";
        String query = "SELECT extension FROM " + table + " WHERE image_id = "+ imageId + ";";
        try{
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                extension = resultSet.getString("extension");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return extension;
    }

    public int getLastInsertId(){
        ResultSet resultSet = null;
        int id = -1;
        try{
            resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
            while (resultSet.next()){
                id = resultSet.getInt("LAST_INSERT_ID()");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
    }

    Advertisement selectById(int id){return null;}
    public ResultSet selectAll(){
        ResultSet resultSet = null;
        String table = "ads";
        String query = "Select * from " + table;

        try{
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
    public ResultSet selectAllImagesByAdId(int adId){
        ResultSet resultSet = null;
        String table = "ads_images";
        String query = "SELECT * FROM " + table + " WHERE ad_id=" + adId + ";";

        connection2 = ConnectionConfig.getConnection();
        if(connection2!=null){
            System.out.println("SelectAllImagesByAdId connection. Connected successfully!");
            try {
                statement2 = connection.createStatement();
                resultSet = statement2.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else System.out.println("SelectAllImagesByAdId connection. Error. No connection2");
        return resultSet;
    }
//    public ResultSet selectAllJoinImages(){
//        ResultSet resultSet = null;
//        String adsTable = "ads";
//        String imageTable = "ads_images";
//        String query = "SELECT * FROM " + adsTable + " ads LEFT JOIN " + imageTable + " images ON ads.id=images.ad_id;";
//
//        try{
//            resultSet = statement.executeQuery(query);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return resultSet;
//    }

    void delete(int id){}
    void update(Advertisement advertisement, int id){}
}
