/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Interface.Controller;

import br.com.lojagames.Application.DTO.Token;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 *
 * @author Victor
 */
public abstract class CreatedTokenAbstract extends Token {
    
    public CreatedTokenAbstract() {
        super();
    }

    public abstract boolean codificarToken(String token);

   // public abstract UserEntity tokemUser(String token);

    public abstract String header();

 
    public abstract String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException;

    
    public abstract boolean validaToken(String header);
    
}
