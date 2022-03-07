package com.coforge.microservices.Customersservice.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;


@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.inMemoryAuthentication()
    		.withUser("mounika")
    		.password("12345")
    		.roles("user")
    		.and()
    		.withUser("Nekkalapu")
    		.password("7890")
    		.roles("admin");
    		
    }
  
    /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	System.out.println("Inside security roles");
    	http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("ADMIN", "USER")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }*/

    
    
    
    protected void configure(HttpSecurity http) throws Exception {

    	http
    	.httpBasic()
    	.and()
    	.authorizeRequests()
    	.antMatchers(HttpMethod.GET, "/CustomersAll/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/add").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/Transactions/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }


    
    
	/*
	 * @Bean public PasswordEncoder getPasswordEncoder() { return
	 * NoOpPasswordEncoder.getInstance(); }
	 */
}
