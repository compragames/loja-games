/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Domain.Entity;

import br.com.lojagames.Application.Model.ClienteModel;
import br.com.lojagames.Application.Model.Model;
import java.sql.Timestamp;

/**
 *
 * @author gisidorio
 */
public class ClienteEntity extends Entity {

    ClienteModel clienteModel;

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }
    
    private int idCliente;
    private String nome;
    private String cpf;
    private String cnpj;
    private String dataNascimento;
    private String telefone;
    private String email;
    private String endereco;
    private String cep;
    private int usuario;
    private String senha;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    private String datainclusao;



    public String getDataInclusao() {
        return datainclusao;
    }

    public void setDataInclusao(String status) {
        this.datainclusao = status;
    }


    public ClienteEntity() {
    }

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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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


    @Override
    public Model getModel() {
        clienteModel = new ClienteModel();
        clienteModel.setIdCliente(idCliente);
        clienteModel.setNome(nome);
        clienteModel.setCpf(cpf);
        clienteModel.setCnpj(cnpj);
        clienteModel.setDataNascimento(dataNascimento);
        clienteModel.setTelefone(telefone);
        clienteModel.setEmail(email);
        clienteModel.setEndereco(endereco);
        clienteModel.setCep(cep);
        clienteModel.setUsuario(usuario);
        clienteModel.setSenha(senha);

        clienteModel.setDataInclusao(datainclusao);

        return clienteModel;
    }
    
}
