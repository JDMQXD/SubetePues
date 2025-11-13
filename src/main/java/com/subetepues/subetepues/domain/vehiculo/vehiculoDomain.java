package com.subetepues.subetepues.domain.vehiculo;


import com.subetepues.subetepues.domain.ciudad.ciudadDomain;
import com.subetepues.subetepues.domain.disponibilidad.disponibilidadDomain;
import com.subetepues.subetepues.domain.propietario.propietarioDomain;
import com.subetepues.subetepues.domain.tipoVehiculo.tipoVehiculoDomain;
import com.subetepues.subetepues.domain.transmision.transmisionDomain;
import com.subetepues.subetepues.domain.usuario.usuarioDomain;
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

    @ManyToOne
    @JoinColumn(name = "idTransmision")
    private transmisionDomain transmision;

    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private ciudadDomain ubicacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private usuarioDomain usuario;

    @ManyToOne
    @JoinColumn(name = "idTipoVehiculo")
    private tipoVehiculoDomain tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "idDisponibilidad")
    private disponibilidadDomain disponibilidad;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "marca")
    private String marca;

    @Column(name = "especificacion")
    private String especificacion;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;


}