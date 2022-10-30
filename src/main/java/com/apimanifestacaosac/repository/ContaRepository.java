package com.apimanifestacaosac.repository;

import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Conta;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public interface ContaRepository extends CrudRepository<Conta, Integer> {
    Optional<Conta> findByAgenciaAndNumConta(Integer agencia, Long numConta);

    List<Conta> findAllByCliente(Optional<Cliente> cliente);
}
