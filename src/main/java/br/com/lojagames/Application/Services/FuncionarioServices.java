/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.Services;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Application.IService.IFuncionarioServices;
import br.com.lojagames.Application.Model.FuncionarioModel;
import br.com.lojagames.Application.Model.Model;
import br.com.lojagames.Application.Model.ReturnModel;
import br.com.lojagames.Domain.Interfaces.IFuncionarioRepository;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author lucas.sfaria5
 */
public class FuncionarioServices extends Services implements IFuncionarioServices<Model> {

    @Inject
    private IFuncionarioRepository iFuncionarioRepository;

    public FuncionarioServices() {
    }
    
    @Override
    public Model cadastroFuncionario(FuncionarioModel funcionario, String token) {
        ReturnModel retorno = new ReturnModel();
        try{
            getConnectOpen();
            //inserir metodo no banco
            return retorno;
        } catch (SQLException e) {
            getConnectClose();
            retorno.setRetorno(false);
            retorno.setTxtRetorno("Erro ao tentar cadastrar funcionario");
            return retorno;
        }
    }

    @Override
    public Model deletarFuncionario(FuncionarioModel funcionario, Token token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Model> getFuncionario(List<FuncionarioModel> funcionarios) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Model> listarFuncionario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model modificarFuncionario(FuncionarioModel funcionario, Token token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Model updateFuncionario(FuncionarioModel funcionario, Token token) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
