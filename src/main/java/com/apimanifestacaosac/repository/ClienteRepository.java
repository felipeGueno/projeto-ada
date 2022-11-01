package com.apimanifestacaosac.repository;

import com.apimanifestacaosac.entidades.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    Optional<Cliente> findByCpf(String cpf);
}
