package com.subetepues.subetepues.domain.vehiculo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ciudad")
public class CiudadDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_ciudad", updatable = false, nullable = false)
    private UUID idCiudad;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_departamento", nullable = false)
    private DepartamentoDomain departamento;

    public CiudadDomain() {}
    public CiudadDomain(String nombre, DepartamentoDomain departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
    }

    public UUID getIdCiudad() { return idCiudad; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public DepartamentoDomain getDepartamento() { return departamento; }
    public void setDepartamento(DepartamentoDomain departamento) { this.departamento = departamento; }
}
