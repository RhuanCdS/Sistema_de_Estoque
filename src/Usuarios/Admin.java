package Usuarios;

import Funcionalidade.Estoque;
import Funcionalidade.Produto;

public class Admin extends Person{

    private Produto produto;
    private Estoque list;

    public Admin(String name, String login, String senha) {
        super(name, login, senha);
    }

    public void criarProduto(String name, int qtd, double preco){

        if(list != null){
            this.produto = new Produto(name, qtd, preco);

            inserirProdutoNoEstoque();
        }

        System.out.println("Estoque inexistente!!!");
    }

    public void criarEstoque(int qtd){
        this.list = new Estoque(qtd);
    }

    private void inserirProdutoNoEstoque(){
        list.cadastrar(this.produto);
    }

    

}
