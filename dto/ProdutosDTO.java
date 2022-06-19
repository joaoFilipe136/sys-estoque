
package dto;

public class ProdutosDTO {
    
    private String nome_produto, fornecedor_produto;
    private int lote_produto, quant_produto,id_produto;

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getFornecedor_produto() {
        return fornecedor_produto;
    }

    public void setFornecedor_produto(String fornecedor_produto) {
        this.fornecedor_produto = fornecedor_produto;
    }

    public int getLote_produto() {
        return lote_produto;
    }

    public void setLote_produto(int lote_produto) {
        this.lote_produto = lote_produto;
    }

    public int getQuant_produto() {
        return quant_produto;
    }

    public void setQuant_produto(int quant_produto) {
        this.quant_produto = quant_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id) {
        this.id_produto = id;
    }
    
}
