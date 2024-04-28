package com.example.Spring.Security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
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
@EnableMethodSecurity
public class SpringSecurityConfig {

	@Bean
	public UserDetailsService userDetails(PasswordEncoder encoder) {
//		UserDetails ADMIN=User.withUsername("Kamal")
//				          .password(encoder.encode("Kamal"))
//				          .roles("Admin")
//				          .build();
//		
//		UserDetails user=User.withUsername("kannan")
//		          .password(encoder.encode("Kannan"))
//		          .roles("User")
//		          .build();
//		return new InMemoryUserDetailsManager(ADMIN,user);
		return new UserInfoUserDetailServices();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return  http.csrf().disable().authorizeHttpRequests().requestMatchers("/endpoint").permitAll()
				.and()
				.authorizeHttpRequests().requestMatchers("/welcome").authenticated()
				.and().formLogin()
                .and().build();
                }
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
