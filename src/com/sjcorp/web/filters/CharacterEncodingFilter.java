package com.sjcorp.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//사전작업
		request.setCharacterEncoding("UTF-8");
		
		//기준
		chain.doFilter(request, response);
		
		//사후작업
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
