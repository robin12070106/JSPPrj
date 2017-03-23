package com.sjcopr.web.controller.cutomer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sjcorp.web.dao.NoticeDao;
import com.sjcorp.web.dao.NoticeFileDao;
import com.sjcorp.web.dao.mysql.MYSQLNoticeDao;
import com.sjcorp.web.dao.mysql.MYSQLNoticeFileDao;
import com.sjcorp.web.entity.NoticeFile;



@WebServlet("/customer/notice-reg-proc")
public class NoticeRegProcController extends HttpServlet{

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			PrintWriter out = response.getWriter();
			
			ServletContext ctx = request.getServletContext();
			String path = ctx.getRealPath("/customer/upload");
			out.println(path);

			File d = new File(path);
			if(!d.exists())//경로가 존재하지 않는다면
				d.mkdirs();
			
			MultipartRequest req = new MultipartRequest(request
			, path
			, 1024*1024*10
			, "UTF-8"
			, new DefaultFileRenamePolicy());
			
			String title = req.getParameter("title");
			String content = req.getParameter("content");	
			
			out.println("<br/>"+title);
			out.println("<br/>"+content);
			
			NoticeDao noticeDao = new MYSQLNoticeDao();
			
			int result = noticeDao.add(title, content, "ROBIN");	
			String noticeCode = noticeDao.lastCode();//방금 등록한 그 녀석의 번호를 가져오는것  - 동시에 넣는 타인을 막기위한 트렌섹션(락)처리가 필요 - spring 배울 때 할거다 지금은 못함
			
			NoticeFileDao noticeFileDao = new MYSQLNoticeFileDao();
			
			Enumeration fnames = req.getFileNames();
			
			
			while(fnames.hasMoreElements()){
				
				String f = (String)fnames.nextElement();
				String fname = req.getFilesystemName(f);
				
				NoticeFile file= new NoticeFile();
				file.setNoticeCode(noticeCode);
				file.setSrc(fname);		
				noticeFileDao.add(file);
				
				
				out.println("<br/>"+f);
				out.println("<br/>"+fname);
			};
				

			if(result>0)
				response.sendRedirect("notice"); 	
			
			
		}
}
