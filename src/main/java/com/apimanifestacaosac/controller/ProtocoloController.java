package com.apimanifestacaosac.controller;

import com.apimanifestacaosac.dto.dtoProtocolo.GetProtocoloDto;
import com.apimanifestacaosac.dto.dtoProtocolo.CadastroProtocoloDto;
import com.apimanifestacaosac.service.ProtocoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/protocolo")
public class ProtocoloController {

    ProtocoloService protocoloService;

    @Autowired
    public ProtocoloController(ProtocoloService protocoloService) {
        this.protocoloService = protocoloService;
    }

    @PostMapping
    public ResponseEntity<GetProtocoloDto> cadastraProtoco (@RequestBody CadastroProtocoloDto dto) throws IllegalAccessException {
        return  ResponseEntity.status(HttpStatus.CREATED).body(protocoloService.cadastraProtocolo(dto));
    }

    @GetMapping
    public ResponseEntity<List<GetProtocoloDto>> buscaTodosProtocolos(){

        return ResponseEntity.status(HttpStatus.FOUND).body(protocoloService.buscaTodosProcolos());
    }

    @PutMapping("/distribuir")
    public ResponseEntity<String> distribuiProtocolos(){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(protocoloService.distribuiProtocolos());
    }

    @PatchMapping("/agilizar/{numProtocolo}")
    public ResponseEntity<GetProtocoloDto> agilizarProtocolo(@PathVariable Integer numProtocolo){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(protocoloService.agilizaProtocolo(numProtocolo));
    }



    /**
     * NÃO HÁ OPCÃO DE DELETAR PROTOCOLO
     *
     * */

}
