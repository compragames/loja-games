/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Interface.Controller.temp;



import br.com.lojagames.Application.IService.IUserServices;
import br.com.lojagames.Application.Model.ClienteModel;
import br.com.lojagames.Application.Model.ProdutoModel;
import br.com.lojagames.Application.Model.UsuarioModel;
import br.com.lojagames.Application.Model.temp.UserPost;
import br.com.lojagames.Application.Services.GeralServices;
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



@Path("/geral")
public class RestUsers {
    
    private final GeralServices generalServices = new GeralServices();
    
    @Context
    private UriInfo context;
    private final Gson gson;

    @Inject
    public RestUsers() {
         gson = new Gson();
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/users")
    public String Login() {
      
    UserPost userPost = new UserPost();
        return this.gson.toJson(this.generalServices.Post(userPost));
    }

  
}
