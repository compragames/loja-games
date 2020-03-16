/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Domain.Entity;

import br.com.lojagames.Application.Model.Model;
import br.com.lojagames.Application.Model.UserModel;

/**
 *
 * @author Victor
 */
public class UserEntity extends Entity {

    private UserModel userModel;

    // private UserModel userModel;
    private int id;
    private String nome;
    private String login;
    private String senha;
    private String emailAlternativo;
    private String confereSenha;
    private String dataCri;
    private String token;
    private boolean isAdmin;

    public UserEntity() {
    }

    public UserEntity(UserModel userModel) {
        this.id = userModel.getId();
        this.nome = userModel.getNome();
        this.login = userModel.getLogin();
        this.senha = userModel.getSenha();
        this.emailAlternativo = userModel.getEmailAlternativo();
        this.confereSenha = userModel.getConfereSenha();
        this.dataCri = userModel.getDataCri();

    }

    public UserEntity(int id, String nome, String login, String senha, String cnpj, String emailAlternativo) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.emailAlternativo = emailAlternativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmailAlternativo() {
        return emailAlternativo;
    }

    public void setEmailAlternativo(String emailAlternativo) {
        this.emailAlternativo = emailAlternativo;
    }

    public String getConfereSenha() {
        return confereSenha;
    }

    public void setConfereSenha(String confereSenha) {
        this.confereSenha = confereSenha;
    }

    public String getDataCri() {
        return dataCri;
    }

    public void setDataCri(String dataCri) {
        this.dataCri = dataCri;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Model getModel() {
        userModel = new UserModel();
        userModel.setConfereSenha(confereSenha);
        userModel.setDataCri(dataCri);
        userModel.setEmailAlternativo(emailAlternativo);
        userModel.setId(id);
        userModel.setLogin(login);
        userModel.setNome(nome);
        userModel.setSenha(senha);
        userModel.setToken(token);
        return userModel;
    }

}
