package com.subetepues.subetepues.repository.reserva;

import com.subetepues.subetepues.domain.reserva.reservaDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface reservaRepository extends JpaRepository<reservaDomain, UUID> {
}
