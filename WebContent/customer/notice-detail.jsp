<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
						<a href="notice.jsp?code=${n.code }">목록</a>		            	                        
		               <a href="notice-edit.jsp?code=${n.code }">수정</a>
		               <a href="notice-del-proc.jsp?code=${n.code }">삭제</a>
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