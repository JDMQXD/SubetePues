package com.subetepues.subetepues.domain.servicio;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "servicio")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ServicioDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_servicio", updatable = false, nullable = false)
    private UUID idServicio;

    @Column(name = "nombre")
    private String nombreServicio;

    @Column(name = "costo")
    private Double costo;
}
