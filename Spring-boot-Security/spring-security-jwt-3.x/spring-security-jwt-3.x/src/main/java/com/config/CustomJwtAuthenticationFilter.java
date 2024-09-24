package com.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import java.io.IOException;
@Component
public class CustomJwtAuthenticationFilter extends GenericFilterBean {

	@Autowired
	private JwtUtil jwtTokenUtil;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI();

        // Skip JWT validation for specific paths
        if (path.startsWith("/auth/")) {
            chain.doFilter(request, response);
            return;
        }

        // Your JWT processing logic
        String token = httpRequest.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7); // Remove "Bearer " prefix
            if (!token.isEmpty()) {
                try {
               
                	if (jwtTokenUtil.validateToken(token)) {
        				UserDetails userDetails = new User(jwtTokenUtil.getEmailIdFromToken(token), "",jwtTokenUtil.getRolesFromToken(token));
        
        				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
        						userDetails, null, userDetails.getAuthorities());
        				
        				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        			} 
                } catch (Exception e) {
                    SecurityContextHolder.clearContext();
                    httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid JWT Token");
                    return;
                }
            }
        }

        chain.doFilter(request, response);
    }
}

