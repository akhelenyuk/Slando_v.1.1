package pack.controller;

import pack.classes.AdsToDb;
import pack.classes.Advertisement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
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
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("***********************************************************************");

        Advertisement advertisement = new Advertisement();
        try {
            advertisement.getAllAdverts(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
            //------------------- вариант 1 ----------------------
//            ServletOutputStream out = response.getOutputStream();
//            FileInputStream fin = new FileInputStream("D:/SlandoImages/1/3.jpg");
//
//            BufferedInputStream bin = new BufferedInputStream(fin);
//            BufferedOutputStream bout = new BufferedOutputStream(out);
//            int ch =0;
//            while((ch=bin.read())!=-1)
//            {
//                bout.write(ch);
//            }
//
//            bin.close();
//            fin.close();
//            bout.close();
//            out.close();
            //------------------- вариант 2 ----------------------
//            File imageFile = new File("D:/SlandoImages/" + imagePath);
//            String contentType = getServletContext().getMimeType(imageFile.getName());
//            response.setContentType(contentType);
//            response.setHeader("Content-Length", String.valueOf(imageFile.length()));
//            response.getOutputStream().write();
//                    Files.copy(imageFile.toPath(), response.getOutputStream());
//            ImageIO.write(ImageIO.read(Files.newInputStream(Paths.get(imageFile.getAbsolutePath()))), "jpg", response.getOutputStream());
//                    System.out.println("images = " + images);
            //------------------- вариант 3 ----------------------
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ImageIO.write(ImageIO.read(Files.newInputStream(Paths.get("D:/SlandoImages/" + imagePath))), "jpg", baos);
//            byte[] bytes = baos.toByteArray();
//            String url = "data:image/jpg;base64," + Base64.getEncoder().encode(bytes);
//            request.getSession().setAttribute("url", url);

    }

}
