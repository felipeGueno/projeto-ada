package com.apimanifestacaosac.dto.dtoConta;

import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CadastroContaDto {

    private Integer titular;

    private Integer agencia;

    private Long numConta;



}
