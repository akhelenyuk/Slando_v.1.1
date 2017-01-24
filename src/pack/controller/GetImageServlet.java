package pack.controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Oleksandr on 22.01.2017.
 */
public class GetImageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imagePath = request.getParameter("imagePath");
        Path path = Paths.get("D:/SlandoImages/" + imagePath);
        ByteArrayInputStream iStream = new ByteArrayInputStream(Files.readAllBytes(path));

        int length = (int) Files.size(path);

        response.setContentType("image/jpg");
        response.setContentLength(length);

        // Get the output stream from our response object, so we
        // can write our image data to the client:
        ServletOutputStream oStream = response.getOutputStream();

        // Now, loop through buffer reads of our content, and send it to the client:
        byte [] buffer = new byte[1024];
        int len;
        while ((len = iStream.read(buffer)) != -1) {
            oStream.write(buffer, 0, len);
        }

        // Now that we've sent the image data to the client, close down all the resources:
        iStream.close();

        oStream.flush();
        oStream.close();
    }
}
