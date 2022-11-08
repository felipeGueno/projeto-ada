package com.apimanifestacaosac.entidades;

import com.apimanifestacaosac.enums.Canal;
import com.apimanifestacaosac.enums.Departamento;
import com.apimanifestacaosac.enums.Tipo_Protocolo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder(toBuilder = true)
public class Protocolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroProtocolo;
    @Column(nullable = false)
    private String descricao; /** */
    @Column(nullable = false)
    private LocalDateTime dataAbertura;

    private LocalDateTime dataRecebimento;

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;
    @Column(nullable = false)
    private LocalDateTime dataPrazo;
    private LocalDateTime dataUltAcao;

    /**
     * ALTERAR PARA SITUACAO DO PROTOCOLO
     * */

    private Boolean propensaoBacen;
    private Boolean agilizar;
    private Boolean procedente;
    private Boolean devido;
    @Column(nullable = false)
    private Canal canal;
    @Column(nullable = false)
    private Departamento dptoRespons;

    private Tipo_Protocolo tipo_protocolo;

    @OneToMany
    private List<SituacaoProtocolo> situacaoProtocolo;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;


    public Protocolo(Integer numeroProtocolo
            ,String descricao
            ,LocalDateTime dataRecebimento
            ,LocalDateTime dataInicio
            ,LocalDateTime dataFim
            ,LocalDateTime dataPrazo
            ,LocalDateTime dataUltAcao
            ,Canal canal
            ,Departamento dptoRespons
            ,Cliente cliente) {
        this.numeroProtocolo = numeroProtocolo;
        this.descricao = descricao;
        this.dataAbertura = LocalDateTime.now();
        this.dataRecebimento = dataRecebimento;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.dataPrazo =dataPrazo;
        this.dataUltAcao = dataUltAcao;
        this.propensaoBacen = false;
        this.agilizar = false;
        this.procedente = false;
        this.devido = false;
        this.canal = canal;
        this.dptoRespons = dptoRespons;
        this.cliente = cliente;
    }
}
