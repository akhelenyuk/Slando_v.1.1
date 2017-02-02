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
    private String imagePath;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println("***********************************************************************");
        try {
            AdsToDb adsToDb = new AdsToDb();

            // выгружаю список всех объявлений из базы данных
            // resultSet - для списка объявлений
            // resultSet2 - для списка фотографий
            ResultSet resultSet = adsToDb.selectAll();
            ResultSet resultSet2 = null;

            ArrayList<Advertisement> adsList = new ArrayList<>();


            while (resultSet.next()) {
                // получаю id каждого объявления
                int adId = resultSet.getInt("id");

                // выбираю все фото из базы данных, относящиеся к этому объявлению
                resultSet2 = adsToDb.getAdvertImages(adId);

                // создаю список адресов фоток, относящиеся к этому объявлению в формате "3/45.jpg", где
                // 3 - это id объявления и папка, в которой хранятся фото;
                // 45 - id фото и имя файла
                ArrayList<String> images = new ArrayList<>();
                while (resultSet2.next()){
                    imagePath = adId + "/" + resultSet2.getInt("image_id") + "." + resultSet2.getString("extension");
                    images.add(imagePath);
                }

                // создаю объект класса Advertisement и добавляю его в ArrayList
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

            // записываю ArrayList объявлений в сессию и перенаправляю на стартовую страницу
            request.getSession().setAttribute("adsList", adsList);
            response.sendRedirect("index.jsp");

        } catch (SQLException e) {
            System.out.println("try error");
            e.printStackTrace();
        }
    }
}
