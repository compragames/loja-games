package br.com.lojagames.Application.IService;

import br.com.lojagames.Application.Model.UsuarioModel;

/**
 *
 * @author Victor
 */
public interface IUserServices<T> {
     
   
    public T userInfo();
    
    public T modificarPerfil();
    
    public T deletarUsuario();
    
    public T recuperarSenha();

    public T autenticar(UsuarioModel usuario);

}
