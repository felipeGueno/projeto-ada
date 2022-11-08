package com.apimanifestacaosac.service;
import com.apimanifestacaosac.Verificacao;
import com.apimanifestacaosac.dto.dtoFuncionario.FuncionarioCadastroDto;
import com.apimanifestacaosac.dto.dtoFuncionario.FuncionarioGetDto;
import com.apimanifestacaosac.entidades.Funcionario;

import com.apimanifestacaosac.repository.FuncionaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.*;

@Service
public class FuncionarioService {

    FuncionaRepository funcionaRepository;

    @Autowired
    public FuncionarioService(FuncionaRepository funcionaRepository) {
        this.funcionaRepository = funcionaRepository;
    }

    public Object cadastraFuncionario(FuncionarioCadastroDto dto) throws IllegalAccessException, RuntimeException {

        if (Verificacao.verificaTodosCampoNulos(dto).size()==0){

            return new FuncionarioGetDto(funcionaRepository.save(
                    Funcionario.builder()
                            .nome(dto.getNome())
                            .email(dto.getEmail())
                            .cargo(dto.getCargo())
                            .departamento(dto.getDepartamento())
                            .ativo(true)
                            .build()));
        }
        else
            throw new RuntimeException("Todos os campos devem ser preenchidos");
    }

    public List<FuncionarioGetDto> buscaTodosFuncionario() {

        List<FuncionarioGetDto> listaretorno = new ArrayList<>();
        funcionaRepository.findAll().forEach(funcionario -> listaretorno.add(new FuncionarioGetDto(funcionario)));

        return listaretorno;
    }


    public FuncionarioGetDto atualizaFuncionario(Integer id, FuncionarioCadastroDto dto) throws Exception {

        Optional<Funcionario> funcionario = funcionaRepository.findById(id);
        if (funcionario.isPresent()) {
            Funcionario funcionario1 = funcionario.get();
            Funcionario.FuncionarioBuilder funcionarioBuilder = funcionario1.toBuilder();
            if (Optional.ofNullable(dto.getDepartamento()).isPresent() && Optional.ofNullable(dto.getCargo()).isPresent()) {
                return new FuncionarioGetDto(funcionaRepository.save(funcionarioBuilder.cargo(dto.getCargo()).departamento(dto.getDepartamento()).build()));
            } else if (Optional.ofNullable(dto.getCargo()).isPresent()) {
                return new FuncionarioGetDto(funcionaRepository.save(funcionarioBuilder.cargo(dto.getCargo()).build()));
            } else
                return new FuncionarioGetDto(funcionaRepository.save(funcionarioBuilder.departamento(dto.getDepartamento()).build()));
        }
        throw new Exception("Funcionário nao encontrado");
    }

    public FuncionarioGetDto deletafuncionario(Integer codFuncional){
        Optional<Funcionario> funcionarioEncontrado = funcionaRepository.findById(codFuncional);
        funcionarioEncontrado.ifPresent(funcionario -> funcionaRepository.delete(funcionario));

        return new FuncionarioGetDto(funcionarioEncontrado.orElseThrow());

    }


}
