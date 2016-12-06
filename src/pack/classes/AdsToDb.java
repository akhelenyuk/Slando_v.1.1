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
            System.out.println("Connected successfully!");
            try {
                statement = connection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else System.out.println("Error. No connection");
    }
    void createAdsTable(){

    }
    public void insert(Advertisement advertisement){
        try{
            statement = connection.createStatement();
            statement.execute("INSERT INTO ads(adName,description, price, currency) VALUES('"+advertisement.getName() +"', '" + advertisement.getDescription() +"',"+ advertisement.getPrice()+",'"+ advertisement.getCurrency()+"');");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
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
        ResultSet resultSet;
        String table = "ads";
        String query = "Select * from " + table;

        try{
            resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    void delete(int id){}
    void update(Advertisement advertisement, int id){}
}
