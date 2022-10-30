package com.apimanifestacaosac.dto.dtoCliente;

import com.apimanifestacaosac.enums.Tipo_Telefone;
import lombok.Getter;

@Getter
public class CadastroTelefoneDto {

    private Integer id ;
    private Integer ddd;
    private Long numTelefone;

    private Tipo_Telefone tipo_telefone;

    public CadastroTelefoneDto(Integer id, Integer ddd, Long numTelefone, Tipo_Telefone tipo_telefone) {
        this.id = id;
        this.ddd = ddd;
        this.numTelefone = numTelefone;
        this.tipo_telefone = tipo_telefone;
    }
}
