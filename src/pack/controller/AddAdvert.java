package pack.controller;

import pack.classes.AdsToDb;
import pack.classes.Advertisement;
import pack.classes.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by Oleksandr on 14.01.2017.
 */

@MultipartConfig
public class AddAdvert extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // узнаем юзера, который создал объявление
        User user = null;
        user = (User)request.getSession().getAttribute("currentUser");

        // создаем объект объявления из параметров, которые внес юзер
        Advertisement advertisement = new Advertisement(
                request.getParameter("name"),
                request.getParameter("description"),
                Double.valueOf(request.getParameter("price")),
                request.getParameter("currency"),
                user.getId()
        );

        AdsToDb adsToDb = new AdsToDb();

        adsToDb.insertAd(advertisement);
        int adId = adsToDb.getLastInsertId();
        int imageId = -1;
        if(adId!=-1){
            System.out.println("Successfully inserted! AdId = " + adId);
            // need while-loop here
            adsToDb.insertImage(adId);
            imageId = adsToDb.getLastInsertId();
            System.out.println("Successfully inserted! ImageId = " + imageId);

            String imageName = imageId + "." + adsToDb.getImageExtension(imageId);
            saveImageOnDisk(request, adId, imageName);
        } else System.out.println("Error insertAd. Id = " + adId);

        response.sendRedirect("/start");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void saveImageOnDisk(HttpServletRequest request, int adId, String imageName) throws ServletException, IOException{
        Part filePart = request.getPart("image1"); // Retrieves <input type="file" name="file">
//        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
        InputStream input = filePart.getInputStream();

        File uploads = new File("D:/SlandoImages/" + adId);
        if(!uploads.exists()){
            uploads.mkdir();
        }
        File file = new File(uploads, imageName);
        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

}
