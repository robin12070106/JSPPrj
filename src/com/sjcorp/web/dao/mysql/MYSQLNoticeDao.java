package com.sjcorp.web.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sjcorp.web.dao.NoticeDao;
import com.sjcorp.web.entity.Member;
import com.sjcorp.web.entity.Notice;
import com.sjcorp.web.entity.NoticeView;


public class MYSQLNoticeDao implements NoticeDao {

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
		
		  String sql = "SELECT * FROM NOTICE_VIEW WHERE BINARY "+field+" like ? limit ?, 10"; //_VIEW WHERE '%"+field+"%' LIKE '%"+query+"%'
	      List<NoticeView> list = new ArrayList<>();
	        
	      try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, "%"+query+"%");
	         st.setInt(2, 10*(page-1));
	         
	         
	         ResultSet rs = st.executeQuery();

	         NoticeView noticeView = null;

	         while (rs.next()) {
	        	noticeView = new NoticeView();
	        	//notice 항목
	            noticeView.setCode(rs.getString("CODE"));
	            noticeView.setTitle(rs.getString("TITLE"));
	            noticeView.setWriter(rs.getString("WRITER"));
	            noticeView.setContent(rs.getString("CONTENT"));
	            noticeView.setRegDate(rs.getDate("REGDATE"));
	            noticeView.setHit(rs.getInt("HIT"));
	            //noticeView 항목
	            noticeView.setWriterName(rs.getString("WRITER_NAME"));	            	            
	            noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));
	     
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

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return getSize("TITLE","");
	}

	@Override
	public int getSize(String field, String query) {
		  String sql = "SELECT COUNT(CODE) SIZE FROM NOTICE WHERE BINARY "+field+" like ?"; //_VIEW WHERE '%"+field+"%' LIKE '%"+query+"%'
	      int size =0;
	        
	      try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         
	         	         
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, "%"+query+"%");	         
	         ResultSet rs = st.executeQuery();
	         
	         if(rs.next())
	        	 size = rs.getInt("SIZE");
	         
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

	         return size;
	}
	
	@Override
	public int add(String title, String content, String writer) {
		
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setWriter(writer);
	
		return add(notice);
		
	
	}
	
	@Override
	public int add(Notice notice) {
		String codeSql = "SELECT IFNULL(MAX(CAST(CODE AS UNSIGNED)),0)+1 CODE FROM NOTICE";
		
		String sql = "INSERT INTO NOTICE(CODE,TITLE,WRITER,CONTENT,REGDATE)VALUES(?,?,?,?,SYSDATE())";
        int result = 0;
        
      try {
         Class.forName("com.mysql.jdbc.Driver");
         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
         
         
         Statement codeSt = con.createStatement();        
         ResultSet rs = codeSt.executeQuery(codeSql);
         rs.next();
         String code = rs.getString("CODE");
         rs.close();
         codeSt.close();         
         
         
         PreparedStatement st = con.prepareStatement(sql);
         st.setString(1, code);
         st.setString(2, notice.getTitle());
         st.setString(3, notice.getWriter());
         st.setString(4, notice.getContent());    
         
         
         result = st.executeUpdate();
         
         st.close();
         con.close();         
         

      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

         return result;
	}

	@Override
	public NoticeView get(String code) {
		
		String sql = "SELECT * FROM NOTICE_VIEW WHERE CODE=?"; //_VIEW WHERE '%"+field+"%' LIKE '%"+query+"%'
		NoticeView noticeView = null;
	        
	      try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, code);	          
	         
	         ResultSet rs = st.executeQuery();
         

	         if (rs.next()) {
	        	noticeView = new NoticeView();
	        	//notice 항목
	            noticeView.setCode(rs.getString("CODE"));
	            noticeView.setTitle(rs.getString("TITLE"));
	            noticeView.setWriter(rs.getString("WRITER"));
	            noticeView.setContent(rs.getString("CONTENT"));
	            noticeView.setRegDate(rs.getDate("REGDATE"));
	            noticeView.setHit(rs.getInt("HIT"));
	            //noticeView 항목
	            noticeView.setWriterName(rs.getString("WRITER_NAME"));	            	            
	            noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));
	     
	            
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

	         return noticeView;
	}

	@Override
	public NoticeView getNext(String code) {
		String sql = "select*from NOTICE_VIEW where cast(CODE AS unsigned)>cast(? as unsigned)order by REGDATE asc limit 0, 1"; 
		NoticeView noticeView = null;
	      try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, code);	          
	         
	         ResultSet rs = st.executeQuery();
         

	         if (rs.next()) {
	        	noticeView = new NoticeView();
	        	//notice 항목
	            noticeView.setCode(rs.getString("CODE"));
	            noticeView.setTitle(rs.getString("TITLE"));
	            noticeView.setWriter(rs.getString("WRITER"));
	            noticeView.setContent(rs.getString("CONTENT"));
	            noticeView.setRegDate(rs.getDate("REGDATE"));
	            noticeView.setHit(rs.getInt("HIT"));
	            //noticeView 항목
	            noticeView.setWriterName(rs.getString("WRITER_NAME"));	            	            
	            noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));
	     
	            
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

	         return noticeView;
	}

	@Override
	public NoticeView getPrevious(String code) {
		String sql = "select*from NOTICE_VIEW where cast(CODE AS unsigned)<cast(? as unsigned)order by REGDATE desc limit 0, 1"; 
		NoticeView noticeView = null;
	        
	      try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         PreparedStatement st = con.prepareStatement(sql);
	         st.setString(1, code);	          
	         
	         ResultSet rs = st.executeQuery();
         

	         if (rs.next()) {
	        	noticeView = new NoticeView();
	        	//notice 항목
	            noticeView.setCode(rs.getString("CODE"));
	            noticeView.setTitle(rs.getString("TITLE"));
	            noticeView.setWriter(rs.getString("WRITER"));
	            noticeView.setContent(rs.getString("CONTENT"));
	            noticeView.setRegDate(rs.getDate("REGDATE"));
	            noticeView.setHit(rs.getInt("HIT"));
	            //noticeView 항목
	            noticeView.setWriterName(rs.getString("WRITER_NAME"));	            	            
	            noticeView.setCommentCount(rs.getInt("COMMENT_COUNT"));
	     
	            
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

	         return noticeView;
	}
	
	
	@Override
	public int update(String title, String content, String code) {
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setContent(content);
		notice.setCode(code);
	
		return update(notice);
			
	}
	
	
	@Override
	public int update(Notice notice) {
		String sql = "UPDATE NOTICE SET TITLE=?, CONTENT=? WHERE CODE=?";
	    int result = 0;
	    
	  try {
		 Class.forName("com.mysql.jdbc.Driver");
		 String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		 Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	     PreparedStatement st = con.prepareStatement(sql);
	     
	     st.setString(1, notice.getTitle());
	     st.setString(2, notice.getContent());
	     st.setString(3, notice.getCode());
         
	     	     
	     result = st.executeUpdate();
	     
	     st.close();
	     con.close();
	    	           
	
	  } catch (ClassNotFoundException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	  } catch (SQLException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	  }
	  
	  return result;
	}

	@Override
	public int delete(String code) {
		String sql = "DELETE FROM NOTICE WHERE CODE=?";
	    int result =0;
	    
	  try {
		 Class.forName("com.mysql.jdbc.Driver");
	     String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	     Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	     PreparedStatement st = con.prepareStatement(sql);   
	     
	     st.setString(1, code);
	     result = st.executeUpdate();
	     
	     st.close();
	     con.close();
	    
	      	     

	  } catch (ClassNotFoundException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	  } catch (SQLException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	  }
	  
	  return result;
	}



	@Override
	public String lastCode() {
		
		String sql = "SELECT MAX(CAST(CODE AS UNSIGNED))CODE FROM NOTICE";
	      String code ="0";
	        
	      try {
	    	 Class.forName("com.mysql.jdbc.Driver");
	         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
	         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	         
	         	         
	         Statement st = con.createStatement();       
	         ResultSet rs = st.executeQuery(sql);
	         
	         if(rs.next())
	        	 code = rs.getString("CODE");
	         
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

	         return code;
	}

		

}
