package br.com.lojagames.Application.Services;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Application.IService.IProdutoServices;
import br.com.lojagames.Application.Model.Model;
import br.com.lojagames.Application.Model.ProdutoModel;
import br.com.lojagames.Application.Model.ReturnModel;
import br.com.lojagames.Domain.Entity.Entity;
import br.com.lojagames.Domain.Entity.ProdutoEntity;
import br.com.lojagames.Domain.Interfaces.IProdutoRepository;
import br.com.lojagames.InfraStructure.ExternalServices.UploadImageAWS;
import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public class ProdutoServices extends Services implements IProdutoServices<Model> {

    @Inject
    private IProdutoRepository iProdutoRepository;

    private ResultSet rs = null;

    public ProdutoServices() {
    }

    @Override
    public Model cadastroProduto(ProdutoModel produto, Token token) {

        ReturnModel retorno = new ReturnModel();
        try {

            getConnectOpen();
//metodo de inserir produto no banco 
            return retorno;

        } catch (SQLException e) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar cadastrar produto");
            return retorno;
        }

    }

    @Override
    public Model deletarProduto(ProdutoModel produto, Token token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model modificarFoto(ProdutoModel produto, Token token, InputStream fileInputStream) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model modificarProduto(ProdutoModel produto, Token token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model updateProduto(ProdutoModel produto, Token token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model cadastroProduto(ProdutoModel produto, String token, File file) {
        ReturnModel retorno = new ReturnModel();

        try {
            UploadImageAWS updateImageAWS = new UploadImageAWS();

            //verifica o token 
            //verifica permissao
            getConnectOpen();
//metodo de inserir produto no banco 
  //produto.setImage(updateImageAWS.upload(file));
            int id = iProdutoRepository.inserir((ProdutoEntity) produto.getEntity(), getConnect());
          
            produto.setIdProduto(id);
            getConnectClose();
            retorno.setRetorno(true);
            retorno.setTxtRetorno("Produto cadastrado com sucesso");
            retorno.setId(id);
            return retorno;

        } catch (SQLException e) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar cadastrar produto");
            return retorno;
        }
    }

    @Override
    public List<Model> listarProdutos() {
            List<Model> models = new ArrayList();
          
         try {
          
            getConnectOpen();
   //rs =  iProdutoRepository.listaTodosProdutos(getConnect());
              
              iProdutoRepository.listaTodosProdutos(getConnect()).forEach(item -> {
                models.add(((ProdutoEntity) item).getModel());
            });

             getConnectClose();
            return models;
        } catch (SQLException e) {
            getConnectClose();
            return null;
        }}


    @Override
    public Object inserirImagem(int id, InputStream fileInputStream, FormDataContentDisposition fileMetaData) {
   String path = null;
          ReturnModel retorno = new ReturnModel();
          File img = new File(path);
          

        try {
            //verifica o token 
            //verifica permissao
            getConnectOpen();
//metodo de inserir produto no banco 
         System.out.println(fileInputStream);
            getConnectClose();
            retorno.setRetorno(true);
            retorno.setTxtRetorno("Imagem cadastrada com sucesso");
            retorno.setId(id);
            return retorno;

        } catch (SQLException e) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar cadastrar produto");
            return retorno;
        }
        
    }

  

}
