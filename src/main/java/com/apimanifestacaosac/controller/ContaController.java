package com.apimanifestacaosac.controller;

import  java.util.*;
import com.apimanifestacaosac.dto.dtoConta.CadastroContaDto;
import com.apimanifestacaosac.dto.dtoConta.GetContaDto;
import com.apimanifestacaosac.dto.dtoConta.GetContasPorCpf;
import com.apimanifestacaosac.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/conta")
public class ContaController {

    ContaService contaService;

    @Autowired
    public ContaController(ContaService contaService) {
        this.contaService = contaService;
    }

    @PostMapping("/{cpfCliente}")
    public ResponseEntity<GetContaDto> cadastraNovaConta(@RequestBody CadastroContaDto dto,
                                                         @PathVariable String cpfCliente) throws Throwable {

        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.cadastraNovaConta(dto, cpfCliente));
    }

    @GetMapping("/{agencia}/{numConta}")
    public ResponseEntity<GetContaDto> buscaDadosPorAgenciaEConta (@PathVariable Integer agencia,
                                                                   @PathVariable Long numConta){
        return ResponseEntity.status(HttpStatus.FOUND).body(contaService.buscaPorAgenciaEConta(agencia, numConta));
    }

    @GetMapping("/listaContas/{cpfCliente}")
    public ResponseEntity<List<GetContasPorCpf>> buscaContasPorCpf (@PathVariable String cpfCliente){
        return ResponseEntity.status(HttpStatus.FOUND).body(contaService.buscaContasPorCpf(cpfCliente));
    }
}
