package com.subetepues.subetepues.repository.ciudad;

import com.subetepues.subetepues.domain.ciudad.ciudadDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CiudadRepository extends JpaRepository<ciudadDomain, UUID> {
}
