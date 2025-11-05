package com.subetepues.subetepues.controller.transmision;

import com.subetepues.subetepues.domain.transmision.transmisionDomain;
import com.subetepues.subetepues.repository.transmision.TransmisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transmision")
@CrossOrigin(origins = "*")
public class transmisionController {

    @Autowired
    private TransmisionRepository transmisionRepository;

    @GetMapping("/all")
    public List<transmisionDomain> getAll() {
        return transmisionRepository.findAll();
    }
}
