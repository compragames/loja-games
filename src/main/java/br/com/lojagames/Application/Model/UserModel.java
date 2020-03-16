package br.com.lojagames.Application.Model;

import br.com.lojagames.Domain.Entity.Entity;
import br.com.lojagames.Domain.Entity.UserEntity;

/**
 *
 * @author Victor
 */
public class UserModel extends Model {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String emailAlternativo;
    private String confereSenha;
    private String dataCri;
    private String token;
    private boolean isAdmin;

    private UserEntity userEntity;

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

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public Entity getEntity() {
        userEntity = new UserEntity();
        userEntity.setConfereSenha(confereSenha);
        userEntity.setDataCri(dataCri);
        userEntity.setLogin(login);
        userEntity.setNome(nome);
        userEntity.setSenha(senha);
        userEntity.setToken(token);

        return userEntity;

    }
}
