package com.apimanifestacaosac.dto.dtoCliente;

import com.apimanifestacaosac.enums.Tipo_Telefone;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;

@Data
public class CadastroTelefoneDto {


    @NotBlank
    private Integer ddd;
    @NotBlank
    private Long numTelefone;
    @NotBlank
    private Tipo_Telefone tipo_telefone;


}
