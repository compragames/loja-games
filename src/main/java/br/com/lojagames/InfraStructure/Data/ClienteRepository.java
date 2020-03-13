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

/**
 *
 * @author gabriel.gisidorio
 */
public class ClienteRepository extends IRepository implements IClienteRepository {

    @Override
    public int inserir(ClienteEntity cliente, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("");
        this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        
        return 1;
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
