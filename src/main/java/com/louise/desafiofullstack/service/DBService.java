package com.louise.desafiofullstack.service;

import com.louise.desafiofullstack.domain.Empresa;
import com.louise.desafiofullstack.domain.Fornecedor;
import com.louise.desafiofullstack.repositories.EmpresaRepository;
import com.louise.desafiofullstack.repositories.FornecedorRepository;
import org.apache.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@Service
public class DBService {

    @Autowired
    private EmpresaRepository empresaRepository;
    @Autowired
    private FornecedorRepository fornecedorRepository;

    public void instanciaBasedeDados(){

        Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998");

        Empresa accenture = new Empresa("96534094001049", "ACCENTURE DO BRASIL LTDA", 30260070);
        Fornecedor louise = new Fornecedor("12345678901234", "Louise", "louise@exemplo.com", 31569190, 19680716, date1);

        empresaRepository.saveAll(Arrays.asList(accenture));
        fornecedorRepository.saveAll(Arrays.asList(louise));
    }
}
