package br.com.lojagames.Application.Services;

import br.com.lojagames.Application.IService.IProdutoServices;
import br.com.lojagames.Application.IService.IUserServices;
import br.com.lojagames.Application.Model.Model;
import br.com.lojagames.Application.Model.ReturnModel;
import br.com.lojagames.Application.Model.UsuarioModel;
import br.com.lojagames.Domain.Interfaces.IProdutoRepository;
import br.com.lojagames.Domain.Interfaces.IUserRepository;
import br.com.lojagames.Domain.ValueObject.TokenPreferences;
import br.com.lojagames.Interface.RestController.TokenPreferencesAbstract;
import com.google.gson.JsonObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.inject.Inject;

/**
 *
 * @author Victor
 */
public class UserServices extends Services implements IUserServices<Model> {
    
    @Inject
    private IUserRepository iUserRepository;
    
    private ResultSet rs = null;
    
    @Override
    public Model userInfo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Model modificarPerfil() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Model deletarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Model recuperarSenha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Model autenticar(UsuarioModel usuario) {
        ReturnModel retorno = new ReturnModel();
        try {
            
            TokenPreferences token = new TokenPreferences();
              getConnectOpen();
          UsuarioModel user =   iUserRepository.buscarUsuario(usuario.getEmail(), usuario.getPassword(), getConnect());
            
                 Date dateNow = new Date();
                Date expires = new Date(dateNow.getTime() + (1000 * 60 * 60 * 72));
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("iss", dateNow.getTime());
                jsonObject.addProperty("exp", expires.getTime());
                jsonObject.addProperty("id", user.getId());
                jsonObject.addProperty("nivelAcesso", user.getNivel());
                
                getConnectClose();
                retorno.setTxtRetorno(token.token(jsonObject));
                retorno.setRetorno(true);
      
          
            
            return retorno;
        } catch (SQLException e) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar realizar o login");
            return retorno;
        }
        
    }
    
}
