package com.subetepues.subetepues.repository.usuario;

import com.subetepues.subetepues.domain.usuario.usuarioDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<usuarioDomain, UUID> {
    Optional<usuarioDomain> findByCorreo(String correo);
}

