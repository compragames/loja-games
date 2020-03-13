package br.com.lojagames.Application.Model;

import br.com.lojagames.Domain.Entity.Entity;
import br.com.lojagames.Domain.Entity.ProdutoEntity;

/**
 *
 * @author Victor
 */
public class ProdutoModel extends Model {

    private ProdutoEntity produtoEntity;

    private int idProduto;
    private String nome;
    private String tipoProduto;
    private int qtdEstoque;
    private double valorUnitario;
    private String imagens;

    public ProdutoModel() {
    }

    public int getIdProduto() {
        return idProduto;
    }
      public void setIdProduto(int id) {
          this.idProduto = id;
          }


  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
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

     
    
    public String getImagens() {
        return this.imagens;
    }
  
    @Override
    public Entity getEntity() {
        produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(nome);
        produtoEntity.setTipoProduto(tipoProduto);
        produtoEntity.setValorUnitario(valorUnitario);
        produtoEntity.setIdEmpresa(1);
        produtoEntity.setQtdEstoque(qtdEstoque);
        produtoEntity.setImagens(imagens);
        

        return produtoEntity;

    }

    public void setImage(String upload) {
       this.imagens = upload;
    }

  
 

}
