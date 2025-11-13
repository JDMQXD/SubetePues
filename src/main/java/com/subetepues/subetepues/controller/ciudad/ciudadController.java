package com.subetepues.subetepues.controller.ciudad;

import com.subetepues.subetepues.domain.ciudad.ciudadDomain;
import com.subetepues.subetepues.repository.ciudad.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ciudad")
@CrossOrigin(origins = "*")
public class ciudadController {

    @Autowired
    private CiudadRepository ciudadRepository;

    @GetMapping("/all")
    public List<ciudadDomain> getAll() {
        return ciudadRepository.findAll();
    }
}

