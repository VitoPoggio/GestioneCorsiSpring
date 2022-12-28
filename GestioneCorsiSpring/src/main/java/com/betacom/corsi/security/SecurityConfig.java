package com.betacom.corsi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.betacom.corsi.repository.AdminRepository;

@Configuration
public class SecurityConfig {
	private AdminRepository adminRepository;
 
	@Autowired
	AdminDetailsService adminDetailsService;

	public SecurityConfig(AdminRepository adminRepository) {
		this.adminRepository = adminRepository;
	}

	 @Bean
	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		  http.authorizeRequests()
			  .antMatchers("/")
			  .permitAll()
			  .antMatchers("/admin/**")
			  .hasRole("ADMIN")
			  .and()
			  .formLogin()
			  .loginPage("/loginadmin")
			  .permitAll()
			  .and()
			  .logout()
			  .logoutRequestMatcher(new AntPathRequestMatcher("/logoutadmin"))
			  .logoutSuccessUrl("/admin/");
		  return http.build();
	 }
	
	 @Bean
	 public DaoAuthenticationProvider authenticationProvider() {
		  DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		  authProvider.setUserDetailsService(new AdminDetailsService(this.adminRepository));
		  authProvider.setPasswordEncoder(passwordEncoder());
		  return authProvider;
	 }
	
	 @Bean
	 public PasswordEncoder passwordEncoder() {
		 return new BCryptPasswordEncoder();
	 }
}