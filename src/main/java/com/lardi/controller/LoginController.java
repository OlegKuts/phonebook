package com.lardi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
public class LoginController extends WebMvcConfigurerAdapter {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}

	@Configuration
	@EnableWebSecurity
	protected static class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private DataSource dataSource;

		@Autowired
		private MyAuthenticationSuccessHandler authenticationSuccessHandler;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login")
					.successHandler(authenticationSuccessHandler).failureUrl("/login?error").permitAll().and().logout()
					.permitAll();
			http.csrf().disable();

		}

		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(dataSource)
					.usersByUsernameQuery("select login, password, enabled from users where login=?")
					.authoritiesByUsernameQuery("select login, 'ROLE_USER' from users where login=?");
		}

	}

	@Component
	protected static class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

		private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

		@Override
		public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
				HttpServletResponse httpServletResponse, Authentication authentication)
						throws IOException, ServletException {
			redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, "/notes");

		}
	}

}
