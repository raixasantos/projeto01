package com.imd0409.vacinacaobovino.config;

import com.imd0409.vacinacaobovino.security.JwtAuthFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.imd0409.vacinacaobovino.security.JwtService;
import com.imd0409.vacinacaobovino.service.impl.PessoaServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private JwtService jwtService;

    @Autowired
    private PessoaServiceImpl pessoaService;

    @Bean
    public OncePerRequestFilter jwtFilter(){
        return new JwtAuthFilter(jwtService, pessoaService);
    }

    @Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
            .csrf().disable()
			.authorizeHttpRequests((authz) -> {
                try {
                    authz
						.antMatchers(HttpMethod.POST, "/pessoa/**")
							.permitAll()         
                        .antMatchers(HttpMethod.POST, "/bovino/**")
                            .hasRole("PROPRIETARIO")
                        .antMatchers(HttpMethod.POST, "/carteira/**")
                            .hasAnyRole("GESTOR", "VETERINARIO")
                        .antMatchers(HttpMethod.POST, "/aplicacao/**")
                            .hasAnyRole("GESTOR", "VETERINARIO")
                        .antMatchers(HttpMethod.POST, "/fabricante/**")
                            .hasAnyRole("GESTOR", "VETERINARIO")
                        .antMatchers(HttpMethod.POST, "/vacina/**")
                            .hasAnyRole("GESTOR", "VETERINARIO") 
                        .antMatchers(HttpMethod.GET, "/v3/api-docs/**")
                            .permitAll()
                        .antMatchers(HttpMethod.GET, "/api-docs/**")
                            .permitAll()
                        .antMatchers(HttpMethod.GET, "/swagger-ui/**")
                            .permitAll() 
                        .anyRequest().authenticated()    
                    .and() 
                        .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                        .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

		return http.build();
	}

}
