package com.apimanifestacaosac.entidades;
import com.apimanifestacaosac.enums.Cargo;
import com.apimanifestacaosac.enums.Departamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Min;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder (toBuilder = true)
public class Funcionario {

    @Id
    @Min(1000)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codFuncional;
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    private Departamento departamento;
    private Cargo cargo;

    private Boolean ativo;

//    @ManyToMany(mappedBy = )
//    List <SituacaoProtocolo> situacaoProtocoloList;


}
