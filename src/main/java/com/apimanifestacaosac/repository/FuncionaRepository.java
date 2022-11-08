package com.apimanifestacaosac.repository;

import com.apimanifestacaosac.entidades.Funcionario;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

public interface FuncionaRepository extends CrudRepository<Funcionario, Integer> {


    List<Funcionario> findAllByAtivo(Boolean ativo);

}
