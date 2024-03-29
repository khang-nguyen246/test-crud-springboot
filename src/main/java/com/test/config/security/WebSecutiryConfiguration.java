package com.test.config.security; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; 
import
org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter; 
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; 
import org.springframework.stereotype.Component;

import com.test.service.IAccountService; 
@Component 
@EnableWebSecurity 
public class WebSecutiryConfiguration extends WebSecurityConfigurerAdapter { 
@Autowired 
private IAccountService accountService; 
@Override 
protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
auth.userDetailsService(accountService).passwordEncoder(new BCryptPasswordEncoder()); 
} 
@Override 
protected void configure(HttpSecurity http) throws Exception { 
http 
 .cors()
.and()
.authorizeRequests()
.antMatchers("/api/v1/accounts").hasAnyAuthority("Admin","Manager")
.antMatchers("/api/v1/accounts/*").hasAnyAuthority("Admin","Manager")
.anyRequest().authenticated()
.and()
.httpBasic()
.and()
.csrf().disable();} 
}
