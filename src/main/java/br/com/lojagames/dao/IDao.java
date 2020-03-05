
package br.com.lojagames.dao;

/**
 *
 * @author Victor
 */
public interface IDao {
    public boolean salvar(Object object);
    
    public boolean editar(Object object);
    
    public boolean excluir(int id);
}
