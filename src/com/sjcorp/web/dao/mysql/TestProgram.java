package com.sjcorp.web.dao.mysql;

import java.util.List;

import com.sjcorp.web.dao.NoticeDao;
import com.sjcorp.web.entity.NoticeView;

public class TestProgram {

	public static void main(String[] args) {
		
		NoticeDao noticeDao = new MYSQLNoticeDao();
		List<NoticeView> list = noticeDao.getList();
		
		for(NoticeView view : list)
			System.out.println(view.getTitle());
		

	}

}
