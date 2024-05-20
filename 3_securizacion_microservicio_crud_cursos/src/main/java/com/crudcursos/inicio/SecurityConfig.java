package com.crudcursos.inicio;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	InMemoryUserDetailsManager userDetails() throws Exception {
		List<UserDetails> users = List.of(User.withUsername("user1").password("{noop}user1").roles("Invitado").build(),
				User.withUsername("user2").password("{noop}user2").roles("Operador").build(),
				User.withUsername("user3").password("{noop}user3").roles("Admin").build(),
				User.withUsername("user4").password("{noop}user4").roles("Operador", "Admin").build());
		return new InMemoryUserDetailsManager(users);
	}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(cr -> cr.disable())
				.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "curso").hasAnyRole("Admin")
						.requestMatchers(HttpMethod.DELETE, "curso/**").hasAnyRole("Admin", "Operador")
						.requestMatchers(HttpMethod.PUT, "curso/**").hasAnyRole("Admin", "Operador")
						.requestMatchers(HttpMethod.GET, "/cursos", "/curso/**").authenticated().anyRequest().denyAll())
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
