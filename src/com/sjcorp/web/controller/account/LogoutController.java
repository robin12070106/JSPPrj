package com.sjcorp.web.controller.account;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.sjcorp.web.dao.mysql.MYSQLMemberDao;
import com.sjcorp.web.entity.Member;



@WebServlet("/account/logout")
public class LogoutController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.getSession().invalidate();
		
		response.sendRedirect("../index");
		
	}
	

	
}
