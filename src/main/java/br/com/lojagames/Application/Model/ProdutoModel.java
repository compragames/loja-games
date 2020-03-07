package br.com.lojagames.Application.Model;

import br.com.lojagames.Domain.Entity.Entity;
import br.com.lojagames.Domain.Entity.ProdutoEntity;
import java.util.List;

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
    private List imagens;

    public ProdutoModel() {
    }

    public int getIdProduto() {
        return idProduto;
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

     
    
    public List getImagens() {
        return this.imagens;
    }

    @Override
    public Entity getEntity() {
        produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(nome);
        produtoEntity.setTipoProduto(tipoProduto);
        produtoEntity.setValorUnitario(valorUnitario);

        return produtoEntity;

    }

}
