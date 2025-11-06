package com.subetepues.subetepues.repository.servicio;

import com.subetepues.subetepues.domain.servicio.ServicioDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicioRepository extends JpaRepository<ServicioDomain, UUID> {
}
