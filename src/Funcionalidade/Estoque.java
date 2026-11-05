package Funcionalidade;

import java.util.Objects;

public class Estoque {

    private static Estoque instancia;

    private Produto[] list;
    private int qtd_list;

    private int count = 0;

    private Estoque(int qtd_list){

        this.qtd_list = qtd_list;
        this.list = new Produto[this.qtd_list];

    }

    public static Estoque criarList(int size){

        if(instancia == null){
            instancia = new Estoque(size);
        }

        return instancia;

    }

    public static Estoque getInstancia() {
        return instancia;
    }

    public void cadastrar(Produto produto){

        if(this.count < this.qtd_list){

            this.list[count] = produto;
            count++;

        }else {

            System.out.println("Lista está cheia!!!");

        }

    }

    public void listar(){

        if(list == null){
            System.out.println("Estoque vazio!!!");
            return;
        }

        System.out.println("Cod | Nome | Qtd | Preço");

        for (int i = 0; i < count; i++){

            System.out.println(

                    list[i].getCod() + " | " +
                    list[i].getName() + " | " +
                    list[i].getQtd() + " | " +
                    list[i].getPreco()

            );

        }

    }

    public void buscar(String name){

        if(list == null){
            System.out.println("Estoque vazio!!!");
            return;
        }

        for(int i = 0; i < count; i++){

            if(Objects.equals(list[i].getName().toUpperCase(), name)){

                System.out.println("Produto encontrado.");
                return;

            }

        }

        System.out.println("Produto não encontrado.");

    }

    public void atualizarPrice(int cod, double newPreco){

        int i = 0;

        if(list[0] == null) return;

        while(i < count && list[i].getCod() != cod){
            i++;
        }

        if(list[i] == null) return;

        list[i].setPreco(newPreco);

        System.out.println("Preço do produto atualizado com sucesso!!!");

    }

    public void excluir(int cod){

        if(list[0] == null) {return;}

        int i = 0;
        Produto atual = list[0];


        while (i < count - 1 && list[i].getCod() != cod){
            i++;
            atual = list[i];
        }

        if(atual == null){
            System.out.println("Item inexistente");
            return;
        }

        for (int k = i; k < count - 1; k++){

            list[k] = list[k + 1];

        }

        list[count - 1] = null;
        count--;


    }

    public void consultarQtdProduto(int c){

        if(list[0] == null){
            System.out.println("Nenhum produto no estoque.");
            return;
        }

        Produto t = list[c - 1];

        int qtdP = t.getQtd();

        System.out.println(qtdP);
    }

    public void adicionarQtdProduto(int index, int qtd){

        int i = 0;

        if(list[0] == null) return;

        while(list[i].getCod() != index && list[i] != null && i < count - 1){
            i++;
        }

        if(list[i] == null){
            System.out.println("Produto não encontrado!!!");
            return;
        }

        list[i].aumentarQtdProduto(qtd);
        System.out.println("Quantidade de produto adicionado com sucesso.");

    }

    public void retirarQtdProduto(int index, int qtd){

        int i = 0;

        if(list[0] == null) return;

        while(list[i].getCod() != index && list[i] != null && i < count - 1){
            i++;
        }

        if(list[i] == null){
            System.out.println("Produto não encontrado!!!");
            return;
        }

        int qtdP = list[i].getQtd();

        if(qtdP < qtd){
            System.out.println("Quantidade de produto no estoque insuficiente.");
            return;
        }

        list[i].diminuirQtdProduto(qtd);
        System.out.println("Produto comprado com sucesso.");

    }

    public Produto retornarProduto(int cod){

        int i = 0;

        while (this.list[i].getCod() != cod){
            i++;
        }

        return this.list[i];
    }
}
