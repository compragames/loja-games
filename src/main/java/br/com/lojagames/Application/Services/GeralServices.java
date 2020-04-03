/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.Services;

import br.com.lojagames.Application.Model.UsuarioModel;
import br.com.lojagames.Application.Model.temp.UserPost;
import br.com.lojagames.Domain.Entity.UserEntity;
import br.com.lojagames.Domain.Interfaces.IUserRepository;
import java.sql.ResultSet;
import javax.inject.Inject;

/**
 *
 * @author gabri
 */
public class GeralServices extends Services{
       @Inject
    private IUserRepository iUserRepository;
    
    private ResultSet rs = null;
    public boolean Post(UserPost user) {
        UserEntity cadastro = new UserEntity();
        cadastro.setNome(user.getName());
        cadastro.setLogin(user.getEmail());
        cadastro.setSenha(user.getPassword());
         return   iUserRepository.inserirUsuario(cadastro, 0, getConnect());
        
        
       
    }
    
    
}
