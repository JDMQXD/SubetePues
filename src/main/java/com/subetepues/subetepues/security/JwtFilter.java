package com.subetepues.subetepues.security;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            if (jwtUtil.validarToken(token)) {
                String username = jwtUtil.obtenerUsername(token);
                String role = jwtUtil.obtenerRole(token);

                if (role != null) {
                    role = role.trim().replace("\"", "");
                }

                System.out.println("Token recibido: " + token);
                System.out.println("Usuario: " + username);
                System.out.println("Rol en token: " + role);

                // Spring espera las autoridades con el prefijo ROLE_
                if (!role.startsWith("ROLE_")) {
                    role = "ROLE_" + role;
                }

                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(
                                username,
                                null,
                                List.of(new SimpleGrantedAuthority(role))
                        );

                SecurityContextHolder.getContext().setAuthentication(authentication);

                System.out.println("Context authorities: " +
                        SecurityContextHolder.getContext().getAuthentication().getAuthorities());
            }
        }

        filterChain.doFilter(request, response);
    }

}


