package com.subetepues.subetepues.services.reserva;

import com.subetepues.subetepues.domain.reserva.reservaDomain;
import com.subetepues.subetepues.repository.reserva.reservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReservaServices {

    private reservaRepository reservaRepository;

    public ReservaServices(reservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public List<reservaDomain> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Optional<reservaDomain> getReservaById(UUID id) {
        return reservaRepository.findById(id);
    }

    public reservaDomain createReserva(reservaDomain reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteReserva(UUID id) {
        reservaRepository.deleteById(id);
    }

    public reservaDomain updateReserva(UUID id, reservaDomain updatedReserva) {
        return reservaRepository.findById(id)
                .map(reserva -> {
                    reserva.setFechaInicio(updatedReserva.getFechaInicio());
                    reserva.setFechaFin(updatedReserva.getFechaFin());
                    reserva.setLugarEntrega(updatedReserva.getLugarEntrega());
                    reserva.setUsuario(updatedReserva.getUsuario());
                    reserva.setVehiculo(updatedReserva.getVehiculo());
                    reserva.setServicio(updatedReserva.getServicio());
                    return reservaRepository.save(reserva);
                })
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }
}
