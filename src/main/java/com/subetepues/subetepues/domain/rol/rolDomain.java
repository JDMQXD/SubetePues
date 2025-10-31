package com.subetepues.subetepues.domain.rol;


import jakarta.persistence.*;

import java.util.UUID;

@Table(name = "rol")
@Entity
public class rolDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Rol", updatable = false, nullable = false)
    private UUID idRol;

    @Column(name = "nombre")
    private String nombre;
}
