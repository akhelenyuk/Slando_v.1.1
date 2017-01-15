package pack.controller;

import pack.classes.AdsToDb;
import pack.classes.Advertisement;
import pack.classes.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Oleksandr on 14.01.2017.
 */
public class AddAdvert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // узнаем юзера, который создал объявление
        User user = (User)request.getSession().getAttribute("currentUser");

        // создаем объект объявления из параметров, которые внес юзер
        Advertisement advertisement = new Advertisement(
                request.getParameter("name"),
                request.getParameter("description"),
                Double.valueOf(request.getParameter("price")),
                request.getParameter("currency"),
                user.getId()
        );

        AdsToDb adsToDb = new AdsToDb();
        adsToDb.insert(advertisement);
        System.out.println("user = " + user);
        System.out.println("-----------------------------------");
        System.out.println("advertisement = " + advertisement);


        response.sendRedirect("index.jsp");
    }

}
