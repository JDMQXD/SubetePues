package com.subetepues.subetepues.domain.vehiculo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "departamento")
public class DepartamentoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_departamento", updatable = false, nullable = false)
    private UUID idDepartamento;

    @Column(nullable = false, unique = true)
    private String nombre;

    public DepartamentoDomain() {}
    public DepartamentoDomain(String nombre) { this.nombre = nombre; }

    public UUID getIdDepartamento() { return idDepartamento; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
