<%@page import="com.sjcorp.web.dao.mysql.MYSQLNoticeDao"%>
<%@page import="com.sjcorp.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String code = request.getParameter("code");
	
	NoticeDao noticeDao = new MYSQLNoticeDao();
	int result = noticeDao.update(title,content,code);

	if(result>0)
		response.sendRedirect("notice-detail.jsp?code="+code);	
	
	

%>