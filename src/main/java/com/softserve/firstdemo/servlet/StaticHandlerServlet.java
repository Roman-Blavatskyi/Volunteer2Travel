package com.softserve.firstdemo.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/static/*")
public class StaticHandlerServlet extends HttpServlet {
    public final String staticContentBase = "D:\\SoftServe IT Academy\\Demo#1\\Volunteer2Travel\\src\\main\\webapp\\resources/";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String URLAfterWebDomain = request.getRequestURI();

        /*//Only accept mappings as src="/images/whatever.jpg", even if web.xml has other mappings to this servlet.

        if(URLAfterWebDomain.startsWith("/images/") == false)
            return;*/

        //get the image name, or even directory and image, e.g. /images/music/beethoven.jpg:
        //will get "music/beethoven.jpg"
        String relativeImagePath = URLAfterWebDomain.substring("/static/".length());

        System.out.println("\nFetching image from " + staticContentBase + relativeImagePath);
        String contentType = "";
        if (URLAfterWebDomain.endsWith("css")) {
            contentType = "stylesheet";
        } else if (URLAfterWebDomain.endsWith("jpeg")) {
            response.setContentType("image/jpeg");
        }
        response.setContentType("image/jpeg");
        //as far as I know, this works for PNG as well.
        // You might want to change the mapping to /images/*.jpg if it's giving problems

        ServletOutputStream outStream;
        outStream = response.getOutputStream();
        FileInputStream fin = new FileInputStream(staticContentBase + relativeImagePath);

        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(outStream);
        int ch = 0;

        while ((ch = bin.read()) != -1)
            bout.write(ch);

        bin.close();
        fin.close();
        bout.close();
        outStream.close();
    }
}