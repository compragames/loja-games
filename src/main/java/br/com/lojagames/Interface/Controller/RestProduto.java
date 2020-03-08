/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Interface.Controller;

import br.com.lojagames.Application.IService.IProdutoServices;
import br.com.lojagames.Application.Model.ProdutoModel;
import com.google.gson.Gson;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("produto")
public class RestProduto {

    private final IProdutoServices iProdutoServices;

    @Context
    private UriInfo context;
    private final Gson gson;

    @Inject
    public RestProduto(IProdutoServices iProdutoServices) {
        this.iProdutoServices = iProdutoServices;
        gson = new Gson();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public String getList() {
        ProdutoModel produto = new ProdutoModel();

        return this.gson.toJson(this.iProdutoServices.listarProdutos());
    }

    //  @Safe
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("insert")
    public String insertPost(String content, @HeaderParam("Authorization") String header) {
        //Token token = CreatedToken.decodeToken(header);
        ProdutoModel produtos = (ProdutoModel) this.gson.fromJson(content, ProdutoModel.class);

        return this.gson.toJson(this.iProdutoServices.cadastroProduto(produtos, ""));
    }
}
