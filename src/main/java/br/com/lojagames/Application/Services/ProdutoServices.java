package br.com.lojagames.Application.Services;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Application.IService.IProdutoServices;
import br.com.lojagames.Application.Model.Model;
import br.com.lojagames.Application.Model.ProdutoModel;
import br.com.lojagames.Application.Model.ReturnModel;
import br.com.lojagames.Domain.ValueObject.CreatedToken;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

public class ProdutoServices extends Services implements IProdutoServices<Model> {

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
    public List<Model> getProduto(List<ProdutoModel> produtos) {
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

}
