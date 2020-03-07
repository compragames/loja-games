package br.com.lojagames.InfraStructure.Data;

/**
 *
 * @author Victor
 */


import br.com.lojagames.Domain.Entity.ProdutoEntity;
import br.com.lojagames.Domain.Interfaces.IRepository;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;


import br.com.lojasgames.Domain.Interfaces.IProdutoRepository;
import java.sql.SQLException;



public class ProdutoRepository extends IRepository implements IProdutoRepository {

    @Override
    public int inserir(ProdutoEntity produto, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet busca(Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet buscaEstoque(Connection conexao, ProdutoEntity productEntity) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(ProdutoEntity produto, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificandoFoto(ProdutoEntity produto, InputStream fileInputStream, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificandoProduto(ProdutoEntity produto, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet buscaPorId(ProdutoEntity produto, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}

