package com.apimanifestacaosac.entidades;

import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.*;

import java.util.*;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder (toBuilder = true)
@Getter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private Tipo_Pessoa tipo_pessoa;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "cliente_id")
    private List<Telefone> telefone;


    public Cliente(Integer id, String nome, String cpf, String email, Tipo_Pessoa tipo_pessoa) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.tipo_pessoa = tipo_pessoa;
    }
}
