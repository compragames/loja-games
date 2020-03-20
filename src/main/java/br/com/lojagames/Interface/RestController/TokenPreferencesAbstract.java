package br.com.lojagames.Interface.RestController;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Domain.Entity.UserEntity;
import com.google.gson.JsonObject;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/**
 *
 * @author Victor
 */
public abstract class TokenPreferencesAbstract extends Token {

    public TokenPreferencesAbstract() {
        super();
    }

    public abstract boolean codificarToken(String token);

    public abstract UserEntity tokemUser(String token);

    public abstract String payload(JsonObject object);

    public abstract String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException;

    public abstract String header();

    public abstract String token(JsonObject payloadObject);

    public abstract boolean validaToken(String header);
}
