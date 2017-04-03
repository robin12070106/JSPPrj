import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjcorp.web.dao.MemberDao;
import com.sjcorp.web.dao.mysql.MYSQLMemberDao;
import com.sjcorp.web.entity.Member;


public class Nana extends HttpServlet {

   public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
      
	   
/*	  response.setContentType("image/png");
	   
	  String url = "images/photo/visual2.png";
	  ServletContext context = request.getServletContext();
	  String path = context.getRealPath(url);
	  
	  BufferedImage image = ImageIO.read(new File(path));
	  
	  OutputStream os = response.getOutputStream();
	  ImageIO.write(image, "png",os);*/
	   
	   
	  
	  response.setCharacterEncoding("UTF-8");
	  response.setContentType("text/html;charset=UTF-8");
	  
	   
      /*OutputStream os = response.getOutputStream();
      PrintStream out = new PrintStream(os);*/
      
      PrintWriter out = response.getWriter();
      // Out/InputStream : byte - 영어이용자, Writer/Reader : char - 영어외 이용자
      
      
      MemberDao memberDao = new MYSQLMemberDao();
		 
      List<Member> list = memberDao.getList();
		 
      for(Member m : list) 
    	  out.printf("%s	%s	<span style='color:blue'>%s</span>	%s	%s	%s	%d	%s	%s	%s	%s	%s	%s	%s<br/> ",m.getId(),m.getName(),m.getPwd(),m.getNicName(),m.getGender(),m.getBirthday(),m.getIsLunar(),m.getPhone(),m.getEmail(),m.getZipCode(),m.getAddress(),m.getAddressDetail(),m.getRegDate(),m.getLastLoginTime());

   }

}