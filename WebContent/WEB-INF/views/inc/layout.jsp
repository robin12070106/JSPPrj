<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
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
	
	<tiles:insertAttribute name="header" />
	
<!-- -------------visual------------------------------------------------------------- -->
	
	<tiles:insertAttribute name="visual" />
	
<!-- ------------body-------------------------------------------------------------- -->	
	
	<div id="body">
		<div class="content-container clearfix">
		
		
		<!-- aside -->
		<tiles:insertAttribute name="aside" />
		
		<!-- main -->
		<tiles:insertAttribute name="main" />	
		
		</div>
	</div>	
	
<!-- ----------footer---------------------------------------------------------------- -->
	
	<tiles:insertAttribute name="footer" />	
	
</body>
</html>