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
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;

//lets servlet recognize and support multipart/form-data requests
// and thus get getPart() to work
@MultipartConfig

public class AddAdvert extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        switch (request.getParameter("button")){
            case "Добавить": {
                // узнаем юзера, который создал объявление
                User user = (User) request.getSession().getAttribute("currentUser");

                // создаем объект объявления из параметров, которые внес юзер
                // и вносим его в БД
                Advertisement advertisement = new Advertisement(
                        request.getParameter("name"),
                        request.getParameter("description"),
                        Double.valueOf(request.getParameter("price")),
                        request.getParameter("currency"),
                        user.getId()
                );
                AdsToDb adsToDb = new AdsToDb();
                adsToDb.insertAd(advertisement);

                // получаем id последнего добавленного в базу объявления
                int adId = adsToDb.getLastInsertId();
                int imageId;
                if (adId != -1) {
                    System.out.println("Advert was successfully inserted! AdId = " + adId);

                    ArrayList<String> inputImages = new ArrayList<>();
                    inputImages.add("image1");
                    inputImages.add("image2");
                    inputImages.add("image3");
                    inputImages.add("image4");
                    inputImages.add("image5");


                    Collection<Part> parts = request.getParts();
                    for (Part part: parts)
                    {
                        if(getFileName(part)!=null && !getFileName(part).equals("")){
                            adsToDb.insertImage(adId);
                            imageId = adsToDb.getLastInsertId();
                            System.out.println("Image was successfully inserted! ImageId = " + imageId);
                            String imageName = imageId + "." + adsToDb.getImageExtension(imageId);
                            saveImageOnDisk(request, adId, imageName, part);
                        }
                    }
                    System.out.println(parts.toString());
                    response.sendRedirect("addadvertsuccess.jsp");
                    return;
                } else System.out.println("Error insertAd. Id = " + adId);

            }
            case "Отменить":
                break;
        }
        response.sendRedirect("/start");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void saveImageOnDisk(HttpServletRequest request, int adId, String imageName, Part part) throws ServletException, IOException {
//        Part filePart = request.getPart(""); // Retrieves <input type="file" name="file">
        InputStream input = part.getInputStream();

        File uploads = new File("D:/SlandoImages/" + adId);
        if (!uploads.exists()) {
            uploads.mkdir();
        }
        File file = new File(uploads, imageName);
        Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
