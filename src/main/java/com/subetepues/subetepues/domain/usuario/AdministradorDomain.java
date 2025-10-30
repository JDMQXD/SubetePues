package com.subetepues.subetepues.domain.usuario;



import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "administrador")
public class AdministradorDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_admin", updatable = false, nullable = false)
    private UUID idAdministrador;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    public AdministradorDomain() {}

    public AdministradorDomain(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public UUID getIdAdministrador() {
        return idAdministrador; }
    public String getNombre() {
        return nombre; }

    public void setNombre(String nombre) {
        this.nombre = nombre; }

    public String getCorreo() {
        return correo; }

    public void setCorreo(String correo) {
        this.correo = correo; }

    public String getTelefono() {
        return telefono; }

    public void setTelefono(String telefono) {
        this.telefono = telefono; }
}

