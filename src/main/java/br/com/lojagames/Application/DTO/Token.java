package br.com.lojagames.Application.DTO;

/**
 *
 * @author Victor
 */
public class Token {
private String iss ;

    public String getIss() {
        return iss;
    }

    public void setIss(String iss) {
        this.iss = iss;
    }
    private long exp;
    private int id;
    private String dataCri;
    private String dataVencimento;

    public Token() {
    }

    public Token(long exp, int id, String nome, String cnpj, String emailAlternativo) {

        this.exp = exp;
        this.id = id;

    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataCri() {
        return dataCri;
    }

    public void setDataCri(String dataCri) {
        this.dataCri = dataCri;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

}
