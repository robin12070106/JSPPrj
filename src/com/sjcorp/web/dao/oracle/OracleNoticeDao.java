package com.sjcorp.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sjcorp.web.dao.NoticeDao;
import com.sjcorp.web.data.view.NoticeView;
import com.sjcorp.web.entity.Notice;

public class OracleNoticeDao implements NoticeDao {

	@Override
	public List<NoticeView> getList() {
		// TODO Auto-generated method stub
		return getList(1,"TITLE","");
	}

	@Override
	public List<NoticeView> getList(int page) {
		// TODO Auto-generated method stub
		return getList(page,"TITLE","");
	}

	@Override
	public List<NoticeView> getList(int page, String field, String query) {
		
		  String sql = "SELECT  * FROM NOTICE_VIEW WHERE '%"+field+"%' LIKE '%"+query+"%'";
	      List<NoticeView> list = new ArrayList<>();
	        
	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql);

	         NoticeView noticeView = null;

	         while (rs.next()) {
	        	noticeView = new NoticeView();
	            noticeView.setCode(rs.getString("CODE"));
	            noticeView.setTitle(rs.getString("TITLE"));
	            noticeView.setWriter(rs.getString("WRITER"));
	            noticeView.setWriterName(rs.getString("NAME"));	            	            
	            noticeView.setHit(rs.getInt("COMMENT_COUNT"));
	     
	            list.add(noticeView);
	         }
	         rs.close();
	         st.close();
	         con.close();

	      } catch (ClassNotFoundException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }

	         return list;
		
	}

}
