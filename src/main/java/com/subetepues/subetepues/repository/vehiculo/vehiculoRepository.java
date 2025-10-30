package com.subetepues.subetepues.repository.vehiculo;


import com.subetepues.subetepues.domain.vehiculo.vehiculoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface vehiculoRepository extends JpaRepository<vehiculoDomain,UUID>{
}
