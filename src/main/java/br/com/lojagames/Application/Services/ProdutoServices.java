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
import java.util.logging.Level;
import java.util.logging.Logger;
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
        ReturnModel retorno = new ReturnModel();
        try {

            getConnectOpen();

            return retorno;

        } catch (SQLException e) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar editar produto");
            return retorno;
        }
    }

    @Override
    public Model updateProduto(ProdutoModel produto, Token token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model cadastroProduto(ProdutoModel produto, String token) {
        ReturnModel retorno = new ReturnModel();
        try {
            //verifica o token 
            //verifica permissao
            getConnectOpen();
            int id = iProdutoRepository.inserir((ProdutoEntity) produto.getEntity(), getConnect());
                    

            retorno.setRetorno(true);
            retorno.setTxtRetorno("Produto cadastrado com sucesso");
            retorno.setId(id);
            getConnectClose();
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
                try {
                    item.setImagens(iProdutoRepository.listaImagem(item.getIdProduto(),  getConnect()));
                    System.out.println(item);
                } catch (SQLException ex) {
                    System.out.println("O erro ao listar imagem"+ex);
                }
                models.add(((ProdutoEntity)item).getModel());
                
            });
            
        
            getConnectClose();
            return models;
        } catch (SQLException e) {
            getConnectClose();
            return null;
        }
    }
@Override
 public List<Model> listarProdutosFaq() {
        List<Model> models = new ArrayList();
        try {
            getConnectOpen();
            //rs =  iProdutoRepository.listaTodosProdutos(getConnect());
            iProdutoRepository.listaTodosProdutos(getConnect()).forEach(item -> {
                try {
                    item.setImagens(iProdutoRepository.listaImagem(item.getIdProduto(),  getConnect()));
                    System.out.println(item);
                } catch (SQLException ex) {
                    System.out.println("O erro ao listar imagem"+ex);
                }
               
                try {
                    item.setFaq(iProdutoRepository.listaFaq(item.getIdProduto(),  getConnect()));
                } catch (SQLException ex) {
                    Logger.getLogger(ProdutoServices.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                models.add(((ProdutoEntity)item).getModel());
                
            });
            
        
            getConnectClose();
            return models;
        } catch (SQLException e) {
            getConnectClose();
            return null;
        }
    }

    @Override
    public Model vincularImagemProduto(int produto, String nomeImagem, String token) {
           ReturnModel retorno = new ReturnModel();
           nomeImagem = "https://arquivos-compragames.s3.amazonaws.com/public/" + nomeImagem;
     try {
            //verifica o token 
            //verifica permissao
            getConnectOpen();
            int id = iProdutoRepository.inserirImagem(produto, nomeImagem, getConnect());
                    
            retorno.setRetorno(true);
            retorno.setTxtRetorno("Imagem inserida com sucesso");
            retorno.setId(id);
            getConnectClose();
            return retorno;

        } catch (SQLException e) {
            System.out.println(e);
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar inserir imagem");
            return retorno;
        }    
    
    
    }

    @Override
    public Model modificarProduto(ProdutoModel produto, String token) {
        ReturnModel retorno = new ReturnModel();
        try {
            //verifica o token 
            //verifica permissao
            getConnectOpen();
            int id = iProdutoRepository.modificandoProduto((ProdutoEntity) produto.getEntity(), getConnect());
                    

            retorno.setRetorno(true);
            retorno.setTxtRetorno("Produto editado com sucesso");
            retorno.setId(id);
            getConnectClose();
            return retorno;

        } catch (SQLException e) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar editar produto");
            return retorno;
        }
    }

}
