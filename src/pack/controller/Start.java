package pack.controller;

import pack.classes.AdsToDb;
import pack.classes.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Oleksandr on 15.01.2017.
 */
public class Start extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdsToDb adsToDb = new AdsToDb();
            ResultSet resultSet = adsToDb.selectAll();
            ArrayList<Advertisement> adsList = new ArrayList<>();

            while (resultSet.next()) {
                Advertisement adTemp = new Advertisement(
                        resultSet.getInt("id"),
                        resultSet.getString("adName"),
                        resultSet.getDate("dateOfAdPlacing").toLocalDate(),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("currency"),
                        resultSet.getInt("adViewNumber"),
                        resultSet.getInt("adPlacerId")
                );
                adsList.add(adTemp);

            }
            request.setAttribute("adsList", adsList);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (SQLException e) {
            System.out.println("try error");
            e.printStackTrace();
        }
    }
}
