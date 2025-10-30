package com.subetepues.subetepues.domain.documento;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "documento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class documentoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_documento", updatable = false, nullable = false)
    private UUID idDocumento;

    @Column(name = "tipoDocumento")
    private String tipoDocumento;
}
