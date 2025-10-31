package com.subetepues.subetepues.domain.usuario;

import com.subetepues.subetepues.domain.rol.rolDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "inicio_sesion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InicioSesionDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sesion", updatable = false, nullable = false)
    private UUID idSesion;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(name = "correo")
    private String correo;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private rolDomain rol;
}
