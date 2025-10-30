package com.subetepues.subetepues.domain.vehiculo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "transmision")
public class TransmisionDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transmision", updatable = false, nullable = false)
    private UUID idTransmision;

    @Column(nullable = false, unique = true)
    private String tipo; // "Automático" o "Manual"

    public TransmisionDomain() {}
    public TransmisionDomain(String tipo) { this.tipo = tipo; }

    public UUID getIdTransmision() { return idTransmision; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
