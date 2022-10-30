package com.apimanifestacaosac.repository;

import com.apimanifestacaosac.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Optional<Cliente> findByCpf(String cpf);
}
