<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main id="main">
													
				<h2 class="main-title">공지사항</h2>
			
				<div class="breadcrumb">	
					<h3 class="hidden">breadcrumb</h3>
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</div>
			
				<div class="main-margin">
					<h3 class="hidden">공지사항</h3>
						<form>
			               <fieldset>
			                  <legend class="hidden">검색필드</legend>
			                  <label class="hidden">검색분류</label>
			                  <select name="f">
			                  	<c:if test="${field == 'TITLE'}">
			                  		<c:set var="selTitle" value="selected" />
			                  	</c:if>
			                  	<c:if test="${field == 'CONTENT'}">
			                  		<c:set var="selContent" value="selected" />
			                  	</c:if>			                  	                                         
			                     <option value="TITLE" ${selTitle }>제목</option>
			                     <option value="CONTENT" ${selContent }>내용</option>                     
			                  </select>
			                  <label class="hidden">검색어</label>
			                  <input name="q" type="text" value="${query }" placeholder="검색어를 입력하세요"/>
			                  <input  class="btn btn-search"type="submit" value="검색"/>
			                  <input name="p" type="hidden" value="1" />
			               </fieldset>               
			            </form>
				</div>
			
				<div class="notice margin">
	               <h3>공지목록[${size}]</h3>
	               
	               <script type="text/javascript">
	               
		                window.addEventListener("load", function(e) {
		               		
		               		var notices=[
		               			{code:"1",title:"ddddd"},
		               			{code:"2",title:"eeeee"},
		               			{code:"3",title:"fffff"}
		               			];       		
		               		
		               		var moreBtn = document.querySelector("#more-button");
		               		
		               		moreBtn.onclick = function(){
		               			
		               			var template = document.querySelector("#notice-row");
		               			
		               			for(var i in notices){
				               		var tbody = document.querySelector(".notice-table tbody");		               		
				               		var tds = template.content.querySelectorAll("td");
				               		
				               		tds[0].innerText = notices[i].code;
				               		tds[1].innerText = notices[i].title;
				               		
				               		var clone = document.importNode(template.content, true);
			               			tbody.appendChild(clone);
		               			}
		               			
		               		};
		               		
		               	});
	               
	               </script>
	               <table class="table notice-table">
	                  <thead>
	                     <tr>
	                        <td>번호</td>
	                        <td>제목</td>
	                        <td>작성자</td>
	                        <td>작성일</td>
	                        <td>조회수</td>
	                     </tr>
	                  </thead>
	                  <tbody> <!-- 여러개 올 수 있다 -->
	                  <template id="notice-row">
			               	<tr>
			               		<td></td>
			               		<td></td>
			               		<td></td>
			               		<td></td>
			               		<td></td>
			               	</tr>
		               </template>
	                  <c:forEach var="v" items="${list }">	                  
	                     <tr>
	                        <td><a href="notice-detail?code=${v.code}">${v.code}</td>
	                        <td><a href="notice-detail?code=${v.code}">${v.title}</a></td>
	                        <td>${v.writer}</td>
	                        <td>${v.regDate}</td>
	                        <td>${v.hit}</td>
	                     </tr>	                   
	                   </c:forEach>                     
	                  </tbody>
	               </table>
           		</div>
				<fmt:parseNumber var="sizeInt" integerOnly="true" value="${size/10 }"/>
				<c:set var="last" value="${(size%10)>0 ? sizeInt+1 : sizeInt }"/>
				
				<div class="margin">${pg }/${last } pages</div>				
				<div class="margin">
		            <div class = "page">
		            <c:if test="${pg-1>0 }">		            
		               <a href="?p=${pg-1 }&f=${field}&q=${query}">이전</a>
					</c:if>
		            </div>
		            <ul class="page">
		               <c:forEach var="i" begin="1" end="${last }">
		               <li class="page">&nbsp;<a href="?p=${i }&f=${field }&q=${query}">${i }</a>&nbsp;</li>
		               </c:forEach>
		            </ul>
		            <div>
		            	<c:if test="${pg+1<=last }">
		               <a href="?p=${pg+1 }&f=${field }&q=${query}">다음</a>
		               </c:if>
		            </div>		      	
		        </div>
			<div>
				<a href="notice-reg">글쓰기</a>
				<span id="more-button">더보기</span>
			</div>


		
			</main>