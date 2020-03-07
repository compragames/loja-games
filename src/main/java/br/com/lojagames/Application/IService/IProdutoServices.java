package br.com.lojagames.Application.IService;


import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Application.Model.ProdutoModel;
import java.io.InputStream;
import java.util.List;


public interface IProdutoServices<T> {


    public T cadastroProduto(ProdutoModel produto, Token token);

    public T deletarProduto(ProdutoModel produto, Token token);

    public List<T> getProduto(List<ProdutoModel> produtos);

    public T modificarFoto(ProdutoModel produto, Token token,InputStream fileInputStream);

    public T modificarProduto(ProdutoModel produto, Token token);

    public T updateProduto(ProdutoModel produto, Token token);

    

}

    

