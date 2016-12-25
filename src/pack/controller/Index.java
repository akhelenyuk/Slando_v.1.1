package pack.controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Oleksandr on 24.12.2016.
 */
public class Index extends javax.servlet.http.HttpServlet {
//    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        HttpSession session = request.getSession();

        /**
         *    checks if user is logged in. If isLogged attribute if null - it is set to false and redirected to login page.
         *    If "false" - user will be redirected to login page
         *    if "true" - user will be redirected to the requested page
         */
        if(session.getAttribute("isLogged") == null)
            session.setAttribute("isLogged", false);
        if(!(boolean) session.getAttribute("isLogged"))
            response.sendRedirect("login.jsp");
        else
            response.sendRedirect("");


    }
}