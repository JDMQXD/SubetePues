package com.subetepues.subetepues.services.vehiculo;


import com.subetepues.subetepues.domain.vehiculo.vehiculoDomain;
import com.subetepues.subetepues.repository.vehiculo.vehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class vehiculoServices {

    private vehiculoRepository vehiculoRepository;
    @Autowired
    public vehiculoServices(vehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<vehiculoDomain> getAllVehiculo() {
        return vehiculoRepository.findAll();
    }

    public Optional<vehiculoDomain> getVehiculoById(UUID id) {
        return vehiculoRepository.findById(id);
    }

    public vehiculoDomain saveVehiculo(vehiculoDomain vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
    public void deleteVehiculo(UUID id) {
        vehiculoRepository.deleteById(id);
    }

    public vehiculoDomain updateVehiculo(UUID id, vehiculoDomain updatedVehiculo) {
        return vehiculoRepository.findById(id)
                .map(vehiculo -> {

                    vehiculo.setModelo(updatedVehiculo.getModelo());
                    vehiculo.setMarca(updatedVehiculo.getMarca());
                    vehiculo.setEspecificacion(updatedVehiculo.getEspecificacion());
                    vehiculo.setEstadoDeCuenta(updatedVehiculo.getEstadoDeCuenta());
                    vehiculo.setFechaRegistro(updatedVehiculo.getFechaRegistro());


                    vehiculo.setTransmision(updatedVehiculo.getTransmision());
                    vehiculo.setUbicacion(updatedVehiculo.getUbicacion());
                    vehiculo.setUsuario(updatedVehiculo.getUsuario());
                    vehiculo.setTipoVehiculo(updatedVehiculo.getTipoVehiculo());
                    vehiculo.setDisponibilidad(updatedVehiculo.getDisponibilidad());


                    return vehiculoRepository.save(vehiculo);
                })
                .orElseThrow(() -> new RuntimeException("Vehículo no encontrado con id: " + id));
    }

}
