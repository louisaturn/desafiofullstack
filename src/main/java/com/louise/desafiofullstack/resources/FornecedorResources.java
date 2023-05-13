package com.louise.desafiofullstack.resources;
import com.louise.desafiofullstack.domain.Fornecedor;
import com.louise.desafiofullstack.service.FornecedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/fornecedores")
public class FornecedorResources {

        @Autowired
        private FornecedorService service;

        @GetMapping(value = "/{cnpjOuCpf}")
        public ResponseEntity<Fornecedor> findById(@PathVariable Integer cnpjOuCpf) {
            Fornecedor obj = service.findById(cnpjOuCpf);
            return ResponseEntity.ok().body(obj);
        }

        @GetMapping
        public ResponseEntity<List<Fornecedor>> listFornecedores() {
            List<Fornecedor> fornecedores = service.listAllFornecedores();
            return ResponseEntity.ok().body(fornecedores);
        }

        @PostMapping
        public ResponseEntity<Fornecedor> create(@RequestBody Fornecedor fornecedor){
            fornecedor = service.create(fornecedor);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpjOuCpf}").buildAndExpand(fornecedor.getCnpjOuCpf()).toUri();
            return ResponseEntity.created(uri).build();
        }

        @DeleteMapping(value = "/{cnpjOuCpf}")
        public ResponseEntity<Void> delete(@PathVariable Integer cnpjOuCpf) {
            service.delete(cnpjOuCpf);
            return ResponseEntity.noContent().build();
        }

        @PutMapping(value = "/{cnpjOuCpf}")
        public ResponseEntity<Fornecedor> update(@PathVariable long cnpjOuCpf, @RequestBody Fornecedor fornecedor){
            Fornecedor newFornecedor = service.update(cnpjOuCpf, fornecedor);
            return ResponseEntity.ok().body(newFornecedor);
        }

    }
