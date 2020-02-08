package com.needine.pbreferences.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
/*
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private DataSource dataSource;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		
		auth
        .inMemoryAuthentication()
        .withUser("user").password("$2y$12$AGlrynOJWebkvjfPk/PMIO6Vwq5.pNHv4hVHb7eOYrPavJLkgPSAG").roles("USER");
		
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {


		http
        .authorizeRequests()
           .antMatchers(HttpMethod.GET, "/").permitAll()
           .antMatchers(HttpMethod.POST, "/").permitAll()
           .antMatchers(HttpMethod.PUT, "/").permitAll()
           .antMatchers(HttpMethod.DELETE, "/").permitAll()

           //.anyRequest().authenticated()
           .and()
           .httpBasic()
		;

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
*/