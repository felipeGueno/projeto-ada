package com.apimanifestacaosac.entidades;

import com.apimanifestacaosac.enums.Tipo_Telefone;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(nullable = false)
    private Integer ddd;
    @Column(nullable = false)
    private Long numTelefone;
    @Column(nullable = false)
    private Tipo_Telefone tipo_telefone;

}
