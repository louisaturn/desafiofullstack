package com.louise.desafiofullstack.resources;

import com.louise.desafiofullstack.domain.Empresa;
import com.louise.desafiofullstack.domain.EmpresaFornecedor;
import com.louise.desafiofullstack.service.EmpresaFornecedorService;
import com.louise.desafiofullstack.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/empresasfornecedores")

public class EmpresaFornecedorResource {
    @Autowired
    private EmpresaFornecedorService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmpresaFornecedor> findById(@PathVariable Integer id) {
        EmpresaFornecedor obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<EmpresaFornecedor>> listEmpresasFornecedores() {
        List<EmpresaFornecedor> obj = service.listAllEmpresasFornecedores();
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<EmpresaFornecedor> create(@RequestBody EmpresaFornecedor empresaFornecedor){
        empresaFornecedor = service.create(empresaFornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresaFornecedor.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmpresaFornecedor> update(@PathVariable Integer id, @RequestBody EmpresaFornecedor empresaFornecedor){
        EmpresaFornecedor newEmpresaFornecedor = service.update(id, empresaFornecedor);
        return ResponseEntity.ok().body(newEmpresaFornecedor);
    }

}
