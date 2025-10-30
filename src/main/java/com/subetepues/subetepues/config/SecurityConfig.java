package com.subetepues.subetepues.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Desactiva CSRF (importante para Postman)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Permite TODO sin autenticación
                )
                .formLogin(form -> form.disable()) // Desactiva login
                .httpBasic(httpBasic -> httpBasic.disable()); // Desactiva autenticación básica
        return http.build();
    }
}
