package com.subetepues.subetepues.domain.vehiculo;

import jakarta.persistence.*;
import com.subetepues.subetepues.domain.propietario.PropietarioDomain;
import java.util.UUID;

@Entity
@Table(name = "vehiculo")
public class VehiculoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_vehiculo", updatable = false, nullable = false)
    private UUID idVehiculo;

    @Column(nullable = false, unique = true)
    private String placa;

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "id_transmision", nullable = false)
    private TransmisionDomain transmision;

    @ManyToOne
    @JoinColumn(name = "id_tipo_vehiculo", nullable = false)
    private TipoVehiculoDomain tipoVehiculo;

    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private CiudadDomain ciudad;

    @ManyToOne
    @JoinColumn(name = "id_propietario", nullable = false)
    private PropietarioDomain propietario;

    public VehiculoDomain() {}

    public VehiculoDomain(String placa, String marca, String modelo,
                          TransmisionDomain transmision, TipoVehiculoDomain tipoVehiculo,
                          CiudadDomain ciudad, PropietarioDomain propietario) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.transmision = transmision;
        this.tipoVehiculo = tipoVehiculo;
        this.ciudad = ciudad;
        this.propietario = propietario;
    }

    public UUID getIdVehiculo() { return idVehiculo; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public TransmisionDomain getTransmision() { return transmision; }
    public void setTransmision(TransmisionDomain transmision) { this.transmision = transmision; }
    public TipoVehiculoDomain getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(TipoVehiculoDomain tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }
    public CiudadDomain getCiudad() { return ciudad; }
    public void setCiudad(CiudadDomain ciudad) { this.ciudad = ciudad; }
    public PropietarioDomain getPropietario() { return propietario; }
    public void setPropietario(PropietarioDomain propietario) { this.propietario = propietario; }
}
