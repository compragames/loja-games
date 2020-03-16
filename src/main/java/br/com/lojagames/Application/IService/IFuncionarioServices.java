/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.IService;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Application.Model.FuncionarioModel;
import java.util.List;

/**
 *
 * @author lucas.sfaria5
 */
public interface IFuncionarioServices <T> {
    
    public T cadastroFuncionario (FuncionarioModel funcionario, String token);
    public T cadastroFuncionario (FuncionarioModel funcionario, Token token);
    
    public T deletarFuncionario(FuncionarioModel funcionario, Token token);

    public List<T> getFuncionario(List<FuncionarioModel> funcionarios);
    public List<T> listarFuncionario();

    public T modificarFuncionario(FuncionarioModel funcionario, Token token);

    public T updateFuncionario(FuncionarioModel funcionario, Token token);

    
    
}
