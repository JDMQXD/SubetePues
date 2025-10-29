package com.subetepues.subetepues.domain.usuario;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "inicio_sesion")
public class InicioSesionDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sesion", updatable = false, nullable = false)
    private UUID idSesion;

    @Column(nullable = false, unique = true)
    private String usuario;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String rol; // "cliente" o "administrador"

    public InicioSesionDomain() {}

    public InicioSesionDomain(String usuario, String contrasena, String rol) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public UUID getIdSesion() { return idSesion; }
    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }
}
