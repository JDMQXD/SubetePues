package com.subetepues.subetepues.domain.servicio;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "servicio")

public class servicioDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_servicio", updatable = false, nullable = false)
    private UUID idServicio;

    @Column(name = "nombre")
    private String nombreServicio;

    @Column(name = "costo")
    private Double costo;
}
