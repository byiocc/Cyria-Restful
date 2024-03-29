package com.kunteng.cyria.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class GoAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		response.setHeader("Content-Type", "application/json;charset=utf-8");
        response.getWriter().print("{\"code\":401,\"message\":\""+"未认证："+accessDeniedException.getMessage()+"\"}");
        response.getWriter().flush();
	}

}
