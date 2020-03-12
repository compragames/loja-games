package br.com.lojagames.Application.IService;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Application.Model.ProdutoModel;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

public interface IProdutoServices<T> {

    public T cadastroProduto(ProdutoModel produto, Token token);
    

    public T cadastroProduto(ProdutoModel produto, String token,File file);

    public T deletarProduto(ProdutoModel produto, Token token);

    public List<T> getProduto(List<ProdutoModel> produtos);
     public List<T> listarProdutos();

    public T modificarFoto(ProdutoModel produto, Token token, InputStream fileInputStream);

    public T modificarProduto(ProdutoModel produto, Token token);

    public T updateProduto(ProdutoModel produto, Token token);

    public Object inserirImagem(int id, InputStream fileInputStream, FormDataContentDisposition fileMetaData);



}
