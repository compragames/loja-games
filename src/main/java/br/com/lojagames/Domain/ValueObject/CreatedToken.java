/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Domain.ValueObject;

import br.com.lojagames.Interface.RestController.CreatedTokenAbstract;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 *
 * @author Victor
 */
public class CreatedToken  extends CreatedTokenAbstract{

    @Override
    public boolean codificarToken(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String header() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validaToken(String header) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
