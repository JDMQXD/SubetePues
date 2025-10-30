package com.subetepues.subetepues.domain.vehiculo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "categoria")
public class CategoriaDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categoria", updatable = false, nullable = false)
    private UUID idCategoria;

    @Column(nullable = false, unique = true)
    private String nombre; // Ejemplo: "Económico", "Premium"

    public CategoriaDomain() {}
    public CategoriaDomain(String nombre) { this.nombre = nombre; }

    public UUID getIdCategoria() { return idCategoria; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
