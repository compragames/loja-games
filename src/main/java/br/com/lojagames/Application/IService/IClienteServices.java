/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.IService;

import br.com.lojagames.Application.DTO.Token;
import br.com.lojagames.Application.Model.ClienteModel;
import java.util.List;

/**
 *
 * @author gabriel.gisidorio
 * @param <T>
 */
public interface IClienteServices<T> {
    
    public T cadastrarCliente(ClienteModel cliente, Token token);
    
    public T cadastrarCliente(ClienteModel cliente, String token);
    
    public List<T> listarClientes();
    
    public T editarCliente(ClienteModel cliente, Token token);
    
    public T editarCliente(ClienteModel cliente, String token);
}
