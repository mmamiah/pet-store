package com.mms.rbc.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Cross Origin Requests 
 */
@Component
public class PetStoreCorsFilter extends OncePerRequestFilter {
	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//		HttpServletResponse res = (HttpServletResponse) response;
//		res.setHeader("Access-Control-Allow-Origin", "*");
//		res.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
//		res.setHeader("Access-Control-Max-Age", "3600");
//		res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
//		res.setHeader("Access-Control-Expose-Headers", "Location");
//		chain.doFilter(request, res);


		String origin = request.getHeader("origin");
		origin = (origin == null || origin.equals("")) ? "null" : origin;
		response.addHeader("Access-Control-Allow-Origin", origin);
		response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, DELETE, OPTIONS");
		response.addHeader("Access-Control-Allow-Credentials", "true");
		response.addHeader("Access-Control-Allow-Headers", "Authorization, origin, content-type, accept, x-requested-with");
		filterChain.doFilter(request, response);
	}
	
	
	

	@Override
	public void destroy() {}
	
}
