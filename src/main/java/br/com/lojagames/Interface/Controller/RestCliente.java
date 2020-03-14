/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Interface.Controller;

import br.com.lojagames.Application.IService.IClienteServices;
import br.com.lojagames.Application.Model.ClienteModel;
import com.google.gson.Gson;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author gabri
 */
@Path("cliente")
public class RestCliente {
    
    private final IClienteServices iClienteServices;
    
    @Context
    private UriInfo context;
    private final Gson gson;
    
    @Inject
    public RestCliente(IClienteServices iClienteServices) {
        this.iClienteServices = iClienteServices;
        gson = new Gson();
    }
    
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("insert")
    public String insert(@FormDataParam("cliente") String content) {
        ClienteModel cliente = (ClienteModel) this.gson.fromJson(content, ClienteModel.class);
        return this.gson.toJson(this.iClienteServices.cadastrarCliente(cliente, ""));
    }
}
