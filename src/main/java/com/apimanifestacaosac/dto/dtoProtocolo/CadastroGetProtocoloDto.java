package com.apimanifestacaosac.dto.dtoProtocolo;

import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Protocolo;
import com.apimanifestacaosac.entidades.SituacaoProtocolo;
import com.apimanifestacaosac.enums.Canal;
import com.apimanifestacaosac.enums.Departamento;
import com.apimanifestacaosac.enums.Tipo_Protocolo;
import lombok.Getter;
import java.util.*;

import java.time.LocalDateTime;

@Getter
public class CadastroGetProtocoloDto {

    private Integer numeroProtocolo;

    private String descricao;

    private LocalDateTime dataAbertura;

    private LocalDateTime dataPrazo;
    private Canal canal;

    private Departamento dptoRespons;

    private Cliente cliente;

    private Tipo_Protocolo tipo_protocolo;

    private List<SituacaoProtocolo> situacaoProtocolo;

    public CadastroGetProtocoloDto(Protocolo protocolo) {
        this.numeroProtocolo = protocolo.getNumeroProtocolo();
        this.descricao = protocolo.getDescricao();
        this.dataAbertura = protocolo.getDataAbertura();
        this.dataPrazo = protocolo.getDataPrazo();
        this.canal = protocolo.getCanal();
        this.dptoRespons = protocolo.getDptoRespons();
        this.cliente = protocolo.getCliente();
        this.situacaoProtocolo = protocolo.getSituacaoProtocolo();
        this.tipo_protocolo = protocolo.getTipo_protocolo();
    }
}
