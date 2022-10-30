package com.apimanifestacaosac.service;


import com.apimanifestacaosac.dto.dtoConta.CadastroContaDto;
import com.apimanifestacaosac.dto.dtoConta.GetContaDto;
import com.apimanifestacaosac.dto.dtoConta.GetContasPorCpf;
import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Conta;
import com.apimanifestacaosac.repository.ClienteRepository;
import com.apimanifestacaosac.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    ContaRepository contaRepository;

    ClienteRepository clienteRepository;

    @Autowired
    public ContaService(ContaRepository contaRepository, ClienteRepository clienteRepository) {
        this.contaRepository = contaRepository;
        this.clienteRepository = clienteRepository;
    }

    public GetContaDto cadastraNovaConta (CadastroContaDto dto, String cpfCliente) throws Throwable {

            Cliente cliente = clienteRepository.findByCpf(cpfCliente).orElseThrow(() -> new Throwable("Cliente não existe, cadastre"));

            return new GetContaDto(contaRepository.save(Conta.builder()
                    .cliente(cliente)
                    .agencia(dto.getAgencia())
                    .titular(dto.getTitular())
                    .numConta(dto.getNumConta())
                    .tipo_pessoa(cliente.getTipo_pessoa())
                            .status(true)
                    .dataCadastro(LocalDateTime.now())
                    .build()));
    }

    public GetContaDto buscaPorAgenciaEConta(Integer agencia, Long numConta) {
        Optional<Conta> contaOptional = contaRepository.findByAgenciaAndNumConta(agencia, numConta);
        return new GetContaDto(contaOptional.orElseThrow());
    }

    public List<GetContasPorCpf> buscaContasPorCpf(String cpf){
        List<GetContasPorCpf> listaRetorno = new ArrayList<>();
        Optional<Cliente> cliente = clienteRepository.findByCpf(cpf);
        contaRepository.findAllByCliente(cliente).forEach(conta -> listaRetorno.add(new GetContasPorCpf(conta)));

        return listaRetorno;
    }
}
