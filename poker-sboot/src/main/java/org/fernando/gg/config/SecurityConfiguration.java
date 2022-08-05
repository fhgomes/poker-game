package org.fernando.gg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsUtils;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests((auth) -> auth
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
				.antMatchers("/api/public/**").permitAll()
				.antMatchers("/", "/login**", "/webjars/**").permitAll()
				.antMatchers("/management/health").permitAll()
				.antMatchers("/v2/api-docs/**").permitAll()
				.antMatchers("/swagger-resources/**").permitAll()
				.antMatchers("/swagger-ui.html/**").permitAll()
				.antMatchers("/actuator/**").permitAll()
				.anyRequest().authenticated()
			)
			.cors()
			.and()
			.csrf(CsrfConfigurer::disable) //disable csrf since we are not using cookies
			.httpBasic()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		return http.build();
    }

}