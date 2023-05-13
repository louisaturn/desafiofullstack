package com.louise.desafiofullstack.service;

import com.louise.desafiofullstack.domain.Empresa;
import com.louise.desafiofullstack.repositories.EmpresaRepository;
import com.louise.desafiofullstack.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
@Service
public class EmpresaService implements Serializable {

    @Autowired
    private EmpresaRepository repository;

    public Empresa findById(long cnpj) {
        Optional<Empresa> obj = repository.findById(cnpj);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! CNPJ: " + cnpj));
    }

    public List<Empresa> listAllEmpresas() {
        List<Empresa> empresas = repository.findAll();
        return empresas;
    }

    public Empresa create(Empresa empresa) {
        return repository.save(empresa);
    }

    public void delete(long cnpj) {
        repository.deleteById(cnpj);
    }

    public Empresa update(long cnpj, Empresa empresa) {

        Empresa newEmpresa = findById(cnpj);

        newEmpresa.setCep(empresa.getCep());
        newEmpresa.setNomeFantasia(empresa.getNomeFantasia());

        return repository.save(newEmpresa);
    }
}
