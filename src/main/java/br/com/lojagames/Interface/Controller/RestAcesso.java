package br.com.lojagames.Interface.Controller;


import br.com.lojagames.Application.IService.IUserServices;
import br.com.lojagames.Application.Model.ClienteModel;
import br.com.lojagames.Application.Model.ProdutoModel;
import br.com.lojagames.Application.Model.UsuarioModel;
import com.google.gson.Gson;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;



@Path("session")
public class RestAcesso {
    
    private final IUserServices iUserServices;
    
    @Context
    private UriInfo context;
    private final Gson gson;

    @Inject
    public RestAcesso(IUserServices iAcessoServices) {
        this.iUserServices = iAcessoServices;
        gson = new Gson();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("login")
    public String Login(String credenciais) {
      //Token token = CreatedToken.decodeToken(header);
      UsuarioModel usuario = (UsuarioModel) this.gson.fromJson(credenciais, UsuarioModel.class);
        return this.gson.toJson(this.iUserServices.autenticar(usuario));
    }

  
}
