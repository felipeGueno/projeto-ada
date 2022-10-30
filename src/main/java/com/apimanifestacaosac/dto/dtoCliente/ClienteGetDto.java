package com.apimanifestacaosac.dto.dtoCliente;

import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Telefone;
import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
public class ClienteGetDto {


    private String nome;

    private String cpf;

    private String email;

    private Tipo_Pessoa tipo_pessoa;
    private List<Telefone> telefones;

    public ClienteGetDto(Cliente cliente) {

        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefones = cliente.getTelefone();
        this.tipo_pessoa = cliente.getTipo_pessoa();
    }

}
