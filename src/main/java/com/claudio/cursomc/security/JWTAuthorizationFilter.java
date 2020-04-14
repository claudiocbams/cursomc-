package com.claudio.cursomc.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

	private JWTUtil jwtUtil;
	
	private UserDetailsService userDetailsService;
	
	public JWTAuthorizationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.userDetailsService = userDetailsService;
	}
	
	@Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {
		
		String header = request.getHeader("Authorization");//pega o valor do cabeçalho exemplo (Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjbGF1ZGlvY2JhbXRAZ21haWwuY29tIiwiZXhwIjoxNTg2ODgyMjA4fQ.0v9W_-GCUqtwbWPhNVNRljVAALJKOfBtEJlEq01ydMD7tWhVnQsiGKbH1jyR8HNU0VJDVv92GMAhH8Z81a3eqg )
		if (header != null && header.startsWith("Bearer ")) { //verifica se o cabeclho começa com bearer
			UsernamePasswordAuthenticationToken auth = getAuthentication(header.substring(7));// quantidade de string da palavrinha bearer
			if (auth != null) {
				SecurityContextHolder.getContext().setAuthentication(auth);//libera o autorização acesso no filtro
			}
		}
		chain.doFilter(request, response);//continua fazendo requisição se chegar até aqui
	}

	private UsernamePasswordAuthenticationToken getAuthentication(String token) {
		if (jwtUtil.tokenValido(token)) {
			String username = jwtUtil.getUsername(token);
			UserDetails user = userDetailsService.loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
		}
		return null;
	}
}
