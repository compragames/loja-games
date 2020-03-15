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
    public String insertProduto(
            @HeaderParam("Authorization") String header,
            @FormDataParam("image") InputStream fileInputStream,
            @FormDataParam("image") FormDataContentDisposition fileMetaData,
            @FormDataParam("image2") InputStream fileInputStream2,
            @FormDataParam("image2") FormDataContentDisposition fileMetaData2,
            @FormDataParam("image3") InputStream fileInputStream3,
            @FormDataParam("image3") FormDataContentDisposition fileMetaData3,
            @FormDataParam("produto") String content
    ) {
        //Token token = CreatedToken.decodeToken(header);
        ProdutoModel produtos = (ProdutoModel) this.gson.fromJson(content, ProdutoModel.class);

        File file = new UploadImageAWS().bytesToImage(fileInputStream, fileMetaData);
        File file2 = new UploadImageAWS().bytesToImage(fileInputStream2, fileMetaData2);
        File file3 = new UploadImageAWS().bytesToImage(fileInputStream3, fileMetaData3);

        return this.gson.toJson(this.iProdutoServices.cadastroProduto(produtos, ""));
    }

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Path("imagem/{id}")
    public String vincularImagemProduto(
            //@HeaderParam("Authorization") String header,
            @PathParam("id") int id,
            @FormDataParam("image") InputStream fileInputStream,
            @FormDataParam("image") FormDataContentDisposition fileMetaData
    ) {
        //Token token = CreatedToken.decodeToken(header);

        String imagem = new UploadImageAWS().upload(fileInputStream, fileMetaData);

        return this.gson.toJson(this.iProdutoServices.vincularImagemProduto(id, imagem, ""));
    }

}
