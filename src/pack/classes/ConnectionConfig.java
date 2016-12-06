package pack.classes;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Oleksandr on 27.11.2016.
 */
public class ConnectionConfig {
    public static Connection getConnection(){
        String login = "root";
        String pass = "1212";
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys?useSSL=false", login, pass);
        } catch(Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
