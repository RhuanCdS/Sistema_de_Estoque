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

        if(list.isEmpty()){
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

        if(list.isEmpty()){
            System.out.println("Estoque vazio!!!");
            return;
        }

        for(int i = 0; i < list.size(); i++){

            if(Objects.equals(list.get(i).getName().toUpperCase(), name.toUpperCase())){

                System.out.println("Produto encontrado.");
                return;

            }

        }

        System.out.println("Produto não encontrado.");

    }

    public void atualizarPrice(int cod, double newPreco){

        if(list.isEmpty()) return;

        int p = list.size() - cod;

        try {
            list.get(p).setPreco(newPreco);
            System.out.println("Preço do produto atualizado com sucesso!!!");

        } catch (Exception e) {
            System.out.println("Produto nao encontrado.");
        }


    }

    public void excluir(int cod){

        if(list.isEmpty()) return;

        int p = list.size() - cod;

        try {
            list.remove(p);
            System.out.println("Produto excluido.");
        }catch (RuntimeException e){
            System.out.println("Produto nao encontrado!!!");
        }

    }

    public void consultarQtdProduto(int c){

        if(list.isEmpty()){
            System.out.println("Nenhum produto no estoque.");
            return;
        }

        int p = list.size() - c;

        Produto t = list.get(p);

        int qtdP = t.getQtd();

        System.out.println(qtdP);
    }

    public void adicionarQtdProduto(int index, int qtd){

        if(list.isEmpty() || index > list.size()) return;

        int p = list.size() - index;

        try {
            list.get(p).aumentarQtdProduto(qtd);
            System.out.println("Preço do produto atualizado com sucesso!!!");

        } catch (Exception e) {
            System.out.println("Produto nao encontrado.");
        }

    }

    public void retirarQtdProduto(int index, int qtd){


        if(list.isEmpty() || index > list.size()) return;

        int p = list.size() - index;

        try {

            int qtdP = list.get(p).getQtd();

            if(qtdP < qtd){
                System.out.println("Quantidade de produto no estoque insuficiente.");
                return;
            }

            list.get(p).diminuirQtdProduto(qtd);
            System.out.println("Produto comprado com sucesso.");

        } catch (Exception e) {

            System.out.println("Produto nao encontrado.");

        }

    }

    public Produto retornarProduto(int cod){

        if(cod > list.size()){
            return null;
        }

        int p = list.size() - cod;

        return this.list.get(p);
    }

    public void imprimirAlerta(){

        System.out.println("========================================");
        System.out.println("        HISTÓRICO DE MOVIMENTAÇÕES      ");
        System.out.println("========================================");

        int count = 0;

        if (list.isEmpty()){
            System.out.println(
                    "\nNenhum produto com estoque baixo!" +
                            "Todos os produtos estão com \n" +
                            "quantidade acima do límite minimo\n"
            );
        }else{

            System.out.println("\nATENÇÃO: ESTOQUE BAIXO!");
            System.out.println("Quantidade minima: 5\n");

            for(int i = 0; i < list.size(); i++){

                if (list.get(i).getQtd() < 5){
                    System.out.println("\nProduto: " + list.get(i).getName());
                    System.out.println("Quantidade atual: " + list.get(i).getQtd());
                    count++;
                }

            }

            System.out.println("\nTotal de produtos em alerta: " + count);
        }

        System.out.println("========================================");

    }
}