package br.com.lojagames.Application.Model;

import br.com.lojagames.Domain.Entity.Entity;
import br.com.lojagames.Domain.Entity.FaqEntity;
import br.com.lojagames.Domain.Entity.ImagemEntity;
import br.com.lojagames.Domain.Entity.ProdutoEntity;
import java.util.List;

/**
 *
 * @author Victor
 */
public class ProdutoModel extends Model {

    private ProdutoEntity produtoEntity;
// esses são os campos do gson
    private int idProduto;
    private String title;
    private String description;
    private String platform;
    private int qtdEstoque;
    private double price;
    private List<ImagemEntity>imagens;
    private List<FaqEntity> faq;

    public ProdutoModel() {
    }

    public int getIdProduto() {
        return idProduto;
    }

    public List<ImagemEntity> getImagens() {
        return imagens;
    }

    public void setImagens(List<ImagemEntity> imagens) {
        this.imagens = imagens;
    }

    public List<FaqEntity> getFaq() {
        return faq;
    }

    public void setFaq(List<FaqEntity> faq) {
        this.faq = faq;
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

  
    @Override
    public Entity getEntity() {
        produtoEntity = new ProdutoEntity();
        produtoEntity.setIdProduto(idProduto);
        produtoEntity.setNome(title);
        produtoEntity.setPlataforma(platform);
        produtoEntity.setValorUnitario(price);
        produtoEntity.setIdEmpresa(1);
        produtoEntity.setQtdEstoque(qtdEstoque);

        return produtoEntity;

    }

    public void getImagens(List<ImagemEntity> imagens) {
    this.imagens = imagens;   
    }

    public void getFaq(List<FaqEntity> faq) {
       this.faq = faq;  }

}
