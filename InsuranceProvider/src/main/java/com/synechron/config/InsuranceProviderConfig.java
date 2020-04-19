package com.synechron.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class InsuranceProviderConfig extends WebSecurityConfigurerAdapter{
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication()
	  .withUser("pallavi").password("{noop}bachute").roles("USER") .and()
	  .withUser("admin").password("{noop}admin123").roles("USER", "ADMIN"); }
	 
    
	  protected void configure(HttpSecurity http) throws Exception {
	  http.httpBasic().and().authorizeRequests()
	  .antMatchers(HttpMethod.GET,"/plans").hasAnyRole("USER","ADMIN")
	  .antMatchers(HttpMethod.POST,"/plans").hasRole("ADMIN")
	  .antMatchers(HttpMethod.DELETE,"/plans/**").hasRole("ADMIN")
	  .antMatchers(HttpMethod.PUT,"/plans/**").hasRole("ADMIN") .and()
	  .csrf().disable().headers().frameOptions().disable(); }
	 
    

    

}
