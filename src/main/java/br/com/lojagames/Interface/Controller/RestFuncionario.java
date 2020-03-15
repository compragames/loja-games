/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Interface.Controller;

import br.com.lojagames.Application.IService.IFuncionarioServices;
import br.com.lojagames.Application.Model.FuncionarioModel;
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

/**
 *
 * @author lucas
 */
@Path("funcionario")
public class RestFuncionario {
    private final IFuncionarioServices iFuncionarioServices;

    @Context
    private UriInfo context;
    private final Gson gson;

    @Inject
    public RestFuncionario(IFuncionarioServices iFuncionarioServices) {
        this.iFuncionarioServices = iFuncionarioServices;
        gson = new Gson();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public String getList() {
        FuncionarioModel f = new FuncionarioModel();
        
        return this.gson.toJson(this.iFuncionarioServices.listarFuncionario());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("insert")
    public String insert(String content) {
        FuncionarioModel funcionario = (FuncionarioModel) this.gson.fromJson(content, FuncionarioModel.class);
        return this.gson.toJson(this.iFuncionarioServices.cadastroFuncionario(funcionario, ""));
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("update")
    public String update(String content) {
        FuncionarioModel funcionario = (FuncionarioModel) this.gson.fromJson(content, FuncionarioModel.class);
        return this.gson.toJson(this.iFuncionarioServices.updateFuncionario(funcionario, ""));
    }
}
