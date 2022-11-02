package com.apimanifestacaosac.service;

import com.apimanifestacaosac.dto.dtoCliente.CadastroTelefoneDto;
import com.apimanifestacaosac.dto.dtoCliente.CadastroClienteDto;
import com.apimanifestacaosac.dto.dtoCliente.ClienteGetDto;
import com.apimanifestacaosac.entidades.Cliente;

import com.apimanifestacaosac.entidades.Telefone;
import com.apimanifestacaosac.repository.ClienteRepository;
import com.apimanifestacaosac.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {

    ClienteRepository repository;

    TelefoneRepository telefoneRepository;

    @Autowired
    public ClienteService(ClienteRepository repository, TelefoneRepository telefoneRepository) {
        this.repository = repository;
        this.telefoneRepository = telefoneRepository;
    }
    public ClienteGetDto cadastraCliente(CadastroClienteDto dto) throws Exception {

        Cliente cliente;

            if (Optional.ofNullable(dto.getTelefones()).isPresent()) {
                dto.getTelefones().forEach(t -> telefoneRepository.save(t));
                cliente = Cliente.builder()
                        .nome(dto.getNome())
                        .cpf(dto.getCpf())
                        .email(dto.getEmail())
                        .telefone(dto.getTelefones())
                        .tipo_pessoa(dto.getTipo_pessoa())
                        .build();
                repository.save(cliente);

            } else {
                cliente = new Cliente(null, dto.getNome(), dto.getCpf(), dto.getEmail(), dto.getTipo_pessoa());
                repository.save(cliente);
            }

        return new ClienteGetDto(cliente);
    }

    public List<ClienteGetDto> buscaTodosClientes() {
        Iterable<Cliente> all = repository.findAll();
        List<ClienteGetDto> listaRetorno = new ArrayList<>();

        all.forEach(cliente -> listaRetorno.add(new ClienteGetDto(cliente)));

        return listaRetorno;
    }

    public Optional<Cliente> deletaCliente(Integer id) {

        Optional<Cliente> byId = repository.findById(id);
        byId.ifPresent(cliente -> repository.delete(cliente));

        return byId;
    }

    public ClienteGetDto atualizaTelefoneCliente(Integer id, CadastroTelefoneDto dto) throws Throwable {

        Optional<Cliente> byId = repository.findById(id); /* Localizar Cliente*/

        if (byId.isPresent()) {  /*Cliente esta presente?*/
            List<Telefone> telefones = byId.get().getTelefone(); /*Se sim pegue a lista de telefones deste cliente*/
            try {
                Telefone novoTelefone = Telefone.builder() // cria novo telefone
                        .ddd(dto.getDdd())
                        .numTelefone(dto.getNumTelefone())
                        .tipo_telefone(dto.getTipo_telefone()).build();
                telefones.add(novoTelefone);/*Adiciona novo telefone na lista*/

                telefoneRepository.save(novoTelefone);// atualiza no banco todos os elementos deste
            } catch (Exception e) {
                throw new RuntimeException("Algum dado necessário faltando");


            }

            return new ClienteGetDto(repository.save(Cliente.builder() // retorna o dto com dados do cliente e todos os telefones atualizado
                    .id(byId.get().getId())
                    .nome(byId.get().getNome())
                    .cpf(byId.get().getCpf())
                    .email(byId.get().getEmail())
                    .tipo_pessoa(byId.get().getTipo_pessoa())
                    .telefone(telefones).build()));
        } else
            throw new Exception("Cliente nao encontrado");
    }

    public ClienteGetDto buscaclientePorCpf(String cpf) throws Throwable {

        Cliente clienteEncontrado = repository.findByCpf(cpf).orElseThrow(() -> new Throwable("Cliente não existe"));

        return new ClienteGetDto(clienteEncontrado);
    }


}
