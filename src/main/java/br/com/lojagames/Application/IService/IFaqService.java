/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Application.IService;

/**
 *
 * @author Victor
 */
public interface IFaqService<T> {
    public T inserirFaqProduto(int idProduto, String pergunta);
    
}
