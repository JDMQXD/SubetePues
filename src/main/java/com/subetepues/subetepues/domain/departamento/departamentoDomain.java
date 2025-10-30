package com.subetepues.subetepues.domain.departamento;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
;

import java.util.UUID;

@Table(name = "departamento")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class departamentoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_departamento", updatable = false, nullable = false)
    private UUID idDpartamento;

    @Column(name = "nombre")
    private String nombre;
}
