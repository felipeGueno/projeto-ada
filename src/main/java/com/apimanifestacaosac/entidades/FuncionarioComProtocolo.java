package com.apimanifestacaosac.entidades;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class FuncionarioComProtocolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Funcionario funcionario;
    @OneToMany
    private List<Protocolo> protocolosComFuncionario;

    public FuncionarioComProtocolo(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public List<Protocolo> getProtocolosComFuncionario() {
        return protocolosComFuncionario;
    }
}
