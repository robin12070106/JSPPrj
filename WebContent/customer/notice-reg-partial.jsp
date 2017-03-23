<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <script>
    	
    	var f = function(){
    	
    		var regButton = document.querySelector(".reg-button");
    		
    		regButton.onclick = function(){
    			
    			var form = document.querySelector("#form");
    			var formData = new FormData(form);
    			var request = new window.XMLHttpRequest();
    			
    			var progressBar = document.querySelector("progress");
                request.onprogress = function(e){
                   progressBar.value = parseInt((e.loaded/e.total)*100);
                };
               	
				request.onload = function(){
               		               		
               		
               	};
    			
               	request.open("POST","notice-reg-ajax",true);
    			request.send(formData);
    			
               	               	
    			return false;
    			    			
    		};    		
    		
    	};
  		 
    	f();
    	
    </script>
    
    
	<form id="form" action="notice-reg-ajax" method="post" enctype="multipart/form-data">
	    <table border="1">
	       <tbody>
	          <tr>
	             <th>제목</th>
	             <td><input name="title" type="text" /></td>
	          </tr>
	          <tr>
	             <th>첨부파일<progress value="0" max="100"></progress></th>
	             <td><input name="file" type="file" /></td>
	          </tr>
	          <tr>              
	             <td colspan="2">
	                <textarea name="content" rows="20" cols="80"></textarea>
	             </td>
	          </tr>   
	       </tbody>
	    </table>
	    <div>      
	       <input class="reg-button" type="submit" value="등록" />         
	       <a href="ajax.jsp">취소</a>
	    </div>
  	</form> 