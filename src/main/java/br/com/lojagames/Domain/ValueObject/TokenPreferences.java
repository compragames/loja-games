package br.com.lojagames.Domain.ValueObject;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Domain.Entity.UserEntity;
import br.com.lojagames.Interface.RestController.TokenPreferencesAbstract;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Date;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Victor
 */
public class TokenPreferences extends TokenPreferencesAbstract {

    private static final String KEY = "flatZyroT";

    @Override
    public boolean codificarToken(String token) {
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        int indexof = token.indexOf(".");
        int lasttindexof = token.lastIndexOf(".");
        String payLoad = token.substring(indexof + 1, lasttindexof);
        String tokenDecoded = null;
        try {
            tokenDecoded = new String(DatatypeConverter.parseBase64Binary(payLoad), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
        }
        com.google.gson.JsonObject jsonObject = parser.parse(tokenDecoded).getAsJsonObject();
        String TesteToken = token(jsonObject);
        return TesteToken.equals(token);
    }

    @Override
    public String header() {
        String typ = "jwt";
        String alg = "alg";
        com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
        jsonObject.addProperty(typ, "JWT");
        jsonObject.addProperty(alg, "HS256");
        Gson gson = new Gson();
        String header = gson.toJson(jsonObject);
        return Base64.getEncoder().encodeToString(header.getBytes());
    }

    @Override
    public String computeSignature(String baseString, String keyString) throws GeneralSecurityException, UnsupportedEncodingException {
        SecretKey secretKey = null;
        byte[] keyBytes = keyString.getBytes();
        secretKey = new SecretKeySpec(keyBytes, "HMACSHA256");
        Mac mac = Mac.getInstance("HMACSHA256");
        mac.init(secretKey);
        byte[] text = baseString.getBytes();
        return new String(Base64.getEncoder().encode(mac.doFinal(text))).trim();
    }

    @Override
    public boolean validaToken(String header) {
        Token token = (Token) decodeToken(header);
        return new Date().getTime() < token.getExp();
    }

    @Override
    public UserEntity tokemUser(String token) {
        int indexof = token.indexOf(".");
        int lasttindexof = token.lastIndexOf(".");
        String tokenPayload = token.substring(indexof + 1, lasttindexof);
        String tokenDecoded = null;
        try {
            tokenDecoded = new String(DatatypeConverter.parseBase64Binary(tokenPayload), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
        }
        Gson gson = new Gson();
        return gson.fromJson(tokenDecoded, UserEntity.class);
    }

    @Override
    public String token(com.google.gson.JsonObject payloadObject) {
        Gson gson = new Gson();
        String header = header();
        String payload = payload(payloadObject);
        try {
            String estrutura = header + "." + payload;
            String computeSignature = computeSignature(estrutura, KEY);
            return estrutura + "." + computeSignature;
        } catch (GeneralSecurityException | UnsupportedEncodingException e) {
            return "erro ao processar";
        }
    }

    @Override
    public String payload(com.google.gson.JsonObject object) {

        Gson gson = new Gson();
        String payload = gson.toJson(object);
        return Base64.getEncoder().encodeToString(payload.getBytes());

    }

    public static Token decodeToken(String token) {
        com.google.gson.JsonParser parser = new com.google.gson.JsonParser();
        Gson gson = new Gson();
        int indexOne = token.indexOf(".");
        int indexTwo = token.lastIndexOf(".");
        String tokenjwt = null;
        try {
            tokenjwt = new String(DatatypeConverter.parseBase64Binary(token.substring(indexOne + 1, indexTwo)), "UTF-8");
        } catch (UnsupportedEncodingException ex) {
        }
        com.google.gson.JsonObject jsonObject = parser.parse(tokenjwt).getAsJsonObject();
        return gson.fromJson(jsonObject, Token.class);
    }

    public static String newToken(Token token) {
        TokenPreferences jwt = new TokenPreferences();
        Date dateNow = new Date();
        Date expires = new Date(dateNow.getTime() + (1000 * 60 * 60 * 24));
        com.google.gson.JsonObject jsonObject = new com.google.gson.JsonObject();
        jsonObject.addProperty("iss", dateNow.getTime());
        jsonObject.addProperty("exp", expires.getTime());
        jsonObject.addProperty("id", token.getId());
        jsonObject.addProperty("dataCri", token.getDataCri());
        jsonObject.addProperty("dataVencimento", token.getDataVencimento());

        return jwt.token(jsonObject);
    }

    public static boolean verify(Token token) {
        return false;
    }
}
