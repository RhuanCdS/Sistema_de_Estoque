package Funcionalidade;

import java.util.ArrayList;
import java.util.Objects;

public class Estoque {

    private static Estoque instancia;
    private ArrayList<Produto> list;


    private Estoque(){
        this.list = new ArrayList<>();
    }

    public static Estoque getInstancia() {

        if(instancia == null){
            instancia = new Estoque();
        }

        return instancia;
    }

    public void cadastrar(Produto produto){
        list.add(produto);
    }

    public void listar(){

        if(list == null){
            System.out.println("Estoque vazio!!!");
            return;
        }

        System.out.println("Cod | Nome | Qtd | Preço");

        for (int i = 0; i < list.size(); i++){

            System.out.println(

                    list.get(i).getCod() + " | " +
                    list.get(i).getName() + " | " +
                    list.get(i).getQtd() + " | " +
                    list.get(i).getPreco()

            );

        }

    }

    public void buscar(String name){

        if(list == null){
            System.out.println("Estoque vazio!!!");
            return;
        }

        for(int i = 0; i < list.size(); i++){

            if(Objects.equals(list.get(i).getName().toUpperCase(), name)){

                System.out.println("Produto encontrado.");
                return;

            }

        }

        System.out.println("Produto não encontrado.");

    }

    public void atualizarPrice(int cod, double newPreco){

        int i = 0;

        if(list.getFirst() == null) return;

        while(i < list.size() && list.get(i).getCod() != cod){
            i++;
        }

        if(list.get(i) == null) return;

        list.get(i).setPreco(newPreco);

        System.out.println("Preço do produto atualizado com sucesso!!!");

    }

    public void excluir(int cod){

        if(list.getFirst() == null) {return;}

        int i = 0;
        Produto atual = list.get(0);


        while (i < list.size() && list.get(i).getCod() != cod){
            i++;
            atual = list.get(i);
        }

        if(atual == null){
            System.out.println("Item inexistente");
            return;
        }

        for (int k = i; k < list.size(); k++){

            list.set(k, list.get(k - 1));

        }

        list.removeLast();
    }

    public void consultarQtdProduto(int c){

        if(list.getFirst() == null){
            System.out.println("Nenhum produto no estoque.");
            return;
        }

        Produto t = list.get(c - 1);

        int qtdP = t.getQtd();

        System.out.println(qtdP);
    }

    public void adicionarQtdProduto(int index, int qtd){

        int i = 0;

        if(list.getFirst() == null) return;

        while(list.get(i).getCod() != index && list.get(i) != null){
            i++;
        }

        if(list.get(i) == null){
            System.out.println("Produto não encontrado!!!");
            return;
        }

        list.get(i).aumentarQtdProduto(qtd);
        System.out.println("Quantidade de produto adicionado com sucesso.");

    }

    public void retirarQtdProduto(int index, int qtd){

        int i = 0;

        if(list.getFirst() == null) return;

        while(list.get(i).getCod() != index && list.get(i) != null){
            i++;
        }

        if(list.get(i) == null){
            System.out.println("Produto não encontrado!!!");
            return;
        }

        int qtdP = list.get(i).getQtd();

        if(qtdP < qtd){
            System.out.println("Quantidade de produto no estoque insuficiente.");
            return;
        }

        list.get(i).diminuirQtdProduto(qtd);
        System.out.println("Produto comprado com sucesso.");

    }

    public Produto retornarProduto(int cod){

        int i = 0;

        while (this.list.get(i).getCod() != cod){
            i++;
        }

        return this.list.get(i);
    }
}