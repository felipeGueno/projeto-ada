package com.apimanifestacaosac.entidades;

import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer titular;
    @Column(nullable = false)
    private Integer agencia;
    @Column(nullable = false)
    private Long numConta;
    @Column(nullable = false)
    private Tipo_Pessoa tipo_pessoa;
    private Boolean status;
    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @ManyToOne()
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}