package com.sjcopr.web.controller.cutomer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjcorp.web.dao.NoticeDao;
import com.sjcorp.web.dao.NoticeFileDao;
import com.sjcorp.web.dao.mysql.MYSQLNoticeDao;
import com.sjcorp.web.dao.mysql.MYSQLNoticeFileDao;
import com.sjcorp.web.entity.NoticeFile;
import com.sjcorp.web.entity.NoticeView;



@WebServlet("/customer/notice-detail")
public class NoticeDetailController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");	
		
		
		NoticeDao noticeDao = new MYSQLNoticeDao();
		NoticeFileDao noticeFileDao = new MYSQLNoticeFileDao();

		
		NoticeView n = noticeDao.get(code);		
		NoticeView next = noticeDao.getNext(code);
		NoticeView prev = noticeDao.getPrevious(code);
		
		
		List<NoticeFile> list = noticeFileDao.getList(n.getCode());
		
		
		//전달 목적ㄴ
		
		request.setAttribute("n", n);
		request.setAttribute("next", next);
		request.setAttribute("prev", prev);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("notice-detail.jsp").forward(request, response);
	}
	
}
