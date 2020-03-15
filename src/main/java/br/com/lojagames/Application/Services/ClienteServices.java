/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.Services;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Application.IService.IClienteServices;
import br.com.lojagames.Application.Model.ClienteModel;
import br.com.lojagames.Application.Model.Model;
import br.com.lojagames.Application.Model.ReturnModel;
import br.com.lojagames.Domain.Entity.ClienteEntity;
import br.com.lojasgames.Domain.Interfaces.IClienteRepository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author gabriel.gisidorio
 */
public class ClienteServices extends Services implements IClienteServices<Model> {

    @Inject
    private IClienteRepository iClienteRepository;

    private ResultSet rs = null;

    @Override
    public Model cadastrarCliente(ClienteModel cliente, Token token) {

        ReturnModel retorno = new ReturnModel();

        try {
            getConnectOpen();

            return retorno;
        } catch (SQLException ex) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar cadastrar cliente");
            return retorno;
        }
    }

    @Override
    public List<Model> listarClientes() {
        List<Model> models = new ArrayList<>();

        try {
            getConnectOpen();
            iClienteRepository.listarClientes(getConnect()).forEach(item -> {
                models.add(((ClienteEntity) item).getModel());
            });
            getConnectClose();
            return models;
        } catch (SQLException ex) {
            getConnectClose();
            return null;
        }
    }

    @Override
    public Model editarCliente(ClienteModel cliente, Token token) {
        ReturnModel retorno = new ReturnModel();

        try {
            getConnectOpen();

            return retorno;
        } catch (SQLException ex) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar editar cliente");
            return retorno;
        }
    }

    @Override
    public Model cadastrarCliente(ClienteModel cliente, String token) {

        ReturnModel retorno = new ReturnModel();

        try {
            getConnectOpen();
            int id = iClienteRepository.inserir((ClienteEntity) cliente.getEntity(), getConnect());
            cliente.setIdCliente(id);
            getConnectClose();
            retorno.setRetorno(true);
            retorno.setTxtRetorno("Cliente cadastrado com sucesso");
            retorno.setId(id);
            return retorno;
        } catch (SQLException ex) {
            System.out.println(ex);
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar cadastrar cliente");
            return retorno;
        }
    }

    @Override
    public Model editarCliente(ClienteModel cliente, String token) {
        
        ReturnModel retorno = new ReturnModel();

        try {
            getConnectOpen();
            int id = iClienteRepository.editarCliente((ClienteEntity) cliente.getEntity(), getConnect());
            cliente.setIdCliente(id);
            getConnectClose();
            retorno.setRetorno(true);
            retorno.setTxtRetorno("Cliente editado com sucesso");
            retorno.setId(id);
            return retorno;
        } catch (SQLException ex) {
            System.out.println(ex);
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar editar cliente");
            return retorno;
        }
    }

}
