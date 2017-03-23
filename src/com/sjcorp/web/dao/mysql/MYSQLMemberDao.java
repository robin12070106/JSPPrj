package com.sjcorp.web.dao.mysql;

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

public class MYSQLMemberDao implements MemberDao {

   @Override
   public List<Member> getList(){

        String sql = "SELECT  *  From MEMBER ORDER BY ID ASC";
        List<Member> list = new ArrayList<>();
        
      try {
         Class.forName("com.mysql.jdbc.Driver");
         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);

         Member member = null;

         while (rs.next()) {
            member = new Member();
            member.setId(rs.getString("ID"));
            member.setName(rs.getString("NAME"));
            member.setPwd(rs.getString("PWD"));
            member.setNicName(rs.getString("NICNAME"));
            member.setPhoto(rs.getString("PHOTO"));
            member.setGender(rs.getString("GENDER"));
            member.setBirthday(rs.getString("BIRTHDAY"));
            member.setIsLunar(rs.getInt("IS_LUNAR"));
            member.setPhone(rs.getString("PHONE"));
            member.setEmail(rs.getString("EMAIL"));
            member.setZipCode(rs.getString("ZIPCODE"));
            member.setAddress(rs.getString("ADDRESS"));
            member.setAddressDetail(rs.getString("ADDRESS_DETAIL"));
            member.setRegDate(rs.getDate("REG_DATE"));
            member.setRegIP(rs.getString("REG_IP"));
            member.setRegEnv(rs.getString("REG_ENV"));
            member.setPwdModifyKey(rs.getString("PWD_MODIFY_KEY"));
            member.setRegAdmin(rs.getString("REG_ADMIN"));
            member.setGuid(rs.getString("GUID"));
            member.setDisabled(rs.getBoolean("DISABLED"));
            member.setDisabledReason(rs.getString("DISABLED_REASON"));
            member.setLastLoginIp(rs.getString("LAST_LOGIN_IP"));
            member.setLastLoginPlatform(rs.getString("LAST_LOGIN_PLATFORM"));
            member.setLastLoginTime(rs.getDate("LAST_LOGIN_TIME"));
     
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
   public List<Member> getList(String query){

        String sql = "SELECT  *  From MEMBER WHERE ID LIKE '%"+query+"%' ORDER BY ID ASC";
        List<Member> list = new ArrayList<>();
        
      try {
         Class.forName("com.mysql.jdbc.Driver");
         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);

         Member member = null;

         while (rs.next()) {
            member = new Member();
            member.setId(rs.getString("ID"));
            member.setName(rs.getString("NAME"));
            member.setPwd(rs.getString("PWD"));
            member.setNicName(rs.getString("NICNAME"));
            member.setPhoto(rs.getString("PHOTO"));
            member.setGender(rs.getString("GENDER"));
            member.setBirthday(rs.getString("BIRTHDAY"));
            member.setIsLunar(rs.getInt("IS_LUNAR"));
            member.setPhone(rs.getString("PHONE"));
            member.setEmail(rs.getString("EMAIL"));
            member.setZipCode(rs.getString("ZIPCODE"));
            member.setAddress(rs.getString("ADDRESS"));
            member.setAddressDetail(rs.getString("ADDRESS_DETAIL"));
            member.setRegDate(rs.getDate("REG_DATE"));
            member.setRegIP(rs.getString("REG_IP"));
            member.setRegEnv(rs.getString("REG_ENV"));
            member.setPwdModifyKey(rs.getString("PWD_MODIFY_KEY"));
            member.setRegAdmin(rs.getString("REG_ADMIN"));
            member.setGuid(rs.getString("GUID"));
            member.setDisabled(rs.getBoolean("DISABLED"));
            member.setDisabledReason(rs.getString("DISABLED_REASON"));
            member.setLastLoginIp(rs.getString("LAST_LOGIN_IP"));
            member.setLastLoginPlatform(rs.getString("LAST_LOGIN_PLATFORM"));
            member.setLastLoginTime(rs.getDate("LAST_LOGIN_TIME"));
     
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
        String sql = "INSERT INTO MEMBER(ID,NAME,PWD,NICNAME,GENDER,BIRTHDAY,IS_LUNAR,PHONE,EMAIL,ZIPCODE,ADDRESS,ADDRESS_DETAIL,REG_DATE,LAST_LOGIN_TIME)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,DATETIME,DATETIME)";
        int result = 0;
        
      try {
         Class.forName("com.mysql.jdbc.Driver");
         String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
         Connection con = DriverManager.getConnection(url, "newlec", "sclass");
         PreparedStatement st = con.prepareStatement(sql);
         
         st.setString(1, member.getId());
         st.setString(2, member.getName());
         st.setString(3, member.getPwd());
         st.setString(4, member.getNicName());
         st.setString(5, member.getGender());
         st.setString(6, member.getBirthday());
         st.setInt(7, member.getIsLunar());
         st.setString(8, member.getPhone());
         st.setString(9, member.getEmail());
         st.setString(10, member.getZipCode());
         st.setString(11, member.getAddress());
         st.setString(12, member.getAddressDetail());       
         
         
         
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
public void revise(Member member) {
	
		String sql = "UPDATE MEMBER SET NAME=?,PWD=?,NICNAME=?,GENDER=?,BIRTHDAY=?,IS_LUNAR=?,PHONE=?,EMAIL=?,ZIPCODE=?,ADDRESS=?,ADDRESS_DETAIL=? WHERE ID=?";
	    List<Member> list = new ArrayList<>();
	    
	  try {
	     Class.forName("com.mysql.jdbc.Driver");
	     String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
	     Connection con = DriverManager.getConnection(url, "newlec", "sclass");
	     PreparedStatement st = con.prepareStatement(sql);
	     
	     st.setString(1, member.getName());
         st.setString(2, member.getPwd());
         st.setString(3, member.getNicName());
         st.setString(4, member.getGender());
         st.setString(5, member.getBirthday());
         st.setInt(6, member.getIsLunar());
         st.setString(7, member.getPhone());
         st.setString(8, member.getEmail());
         st.setString(9, member.getZipCode());
         st.setString(10, member.getAddress());
         st.setString(11, member.getAddressDetail()); 
         st.setString(12, member.getId());
	     	     
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
public void delete(String id) {
	

	String sql = "DELETE MEMBER WHERE ID=?";
    List<Member> list = new ArrayList<>();
    
  try {
     Class.forName("com.mysql.jdbc.Driver");
     String url = "jdbc:mysql://211.238.142.84/newlecture?autoReconnect=true&amp;useSSL=false";
     Connection con = DriverManager.getConnection(url, "newlec", "sclass");
     PreparedStatement st = con.prepareStatement(sql);   
     
     st.setString(1, id);
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