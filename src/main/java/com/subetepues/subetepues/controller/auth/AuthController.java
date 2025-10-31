package com.subetepues.subetepues.controller.auth;

import com.subetepues.subetepues.domain.usuario.InicioSesionDomain;
import com.subetepues.subetepues.repository.usuario.UsuarioRepository;
import com.subetepues.subetepues.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // para que funcione con el frontend
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String password = body.get("password");

        InicioSesionDomain usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String token = jwtUtil.generateToken(correo);
        return Map.of(
                "token", token,
                "correo", usuario.getCorreo()
        );
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody InicioSesionDomain usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}
