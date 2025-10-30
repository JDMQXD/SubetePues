package com.subetepues.subetepues.controller.vehiculo;


import com.subetepues.subetepues.domain.reserva.reservaDomain;
import com.subetepues.subetepues.domain.vehiculo.vehiculoDomain;
import com.subetepues.subetepues.services.vehiculo.vehiculoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehiculos")
public class vehiculoController {

    private vehiculoServices vehiculoServices;

    @Autowired
    public vehiculoController(vehiculoServices vehiculoServices) {
        this.vehiculoServices = vehiculoServices;
    }

    @GetMapping("/all")
    public List<vehiculoDomain> getAllVehiculos(){
        return  vehiculoServices.getAllVehiculo();
    }

    @GetMapping("{id}")
    public ResponseEntity<vehiculoDomain> getVehiculoById(@PathVariable UUID id){
        return vehiculoServices.getVehiculoById(id)
                .map(ResponseEntity ::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public vehiculoDomain saveVehiculo(@RequestBody vehiculoDomain vehiculo) {
        return vehiculoServices.saveVehiculo(vehiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<vehiculoDomain> updatevehiculo(@PathVariable UUID id, @RequestBody vehiculoDomain vehiculo) {
        try {
            vehiculoDomain updated = vehiculoServices.updateVehiculo(id, vehiculo);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable UUID id) {
        vehiculoServices.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }

}
