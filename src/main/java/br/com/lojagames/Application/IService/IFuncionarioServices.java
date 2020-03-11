/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.IService;

import br.com.lojagames.Application.Model.FuncionarioModel;

/**
 *
 * @author lucas.sfaria5
 */
public interface IFuncionarioServices <T> {
    
    public T cadastroFuncionario (FuncionarioModel funcionario, String token);
    
}
