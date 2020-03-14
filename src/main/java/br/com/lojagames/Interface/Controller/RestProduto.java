package br.com.lojagames.Interface.Controller;

import br.com.lojagames.Application.IService.IProdutoServices;
import br.com.lojagames.Application.Model.ProdutoModel;
import br.com.lojagames.InfraStructure.ExternalServices.UploadImageAWS;
import com.google.gson.Gson;
import java.io.File;
import java.io.InputStream;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

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
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("insert")
    public String insertPost(
            @HeaderParam("Authorization") String header,
            @FormDataParam("image") InputStream fileInputStream,
            @FormDataParam("image") FormDataContentDisposition fileMetaData,
           @FormDataParam("image2") InputStream fileInputStream2,
            @FormDataParam("image2") FormDataContentDisposition fileMetaData2,
            @FormDataParam("produto") String content
    ) {
        //Token token = CreatedToken.decodeToken(header);
        ProdutoModel produtos = (ProdutoModel) this.gson.fromJson(content, ProdutoModel.class);
         
        //bytesToImage(fileInputStream, fileMetaData);
        File file = new UploadImageAWS().bytesToImage(fileInputStream, fileMetaData);

        return this.gson.toJson(this.iProdutoServices.cadastroProduto(produtos, "",file));
    }

    //@Safe
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("image/{id}")
    public String insert(
            @FormDataParam("image") InputStream fileInputStream,
            @FormDataParam("image") FormDataContentDisposition fileMetaData,
            @PathParam("id") int id
    ) {

        // Token token = CreatedToken.decodeToken(header);
        return this.gson.toJson(this.iProdutoServices.inserirImagem(id, fileInputStream, fileMetaData));
    }
}
