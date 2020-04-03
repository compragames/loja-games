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
    
    public T cadastrarCliente(ClienteModel cliente);
    
    public List<T> listarClientes();
    
    public T editarCliente(ClienteModel cliente, Token token);
    
    public T editarCliente(ClienteModel cliente, String token);
}
