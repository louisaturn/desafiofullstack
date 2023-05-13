package com.louise.desafiofullstack.service;

import com.louise.desafiofullstack.domain.Fornecedor;
import com.louise.desafiofullstack.repositories.FornecedorRepository;
import com.louise.desafiofullstack.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService implements Serializable {

    @Autowired
    private FornecedorRepository repository;

    public Fornecedor findById(long cnpjOuCpf) {
        Optional<Fornecedor> obj = repository.findById(cnpjOuCpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + cnpjOuCpf));
    }

    public List<Fornecedor> listAllFornecedores() {
        List<Fornecedor> fornecedores = repository.findAll();
        return fornecedores;
    }

    public Fornecedor create(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    public void delete(long cnpjOuCpf) {
        repository.deleteById(cnpjOuCpf);
    }

    public Fornecedor update(long cnpjOuCpf, Fornecedor fornecedor) {

        Fornecedor newFornecedor = findById(cnpjOuCpf);

        newFornecedor.setCep(fornecedor.getCep());
        newFornecedor.setNome(fornecedor.getNome());
        newFornecedor.setCep(fornecedor.getCep());
        newFornecedor.setDataNascimento(fornecedor.getDataNascimento());
        newFornecedor.setRg(fornecedor.getRg());

        return repository.save(newFornecedor);
    }
}
