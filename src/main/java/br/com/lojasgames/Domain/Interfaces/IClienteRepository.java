/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojasgames.Domain.Interfaces;

import br.com.lojagames.Domain.Entity.ClienteEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gabriel.gisidorio
 */
public interface IClienteRepository {
    
    public int inserir(ClienteEntity cliente, Connection conexao) throws SQLException;
    
    public ResultSet buscar(Connection conexao) throws SQLException;
    
    public ResultSet buscarPorId(ClienteEntity cliente, Connection conexao) throws SQLException;
    
    public void deletar(ClienteEntity cliente, Connection conexao) throws SQLException;    
}
