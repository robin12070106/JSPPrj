package com.sjcorp.web.entity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sjcorp.web.dao.MemberDao;
import com.sjcorp.web.dao.mysql.MYSQLMemberDao;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			
	   //controller------------------------------------------------------------------------------------------		
		
		Scanner scan = new Scanner(System.in);
		
		 
		 int mainMenu = 0;
		 
		 	System.out.println("┌──────────────┐");
		    System.out.println("│    메인 메뉴            │");
		    System.out.println("└──────────────┘");
		    System.out.println(" 1.회원 관리  ");
		    System.out.println(" 2.게시글 관리  ");
		    System.out.println(" 3.종료  ");
		    System.out.print(" 선택 > ");
		    
		    mainMenu = Integer.parseInt(scan.nextLine());
		    
		    
		    switch(mainMenu){
		    
			    case 1:
			    	member();
			    	break;
			    case 2:			
			    	notice();
			    	break;
			    	
			    case 3:
			    	break; 		
		    } 
	      
	}
	

	public static void notice() {
		
		
	}

	public static void member() {
		
		Scanner scan = new Scanner(System.in);
		MemberDao memberDao = new MYSQLMemberDao();
		 List<Member> list = memberDao.getList();
		
		 int menu=0;
		 
		 while(menu!=4){
    	
	    	System.out.println("┌──────────────┐");
		    System.out.println("│    회원 관리            │");
		    System.out.println("└──────────────┘");
		    
	    	System.out.println("아이디	이름	비밀번호	닉네임	 성별	생일		음력여부	전화번호		이메일		우편번호	주소	상세주소	등록일		마지막 로그인 시간");
	    	
	    	for(Member m : list) 
		    	  System.out.printf("%s	%s	%s	%s	%s	%s	%d	%s	%s	%s	%s	%s	%s	%s\n",m.getId(),m.getName(),m.getPwd(),m.getNicName(),m.getGender(),m.getBirthday(),m.getIsLunar(),m.getPhone(),m.getEmail(),m.getZipCode(),m.getAddress(),m.getAddressDetail(),m.getRegDate(),m.getLastLoginTime());
	    	System.out.println();
	    	
	    	menu = 0;
	    	
	    	System.out.println("( 1.추가 2.수정 3.삭제 4.상위메뉴 )");
	    	
	    	menu = Integer.parseInt(scan.nextLine());
	    	
	    	switch(menu){
	    	
		    	case 1:{
		    		add();	    		
				    break;
		    	}
				case 2:{
					revise();
					break;
				}
				case 3:{
					delete();
					break;
				}
				case 4:
					break;	
	    	}	
			
	    }
	    	
    
    	
		
	}

	public static void revise() {

		Scanner scan = new Scanner(System.in);
		MemberDao memberDao = new MYSQLMemberDao();
		
		System.out.println("┌──────────────┐");
	    System.out.println("│    회원 수정            │");
	    System.out.println("└──────────────┘");
	    
	    
	    
	    int swi=0;
	    
	    while(swi==0){
		    System.out.println("수정하실 아이디 : ");
		    String id = scan.nextLine();
		    
			Member t = new Member();
			
			t.setId(id);
		    
		    System.out.println("수정하실 내용");
		    System.out.print("이름 : ");
		    String name = scan.nextLine();
		    System.out.print("비밀번호 : ");
		    String pwd = scan.nextLine();
		    System.out.print("닉네임 : ");
		    String nicName = scan.nextLine();
		    System.out.print("성별 : ");
		    String gender = scan.nextLine();		    
		    System.out.print("생일 : ");
		    String birthday = scan.nextLine();
		    System.out.print("음력여부( 0 or 1 ) :");
		    int isLunar = Integer.parseInt(scan.nextLine());
		    System.out.print("전화번호 : ");
		    String phone = scan.nextLine();
		    System.out.print("이메일 : ");
		    String email = scan.nextLine();
		    System.out.print("우편번호 : ");
		    String zipCode = scan.nextLine();
		    System.out.print("주소 : ");
		    String address = scan.nextLine();		    
		    System.out.print("상세주소 : ");
		    String addressDetail = scan.nextLine();
		   
		    t.setName(name);
			t.setPwd(pwd);
			t.setNicName(nicName);
			t.setGender(gender);			
			t.setBirthday(birthday);
			t.setIsLunar(isLunar);			
			t.setPhone(phone);
			t.setZipCode(zipCode);
			t.setAddress(address);
			t.setAddressDetail(addressDetail);	    
		    
		    
			
			memberDao.revise(t);
			
			System.out.println("계속 입력하시겠습니까?(y/n)");
			String enter = scan.nextLine();
			
			if(enter.equals("y"))
				swi=0;
			
			else{
				swi=1;
			}
		    
	    }
	}

	public static void delete() {
		
		Scanner scan = new Scanner(System.in);
		MemberDao memberDao = new MYSQLMemberDao();
		
		System.out.println("┌──────────────┐");
	    System.out.println("│    회원 삭제            │");
	    System.out.println("└──────────────┘");
	    
	    int swi=0;
	    
	    while(swi==0){
	    System.out.println("삭제하고 싶은 아이디 : ");
	    String id = scan.nextLine();
	    
	    memberDao.delete(id);
	    
	    System.out.println("계속 입력하시겠습니까?(y/n)");
		String enter = scan.nextLine();
		
		if(enter.equals("y"))
			swi=0;
		
		else{
			swi=1;
		}
	    
	    }
		
	}

	private static void add() {
		
		Scanner scan = new Scanner(System.in);
		MemberDao memberDao = new MYSQLMemberDao();
		
		
		System.out.println("┌──────────────┐");
	    System.out.println("│    회원 추가            │");
	    System.out.println("└──────────────┘");
		
	   int swi=0;
	    
	    while(swi==0){
	    	
		    System.out.print("아이디 : ");
		    String id = scan.nextLine();		    
		    System.out.print("이름 : ");
		    String name = scan.nextLine();
		    System.out.print("비밀번호 : ");
		    String pwd = scan.nextLine();
		    System.out.print("닉네임 : ");
		    String nicName = scan.nextLine();
		    System.out.print("성별 : ");
		    String gender = scan.nextLine();		    
		    System.out.print("생일 : ");
		    String birthday = scan.nextLine();
		    System.out.print("음력여부( 0 or 1 ) :");
		    int isLunar = Integer.parseInt(scan.nextLine());
		    System.out.print("전화번호 : ");
		    String phone = scan.nextLine();
		    System.out.print("이메일 : ");
		    String email = scan.nextLine();
		    System.out.print("우편번호 : ");
		    String zipCode = scan.nextLine();
		    System.out.print("주소 : ");
		    String address = scan.nextLine();		    
		    System.out.print("상세주소 : ");
		    String addressDetail = scan.nextLine();
		    
							    
		    Member t = new Member();
		    
			t.setId(id);
			t.setName(name);
			t.setPwd(pwd);
			t.setNicName(nicName);
			t.setGender(gender);			
			t.setBirthday(birthday);
			t.setIsLunar(isLunar);			
			t.setPhone(phone);
			t.setZipCode(zipCode);
			t.setAddress(address);
			t.setAddressDetail(addressDetail);
			
								
			memberDao.add(t);
			
			System.out.println("계속 입력하시겠습니까?(y/n)");
			String enter = scan.nextLine();
			
			if(enter.equals("y"))
				swi=0;
			
			else{
				swi=1;
			}
			
	    }
		
	}
	
	
	
	

}
