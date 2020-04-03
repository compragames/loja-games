package br.com.lojagames.Application.Model;

import br.com.lojagames.Domain.Entity.Entity;
import br.com.lojagames.Domain.Entity.UserEntity;

/**
 *
 * @author Victor
 */
public class UsuarioModel extends Model {

    private int id;
    private String nome;
    private String email;
    private String password;
    private String ultimoLogin;
    private boolean provider;
    private String token;
    private boolean isAdmin;
    private String nivel;

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

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public boolean isProvider() {
        return provider;
    }

    public void setProvider(boolean provider) {
        this.provider = provider;
    }
  

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    private UserEntity userEntity;

    public int getId()  {
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
        userEntity.setLogin(email);
        userEntity.setNome(nome);
        userEntity.setSenha(password);
        userEntity.setToken(token);
        

        return userEntity;

    }
}
