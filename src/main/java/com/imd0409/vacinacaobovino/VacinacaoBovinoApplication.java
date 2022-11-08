package com.imd0409.vacinacaobovino;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.imd0409.vacinacaobovino.model.Bovino;
import com.imd0409.vacinacaobovino.model.Fabricante;
import com.imd0409.vacinacaobovino.model.Pessoa;
import com.imd0409.vacinacaobovino.model.Vacina;
import com.imd0409.vacinacaobovino.repository.AplicacaoRepository;
import com.imd0409.vacinacaobovino.repository.BovinoRepository;
import com.imd0409.vacinacaobovino.repository.FabricanteRepository;
import com.imd0409.vacinacaobovino.repository.PessoaRepository;
import com.imd0409.vacinacaobovino.repository.VacinaRepository;

@SpringBootApplication
public class VacinacaoBovinoApplication {

	@Autowired
	BovinoRepository bovinoRepository;
	@Autowired
	FabricanteRepository fabricanteRepository;
    @Autowired
    VacinaRepository vacinaRepository;
	@Autowired
    PessoaRepository pessoaRepository;
	@Autowired
    AplicacaoRepository aplicacaoRepository;

	@Bean
	public CommandLineRunner init(){
		return args -> {
			System.out.println("Cadastrando bovinos");
			LocalDate date = LocalDate.of(2001, 02, 20);
			bovinoRepository.save(new Bovino("Mimoso", date, "Macho", "Preto", 10.0f, true ));

            System.out.println("Cadastrando fabricante");
            fabricanteRepository.save(new Fabricante("Ourovac", "08002378957", "87459612357955", "Brasileira", "Jucurutu", "Rio Grande do Norte", "59330000", "Zona rural", "Veteranos", "13"));
			
            System.out.println("Cadastrando vacina");
            vacinaRepository.save(new Vacina("Aftosa", 360, "Contra a febre aftosa"));
			
            System.out.println("Cadastrando pessoa");
			Pessoa pessoa = new Pessoa("Maria", "995741268", "45678912365", "maria12@gmail.com", "Jucurutu", "Rio Grande do Norte", "59330000", "Zona rural", "Veteranos", "13");
            pessoa.setLogin("Gestor");
			pessoa.setSenha("senha123");
			pessoa.setPapel("GESTOR");
			pessoaRepository.save(pessoa);
            
		};
	}





	public static void main(String[] args) {
		SpringApplication.run(VacinacaoBovinoApplication.class, args);
	}

}
