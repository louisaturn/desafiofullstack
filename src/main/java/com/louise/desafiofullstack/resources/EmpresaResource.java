package com.louise.desafiofullstack.resources;

import com.louise.desafiofullstack.domain.Empresa;
import com.louise.desafiofullstack.domain.Fornecedor;
import com.louise.desafiofullstack.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {

    @Autowired
    private EmpresaService service;

    @GetMapping(value = "/{cnpj}")
    public ResponseEntity<Empresa> findById(@PathVariable String cnpj) {
        Empresa obj = service.findById(cnpj);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> listEmpresas() {
        List<Empresa> empresas = service.listAllEmpresas();
        return ResponseEntity.ok().body(empresas);
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@RequestBody Empresa empresa){
        empresa = service.create(empresa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cnpj}").buildAndExpand(empresa.getCnpj()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{cnpj}")
    public ResponseEntity<Void> delete(@PathVariable String cnpj) {
        service.delete(cnpj);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{cnpj}")
    public ResponseEntity<Empresa> update(@PathVariable String cnpj, @RequestBody Empresa empresa){
        Empresa newEmpresa = service.update(cnpj, empresa);
        return ResponseEntity.ok().body(newEmpresa);
    }

    @PutMapping(value= "/novofornecedor/{cnpj}")
    public ResponseEntity<Empresa> newFornecedor(@PathVariable String cnpj, @RequestBody Fornecedor fornecedor) {
        Empresa empresa = service.findById(cnpj);
        empresa.getFornecedores().add(fornecedor);
        service.update(cnpj, empresa);
        return ResponseEntity.ok().body(empresa);
    }
}
