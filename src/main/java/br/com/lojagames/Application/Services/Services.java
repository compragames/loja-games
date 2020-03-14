/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.Services;

import br.com.lojagames.InfraStructure.Data.ModelConnection;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Victor
 */
public abstract class Services {


    private Connection connection;

    protected void getConnectOpen() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ModelConnection.conectorDev();
            //define se estamos apontando para o banco local ou de produção
        }
    }

    protected Connection getConnect() {
        return connection;
    }

    protected void getConnectClose() {
        try {
            if(connection != null || !connection.isClosed())
            connection.close();
        } catch (SQLException ex) {
        }
    }

}
