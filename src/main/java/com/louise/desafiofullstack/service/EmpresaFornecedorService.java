package com.louise.desafiofullstack.service;

import com.louise.desafiofullstack.domain.EmpresaFornecedor;
import com.louise.desafiofullstack.repositories.EmpresaFornecedorRepository;
import com.louise.desafiofullstack.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaFornecedorService {

    @Autowired
    private EmpresaFornecedorRepository repository;

    public EmpresaFornecedor findById(int id) {
        Optional<EmpresaFornecedor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
    }

    public List<EmpresaFornecedor> listAllEmpresasFornecedores() {
        List<EmpresaFornecedor> empresasFornecedores = repository.findAll();
        return empresasFornecedores;
    }

    public EmpresaFornecedor create(EmpresaFornecedor empresaFornecedor) {
        return repository.save(empresaFornecedor);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public EmpresaFornecedor update(Integer id, EmpresaFornecedor empresaFornecedor) {

        EmpresaFornecedor newEmpresaFornecedor = findById(id);

        newEmpresaFornecedor.setEmpresa(empresaFornecedor.getEmpresa());
        newEmpresaFornecedor.setFornecedor(empresaFornecedor.getFornecedor());

        return repository.save(newEmpresaFornecedor);
    }
}
