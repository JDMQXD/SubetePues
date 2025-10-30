package com.subetepues.subetepues.domain.vehiculo;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tipo_vehiculo")
public class TipoVehiculoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tipo_vehiculo", updatable = false, nullable = false)
    private UUID idTipoVehiculo;

    @Column(nullable = false)
    private String nombre; // Ejemplo: "Carro", "Moto"

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private CategoriaDomain categoria;

    public TipoVehiculoDomain() {}
    public TipoVehiculoDomain(String nombre, CategoriaDomain categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public UUID getIdTipoVehiculo() { return idTipoVehiculo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public CategoriaDomain getCategoria() { return categoria; }
    public void setCategoria(CategoriaDomain categoria) { this.categoria = categoria; }
}
