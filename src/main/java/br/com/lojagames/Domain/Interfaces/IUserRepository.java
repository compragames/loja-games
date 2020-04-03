package br.com.lojagames.Domain.Interfaces;

import br.com.lojagames.Application.Model.UsuarioModel;
import br.com.lojagames.Domain.Entity.ClienteEntity;
import br.com.lojagames.Domain.Entity.FuncionarioEntity;
import br.com.lojagames.Domain.Entity.UserEntity;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public interface IUserRepository {
    
    public UsuarioModel buscarUsuario(String user, String password,Connection conexao)throws SQLException;
    public int  inserirUsuario(ClienteEntity cliente, int usuario, Connection conexao)throws SQLException;
    public int  inserirUsuario(FuncionarioEntity cliente, int usuario, Connection conexao)throws SQLException;
    
    
    //metodos temporarios para cumprir com a entrega
    public boolean inserirUsuario(UserEntity cadastro, int i, Connection connect);
    
}
