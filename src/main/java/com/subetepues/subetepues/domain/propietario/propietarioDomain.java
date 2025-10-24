package com.subetepues.subetepues.domain.propietario;


import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "propietario")
@Entity


public class propietarioDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_propietario", updatable = false, nullable = false)
    private UUID idpropietario;

    @Column(name = "nombre")
    private String nombre;

}
