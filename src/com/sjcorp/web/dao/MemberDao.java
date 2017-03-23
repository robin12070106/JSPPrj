package com.sjcorp.web.dao;

import java.util.List;

import com.sjcorp.web.entity.Member;
 // 재사용 , 컨트롤러와 뷰의 종속 제거 , 협업에 유리
public interface MemberDao {
	List<Member> getList();
   List<Member> getList(String query);
   
   int add(Member member);
   void revise(Member member);
   void delete(String mid);
   
   
} 
