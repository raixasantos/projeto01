package com.imd0409.vacinacaobovino.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.imd0409.vacinacaobovino.service.impl.PessoaServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthFilter extends OncePerRequestFilter {
    private JwtService jwtService;
    private PessoaServiceImpl pessoaService;

    public JwtAuthFilter( JwtService jwtService, PessoaServiceImpl pessoaService ) {
        this.jwtService = jwtService;
        this.pessoaService = pessoaService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain) throws ServletException, IOException {

        String authorization = httpServletRequest.getHeader("Authorization");

        if( authorization != null && authorization.startsWith("Bearer")){
            String token = authorization.split(" ")[1];
            boolean isValid = jwtService.tokenValido(token);
            
            if(isValid){
                String loginPessoa = jwtService.obterLoginPessoa(token);
                UserDetails pessoa = pessoaService.loadUserById(Integer.parseInt(loginPessoa));
                UsernamePasswordAuthenticationToken user = new
                        UsernamePasswordAuthenticationToken(pessoa,null,
                        pessoa.getAuthorities());
                user.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(user);
            }
        }
        
        filterChain.doFilter(httpServletRequest, httpServletResponse);

    }
}
