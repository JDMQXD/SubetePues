package com.subetepues.subetepues.controller.disponibilidad;

import com.subetepues.subetepues.domain.disponibilidad.disponibilidadDomain;
import com.subetepues.subetepues.repository.disponibilidad.DisponibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/disponibilidad")
@CrossOrigin(origins = "*")
public class disponibilidadController {

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    @GetMapping("/all")
    public List<disponibilidadDomain> getAll() {
        return disponibilidadRepository.findAll();
    }
}

