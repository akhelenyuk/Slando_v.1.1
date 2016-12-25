package pack.controller;

import pack.classes.User;
import pack.classes.UserToDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Oleksandr on 25.12.2016.
 */
public class Registration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User newUser = new User(
                request.getParameter("first_name").trim(),
                request.getParameter("last_name").trim(),
                request.getParameter("email"),
                request.getParameter("login"),
                request.getParameter("password")
        );
        UserToDb userToDb = new UserToDb();

        if(userToDb.addNewUserToDb(newUser)){
            request.getSession().setAttribute("RegistrationStatusMessage", "Пользователь успешно зарегистрирован. Пожалуйста, залогиньтесь!");
            response.sendRedirect("login.jsp");
        }
        else {
            request.getSession().setAttribute("RegistrationStatusMessage", "Пользователь с таким Логином уже существует. Пожалуйста, выберите другой логин!");
            response.sendRedirect("registration.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
