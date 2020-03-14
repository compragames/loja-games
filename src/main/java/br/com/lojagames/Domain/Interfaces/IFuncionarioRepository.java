/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Domain.Interfaces;

import br.com.lojagames.Domain.Entity.FuncionarioEntity;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author lucas.sfaria5
 */
public interface IFuncionarioRepository {
    public int inserir (FuncionarioEntity funcionario, Connection conexao) throws SQLException;
    
    public ResultSet busca (Connection conexao) throws SQLException;
    
    public void deletar (FuncionarioEntity funcionario, Connection conexao)throws SQLException;
    
    public ResultSet buscaPorId(FuncionarioEntity funcionario, Connection conexao) throws SQLException;
    
}