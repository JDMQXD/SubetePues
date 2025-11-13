package com.subetepues.subetepues.domain.categoria;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "categoria")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class categoriaDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categoria", updatable = false, nullable = false)
    private UUID idCategoria;

    @Column(name = "nombre")
    private String nombre;
}
