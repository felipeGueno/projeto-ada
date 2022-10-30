package com.apimanifestacaosac.controller;

import com.apimanifestacaosac.dto.dtoCliente.CadastroTelefoneDto;
import com.apimanifestacaosac.dto.dtoCliente.CadastroClienteDto;
import com.apimanifestacaosac.dto.dtoCliente.ClienteGetDto;
import com.apimanifestacaosac.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> cadastraCliente (@RequestBody  @Valid CadastroClienteDto dto) throws Exception {
        ClienteGetDto clienteGetDto = service.cadastraCliente(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cliente " + clienteGetDto.getNome() + " cadastrado com sucesso");

    }

    @PatchMapping("/telefone/{id}")
    public ResponseEntity<Object> atualizaTelefoneCliente(@PathVariable Integer id, @RequestBody @Valid CadastroTelefoneDto dto) throws Throwable {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.atualizaTelefoneCliente(id, dto));
    }

    @GetMapping
    public ResponseEntity<Object> buscaTodosClientes(){
     return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.buscaTodosClientes());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletaCliente (@PathVariable Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(service.deletaCliente(id));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteGetDto> buscaclientePorCpf (@PathVariable String cpf) throws Throwable {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.buscaclientePorCpf(cpf));
    }


}
