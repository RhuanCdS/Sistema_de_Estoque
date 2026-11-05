package Funcionalidade;

import Usuarios.Person;
import Enums.TipoMovimentacao;

public class Movimentacao {

    private int cont = 0;
    private static int auxiliarCount = 0;

    private int cod_produto;
    private String name_produto;

    private TipoMovimentacao tipoMovimentacao;

    private int qtd_movimentacao;
    private String user_responsavel;

    public Movimentacao(Person person, Produto produto, int num){
        this.cod_produto = produto.getCod();
        this.name_produto = produto.getName();

        this.tipoMovimentacao = TipoMovimentacao.fromCod(num);

        this.qtd_movimentacao = produto.getQtd();
        this.user_responsavel = person.getString();

        auxiliarCount++;
        this.cont = auxiliarCount;
    }

    public int getCont(){
        return this.cont;
    }

    public int getCod_produto(){
        return this.cod_produto;
    }

    public String getName_produto(){
        return this.name_produto;
    }

    public String getUser_responsavel(){
        return this.user_responsavel;
    }

    public TipoMovimentacao getTipoMovimentacao() {
        return this.tipoMovimentacao;
    }

    public int getQtd_movimentacao(){
        return this.qtd_movimentacao;
    }


}
