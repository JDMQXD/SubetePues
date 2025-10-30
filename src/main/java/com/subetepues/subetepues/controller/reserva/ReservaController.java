package com.subetepues.subetepues.controller.reserva;
import com.subetepues.subetepues.domain.reserva.reservaDomain;

import com.subetepues.subetepues.services.reserva.ReservaServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private ReservaServices reservaService;

    public ReservaController(ReservaServices reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/all")
    public List<reservaDomain> getAllReservas() {
        return reservaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<reservaDomain> getReservaById(@PathVariable UUID id) {
        return reservaService.getReservaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public reservaDomain createReserva(@RequestBody reservaDomain reserva) {
        return reservaService.createReserva(reserva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<reservaDomain> updateReserva(@PathVariable UUID id, @RequestBody reservaDomain reserva) {
        try {
            reservaDomain updated = reservaService.updateReserva(id, reserva);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable UUID id) {
        reservaService.deleteReserva(id);
        return ResponseEntity.noContent().build();
    }
}
