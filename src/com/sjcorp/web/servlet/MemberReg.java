package com.sjcorp.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member-reg")
public class MemberReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String hobbies[] = request.getParameterValues("hobbies");
		String hobby = request.getParameter("hobby");
		
		System.out.println(id);
		System.out.println(pwd);
		System.out.println(name);
		for(String h : hobbies)
			System.out.println(h);
		System.out.println(hobby);
				
	}

}
