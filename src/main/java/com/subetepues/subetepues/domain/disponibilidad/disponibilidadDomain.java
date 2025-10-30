package com.subetepues.subetepues.domain.disponibilidad;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "disponibilidad")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class disponibilidadDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_disponibilidad", updatable = false, nullable = false)
    private UUID idDisponibilidad;

    @Column(name = "nombre")
    private String nombre;

}
