<%@page import="com.sjcorp.web.entity.NoticeView"%>
<%@page import="java.util.List"%>
<%@page import="com.sjcorp.web.dao.NoticeDao"%>
<%@page import="com.sjcorp.web.dao.mysql.MYSQLNoticeDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

	String _page = request.getParameter("p");
	String _field = request.getParameter("f");
	String _query = request.getParameter("q");

	int pg = 1;
	String field = "TITLE";
	String query = "";
	
	
	if (_page != null && !_page.equals("")) // 전달된 page값이 있다면
			pg = Integer.parseInt(_page);
	if (_field != null && !_field.equals("")) // 전달된 field값이 있다면
		   field = _field;
	if (_query != null && !_query.equals("")) // 전달된 query값이 있다면
		   query = _query;


	NoticeDao noticeDao = new MYSQLNoticeDao();
	List<NoticeView> list = noticeDao.getList(pg, field, query);
	int size = noticeDao.getSize(field,query);

%>






<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice</title>
<link href="../css/customer/style.css" type="text/css" rel="stylesheet"/>
</head>
<!-- <script src = "../js/customer/notice.js" type="text/javascript">
	
	/* window.onload = function(){
	var h1 = document.querySelector("#header > div:first-child > h1");
	h1.onclick = function(){
	   h1.style.border = "1px solid red";
	}
	} */
	
	// var exam = []; (= var exam = new Array();)
	/* var exam = {}; //(= var exam = new Exam();)
	exam["kor a"] = 30;
	exam.eng = 70;
	exam.math = 80;
	
	alert(exam["kor a"] + exam.eng); */
	
	/* exam.Kor = 20;
	alert(exam.kor + exam.eng); */
	
/* 	 var student = {
	name : "홍길동",
	age : 19,
	"취미" : ["코딩", "공부", "수학"]
	};   
	
	alert(student.취미); */
	
	/* alert(student.name);
	alert(student.age + "세");
	alert(student["취미"][1]); */
	
	/* var a = 3 + 4.5;
	alert(a); 
	
	alert(3.5-"2"); //숫자로
	alert("3"+"4"); //문자로
	alert("32" > "4"); //첫자리 숫자 기준 
	alert(32 > "4"); // 숫자로 */

	/* var exam = {
		kor:30,eng:40,math:50
	};
	
	var ar=["취미","코딩","공부","수학"];
	
	for(var i in exam){
		alert(i);
		alert(exam[i]);
	} */
	
	/* var add = new Function("x,y","return x+y;");
	alert(add(3,4)); */
	
/* 	var add = function(x,y){return x+y;}; */

 	/* function add(){
		var sum=0;
		for(var i in arguments)
			sum+=arguments[i];
		
		return sum;}
	alert(add(3,4,5,6)); */
	
	
	/* {var a =1;} //스크립트에서는 중괄호가 변수 영역을 나누지 않음. */
	
/* 	function f1(){
		 a =1 ; // var 안 붙이면 스스로 글로벌 변수가 되어 버린다  //var 붙이면 영역내 지역변수가 된다
		 f2();
		 function f2() {
			a = 2;
			 f3();
			 function f3() {
				a =3;
				 
			 }
		 }
	}
	f1();
	alert(a); */
	

	 
	 //자바 스크립트 박스 : number String boolean
	
/* 	 function f1(){
		var a = 1;
		
		return function f2(){
			
			return a;
		}   //이 영역이  new Function()
	 }
	
	var f = f1();
	var a = f();
	a = null; //이것이 클로져
		
	alert(a); */
	
	
	/* var x =3;
	document.write(x); */
 	
	
/* 	var x,y;
	
	x=prompt("x 입력",0);
	y=prompt("y 입력",0);
	
	//alert(typeof x); // 타입체크 함수
	
	//x=parseInt(x);
	//y=parseInt(y);
	
	//alert(typeof x);
	
	x = new Number(x);
	y = Number(y);
	
	//alert(x+y); */
	
	
/* 	window.onload = function(){
		
		var btnResult = document.getElementById("btn-result");
		btnResult.onclick = printResult;//함수자체를 위임--()붙이면 값을 위임
		
		function printResult(){	
			var x,y;
			
			x=prompt("x 입력",0);
			y=prompt("y 입력",0);
			x=parseInt(x);
			y=parseInt(y);
			
			btnResult.value=x+y;
		}
	} */

</script> -->

<body>

<!-- -------------header--------------------------------------------------------- -->
	
	<header id="header">
		<div class="content-container">
			<h1 id="logo">
				<img src="../images/logo.png" alt="뉴렉처 온라인" />
			</h1>
		
			<section>
				<h1 class="hidden">Header</h1>
			
				<nav id="main-menu" class="hr-menu">
					<h1 class="hidden">메인 메뉴</h1>
						<!-- <input type="button" value="클릭" id="btn-result"/> -->
					<ul>
						<li><a href="">학습가이드</a></li>	
						<li><a href="">뉴렉과정</a></li>
						<li><a href="">강좌선택</a></li>
					</ul>
				</nav>
			
				<nav id="lecture-search-form" class="hr-menu">
					<h1 class="hidden">강좌 검색 폼</h1>
					<form>
						<fieldset>
							<legend class="hidden">검색필드</legend>
							<label>과정검색</label>
							<input type="text"/>
							<input class="lecture-search-button" type="submit" value="검색"/>						
						</fieldset>
					</form>
				</nav>
			
				<nav id="account-menu" class="hr-menu">
					<h1 class="hidden">계정 메뉴</h1>
					<ul>
						<li><a href="../index.html">HOME</a></li>
						<li><a href="../Account/login">로그인</a></li>
						<li><a href="../Account/join">회원가입</a></li>
					</ul>
				</nav>
			
				<nav id="member-menu" class="hr-menu">	
					<h1 class="hidden">고객 메뉴</h1>
					<ul>
						<li>
							<a href="">
								<img src="../images/txt-mypage.png" alt="마이페이지" />
							</a>
						</li>
						<li>
							<a href="">
								<img src="../images/txt-customer.png" alt="고객센터" />
							</a>
						</li>
					</ul>
				</nav>
			</section>
		</div>	
	</header>
	
<!-- -------------visul------------------------------------------------------------- -->
	
	<div id="visual">
		<div class="content-container">
			
						
		</div>	
	</div>
	
<!-- ------------body-------------------------------------------------------------- -->	
	
	<div id="body">
		<div class="content-container clearfix">
			<aside id="aside">
						
				<h1 class="aside-title aside-main-title aside-margin">고객센터</h1>
							
				<nav>	
					<h1 class="hidden">고객센터 메뉴</h1>
					<ul class="margin">
						<li class="aside-menu-item"><a class="aside-menu-item-link" href="">공지사항</a></li>
						<li class="aside-menu-item"><a class="aside-menu-item-link" href="">1:1고객문의</a></li>
						<li class="aside-menu-item"><a class="aside-menu-item-link" href="">학습안내</a></li>
					</ul>
				</nav>
			
				<nav>
					<h1 class="aside-title">추천사이트</h1>
					<ul class="margin">
						<li>
							<a href="">
								<img src="../images/answeris.png" alt="앤서이즈" />
							</a>
						</li>
						<li>
							<a href="">
								<img src="../images/w3c.png" alt="W3C" />
							</a>
						</li>
						<li>
							<a href="">
								<img src="../images/microsoft.png" alt="마이크로소프트" />
							</a>
						</li>
					</ul>
				</nav>
				
				<nav>
					<h1 class="aside-title">구글광고</h1>
				</nav>
			</aside>
		
		
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
			                     <option value="TITLE" <%if(field.equals("TITLE")){%>selected<%} %>>제목</option>
			                     <option value="CONTENT" <%if(field.equals("CONTENT")){%>selected<%} %>>내용</option>                     
			                  </select>
			                  <label class="hidden">검색어</label>
			                  <input name="q" type="text" value="<%=query%>" placeholder="검색어를 입력하세요"/>
			                  <input  class="btn btn-search"type="submit" value="검색"/>
			                  <input name="p" type="hidden" value="1" />
			               </fieldset>               
			            </form>
				</div>
			
				<div class="notice margin">
	               <h3>공지목록[<%=size %>]</h3>
	               
	               <script type="text/javascript">
	               
		                window.addEventListener("load", function(e) {
		               		
		               		/* var notices=[
		               			{code:"1",title:"ddddd"},
		               			{code:"2",title:"eeeee"},
		               			{code:"3",title:"fffff"}
		               			]; */  
		               			
		               		var regButton = document.querySelector("#reg-button")
		               			
		               		var moreBtn = document.querySelector("#more-button");
		               		
							/*var a = function(){};
							moreBtn.addEventListener("click",a);
							moreBtn.removeEventListener("click",a); */

		               		moreBtn.onclick = function(){
		               	
		               		//eval("var x =8+4;");
		               		
		               		//var data=eval('[{code:"1",title:"dd44ddd"},{code:"2",title:"eee334ee"},{code:"3",title:"fff343ff"}];');
		               		//var data = JSON.parse('[{"code":"1","title":"오오오오오오"},{"code":"2","title":"요요요요요요"},{"code":"3","title":"유유유유유유"}]');
		               		//alert(data[1].title);
		               			
		               			
		               			
		               		//var request = new ActiveXObject("Microsoft.XMLHTTP");
				               	
				               	var request = new window.XMLHttpRequest();
				               	request.open("GET","ajax-data.jsp?p=3",true);
				               	//request.onreadystatechange = function(){
				               	request.onload = function(){
				               		//if(request.readyState==4){
					               		var notices = JSON.parse(request.responseText);			               	
							              
				               			
				               			var template = document.querySelector("#notice-row");
				               			
				               			for(var i in notices){
						               		var tbody = document.querySelector(".notice-table tbody");		               		
						               		var tds = template.content.querySelectorAll("td");
						               		
						               		tds[0].innerText = notices[i].code;
						               		tds[1].innerText = notices[i].title;
						               		
						               		var clone = document.importNode(template.content, true);
					               			tbody.appendChild(clone);
				               		    
			               				};
			               				
			               				document.body.removeChild(screen);
			               				
			               			//};
				               		
				               	};
				               	
				               	request.send();	               	
				               	
				               	var screen = document.createElement("div");
				               	screen.style.width="100%";
				               	screen.style.height="100%";
				               	screen.style.position="fixed";
				               	screen.style.left="0px";
				               	screen.style.top="0px";
				               	screen.style.background="#000";
				               	screen.style.opacity="0.5";				               			               	
				               	
				               	document.body.appendChild(screen);
				               
		               		};
		               		
		               		regButton.onclick = function(){
		               			
		               			
		               			var request = new window.XMLHttpRequest();
				               	request.open("GET","notice-reg-partial.jsp",true);				               	
				               	request.onload = function(){
				               		

				               		var screen = document.createElement("div");
					               	screen.style.width="100%";
					               	screen.style.height="100%";
					               	screen.style.position="fixed";
					               	screen.style.left="0px";
					               	screen.style.top="0px";
					               	screen.style.background="#000";
					               	screen.style.opacity="0.5";				               			               	
					               	
					               	document.body.appendChild(screen);
					               	
           		
					               	var formScreen = document.createElement("div");
					               	formScreen.style.width="100%";
					               	formScreen.style.height="100%";
					               	formScreen.style.position="fixed";
					               	formScreen.style.left="0px";
					               	formScreen.style.top="0px";					               					               			               	
					               	
					               	document.body.appendChild(formScreen);
					               	
				               		var formText = request.responseText;
				               		formScreen.innerHTML = formText;
				               		
				               		var form = formScreen.querySelector("form");
				               		form.style.background = "#fff";
				               		form.style.width ="581px";
				               		form.style.marginLeft="auto";
				               		form.style.marginRight="auto";
				               		form.style.position = "relative";
				               		form.style.top="50%";
				               		form.style.transform = "translateY(-50%)";
				               		
				               		
				               		var script = formScreen.querySelector("script");
				               		eval(script.textContent);
				               		
				               		
				               	};
				               	
				               	request.send();
		               			
		               			return false;
		               		
		               		
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
	                  <% for(NoticeView v : list){ %>
	                     <tr>
	                        <td><%=v.getCode() %></td>
	                        <td><%=v.getTitle() %></td>
	                        <td><%=v.getWriter() %></td>
	                        <td><%=v.getRegDate() %></td>
	                        <td><%=v.getHit() %></td>
	                     </tr>	
	                   <% } %>                     
	                  </tbody>
	               </table>
           		</div>
				
				<%
					int last = (size%10)>0 ? (size/10)+1 : size/10;					
				%>
				<div class="margin"><%=pg %>/<%=last %> pages</div>				
				<div class="margin">
	            <div>
	               <a href="">이전</a>
	            </div>
	            <ul>
	               <% for(int i=1;i<=last;i++){ %>
	               <li><a href="?p=<%=i %>&f=<%=field%>&q=<%=query%>"><%=i %></a></li>
	               <%} %>
	            </ul>
	            <div>
	               <a href="">다음</a>
	            </div>
	         </div>	
			<div>
				<a id="reg-button" href="">글쓰기</a>
				<span id="more-button">더보기</span>
			</div>


		
			</main>
		</div>
	</div>	
	
<!-- ----------footer---------------------------------------------------------------- -->
	
	<footer id="footer">
		<div class="content-container ">
			<h2>
				<img src="../images/logo-footer.png" alt="회사정보" />
			</h2>
			<div>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
				Contact admin@newlecture.com for more information</div>
		</div>		
	</footer>
	
</body>
</html>