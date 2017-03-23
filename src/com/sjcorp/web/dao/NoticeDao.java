package com.sjcorp.web.dao; // DAO (Data Access Object)

import java.util.List;


import com.sjcorp.web.entity.Notice;
import com.sjcorp.web.entity.NoticeView;

public interface NoticeDao {
	
	
	String lastCode();
	
	int update(Notice notice);
	int update(String title,String content,String code);
	
	int delete(String code);
	
	NoticeView get(String code);
	NoticeView getNext(String code);
	NoticeView getPrevious(String code);
	
	List<NoticeView> getList();
	List<NoticeView> getList(int page);
	List<NoticeView> getList(int page, String field, String query);
	
	
		
	int getSize();
	int getSize(String field, String query);
	
	int add(Notice notice);
	int add(String title, String content, String writer);
}
