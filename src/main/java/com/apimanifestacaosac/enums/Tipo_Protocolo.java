package com.apimanifestacaosac.enums;

public enum Tipo_Protocolo {

    RECLAMACAO(5),
    ELOGIO(10),
    INFORMACAO(7),
    SOLICITACAO(7),
    CONSULTA(7),
    DENUNCIA(3),
    CANCELAMENTO(2);

    public Integer prazo;

    Tipo_Protocolo(Integer prazo) {
        this.prazo = prazo;
    }
}
