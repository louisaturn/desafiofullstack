package com.louise.desafiofullstack.service;

import com.louise.desafiofullstack.domain.Empresa;
import com.louise.desafiofullstack.domain.Fornecedor;
import com.louise.desafiofullstack.domain.EmpresaFornecedor;
import com.louise.desafiofullstack.repositories.EmpresaFornecedorRepository;
import com.louise.desafiofullstack.repositories.EmpresaRepository;
import com.louise.desafiofullstack.repositories.FornecedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @Autowired
    private EmpresaFornecedorRepository empresaFornecedorRepository;

    public void instanciaBasedeDados(){

        Empresa accenture = new Empresa(96534094001049l, "Accenture", 30260070);
        Fornecedor louise = new Fornecedor(12345678901234l, "Louise", "louise@exemplo.com", 31569190, 19680716, "25/12/2023");

        empresaRepository.saveAll(Arrays.asList(accenture));
        fornecedorRepository.saveAll(Arrays.asList(louise));
    }
}
