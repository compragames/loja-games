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
    private String title;
    private String description;
    private String platform;
    private int qtdEstoque;
    private double price;
    private String[] imagens;

    public ProdutoModel() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int id) {
        this.idProduto = id;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public ProdutoEntity getProdutoEntity() {
        return produtoEntity;
    }

    public void setProdutoEntity(ProdutoEntity produtoEntity) {
        this.produtoEntity = produtoEntity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String[] getImagens() {
        return imagens;
    }

    public void setImagens(String[] imagens) {
        this.imagens = imagens;
    }

    @Override
    public Entity getEntity() {
        produtoEntity = new ProdutoEntity();
        produtoEntity.setNome(title);
        produtoEntity.setPlataforma(platform);
        produtoEntity.setValorUnitario(price);
        produtoEntity.setIdEmpresa(1);
        produtoEntity.setQtdEstoque(qtdEstoque);

        return produtoEntity;

    }

}
