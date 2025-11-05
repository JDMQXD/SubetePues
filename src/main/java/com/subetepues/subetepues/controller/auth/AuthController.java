package com.subetepues.subetepues.controller.auth;

import com.subetepues.subetepues.domain.usuario.usuarioDomain;
import com.subetepues.subetepues.repository.usuario.UsuarioRepository;
import com.subetepues.subetepues.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*") // para que funcione con el frontend
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody Map<String, String> body) {
        String correo = body.get("correo");
        String password = body.get("password");

        usuarioDomain usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!passwordEncoder.matches(password, usuario.getPassword())) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        String rolNombre = usuario.getRol().getNombre();

        String token = jwtUtil.generarToken(usuario.getCorreo(), rolNombre.toUpperCase());

        return Map.of(
                "token", token,
                "usuario", Map.of(
                        "idUsuario", usuario.getIdUsuario(),
                        "nombre", usuario.getNombre(),
                        "correo", usuario.getCorreo(),
                        "rol", usuario.getRol().getNombre()
                ),
                "correo", usuario.getCorreo(),
                "rol", rolNombre
        );
    }


    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody usuarioDomain usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuario registrado correctamente");
    }
}
