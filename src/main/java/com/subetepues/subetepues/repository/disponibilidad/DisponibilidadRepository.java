package com.subetepues.subetepues.repository.disponibilidad;

import com.subetepues.subetepues.domain.disponibilidad.disponibilidadDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface DisponibilidadRepository extends JpaRepository<disponibilidadDomain, UUID> {

}
