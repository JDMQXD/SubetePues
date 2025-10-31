package com.subetepues.subetepues.repository.usuario;

import com.subetepues.subetepues.domain.usuario.InicioSesionDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<InicioSesionDomain, UUID> {
    Optional<InicioSesionDomain> findByCorreo(String correo);
}

