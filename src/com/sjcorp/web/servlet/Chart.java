package com.sjcorp.web.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/chart")
public class Chart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       		
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("image/png");
		  
		  
		String url = "images/photo/visual2.png";
		ServletContext context = request.getServletContext();
		String path = context.getRealPath(url);
		  
		    
		   
		//BufferedImage image = new BufferedImage(800, 500, BufferedImage.TYPE_INT_RGB);
			  
		BufferedImage image = ImageIO.read(new File(path));// = ImageIO.read(new URL(""));
			  
		Graphics g = image.createGraphics();
		/*g.setColor(Color.WHITE);
		g.fillRect(0, 0, 800, 500);*/
		  
		g.setColor(Color.white);
		 
		g.drawLine(70, 50, 70, 410);
		g.drawString("인원(명)", 50, 30);
		g.drawString("▲", 64, 50);
		g.drawLine(60, 400, 610, 400);
		g.drawString("▶", 610, 405);
		g.drawLine(600, 410, 600, 50);		
		g.drawString("누적상대도수(%)", 550, 30);
		g.drawString("▲", 594, 50);
			
			
		g.setColor(Color.magenta);
		 for(int j=1;j<6;j++){
			 for(int i=70;i<=600;i=i+4)
				g.drawString("- ", i,400-59*j);			
				g.drawString(j*2+"", 55, 400-59*j);
				g.drawString(j*20+"", 605, 400-59*j);
		 }
			
		OutputStream os = response.getOutputStream();     
	    ImageIO.write(image, "png", os);
	
		  /*JPEGImageEncoder encoder = JPEGCodec.createJPEGDecoder(os);
		  encoder.encode(image);*/
	}

}
