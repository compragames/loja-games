/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lojagames.Domain.Entity;

import br.com.lojagames.Application.Model.Model;
import br.com.lojagames.Application.Model.ProdutoModel;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ProdutoEntity extends Entity{
    
    private ProdutoModel produtoModel;
    
    
    /**
     * IDPRODUTO INT AUTO_INCREMENT NOT NULL,
	NOME VARCHAR(50) NOT NULL,
	PLATAFORMA VARCHAR(20) NOT NULL,
	QTDESTOQUE DOUBLE NOT NULL DEFAULT 0,
	VALORUNITARIO DOUBLE NOT NULL,
    DESCRICAO varchar(1000),
	IDEMPRESA INT NOT NULL,
	DATAINCLUSAO TIMESTAMP,
    */
    
    private int idProduto;
    private String nome;
    private String plataforma;
    private int qtdEstoque;
    private double valorUnitario;
    private String descricao;
    private int idEmpresa;
    private String dataInclusao;
    private List<ImagemEntity>imagens;
   // private boolean disponivel;

    public List<ImagemEntity> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemEntity> imagens) {
        this.imagens = imagens;
    }

   

    public ProdutoModel getProdutoModel() {
        return produtoModel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(String dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public void setProdutoModel(ProdutoModel produtoModel) {
        this.produtoModel = produtoModel;
    }

    public ProdutoEntity() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getIdEmpresa() {
        return 1;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    @Override
    public Model getModel() {
        produtoModel = new ProdutoModel();
        produtoModel.setIdProduto(idProduto);
       produtoModel.setTitle(nome);
       produtoModel.setDescription(descricao);
       produtoModel.setIdProduto(idProduto);
       produtoModel.setPrice(valorUnitario);
       produtoModel.setPlatform(plataforma);
        
       
        return produtoModel;
    
    }
}
