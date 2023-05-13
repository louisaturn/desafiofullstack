package com.louise.desafiofullstack;

import com.louise.desafiofullstack.repositories.EmpresaFornecedorRepository;
import com.louise.desafiofullstack.repositories.EmpresaRepository;
import com.louise.desafiofullstack.repositories.FornecedorRepository;
import com.louise.desafiofullstack.repositories.EmpresaFornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DesafiofullstackApplication implements CommandLineRunner {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private FornecedorRepository fornecedorRepository;
	@Autowired
	private EmpresaFornecedorRepository empresaFornecedorRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafiofullstackApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
;
	}

}
