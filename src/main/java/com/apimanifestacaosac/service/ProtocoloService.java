package com.apimanifestacaosac.service;

import com.apimanifestacaosac.Verificacao;
import com.apimanifestacaosac.controller.ProtocoloController;
import com.apimanifestacaosac.dto.dtoProtocolo.GetProtocoloDto;
import com.apimanifestacaosac.dto.dtoProtocolo.CadastroProtocoloDto;
import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Protocolo;
import com.apimanifestacaosac.entidades.SituacaoProtocolo;
import com.apimanifestacaosac.enums.StatusProtocolo;
import com.apimanifestacaosac.repository.ClienteRepository;
import com.apimanifestacaosac.repository.FuncionaRepository;
import com.apimanifestacaosac.repository.ProtocoloRepository;
import com.apimanifestacaosac.repository.SituacaoProtocoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProtocoloService {

    private ProtocoloRepository protocoloRepository;

    private ClienteRepository clienteRepository;

    private FuncionaRepository funcionaRepository;

    private SituacaoProtocoloRepository situacaoProtocoloRepository;
    @Autowired
    public ProtocoloService(ProtocoloRepository protocoloRepository, ClienteRepository clienteRepository, FuncionaRepository funcionaRepository, SituacaoProtocoloRepository situacaoProtocoloRepository) {
        this.protocoloRepository = protocoloRepository;
        this.clienteRepository = clienteRepository;
        this.funcionaRepository = funcionaRepository;
        this.situacaoProtocoloRepository = situacaoProtocoloRepository;
    }


    public GetProtocoloDto cadastraProtocolo (CadastroProtocoloDto dto) throws IllegalAccessException {

        if(Verificacao.verificaTodosCampoNulos(dto).size() == 0) {

            Optional<Cliente> byCpf = clienteRepository.findByCpf(dto.getCpfCliente());

            Protocolo protocoloSalvo = protocoloRepository.save(Protocolo.builder()
                    .descricao(dto.getDescricao())
                    .dataAbertura(LocalDateTime.now())
                    .canal(dto.getCanal())
                    .dataPrazo(LocalDateTime.now().plusDays(dto.getTipo_protocolo().prazo))
                    .dptoRespons(dto.getDptoRespons())
                    .tipo_protocolo(dto.getTipo_protocolo())
                    .cliente(byCpf.orElseThrow())
                    .situacaoProtocolo(criaSituacaoProtocolo())
                    .build());

//                    .protocolo(protocoloSalvo)
//                    .statusProtocolo(StatusProtocolo.NOVO)
//                    .funcionario(allByAtivo.get(new Random().nextInt(allByAtivo.size()))).build()

            return new GetProtocoloDto(protocoloSalvo);
        } else
        throw new RuntimeException("Todos os campos devem ser preenchidos");
    }

    private List<SituacaoProtocolo> criaSituacaoProtocolo() {
        List<SituacaoProtocolo> situacoesDeUmProtocolo = new ArrayList<>();

        situacoesDeUmProtocolo.add(situacaoProtocoloRepository.save(SituacaoProtocolo.builder()
                .statusProtocolo(StatusProtocolo.NOVO)
                .build()));

        return situacoesDeUmProtocolo;
    }




    public List<GetProtocoloDto> buscaTodosProcolos() {

        List<GetProtocoloDto> listaRetorno = new ArrayList<>();

        protocoloRepository.findAll()
                .forEach(protocolo -> listaRetorno.add(new GetProtocoloDto(protocolo)));

        return listaRetorno;
    }

    public String distribuiProtocolos() {


        return "Protocolos Distribuidos com sucesso";
    }

    public GetProtocoloDto agilizaProtocolo(Integer numProtocolo) {

        Optional<Protocolo> protocoloEncontrado = protocoloRepository.findById(numProtocolo);

        if (protocoloEncontrado.isPresent()){

            return new GetProtocoloDto(protocoloRepository.save(protocoloEncontrado.get().toBuilder().agilizar(true).build()));

        }
        else
            throw new RuntimeException("Protocolo não encontrado");
    }
}
