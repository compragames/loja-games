package br.com.lojagames.Domain.Interfaces;

import br.com.lojagames.Domain.Entity.Entity;
import br.com.lojagames.Domain.Entity.ProdutoEntity;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Victor
 */
public interface IProdutoRepository {

    public int inserir(ProdutoEntity produto, Connection conexao) throws SQLException;
     public int inserirImagem(int id,String file, Connection conexao) throws SQLException;
        

    public ResultSet buscaEstoque(Connection conexao, ProdutoEntity productEntity) throws SQLException;

    public void deletar(ProdutoEntity produto, Connection conexao) throws SQLException;
        
    public abstract List<ProdutoEntity> listaTodosProdutos(Connection connection) throws SQLException;

    public void modificandoFoto(ProdutoEntity produto, InputStream fileInputStream, Connection conexao) throws SQLException;

    public int modificandoProduto(ProdutoEntity produto, Connection conexao) throws SQLException;

    public ResultSet buscaPorId(ProdutoEntity produto, Connection conexao) throws SQLException;

}
