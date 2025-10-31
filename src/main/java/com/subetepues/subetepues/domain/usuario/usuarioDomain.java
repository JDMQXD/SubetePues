package com.subetepues.subetepues.domain.usuario;

import com.subetepues.subetepues.domain.documento.documentoDomain;
import com.subetepues.subetepues.domain.rol.rolDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name ="usuario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class usuarioDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario", updatable = false, nullable = false)
    private UUID idUsuario;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idDocumento")
    private documentoDomain tipoDocumento;

    @Column(name = "documento")
    private String documento;

    @Column(name = "telefono")
    private int telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "idRol")
    private rolDomain rol;
}
