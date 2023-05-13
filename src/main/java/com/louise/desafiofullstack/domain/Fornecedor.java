package com.louise.desafiofullstack.domain;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Set;

@Entity
@EntityScan
public class Fornecedor {

    @Id
    private long cnpjOuCpf;
    @ManyToMany(mappedBy = "fornecedores")
    Set<Empresa> empresas;
    private String nome;
    private String email;
    private Integer cep;
    private Integer rg;
    private String dataNascimento;

    public Fornecedor(){
        super();
    }

    public Fornecedor(long cnpjOuCpf, String nome, String email, Integer cep, Integer rg, String dataNascimento) {
        this.cnpjOuCpf = cnpjOuCpf;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }


    public long getCnpjOuCpf() {
        return cnpjOuCpf;
    }

    public void setCnpjOuCpf(long cnpjOuCpf) {
        this.cnpjOuCpf = cnpjOuCpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getRg() {
        return rg;
    }

    public void setRg(Integer rg) {
        this.rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}

