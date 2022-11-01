package com.apimanifestacaosac.dto.dtoFuncionario;

import com.apimanifestacaosac.entidades.Funcionario;
import com.apimanifestacaosac.enums.Cargo;
import com.apimanifestacaosac.enums.Departamento;
import lombok.Getter;


@Getter
public class FuncionarioGetDto {

    private String nome;

    private String email;

    private Departamento departamento;

    private Cargo cargo;

    public FuncionarioGetDto(Funcionario funcionario) {
        this.nome = funcionario.getNome();
        this.email = funcionario.getEmail();
        this.departamento = funcionario.getDepartamento();
        this.cargo = funcionario.getCargo();
    }
}
