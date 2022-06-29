package com.idat.EC2.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("Sofia").password(encriptado().encode("123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("Marlon").password(encriptado().encode("456")).roles("USUARIO");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/productos/v1/**").access("hasRole('ADMIN')")
		.antMatchers("/bodega/v1/**").access("hasRole('ADMIN')")
		.antMatchers("/cliente/v1/**").access("hasRole('ADMIN')")
		.antMatchers("/usuario/v1/**").access("hasRole('ADMIN')")
		.antMatchers("/usuario/v1/listar").access("hasRole('USUARIO')")
		.antMatchers("/productos/v1/listar").access("hasRole('USUARIO')")
		.antMatchers("/bodega/v1/listar").access("hasRole('USUARIO')")
		.antMatchers("/cliente/v1/listar").access("hasRole('USUARIO')")
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
	
	@Bean
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}
}
