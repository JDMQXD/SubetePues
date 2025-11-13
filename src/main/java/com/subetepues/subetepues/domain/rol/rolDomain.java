package com.subetepues.subetepues.domain.rol;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "rol")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class rolDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Rol", updatable = false, nullable = false)
    private UUID idRol;

    @Column(name = "nombre")
    private String nombre;
}
