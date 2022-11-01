package com.apimanifestacaosac.dto.dtoConta;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;


@Getter
@AllArgsConstructor
public class CadastroContaDto {

    @NotBlank
    private Integer titular;
    @NotBlank
    private Integer agencia;
    @NotBlank
    private Long numConta;


}
