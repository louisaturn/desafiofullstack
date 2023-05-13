package com.louise.desafiofullstack.domain;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class EmpresaFornecedor implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Empresa empresa;
    private Fornecedor fornecedor;

    public EmpresaFornecedor(){
        super();
    }

    public EmpresaFornecedor(Integer id, Empresa empresa, Fornecedor fornecedor) {
        this.id = id;
        this.empresa = empresa;
        this.fornecedor = fornecedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
}
