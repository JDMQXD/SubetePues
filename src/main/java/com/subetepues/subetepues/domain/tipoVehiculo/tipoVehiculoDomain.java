package com.subetepues.subetepues.domain.tipoVehiculo;


import com.subetepues.subetepues.domain.categoria.categoriaDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tipoVehiculo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class tipoVehiculoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipoVehiculo", updatable = false, nullable = false)
    private UUID idTipoVehiculo;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idCategoria")
    private categoriaDomain categoria;


}
