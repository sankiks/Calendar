package com.example.Calendar.WebSecurity;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((requests) -> requests
				.requestMatchers( "api/v1/Calendar").permitAll()
				.anyRequest().authenticated()
			)
			.formLogin((form) -> form
				
				.permitAll() //permitAll() changed to disable() to sent post requests
			)
			.logout((logout) -> logout.permitAll());

		return http.build();
	}
	@Bean
 	public UserDetailsService userDetailsService() {
 		UserDetails user = User.builder()
 			.username("user")
 			.password(encoder().encode("password"))
 			.roles("USER")
 			.build();
 		UserDetails admin = User.builder()
 			.username("admin")
 			.password(encoder().encode("password"))
 			.roles("ADMIN", "MANAGER")
 			.build();
 		return new InMemoryUserDetailsManager(user, admin);
 	}
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder();
	}

	

}



