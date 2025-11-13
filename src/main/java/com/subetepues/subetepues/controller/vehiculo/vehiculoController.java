package com.subetepues.subetepues.controller.vehiculo;


import com.subetepues.subetepues.domain.reserva.reservaDomain;
import com.subetepues.subetepues.domain.vehiculo.vehiculoDomain;
import com.subetepues.subetepues.security.JwtUtil;
import com.subetepues.subetepues.services.vehiculo.vehiculoServices;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
@RestController
@RequestMapping("/")
public class vehiculoController {

    private vehiculoServices vehiculoServices;
    private final JwtUtil jwtUtil;

    @Autowired
    public vehiculoController(vehiculoServices vehiculoServices, JwtUtil jwtUtil) {
        this.vehiculoServices = vehiculoServices;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("")
    public List<vehiculoDomain> getAllVehiculos(){
        return  vehiculoServices.getAllVehiculo();
    }

    @GetMapping("{id}")
    public ResponseEntity<vehiculoDomain> getVehiculoById(@PathVariable UUID id){
        return vehiculoServices.getVehiculoById(id)
                .map(ResponseEntity ::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("propietario/crear")
    public vehiculoDomain saveVehiculo(@RequestBody vehiculoDomain vehiculo) {
        return vehiculoServices.saveVehiculo(vehiculo);
    }

    @PutMapping("propietario/update/{id}")
    public ResponseEntity<vehiculoDomain> updatevehiculo(@PathVariable UUID id, @RequestBody vehiculoDomain vehiculo) {
        try {
            vehiculoDomain updated = vehiculoServices.updateVehiculo(id, vehiculo);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("propietario/eliminar/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable UUID id) {
        vehiculoServices.deleteVehiculo(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("propietario/vehiculos")
    public ResponseEntity<List<vehiculoDomain>> getVehiculosByPropietario(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(401).build();
        }

        String token = authHeader.substring(7);
        String correo = jwtUtil.obtenerUsername(token); // obtienes el correo o username del JWT

        List<vehiculoDomain> vehiculos = vehiculoServices.getVehiculosByPropietario(correo);
        return ResponseEntity.ok(vehiculos);
    }


}
