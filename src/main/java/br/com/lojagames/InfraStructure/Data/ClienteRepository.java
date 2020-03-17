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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        sql.append("INSERT INTO CLIENTE"
                + "(NOME, CPF, CNPJ, DATANASCIMENTO, TELEFONE, EMAIL, ENDERECO,CEP,TIPO, STATUS)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
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
        prepareStatement.setString(10, cliente.getStatus());
        this.prepareStatement.executeUpdate();
        
        final ResultSet rs = this.prepareStatement.getGeneratedKeys();
        
        if (rs.next()) 
            cliente.setIdCliente(rs.getInt(1));
        
        return rs.getInt(1);
    }

    @Override
    public List<ClienteEntity> listarClientes(Connection conexao) throws SQLException {
        List<ClienteEntity> listaClientes = new ArrayList<>();
        StringBuilder query = new StringBuilder();                      
        
        Date data = new Date();
        
        
        query.append("SELECT * FROM CLIENTE");
        
        this.prepareStatement = conexao.prepareStatement(query.toString());

        ResultSet rs = prepareStatement.executeQuery();
        while(rs.next()) {
            data.setTime(rs.getTimestamp(5).getTime());
            String formattedDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(data);
            ClienteEntity clienteEntity = new ClienteEntity();
            clienteEntity.setIdCliente(rs.getInt(1));
            clienteEntity.setNome(rs.getString(2));
            clienteEntity.setCpf(rs.getString(3));
            clienteEntity.setCnpj(rs.getString(4));
            clienteEntity. setDataNascimento(formattedDate);
            clienteEntity.setTelefone(rs.getString(6));
            clienteEntity.setEmail(rs.getString(7));
            clienteEntity.setEndereco(rs.getString(8));
            clienteEntity.setCep(rs.getString(9));
            clienteEntity.setTipo(rs.getString(10));
            clienteEntity.setStatus(rs.getString(11));
            listaClientes.add(clienteEntity);
        }
        
        return listaClientes;
    }

    @Override
    public ResultSet buscarPorId(ClienteEntity cliente, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(ClienteEntity cliente, Connection conexao) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int editarCliente(ClienteEntity cliente, Connection conexao) throws SQLException {
        StringBuilder sql = new StringBuilder();        
        Timestamp ts = Timestamp.valueOf(cliente.getDataNascimento());
        System.out.println(ts);
        sql.append("UPDATE CLIENTE "
                + "SET NOME = ?, CPF = ?, CNPJ = ?, DATANASCIMENTO = ?, "
                + "TELEFONE = ?, EMAIL = ?, ENDERECO = ?, CEP = ?, TIPO = ?, STATUS = ? "
                + "WHERE IDCLIENTE = ?");
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
        prepareStatement.setString(10, cliente.getStatus());
        prepareStatement.setInt(11, cliente.getIdCliente());
        this.prepareStatement.executeUpdate();
        
        return cliente.getIdCliente();
    }
    
}
