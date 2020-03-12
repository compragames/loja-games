/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.Model;

import br.com.lojagames.Domain.Entity.ClienteEntity;
import br.com.lojagames.Domain.Entity.Entity;
import java.sql.Timestamp;

/**
 *
 * @author gisidorio
 */
public class ClienteModel extends Model {

    private ClienteEntity clienteEntity;
    
    private int idCliente;
    private String nome;
    private String cpf;
    private String cnpj;
    private Timestamp dataNascimento;
    private String telefone;
    private String email;
    private String endereco;
    private String cep;
    private String tipo;

    public ClienteModel() {}

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Entity getEntity() {
        clienteEntity = new ClienteEntity();
        clienteEntity.setNome(nome);
        clienteEntity.setCpf(cpf);
        clienteEntity.setCnpj(cnpj);
        clienteEntity.setDataNascimento(dataNascimento);
        clienteEntity.setTelefone(telefone);
        clienteEntity.setEmail(email);
        clienteEntity.setEndereco(endereco);
        clienteEntity.setCep(cep);
        clienteEntity.setTipo(tipo);
        return clienteEntity;
        
    }

}