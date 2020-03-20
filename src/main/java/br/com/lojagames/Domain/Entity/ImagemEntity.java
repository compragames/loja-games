/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Domain.Entity;

import br.com.lojagames.Application.Model.Model;

/**
 *
 * @author Victor
 */
public class ImagemEntity extends Entity{
private int idImagem;
    private int idProduto; 
	private String url;
	private boolean imgUso;

    public int getIdImagem() {
        return idImagem;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isImgUso() {
        return imgUso;
    }

    public void setImgUso(boolean imgUso) {
        this.imgUso = imgUso;
    }

    @Override
    public Model getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
