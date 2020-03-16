package br.com.lojagames.Domain.ValueObject;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Domain.Entity.UserEntity;
import br.com.lojagames.Interface.RestController.TokenPreferencesAbstract;
import com.google.gson.Gson;
import com.mysql.cj.xdevapi.JsonParser;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.json.JsonObject;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Victor
 */
public class CreatedToken  extends TokenPreferencesAbstract{

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
    
       public static String decodeToken(String token) {
//        JsonParser parser = new JsonParser();
//        Gson gson = new Gson();
//        int indexOne = token.indexOf(".");
//        int indexTwo = token.lastIndexOf(".");
//        String tokenjwt = null;
//        try {
//            tokenjwt = new String(DatatypeConverter.parseBase64Binary(token.substring(indexOne + 1, indexTwo)), "UTF-8");
//        } catch (UnsupportedEncodingException ex) {
//        }
//        JsonObject jsonObject = parser.parseString(tokenjwt).getAsJsonObject();
//        
//    return gson.fromJson(jsonObject, Token.class);
return "";

    }

    @Override
    public UserEntity tokemUser(String token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public String token(com.google.gson.JsonObject payloadObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
