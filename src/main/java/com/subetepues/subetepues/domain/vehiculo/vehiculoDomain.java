package com.subetepues.subetepues.domain.vehiculo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "vehiculo")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class vehiculoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_vehiculo", updatable = false, nullable = false)
    private UUID idVehiculo;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "especificacion")
    private String especificacion;

    @Column(name = "estadoDeCuenta")
    private String estadoDeCuenta;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;


}
