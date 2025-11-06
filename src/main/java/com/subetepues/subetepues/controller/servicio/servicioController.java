package com.subetepues.subetepues.controller.servicio;


import com.subetepues.subetepues.domain.servicio.ServicioDomain;
import com.subetepues.subetepues.repository.servicio.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/servicio")
@CrossOrigin(origins = "*")
public class servicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/all")
    public List<ServicioDomain> getAll() {
        return servicioRepository.findAll();
    }

}
