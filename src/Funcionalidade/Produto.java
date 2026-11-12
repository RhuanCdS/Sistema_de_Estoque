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

    public int getCod(){
        return this.cod;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getQtd(){
        return this.qtd;
    }

    public void setQtd(int qtd){
        this.qtd = qtd;
    }

    public void aumentarQtdProduto(int qtd){
        this.qtd += qtd;
    }

    public void diminuirQtdProduto(int qtd){
        this.qtd -= qtd;
    }

    public double getPreco(){
        return this.preco;
    }

    public void setPreco(double preco){
        this.preco = preco;
    }

}
