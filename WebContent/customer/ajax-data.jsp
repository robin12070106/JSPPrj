<%@page import="java.util.ArrayList"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.sjcorp.web.entity.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.sjcorp.web.dao.mysql.MYSQLNoticeDao"%>
<%@page import="com.sjcorp.web.dao.NoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

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

	//Thread.sleep(2000);//새로운 캐셔 추가 같은 느낌, 2줄 되는 것, 병렬화
	
	Gson gson = new Gson();
	String json = gson.toJson(list);
	
	out.println(json);		 
		 
	

%>