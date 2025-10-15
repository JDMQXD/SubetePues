package com.subetepues.subetepues.domain.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name ="cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class clienteDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", updatable = false, nullable = false)
    private UUID idCliente;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipoDocumento")
    private int tipoDocumento;

    @Column(name = "documento")
    private String documento;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;
}
