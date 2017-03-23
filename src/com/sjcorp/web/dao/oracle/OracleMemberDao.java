package com.sjcorp.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sjcorp.web.dao.MemberDao;
import com.sjcorp.web.entity.Member;

public class OracleMemberDao implements MemberDao {

   @Override
   public List<Member> getList(){

        String sql = "SELECT  * FROM MEMBER";
        List<Member> list = new ArrayList<>();
        
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);

         Member member = null;

         while (rs.next()) {
            member = new Member();
            member.setMid(rs.getString("MID"));
            member.setPwd(rs.getString("PWD"));
            member.setName(rs.getString("NAME"));
            member.setGender(rs.getString("GENDER"));
            member.setAge(rs.getInt("AGE"));
            member.setBirthday(rs.getString("BIRTHDAY"));
            member.setMajor(rs.getString("MAJOR"));
            member.setAddress(rs.getString("ADDRESS"));
            member.setPhone(rs.getString("PHONE"));
            member.setSsn(rs.getString("SSN"));
            member.setIp(rs.getString("IP"));
            member.setRegDate(rs.getDate("REGDATE"));
     
            list.add(member);
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
   public int add(Member member) {
        String sql = "INSERT INTO MEMBER(MID,PWD,NAME,GENDER,AGE,BIRTHDAY,MAJOR,ADDRESS,PHONE,SSN,IP,REGDATE)VALUES(?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
        List<Member> list = new ArrayList<>();
        
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
         Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
         PreparedStatement st = con.prepareStatement(sql);
         st.setString(1, member.getMid());
         st.setString(2, member.getPwd());
         st.setString(3, member.getName());
         st.setString(4, member.getGender());
         st.setInt(5, member.getAge());
         st.setString(6, member.getBirthday());
         st.setString(7, member.getMajor());
         st.setString(8, member.getAddress());
         st.setString(9, member.getPhone());
         st.setString(10, member.getSsn());
         st.setString(11, member.getIp());        
         
         
         
         int result = st.executeUpdate();
         
         st.close();
         con.close();
         
         return result;
         
         
         
         

      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

         return 0;
   }

@Override
public void revise(Member member) {
	
		String sql = "UPDATE MEMBER SET PWD=?,NAME=?,GENDER=?,AGE=?,BIRTHDAY=?,MAJOR=?,ADDRESS=?,PHONE=?,SSN=?,IP=? WHERE MID=?";
	    List<Member> list = new ArrayList<>();
	    
	  try {
	     Class.forName("oracle.jdbc.driver.OracleDriver");
	     String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
	     Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
	     PreparedStatement st = con.prepareStatement(sql);
	     
	     st.setString(1, member.getPwd());
	     st.setString(2, member.getName());
	     st.setString(3, member.getGender());
	     st.setInt(4, member.getAge());
	     st.setString(5, member.getBirthday());
	     st.setString(6, member.getMajor());
	     st.setString(7, member.getAddress());
	     st.setString(8, member.getPhone());
	     st.setString(9, member.getSsn());
	     st.setString(10, member.getIp()); 
	     st.setString(11, member.getMid());
	     
	     	     
	     int result = st.executeUpdate();
	     
	     st.close();
	     con.close();
	    
	      
	     
	
	  } catch (ClassNotFoundException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	  } catch (SQLException e) {
	     // TODO Auto-generated catch block
	     e.printStackTrace();
	  }
	  
}

@Override
public void delete(String mid) {
	

	String sql = "DELETE MEMBER WHERE MID=?";
    List<Member> list = new ArrayList<>();
    
  try {
     Class.forName("oracle.jdbc.driver.OracleDriver");
     String url = "jdbc:oracle:thin:@211.238.142.251:1521:orcl";
     Connection con = DriverManager.getConnection(url, "c##sist", "dclass");
     PreparedStatement st = con.prepareStatement(sql);   
     
     st.setString(1, mid);
     int result = st.executeUpdate();
     
     st.close();
     con.close();
    
      
     

  } catch (ClassNotFoundException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
  } catch (SQLException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
  }
}

   
   
   
}