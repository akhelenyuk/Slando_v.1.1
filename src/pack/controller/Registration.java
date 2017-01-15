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
                0, // юзер создается для удобства, потому id = 0
                request.getParameter("login"),
                request.getParameter("password"),
                request.getParameter("first_name"),
                request.getParameter("last_name"),
                request.getParameter("email")
        );
        if(!newUser.getPassword().equals(request.getParameter("password_confirmation"))){
            request.getSession().setAttribute("RegistrationStatusMessage", "Поле Пароль и Подтверждение пароля не равны!");
            response.sendRedirect("registration.jsp");
            return;
        }
        UserToDb userToDb = new UserToDb();

        if(userToDb.addNewUserToDb(newUser)){
            request.getSession().setAttribute("RegistrationStatusMessage", "Пользователь успешно зарегистрирован. Пожалуйста, залогиньтесь!");
            response.sendRedirect("login.jsp");
//            return;
        }
        else {
            request.getSession().setAttribute("RegistrationStatusMessage", "Пользователь с таким Логином уже существует. Пожалуйста, выберите другой логин!");
            response.sendRedirect("registration.jsp");
//            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
