package com.apimanifestacaosac.dto.dtoFuncionario;

import com.apimanifestacaosac.enums.Cargo;
import com.apimanifestacaosac.enums.Departamento;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class FuncionarioCadastroDto {


    private String nome;

    private String email;

    private Departamento departamento;

    private Cargo cargo;


}
