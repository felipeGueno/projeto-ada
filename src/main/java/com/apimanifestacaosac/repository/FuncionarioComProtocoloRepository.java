package com.apimanifestacaosac.repository;

import com.apimanifestacaosac.entidades.Funcionario;
import com.apimanifestacaosac.entidades.FuncionarioComProtocolo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FuncionarioComProtocoloRepository extends CrudRepository<FuncionarioComProtocolo, Integer> {

    Optional<FuncionarioComProtocolo> findByFuncionario(Funcionario funcionario);
}
