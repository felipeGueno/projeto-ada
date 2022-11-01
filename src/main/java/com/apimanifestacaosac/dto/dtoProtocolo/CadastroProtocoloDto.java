package com.apimanifestacaosac.dto.dtoProtocolo;

import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.enums.Canal;
import com.apimanifestacaosac.enums.Departamento;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CadastroProtocoloDto {

    private String descricao;

    private Canal canal;

    private Departamento dptoRespons;

    private String cpfCliente;

}
