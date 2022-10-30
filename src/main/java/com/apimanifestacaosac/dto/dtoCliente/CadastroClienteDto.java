package com.apimanifestacaosac.dto.dtoCliente;

import com.apimanifestacaosac.entidades.Telefone;
import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@Getter
@AllArgsConstructor
public class CadastroClienteDto {


    private String nome;

    private String cpf;

    private String email;

    private Tipo_Pessoa tipo_pessoa;
    private List<Telefone> telefones;


}
