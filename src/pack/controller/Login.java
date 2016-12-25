package pack.controller;

import pack.classes.User;
import pack.classes.UserToDb;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Oleksandr on 25.12.2016.
 */
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserToDb userToDb = new UserToDb();
        HttpSession session = request.getSession();

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = userToDb.authenticateUser(login, password);
        if(user != null){
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("currentUser", user);
            response.sendRedirect("index.jsp");
        }
        else{
            session.setAttribute("error", "Error. Wrong login or wrong password");
            response.sendRedirect("login.jsp");
        }

        System.out.println(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
