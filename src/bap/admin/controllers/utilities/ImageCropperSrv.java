/*
 *
 * found at: http://java-servlet-jsp-web.blogspot.com/2009/09/java-and-javascript-jcrop-jquery-plugin.html
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bap.admin.controllers.utilities;

import bap.logging.LoggerBean;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A servlet which crops the image based on the JCrop tools parameters
 * @author SANTHOSH REDDY MANDADI
 * @version 1.0
 * @since 04th September 2009
 */
public class ImageCropperSrv extends HttpServlet {

	public void service(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		//Get all the parameters which were populated by JCrop
		int x1 = Integer.parseInt(request.getParameter("x1"));
		int y1 = Integer.parseInt(request.getParameter("y1"));
		int x2 = Integer.parseInt(request.getParameter("x2"));
		int y2 = Integer.parseInt(request.getParameter("y2"));
		int w = Integer.parseInt(request.getParameter("w"));
		int h = Integer.parseInt(request.getParameter("h"));

        LoggerBean.getLoggerBean().getLogger().debug( x1 + " " + y1 + " " + x2 + " " + y2 + " " + w + " " + " " + h );


		//Get the file name from the server
		String file = request.getParameter("file");

		String serverPath = "/commimg/myhotcourses/test/";
		String sourceFile = serverPath + "HC" + file + ".jpg";

		//Get the buffered image reference
		BufferedImage image = ImageIO.read(new File(sourceFile));

		//Get the sub image
		BufferedImage out = image.getSubimage(x1, y1, w, h);

		//Store the image to a new file
		ImageIO.write(out, "jpg", new File(serverPath + "HC" + file + "t.jpg"));

		//Sending the output to the client by showing the cropped image with dimensions
		PrintWriter printer = response.getWriter();
		response.setContentType("text/html");
		printer.println("Photo cropped from " + x1 + "," + y1 + " to the width of " + w + " and height of " + h);
		printer.println("<img src=\"" + serverPath + "HC" + file + "t.jpg" + "\" />");

		printer.close();
	}
}
