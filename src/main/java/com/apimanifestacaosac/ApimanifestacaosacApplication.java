package com.apimanifestacaosac;

import com.apimanifestacaosac.entidades.Cliente;
import com.apimanifestacaosac.entidades.Telefone;
import com.apimanifestacaosac.enums.Tipo_Pessoa;
import com.apimanifestacaosac.enums.Tipo_Telefone;
import com.apimanifestacaosac.repository.ClienteRepository;
import com.apimanifestacaosac.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.*;
@SpringBootApplication
public class ApimanifestacaosacApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApimanifestacaosacApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		repository.save(criaCliente(Cliente.builder()
				.cpf("07685903962")
				.email("felipegueno@gmail.com")
				.nome("Felipe Gueno")
				.tipo_pessoa(Tipo_Pessoa.FISICA)
				.build(), null, 41, 995787237L, Tipo_Telefone.COMERCIAL));

		repository.save(criaCliente(Cliente.builder()
				.cpf("086598121")
				.email("guitschumi@gmail.com")
				.nome("Guilherme Tschumi LTDA")
				.tipo_pessoa(Tipo_Pessoa.JURIDICA)
				.build(), null, 41, 996523578L, Tipo_Telefone.CELULAR));
	}

	private Cliente criaCliente(Cliente cliente, Integer id ,
								Integer ddd,
								Long numTelefone, Tipo_Telefone tipo){
		List<Telefone> telefones = new ArrayList<>();
		telefones.add(new Telefone(null, ddd, numTelefone, tipo));
		telefones.forEach(t -> telefoneRepository.save(t));

		return cliente.toBuilder().telefone(telefones).build();

	}
}
