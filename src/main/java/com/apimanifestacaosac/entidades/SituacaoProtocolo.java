package com.apimanifestacaosac.entidades;


import com.apimanifestacaosac.enums.StatusProtocolo;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class SituacaoProtocolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String respostaProtocolo;

    @ManyToMany
    private List<Funcionario> funcionario;
    @Column(nullable = false)
    private StatusProtocolo statusProtocolo;

}
