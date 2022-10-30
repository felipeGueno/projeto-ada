package com.apimanifestacaosac.dto.dtoConta;

import com.apimanifestacaosac.entidades.Conta;
import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter

public class GetContasPorCpf {

    private Integer titular;

    private Integer agencia;

    private Long numConta;

    private Boolean status;
    private Tipo_Pessoa tipo_pessoa;

    public GetContasPorCpf(Conta conta) {
        this.titular = conta.getTitular();
        this.agencia = conta.getAgencia();
        this.numConta = conta.getNumConta();
        this.status = conta.getStatus();
        this.tipo_pessoa = conta.getTipo_pessoa();
    }
}
