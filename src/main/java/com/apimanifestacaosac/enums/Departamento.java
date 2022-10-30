package com.apimanifestacaosac.enums;

public enum Departamento {

    AOC("AOC"),
    DCPS("DCPS"),
    DEF("DEF"),
    AGENCIA("AGENCIA");

    private String nome;

    Departamento(String nome) {
        this.nome = nome;
    }
}
