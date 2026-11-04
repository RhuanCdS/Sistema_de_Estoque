package Funcionalidade;

import Usuarios.Person;

public class Movimentacao {

    private int cont = 0;
    private static int auxiliarCount = 0;

    private int cod_produto;
    private String name_produto;
    private int qtd_movimentacao;
    private Person user_responsavel;

    public Movimentacao(Person person, Produto produto){
        this.cod_produto = produto.getCod();
        this.name_produto = produto.getName();

        this.qtd_movimentacao = produto.getQtd();
        auxiliarCount++;
        this.cont = auxiliarCount;

    }


}
