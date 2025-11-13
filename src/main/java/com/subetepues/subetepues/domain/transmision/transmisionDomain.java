package com.subetepues.subetepues.domain.transmision;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "transmision")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class transmisionDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transmision", updatable = false, nullable = false)
    private UUID idTransmision;

    @Column(name = "nombre")
    private String nombre;
}
