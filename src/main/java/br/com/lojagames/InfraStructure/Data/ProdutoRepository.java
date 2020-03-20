package br.com.lojagames.InfraStructure.Data;

/**
 *
 * @author Victor
 */
import br.com.lojagames.Domain.Entity.ImagemEntity;
import br.com.lojagames.Domain.Entity.ProdutoEntity;
import br.com.lojagames.Domain.Interfaces.IRepository;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;

import br.com.lojagames.Domain.Interfaces.IProdutoRepository;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository extends IRepository implements IProdutoRepository {

    @Override
    public int inserir(ProdutoEntity produto, Connection conexao) throws SQLException {
        //produto.setDisponivel(true);
        //editar query
        Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO Produto "
                + "(NOME, PLATAFORMA, QTDESTOQUE, VALORUNITARIO,DESCRICAO, IDEMPRESA,DATAINCLUSAO)"
                + "VALUES (?, ?, ?, ?, ?,?,?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setString(1, produto.getNome());
        prepareStatement.setString(2, produto.getPlataforma());
        prepareStatement.setDouble(3, produto.getQtdEstoque());
        prepareStatement.setDouble(4, produto.getValorUnitario());
           prepareStatement.setString(5,produto.getDescricao());
        prepareStatement.setInt(6, produto.getIdEmpresa());
     
        prepareStatement.setTimestamp(7, dataDeHoje);
     
        this.prepareStatement.executeUpdate();
        // generate key devolve a key que foi gerada no banco
        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        if (rs.next()) {
            produto.setIdProduto(rs.getInt(1));
        }
        return rs.getInt(1);
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

    @Override
    public List<ProdutoEntity> listaTodosProdutos(Connection connection) throws SQLException {
        StringBuilder query = new StringBuilder();
        List<ProdutoEntity> list = new ArrayList<>();

        query.append("select * from produto");
        this.prepareStatement = connection.prepareStatement(query.toString());

        ResultSet rs = prepareStatement.executeQuery();
        while (rs.next()) {
            ProdutoEntity produtoEt = new ProdutoEntity();
            produtoEt.setIdProduto(rs.getInt(1));
            produtoEt.setNome(rs.getString(2));
            produtoEt.setPlataforma(rs.getString(3));
            produtoEt.setQtdEstoque(rs.getInt(4));
            produtoEt.setValorUnitario(rs.getDouble(5));
            produtoEt.setDescricao(rs.getString(6));
            produtoEt.setIdEmpresa(rs.getInt(7));
            produtoEt.setDataInclusao(rs.getString(8));

            list.add(produtoEt);
        }
        return list;
    }

    @Override
    public int inserirImagem(int id, String nome, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO imagens (NOME, IDPRODUTO) VALUES (?, ?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setString(1, nome);
        prepareStatement.setInt(2, id);
        this.prepareStatement.executeUpdate();
        // generate key devolve a key que foi gerada no banco
        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
if(rs.next()){

           rs.getInt(1);

        }
        return rs.getInt(1);

    }

    @Override
    public List<ImagemEntity> listaImagem(int idProduto ,Connection connection) throws SQLException {
        
    StringBuilder query = new StringBuilder();
        List<ImagemEntity> list = new ArrayList<>();
        

        query.append("select * from imagem where idProduto = ?");
        this.prepareStatement = connection.prepareStatement(query.toString());
         prepareStatement.setInt(1, idProduto);

        ResultSet rs = prepareStatement.executeQuery();
        while (rs.next()) {
            ImagemEntity imagem = new ImagemEntity();
            imagem.setIdImagem(rs.getInt(1));
            imagem.setIdProduto(rs.getInt(2));
            imagem.setImgUso(rs.getBoolean(3));
            imagem.setUrl(rs.getString(4));
       

            list.add(imagem);
        }
        return list;
    }


}
