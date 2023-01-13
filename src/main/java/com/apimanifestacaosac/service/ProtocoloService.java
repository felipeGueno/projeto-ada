package com.apimanifestacaosac.service;

import com.apimanifestacaosac.Verificacao;
import com.apimanifestacaosac.dto.dtoProtocolo.GetProtocoloDto;
import com.apimanifestacaosac.dto.dtoProtocolo.CadastroProtocoloDto;
import com.apimanifestacaosac.entidades.*;
import com.apimanifestacaosac.enums.StatusProtocolo;
import com.apimanifestacaosac.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

@Service
public class ProtocoloService {

    private ProtocoloRepository protocoloRepository;

    private ClienteRepository clienteRepository;

    private FuncionaRepository funcionaRepository;

    private SituacaoProtocoloRepository situacaoProtocoloRepository;

    private FuncionarioComProtocoloRepository funcionarioComProtocoloRepository;

    @Autowired
    public ProtocoloService(ProtocoloRepository protocoloRepository, ClienteRepository clienteRepository, FuncionaRepository funcionaRepository, SituacaoProtocoloRepository situacaoProtocoloRepository) {
        this.protocoloRepository = protocoloRepository;
        this.clienteRepository = clienteRepository;
        this.funcionaRepository = funcionaRepository;
        this.situacaoProtocoloRepository = situacaoProtocoloRepository;
    }


    public GetProtocoloDto cadastraProtocolo(CadastroProtocoloDto dto) throws IllegalAccessException {

        if (Verificacao.verificaTodosCampoNulos(dto).size() == 0) {

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

        List<Protocolo> listaProtocolos = new ArrayList<>();
        Iterable<Protocolo> all = protocoloRepository.findAll();
        List<Funcionario> allByAtivo = funcionaRepository.findAllByAtivo(true);
        all.forEach(listaProtocolos::add);

        for (Protocolo protocolo : listaProtocolos) {

            if (protocolo.getSituacaoProtocolo().stream().map(SituacaoProtocolo::getFuncionario)
                    .allMatch(Objects::isNull)) {

                protocolo.getSituacaoProtocolo()
                        .add(situacaoProtocoloRepository.save(SituacaoProtocolo.builder().funcionario(allByAtivo.get(new Random().nextInt(allByAtivo.size())))
                                .statusProtocolo(StatusProtocolo.NAO_INICIADO)
                                .build()));

                protocoloRepository.save(protocolo);

            }

        }

        return "Protocolos Distribuidos com sucesso";
    }


    private FuncionarioComProtocolo atribuiFuncionarioAoProtocolo(Funcionario funcionario, Protocolo protocolo) {
        Optional<FuncionarioComProtocolo> byFuncionario = funcionarioComProtocoloRepository.findByFuncionario(funcionario);
        if (byFuncionario.isPresent()) {
            byFuncionario.get().getProtocolosComFuncionario().add(protocolo);
            return funcionarioComProtocoloRepository.save(byFuncionario.get());

        } else
            return funcionarioComProtocoloRepository.save(FuncionarioComProtocolo.builder().funcionario(funcionario).build());

//        protocolo.getSituacaoProtocolo().add(
//                situacaoProtocoloRepository.save(SituacaoProtocolo.builder()
//                        .statusProtocolo(StatusProtocolo.NAO_INICIADO)
//                        .funcionario(funcionario).build()));


    }

    private int qntProtocolosPorFuncionario(FuncionarioComProtocolo funcionarioComProtocolo) {

        return funcionarioComProtocolo.getProtocolosComFuncionario().size();
    }

    public GetProtocoloDto agilizaProtocolo(Integer numProtocolo) {

        Optional<Protocolo> protocoloEncontrado = protocoloRepository.findById(numProtocolo);

        if (protocoloEncontrado.isPresent()) {

            return new GetProtocoloDto(protocoloRepository.save(protocoloEncontrado.get().toBuilder().agilizar(true).build()));

        } else
            throw new RuntimeException("Protocolo não encontrado");
    }
}
