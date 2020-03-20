/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.InfraStructure.Data;

import br.com.lojagames.Domain.Entity.FuncionarioEntity;
import br.com.lojagames.Domain.Interfaces.IFuncionarioRepository;
import br.com.lojagames.Domain.Interfaces.IRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lucas.sfaria5
 */
public class FuncionarioRepository extends IRepository implements IFuncionarioRepository{

    @Override
    public int inserir(FuncionarioEntity funcionario, Connection conexao) throws SQLException {
        Timestamp tsDtNascimento = Timestamp.valueOf(funcionario.getDataNascimento());
        Timestamp tsDtInclusao = Timestamp.valueOf(funcionario.getDtInclusao());
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO FUNCIONARIO "
                + "(NOME, ENDERECO, CEP, CPF, DATANASCIMENTO, DTINCLUSAO, TIPO)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setString(1, funcionario.getNome());
        prepareStatement.setString(2, funcionario.getEndereco());
        prepareStatement.setString(3, funcionario.getCep());
        prepareStatement.setString(4, funcionario.getCpf());
        prepareStatement.setTimestamp(5, tsDtNascimento);
        prepareStatement.setTimestamp(6, tsDtInclusao);
        prepareStatement.setString(7, funcionario.getTipo());
        this.prepareStatement.executeUpdate();
        
        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        
        if (rs.next()) 
            funcionario.setIdfuncionario(rs.getInt(1));
        
        return rs.getInt(1);
    }

    @Override
    public ResultSet busca(Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FuncionarioEntity> listaFuncionarios(Connection connection) throws SQLException {
        StringBuilder query = new StringBuilder();
        List<FuncionarioEntity> list = new ArrayList<>();
     
        query.append("SELECT * FROM FUNCIONARIO");
        this.prepareStatement = connection.prepareStatement(query.toString());

        ResultSet rs = prepareStatement.executeQuery();
        while (rs.next()) {
            FuncionarioEntity fe = new FuncionarioEntity();
            fe.setIdfuncionario(rs.getInt(1));
            fe.setNome(rs.getString(2));
            fe.setEndereco(rs.getString(3));
            fe.setCep(rs.getString(4));
            fe.setCpf(rs.getString(5));
            fe.setDataNascimento(rs.getString(6));
            fe.setDtInclusao(rs.getString(7));
            fe.setTipo(rs.getString(8));
            list.add(fe);
        }
        return list;
    }

    @Override
    public void deletar(FuncionarioEntity funcionario, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet buscaPorId(FuncionarioEntity funcionario, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editarFuncionario(FuncionarioEntity funcionario, Connection conexao) throws SQLException {
        Timestamp tsDtNascimento = Timestamp.valueOf(funcionario.getDataNascimento());
        Timestamp tsDtInclusao = Timestamp.valueOf(funcionario.getDtInclusao());
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE FUNCIONARIO "
                + "SET NOME = ?, ENDERECO = ?, CEP = ?, CPF = ?, DATANASCIMENTO = ?, "
                + "DTINCLUSAO = ?, TIPO = ?"
                + "WHERE IDFUNCIONARIO = ?");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setString(1, funcionario.getNome());
        prepareStatement.setString(2, funcionario.getEndereco());
        prepareStatement.setString(3, funcionario.getCep());
        prepareStatement.setString(4, funcionario.getCpf());
        prepareStatement.setTimestamp(5, tsDtNascimento);
        prepareStatement.setTimestamp(6, tsDtInclusao);
        prepareStatement.setString(7, funcionario.getTipo());
        prepareStatement.setInt(8, funcionario.getIdfuncionario());
        this.prepareStatement.executeUpdate();
        
        return funcionario.getIdfuncionario();
    }
    
}
