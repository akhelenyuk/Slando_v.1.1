package pack.controller;

import pack.classes.AdsToDb;
import pack.classes.Advertisement;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Oleksandr on 24.12.2016.
 */
public class Index extends javax.servlet.http.HttpServlet {
//    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("error", null);
        if (session.getAttribute("isLoggedIn") == null){
            session.setAttribute("isLoggedIn", false);
        }
        switch (request.getParameter("btnIndex")){
            case "Выйти":{
                session.setAttribute("isLoggedIn", false);
                session.setAttribute("currentUser", null);
                response.sendRedirect("index.jsp");
                break;
            }
            case "Подать объявление":{
                if (!(boolean) session.getAttribute("isLoggedIn")) {
                    session.setAttribute("error", "Для выполнения этого действия нужно залогиниться!");
                    response.sendRedirect("login.jsp");
                    return;
                } else{
                    response.sendRedirect("AddAdvert.jsp");
                    return;
                }
            }
            case "Найти":{
                System.out.println("Search");
                Advertisement adverts = new Advertisement();
                try {
                    adverts.findAdverts(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "Мой профиль":{
                response.sendRedirect("login.jsp");
                break;
            }
        }

        /**
         *    checks if user is logged in. If isLogged attribute if null - it is set to false and redirected to login page.
         *    If "false" - user will be redirected to login page
         *    if "true" - user will be redirected to the requested page
         */




    }
}
