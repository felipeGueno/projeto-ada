package com.apimanifestacaosac.service;

import com.apimanifestacaosac.Verificacao;
import com.apimanifestacaosac.dto.dtoCliente.ClienteGetDto;
import com.apimanifestacaosac.dto.dtoProtocolo.CadastroGetProtocoloDto;
import com.apimanifestacaosac.dto.dtoProtocolo.CadastroProtocoloDto;
import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Funcionario;
import com.apimanifestacaosac.entidades.Protocolo;
import com.apimanifestacaosac.repository.ClienteRepository;
import com.apimanifestacaosac.repository.ProtocoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProtocoloService {

    ProtocoloRepository protocoloRepository;

    ClienteRepository clienteRepository;
    @Autowired
    public ProtocoloService(ProtocoloRepository protocoloRepository, ClienteRepository clienteRepository) {
        this.protocoloRepository = protocoloRepository;
        this.clienteRepository = clienteRepository;
    }


    public CadastroGetProtocoloDto cadastraProtocolo (CadastroProtocoloDto dto) throws IllegalAccessException {

        if(Verificacao.verificaTodosCampoNulos(dto).size() == 0) {

            Optional<Cliente> byCpf = clienteRepository.findByCpf(dto.getCpfCliente());

            return new CadastroGetProtocoloDto(protocoloRepository.save(Protocolo.builder()
                    .descricao(dto.getDescricao())
                    .dataAbertura(LocalDateTime.now())
                    .canal(dto.getCanal())
                    .dataPrazo(LocalDateTime.now().plusDays(5))
                    .dptoRespons(dto.getDptoRespons())
                    .cliente(byCpf.orElseThrow())
                    .build()));
        } else
        throw new RuntimeException("Todos os campos devem ser preenchidos");
    }


    public List<CadastroGetProtocoloDto> buscaTodosProcolos() {

        List<CadastroGetProtocoloDto> listaRetorno = new ArrayList<>();

        protocoloRepository.findAll()
                .forEach(protocolo -> listaRetorno.add(new CadastroGetProtocoloDto(protocolo)));

        return listaRetorno;
    }
}
