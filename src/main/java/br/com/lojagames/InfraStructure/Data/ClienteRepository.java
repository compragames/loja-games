/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.InfraStructure.Data;

import br.com.lojagames.Domain.Entity.ClienteEntity;
import br.com.lojagames.Domain.Interfaces.IRepository;
import br.com.lojasgames.Domain.Interfaces.IClienteRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author gabriel.gisidorio
 */
public class ClienteRepository extends IRepository implements IClienteRepository {

    @Override
    public int inserir(ClienteEntity cliente, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        Timestamp ts = Timestamp.valueOf(cliente.getDataNascimento());
        System.out.println(ts);
        sql.append("INSERT INTO CLIENTE "
                + "(NOME, CPF, CNPJ, DATANASCIMENTO, TELEFONE, EMAIL, ENDERECO"
                + "CEP, TIPO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setString(1, cliente.getNome());
        prepareStatement.setString(2, cliente.getCpf());
        prepareStatement.setString(3, cliente.getCnpj());
        prepareStatement.setTimestamp(4,ts);
        prepareStatement.setString(5, cliente.getTelefone());
        prepareStatement.setString(6, cliente.getEmail());
        prepareStatement.setString(7, cliente.getEndereco());
        prepareStatement.setString(8, cliente.getCep());
        prepareStatement.setString(9, cliente.getTipo());
        this.prepareStatement.executeUpdate();
        
        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        
        if (rs.next()) 
            cliente.setIdCliente(rs.getInt(1));
        
        return rs.getInt(1);
    }

    @Override
    public ResultSet buscar(Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResultSet buscarPorId(ClienteEntity cliente, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(ClienteEntity cliente, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
