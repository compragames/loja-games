package br.com.lojagames.Domain.Entity;

import br.com.lojagames.Application.Model.Model;
import br.com.lojagames.Application.Model.UsuarioModel;

/**
 *
 * @author Victor
 */
public class UserEntity extends Entity {

    private UsuarioModel userModel;

    // private UsuarioModel userModel;
   private int id;
    private String nome;
    private String login;
    private String senha;
    private String ultimoLogin;

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    private String token;
    private boolean isAdmin;

    public UserEntity() {
    }

    public UserEntity(UsuarioModel userModel) {
        this.id = userModel.getId();
        this.nome = userModel.getNome();
        this.login = userModel.getEmail();
        this.senha = userModel.getPassword();
     }

    public UserEntity(int id, String nome, String login, String senha, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UsuarioModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UsuarioModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public Model getModel() {
        userModel = new UsuarioModel();
        userModel.setId(id);
        userModel.setEmail(login);
        userModel.setNome(nome);
        userModel.setPassword(senha);
        userModel.setToken(token);
        return userModel;
    }

}
