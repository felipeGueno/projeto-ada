package com.apimanifestacaosac.controller;


import com.apimanifestacaosac.dto.dtoFuncionario.FuncionarioCadastroDto;
import com.apimanifestacaosac.dto.dtoFuncionario.FuncionarioGetDto;

import com.apimanifestacaosac.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {


    FuncionarioService funcionarioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Object> cadastraFuncionario(@RequestBody FuncionarioCadastroDto dto) throws IllegalAccessException {

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.cadastraFuncionario(dto));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<FuncionarioGetDto>> buscaTodosFuncionarios(){

        return ResponseEntity.status(HttpStatus.FOUND).body(funcionarioService.buscaTodosFuncionario());
    }

    @PatchMapping("/atualiza/{codFuncional}")
    public ResponseEntity<FuncionarioGetDto> atualizaFuncionario (@PathVariable Integer codFuncional,
                                                                  @RequestBody FuncionarioCadastroDto dto) throws Exception {

        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).body(funcionarioService.atualizaFuncionario(codFuncional,dto));
    }

    @DeleteMapping("/{codFuncional}")
    public ResponseEntity<FuncionarioGetDto> deletaFuncionario (@PathVariable Integer codFuncional){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(funcionarioService.deletafuncionario(codFuncional));
    }
}
