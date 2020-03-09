package br.com.lojasgames.Domain.Interfaces;

import br.com.lojagames.Domain.Entity.ProdutoEntity;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Victor
 */
public interface IProdutoRepository {

    public int inserir(ProdutoEntity produto, Connection conexao) throws SQLException;
     public int inserirImagem(int id, Connection conexao) throws SQLException;

    public ResultSet busca(Connection conexao) throws SQLException;

    public ResultSet buscaEstoque(Connection conexao, ProdutoEntity productEntity) throws SQLException;

    public void deletar(ProdutoEntity produto, Connection conexao) throws SQLException;

    public void modificandoFoto(ProdutoEntity produto, InputStream fileInputStream, Connection conexao) throws SQLException;

    public int modificandoProduto(ProdutoEntity produto, Connection conexao) throws SQLException;

    public ResultSet buscaPorId(ProdutoEntity produto, Connection conexao) throws SQLException;

}
