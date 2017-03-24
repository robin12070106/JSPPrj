<%@page import="com.sjcorp.web.dao.mysql.MYSQLNoticeDao"%>
<%@page import="com.sjcorp.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String code = request.getParameter("code");	
	
	NoticeDao noticeDao = new MYSQLNoticeDao();
	int result = noticeDao.delete(code);

	if(result>0)
		response.sendRedirect("notice.jsp");	
	
	

%>