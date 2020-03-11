/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Domain.Entity;

import br.com.lojagames.Application.Model.FuncionarioModel;
import br.com.lojagames.Application.Model.Model;
import java.sql.Timestamp;

/**
 *
 * @author lucas.sfaria5
 */
public class FuncionarioEntity extends Entity {
    private int idfuncionario;
    private String nome;
    private String endereco;
    private String cep;
    private String cpf;
    private Timestamp dataNascimento;
    private Timestamp dtInclusao;
    private String tipo;

    public FuncionarioEntity() {
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

    public Timestamp getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Timestamp dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Timestamp getDtInclusao() {
        return dtInclusao;
    }

    public void setDtInclusao(Timestamp dtInclusao) {
        this.dtInclusao = dtInclusao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Model getModel() {
        FuncionarioModel fm = new FuncionarioModel();
            
        fm.setIdfuncionario(idfuncionario);
        fm.setNome(nome);
        fm.setEndereco(endereco);
        fm.setCep(cep);
        fm.setCpf(cpf);
        fm.setDataNascimento(dataNascimento);
        fm.setDtInclusao(dtInclusao);
        
        return fm;
    }
}
