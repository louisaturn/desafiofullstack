package com.louise.desafiofullstack.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Empresa {

    private static final long serialVersionUID = 1L;
    @Id
    private long cnpj;

    @ManyToMany
    @JoinTable(
        name = "empresa_fornecedor",
        joinColumns = @JoinColumn(name = "cnpj"),
        inverseJoinColumns = @JoinColumn(name = "cnpjOuCpf"))
    Set<Fornecedor> fornecedores;
    private String nomeFantasia;
    private Integer cep;

    public Empresa(){
        super();
    }
    public Empresa(long cnpj, String nomeFantasia, Integer cep) {
        super();
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.cep = cep;
        this.fornecedores = new HashSet<Fornecedor>();
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Set<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(Set<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(cnpj, empresa.cnpj) && Objects.equals(nomeFantasia, empresa.nomeFantasia) && Objects.equals(cep, empresa.cep);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnpj, nomeFantasia, cep);
    }

}
