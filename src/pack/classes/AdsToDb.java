package pack.classes;

import java.sql.*;
import java.util.List;

/**
 * Created by Oleksandr on 27.11.2016.
 */
public class AdsToDb {
    Connection connection;
    Statement statement;

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
    public void insert(Advertisement advertisement){
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
        finally {
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

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
    void delete(int id){}
    void update(Advertisement advertisement, int id){}
}
