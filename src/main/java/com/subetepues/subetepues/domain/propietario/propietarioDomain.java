package com.subetepues.subetepues.domain.propietario;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Table(name = "propietario")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class propietarioDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_propietario", updatable = false, nullable = false)
    private UUID idpropietario;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipoDocumento")
    private String tipoDocumento;

    @Column(name = "documento")
    private String documento;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "password")
    private String password;

    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

}
