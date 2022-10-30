package com.apimanifestacaosac.dto.dtoCliente;

import com.apimanifestacaosac.entidades.Telefone;
import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.List;


@Data
public class CadastroClienteDto {


    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private Tipo_Pessoa tipo_pessoa;

    private List<Telefone> telefones;

}
