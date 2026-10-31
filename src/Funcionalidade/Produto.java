package Funcionalidade;

public class Produto {

    private int cod;
    private String name;
    private int qtd;
    private double preco;

    private static int qtd_produto_create = 1;

    public Produto(String name, int qtd, double preco){

        this.name = name;
        this.qtd = qtd;
        this.preco = preco;

        this.cod = qtd_produto_create;
        qtd_produto_create++;

    }

    protected int getCod(){
        return this.cod;
    }

    protected String getName(){
        return this.name;
    }

    protected void setName(String name){
        this.name = name;
    }

    protected int getQtd(){
        return this.qtd;
    }

    protected void setQtd(int qtd){
        this.qtd = qtd;
    }

    protected void aumentarQtdProduto(int qtd){
        this.qtd += qtd;
    }

    protected void diminuirQtdProduto(int qtd){
        this.qtd -= qtd;
    }

    protected double getPreco(){
        return this.preco;
    }

    protected void setPreco(double preco){
        this.preco = preco;
    }

}
