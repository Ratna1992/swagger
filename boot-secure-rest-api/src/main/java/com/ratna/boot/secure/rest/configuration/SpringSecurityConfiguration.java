package com.ratna.boot.secure.rest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("ratna").password("ratna").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dev").password("dev").roles("USER");
	}

	// security for all urls

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic();
	 * }
	 */

	// security for specific url
	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.csrf().disable();
	 * http.authorizeHttpRequests().antMatchers("/v1/api/employee/**").authenticated
	 * ().and().httpBasic(); }
	 */

	// security for specific url for specific role
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeHttpRequests().antMatchers("/v1/api/employee/**").hasAnyRole("ADMIN").anyRequest().authenticated()
				.and().httpBasic();
	}

	// not encoding password
	@Bean
	public static NoOpPasswordEncoder getPasswordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
}
