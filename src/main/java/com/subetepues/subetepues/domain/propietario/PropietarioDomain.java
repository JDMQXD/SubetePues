
package com.subetepues.subetepues.domain.propietario;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "propietario")
public class PropietarioDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_propietario", updatable = false, nullable = false)
    private UUID idPropietario;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String correo;

    @Column(nullable = false)
    private String telefono;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<com.subetepues.subetepues.domain.vehiculo.VehiculoDomain> vehiculos;

    public PropietarioDomain() {}

    public PropietarioDomain(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public UUID getIdPropietario() { return idPropietario; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public List<com.subetepues.subetepues.domain.vehiculo.VehiculoDomain> getVehiculos() { return vehiculos; }
    public void setVehiculos(List<com.subetepues.subetepues.domain.vehiculo.VehiculoDomain> vehiculos) { this.vehiculos = vehiculos; }
}
