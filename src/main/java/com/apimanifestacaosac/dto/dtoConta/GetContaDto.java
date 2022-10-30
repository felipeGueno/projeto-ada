package com.apimanifestacaosac.dto.dtoConta;

import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Conta;
import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.Getter;

@Getter
public class GetContaDto {

    private Integer titular;

    private Integer agencia;

    private Long numConta;

    private Tipo_Pessoa tipo_pessoa;

    private Cliente cliente;

    public GetContaDto(Conta conta) {
        this.titular = conta.getTitular();
        this.agencia = conta.getAgencia();
        this.numConta = conta.getNumConta();
        this.tipo_pessoa = conta.getTipo_pessoa();
        this.cliente = conta.getCliente();
    }
}
