package com.subetepues.subetepues.domain.reserva;



import com.subetepues.subetepues.domain.servicio.ServicioDomain;
import com.subetepues.subetepues.domain.usuario.usuarioDomain;
import com.subetepues.subetepues.domain.vehiculo.vehiculoDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "reserva")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter


public class reservaDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_Reserva", updatable = false, nullable = false)
    private UUID idReserva;

    @ManyToOne
    @JoinColumn(name = "idServicio")
    private ServicioDomain servicio;

    @ManyToOne
    @JoinColumn(name = "idVehiculo")
    private vehiculoDomain vehiculo;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private usuarioDomain usuario;

    @Column(name = "fechaReserva")
    private Date fechaReserva;

    @Column(name = "fechaInicio")
    private Date fechaInicio;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Column(name = "lugarEntrega")
    private String lugarEntrega;

}
