package com.apimanifestacaosac.entidades;

import com.apimanifestacaosac.enums.Tipo_Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private Tipo_Pessoa tipo_pessoa;


    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.PERSIST)
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
