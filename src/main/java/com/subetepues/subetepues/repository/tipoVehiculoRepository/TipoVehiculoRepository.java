package com.subetepues.subetepues.repository.tipoVehiculoRepository;

import com.subetepues.subetepues.domain.tipoVehiculo.tipoVehiculoDomain;
import com.subetepues.subetepues.domain.usuario.usuarioDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoVehiculoRepository extends JpaRepository<tipoVehiculoDomain, UUID> {
}
