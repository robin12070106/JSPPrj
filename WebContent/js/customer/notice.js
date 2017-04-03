	
	window.addEventListener("load",function(){
		
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
	});