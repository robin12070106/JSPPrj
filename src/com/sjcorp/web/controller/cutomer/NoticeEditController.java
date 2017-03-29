package com.sjcorp.web.controller.cutomer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sjcorp.web.dao.NoticeDao;
import com.sjcorp.web.dao.NoticeFileDao;
import com.sjcorp.web.dao.mysql.MYSQLNoticeDao;
import com.sjcorp.web.entity.NoticeView;



@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet{

	
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String code = request.getParameter("code");
		

			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			NoticeDao noticeDao = new MYSQLNoticeDao();
			NoticeView n = noticeDao.get(code);
			HttpSession session = request.getSession();
			
			//인증과 권한
			if(session.getAttribute("id")==null)
				response.sendRedirect("../account/login?return-url=../customer/notice-edit?code="+code);
				
			else if(!session.getAttribute("id").equals(n.getWriter()))
				response.getWriter().println("<script>alert('인증이 요구되는 페이지 입니다');location.href='notice-detail?code="+code+"';</script>");
			else{								
				request.setAttribute("n", n);				
				request.getRequestDispatcher("/WEB-INF/views/customer/notice-edit.jsp").forward(request, response);
				
			}
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String code = request.getParameter("code");
			
			NoticeDao noticeDao = new MYSQLNoticeDao();
			int result = noticeDao.update(title,content,code);

			if(result>0)
				response.sendRedirect("notice-detail?code="+code);	
			
		}
		
}
