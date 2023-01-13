package com.apimanifestacaosac.repository;

import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Funcionario;
import com.apimanifestacaosac.entidades.SituacaoProtocolo;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface SituacaoProtocoloRepository extends CrudRepository<SituacaoProtocolo, Integer> {

    List<SituacaoProtocolo> findAllByFuncionario(Object obj);
}
