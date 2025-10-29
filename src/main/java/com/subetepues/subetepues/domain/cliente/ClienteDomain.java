package com.subetepues.subetepues.domain.cliente;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cliente")
public class ClienteDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cliente", updatable = false, nullable = false)
    private UUID idCliente;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private boolean registrado;

    public ClienteDomain() {}

    public ClienteDomain(String nombre, String correo, String telefono, boolean registrado) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.registrado = registrado;
    }

    public UUID getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public boolean isRegistrado() { return registrado; }
    public void setRegistrado(boolean registrado) { this.registrado = registrado; }
}
