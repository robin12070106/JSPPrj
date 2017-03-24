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



@WebServlet("/account/login")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//전달 목적			
		request.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		
		Member member = new MYSQLMemberDao().get(id);
		
		HttpSession session = request.getSession();
		
		boolean validate = true;
		
		//인증과정
		//id 존재 확인
		if(member==null){
			validate = false;
			System.out.println("아이디 없음");
		
		//비밀번호 확인
		}else if(!member.getPwd().equals(pwd)){
			validate = false;
			System.out.println("비밀번호 틀림");
		
		//인증 성공 시 세션에 저장	
		}else {
			session.setAttribute("id", id);
			System.out.println("로그인 성공");
			
		}
			
		//페이지 이동
		//성공시
		if(validate)
			response.sendRedirect("../index");
		//실패시
		else{
			request.setAttribute("validate", validate);
			request.getRequestDispatcher("/WEB-INF/views/account/login.jsp").forward(request, response);
		}
	}
	
}
