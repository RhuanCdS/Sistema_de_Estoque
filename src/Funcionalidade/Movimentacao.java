package Funcionalidade;

import Usuarios.Person;
import Enums.TipoMovimentacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimentacao {

    private int cont = 0;
    private static int auxiliarCount = 0;

    private int cod_produto;
    private String name_produto;

    private TipoMovimentacao tipoMovimentacao;

    private LocalDateTime dataHora;
    private static final DateTimeFormatter data = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss");

    private int qtd_movimentacao;
    private String user_responsavel;

    public Movimentacao(Person person, Produto produto, int qtd, int num){
        this.cod_produto = produto.getCod();
        this.name_produto = produto.getName();

        this.tipoMovimentacao = TipoMovimentacao.fromCod(num);

        this.qtd_movimentacao = qtd;
        this.user_responsavel = person.getString();

        auxiliarCount++;
        this.cont = auxiliarCount;

        this.dataHora = LocalDateTime.now();
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

    //Formatação da Data e Hora
    public String  getDataFormatada(){
        return this.data.format(this.dataHora);
    }

    public String getHoraFormatada(){
        return this.hora.format(this.dataHora);
    }


}
