package com.config;

import java.io.IOException;


import jakarta.servlet.http.*;


import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;



@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException {
		
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
	}


}
