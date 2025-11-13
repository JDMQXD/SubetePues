package com.subetepues.subetepues.domain.ciudad;


import com.subetepues.subetepues.domain.departamento.departamentoDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Table(name = "ciudad")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ciudadDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ciudad", updatable = false, nullable = false)
    private UUID idCiudad;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private departamentoDomain departamento;

}
