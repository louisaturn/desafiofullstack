package com.louise.desafiofullstack.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cnpjOuCpf;
    private String nome;
    private String email;
    private Integer cep;
    private Integer rg;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;

    public Fornecedor(){
        super();
    }

    public Fornecedor(String cnpjOuCpf, String nome, String email, Integer cep, Integer rg, Date dataNascimento) {
        this.cnpjOuCpf = cnpjOuCpf;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }


    public String getCnpjOuCpf() {
        return cnpjOuCpf;
    }

    public void setCnpjOuCpf(String cnpjOuCpf) {
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
