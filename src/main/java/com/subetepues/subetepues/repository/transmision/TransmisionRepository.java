package com.subetepues.subetepues.repository.transmision;

import com.subetepues.subetepues.domain.transmision.transmisionDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransmisionRepository extends JpaRepository<transmisionDomain, UUID> {
}
