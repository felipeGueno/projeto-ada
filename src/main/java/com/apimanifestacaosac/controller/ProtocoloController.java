package com.apimanifestacaosac.controller;

import com.apimanifestacaosac.dto.dtoProtocolo.CadastroGetProtocoloDto;
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
    public ResponseEntity<CadastroGetProtocoloDto> cadastraProtoco (@RequestBody CadastroProtocoloDto dto) throws IllegalAccessException {
        return  ResponseEntity.status(HttpStatus.CREATED).body(protocoloService.cadastraProtocolo(dto));
    }

    @GetMapping
    public ResponseEntity<List<CadastroGetProtocoloDto>> buscaTodosProtocolos(){

        return ResponseEntity.status(HttpStatus.FOUND).body(protocoloService.buscaTodosProcolos());
    }

}
