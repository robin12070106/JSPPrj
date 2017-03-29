<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<main id="main">
											
		<h2 class="main-title">공지사항 내용</h2>
	
		<div class="breadcrumb">	
			<h3 class="hidden">breadcrumb</h3>
			<ol>
				<li>home</li>
				<li>고객센터</li>
				<li>공지사항</li>
			</ol>
		</div>						
				
            <table border="1">
               <tbody>
                  <tr>		                  
                     <th>제목</th>
                     <td>
                     	${n.title } <!-- //el표기 -->
                     </td>	                    
                  </tr>
                  <tr>
                     <th>작성자</th>
                     <td>
						${n.writer }
					 </td>	                    
                  </tr>
                  <tr>
                     <th>작성일</th>
                     <td>
						${n.regDate }
					 </td>	                    
                  </tr>
                  <tr>
                     <th>조회수</th>
                     <td>
                     	${n.hit }
                     </td>	                    
                  </tr>
                  <tr>
                     <th>첨부파일</th>
                     <td>
                     <%-- 	<%
                     		/* List ns = new ArrayList();
                     		ns.add("a");
                     		ns.add("b");
                     		ns.add("c");
                     		ns.add("d");
                     		ns.add("e");
                     		ns.add("f"); */
                     		
                     		String hbs="롤, 야구, 코딩, 먹기, 자기";
                     		
                     		
                     		pageContext.setAttribute("hbs", hbs);
                     	%> --%>
                     	<%-- <c:forEach var="str" begin="0" end="3" items="${ns }" varStatus="">
                     	${st.index} : 가나다라 ${str }<br/>
                     	</c:forEach> --%>
                     	
                     	<%-- <c:forTokens var="hb" items="${hbs }" delims=",">
                     		${hb}<br/>
                     	</c:forTokens> --%>
                     <c:forEach var="f" items="${list }">		                     
                     <a href="upload/${f.src }" download>${f.src }</a>							 
					 </c:forEach>     
					 </td>                
                  </tr>
                  <tr>              
                     <td colspan="2">
                     	${n.content }
                     	<c:forEach var="f" items="${list }">		                     
                     	<img src="upload/${f.src }"/>							 
						</c:forEach>                      
                     </td>
                  </tr>   
               </tbody>
            </table>
            <div>
				<a href="notice?code=${n.code }">목록</a>		            	                        
               <a href="notice-edit?code=${n.code }">수정</a>
               <a href="notice-del?code=${n.code }">삭제</a>
            </div>
            <div>
            	<ul>
            		<li>
            			<span>다음글: </span>
            			<c:if test="${empty next }">
            			<span>다음글이 존재하지 않습니다</span>
            			</c:if>
            			<c:if test="${not empty next }">
            			<a href="?code=${next.code }">${next["title"] }</a> <!--  n.xxx/n["xxx"] 둘 다 동일 -->
            			</c:if>
            		</li>
            		<li>
            			<span>이전글: </span>
            			<c:if test="${empty prev }">
            			<span>이전글이 존재하지 않습니다</span>
            			</c:if>
            			<c:if test="${not empty next }">
            			<a href="?code=${prev.code }">${prev.title }</a>
            			</c:if> 
            		</li>
            	</ul>
            </div>
          		
	</main>
