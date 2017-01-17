package pack.controller;

import pack.classes.AdsToDb;
import pack.classes.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Oleksandr on 15.01.2017.
 */
public class Start extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            AdsToDb adsToDb = new AdsToDb();
            ResultSet resultSet = adsToDb.selectAll();
            ResultSet resultSet2 = null;

            ArrayList<Advertisement> adsList = new ArrayList<>();


            while (resultSet.next()) {
                int adId = resultSet.getInt("id");
                resultSet2 = adsToDb.selectAllImagesByAdId(adId);
                ArrayList<String> images = new ArrayList<>();
                while (resultSet2.next()){
                    images.add(adId + "/" + resultSet2.getInt("image_id") + "." + resultSet2.getString("extension"));
                    System.out.println("images = " + images);
                }
                Advertisement adTemp = new Advertisement(
                        adId,
                        resultSet.getString("adName"),
                        resultSet.getDate("dateOfAdPlacing").toLocalDate(),
                        resultSet.getString("description"),
                        resultSet.getDouble("price"),
                        resultSet.getString("currency"),
                        resultSet.getInt("adViewNumber"),
                        resultSet.getInt("adPlacerId"),
                        images
                );
                adsList.add(adTemp);

            }
            request.getSession().setAttribute("adsList", adsList);
            response.sendRedirect("index.jsp");
//            request.setAttribute("adsList", adsList);
//            request.getRequestDispatcher("index.jsp").forward(request, response);

        } catch (SQLException e) {
            System.out.println("try error");
            e.printStackTrace();
        }
    }
}
