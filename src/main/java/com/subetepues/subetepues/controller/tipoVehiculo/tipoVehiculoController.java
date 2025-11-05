package com.subetepues.subetepues.controller.tipoVehiculo;

import com.subetepues.subetepues.domain.tipoVehiculo.tipoVehiculoDomain;
import com.subetepues.subetepues.repository.tipoVehiculoRepository.TipoVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tipoVehiculo")
@CrossOrigin(origins = "*")
public class tipoVehiculoController {

    @Autowired
    private TipoVehiculoRepository tipoVehiculoRepository;

    @GetMapping("/all")
    public List<tipoVehiculoDomain> getAll() {
        return tipoVehiculoRepository.findAll();
    }
}

