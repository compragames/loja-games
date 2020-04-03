/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.Model;

import br.com.lojagames.Domain.Entity.Entity;
import br.com.lojagames.Domain.Entity.FuncionarioEntity;
import java.sql.Timestamp;

/**
 *
 * @author lucas.sfaria5
 */
public class FuncionarioModel extends Model{
    
    private FuncionarioEntity fe;
    
    private int idfuncionario;
    private String nome;
    private String email;
    private String password;
    private String endereco;
    private String cep;
    private String cpf;
    private String dataNascimento;
    private String dtInclusao;
    private String tipo;
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
    private boolean admin;

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public FuncionarioModel() {
    }
    
    
    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(String dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        
    
    
    @Override
    public Entity getEntity() {
        fe = new FuncionarioEntity();
        fe.setEmail(email);
        fe.setPassword(password);
        fe.setIdfuncionario(idfuncionario);
        fe.setNome(nome);
        fe.setEndereco(endereco);
        fe.setCep(cep);
        fe.setCpf(cpf);
        fe.setDataNascimento(dataNascimento);
        fe.setDtInclusao(dtInclusao);
        fe.setTipo(tipo);
        return fe;
    }
    
}
