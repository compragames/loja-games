package br.com.lojagames.InfraStructure.Data;

import br.com.lojagames.Application.Model.UsuarioModel;
import br.com.lojagames.Domain.Entity.ClienteEntity;
import br.com.lojagames.Domain.Entity.FuncionarioEntity;
import br.com.lojagames.Domain.Entity.UserEntity;
import br.com.lojagames.Domain.Interfaces.IRepository;
import br.com.lojagames.Domain.Interfaces.IUserRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 *
 * @author Victor
 */
public class UserRepository extends IRepository implements IUserRepository {

    @Override
    public UsuarioModel buscarUsuario(String user, String password, Connection conexao) throws SQLException {
        UsuarioModel usuario = new UsuarioModel();
        StringBuilder sql = new StringBuilder();
        sql.append("select * from USUARIO WHERE LOGIN = ? AND SENHA = ?");
        this.prepareStatement = conexao.prepareStatement(sql.toString());
        this.prepareStatement.setString(1, user);
        this.prepareStatement.setString(2,password);

        ResultSet rs = prepareStatement.executeQuery();
        // generate key devolve a key que foi gerada no banco
       
       
      if (rs.next()) {
            usuario.setNome(rs.getString(3));
        usuario.setNivel(rs.getString(2));

            
        }
        return usuario;
    }

    @Override
    public int inserirUsuario(ClienteEntity cliente, int usuario, Connection conexao) throws SQLException {
     StringBuilder sql = new StringBuilder();           
       sql.append("INSERT INTO USUARIO "
                + "(NIVEL, LOGIN, SENHA)"
                + " VALUES (?, ?, ?)");
       this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setInt(1, usuario);
        prepareStatement.setString(2, cliente.getEmail());
        prepareStatement.setString(3, cliente.getSenha());
   

    
        this.prepareStatement.executeUpdate();
        
        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        
        if (rs.next()) 
            cliente.setIdCliente(rs.getInt(1));
        
        return rs.getInt(1);
    }

    @Override
    public int inserirUsuario(FuncionarioEntity f, int usuario, Connection conexao) throws SQLException {
     StringBuilder sql = new StringBuilder();        

        sql.append("INSERT INTO USUARIO "
                + "(NIVEL, LOGIN, SENHA)"
                + " VALUES (?, ?, ?)");
       this.prepareStatement = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
        prepareStatement.setInt(1, usuario);
        prepareStatement.setString(2, f.getEmail());
        prepareStatement.setString(3, f.getPassword());
   

   
        this.prepareStatement.executeUpdate();
        
        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        
        if (rs.next()) 
            f.setIdfuncionario(rs.getInt(1));
        
        return rs.getInt(1);   
    }
//metodos temporarios para a entrega abaixo.
    @Override
    public boolean inserirUsuario(UserEntity cadastro, int i, Connection connect) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
