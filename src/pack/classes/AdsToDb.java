package pack.classes;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Oleksandr on 27.11.2016.
 */
public class AdsToDb {
    void createAdsTable(){

    }
    public void insert(Advertisement advertisement){
        Connection connection = null;
        Statement statement = null;

        try{
            connection = ConnectionConfig.getConnection();
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
    List<Advertisement> selectAll(){return null;}
    void delete(int id){}
    void update(Advertisement advertisement, int id){}
}
