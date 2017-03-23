<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! %>    
<% 
		String _x = request.getParameter("x");
		String _y = request.getParameter("y");
		
		/*int x = Integer.parseInt(_x);
		int y = Integer.parseInt(_y);*/
		
		int x=0;
		int y=0;
		
		if(_x!=null && !_x.equals(""))
			x = Integer.parseInt(_x);
		if(_y!=null && !_y.equals(""))
			y = Integer.parseInt(_y);

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JASPER</title>

</head>
<body>
	<form>  <!-- action="calc"  method="post"-->
		<p>
			<label>x:</label>
				<input name = "x" id="txt-x" />
			<label>y:</label>
				<input name = "y" id="txt-y" />
		</p>
		<p>
			sum = <input name = "sum" id="txt-sum" value="<%out.print(x+y);%>"/>
		</p>
		<p>
			<input id="btn-sum" type="submit" value="결과" />
		</p>
	</form>
	
</body>
</html>