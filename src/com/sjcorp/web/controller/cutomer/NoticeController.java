package com.sjcorp.web.controller.cutomer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjcorp.web.dao.NoticeDao;
import com.sjcorp.web.dao.mysql.MYSQLNoticeDao;
import com.sjcorp.web.entity.NoticeView;



@WebServlet("/customer/notice")
public class NoticeController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String _page = request.getParameter("p");
		String _field = request.getParameter("f");
		String _query = request.getParameter("q");

		int pg = 1;
		String field = "TITLE";
		String query = "";
		
		
		if (_page != null && !_page.equals("")) // 전달된 page값이 있다면
				pg = Integer.parseInt(_page);
		if (_field != null && !_field.equals("")) // 전달된 field값이 있다면
			   field = _field;
		if (_query != null && !_query.equals("")) // 전달된 query값이 있다면
			   query = _query;


		NoticeDao noticeDao = new MYSQLNoticeDao();
		List<NoticeView> list = noticeDao.getList(pg, field, query);
		
		
		int size = noticeDao.getSize(field,query);
		
		
		//전달 목적
		
		request.setAttribute("pg", pg);
		request.setAttribute("field", field);
		request.setAttribute("query", query);
		
		request.setAttribute("list", list);
		request.setAttribute("size", size);
		
		request.getRequestDispatcher("notice.jsp").forward(request, response);
	}
	
}
