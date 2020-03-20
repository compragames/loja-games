package br.com.lojagames.Application.Model;

import br.com.lojagames.Domain.Entity.Entity;

/**
 *
 * @author Victor
 */
public class ReturnModel extends Model {


    private int id;
    private String token;
    private boolean retorno;
    private String txtRetorno;

    public ReturnModel() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ReturnModel(boolean retorno, String txtRetorno) {
        this.retorno = retorno;
        this.txtRetorno = txtRetorno;
    }

    public boolean isRetorno() {
        return retorno;
    }

    public void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }

    public String getTxtRetorno() {
        return txtRetorno;
    }

    public void setTxtRetorno(String txtRetorno) {
        this.txtRetorno = txtRetorno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public Entity getEntity() {
       
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}
