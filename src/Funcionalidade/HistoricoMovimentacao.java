package Funcionalidade;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HistoricoMovimentacao {

    private static ArrayList<Movimentacao> movimentacao;
    private static HistoricoMovimentacao instance;

    public HistoricoMovimentacao(){
        movimentacao = new ArrayList<>();
    }

    public void inserirNoHistorico(Movimentacao movimentacao){
        this.movimentacao.add(movimentacao);
    }

    public static HistoricoMovimentacao getInstance() {

        if(instance == null){
            instance = new HistoricoMovimentacao();
        }

        return instance;
    }

    public void imprimirHistorico(){

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = now.format(date);

        System.out.println("========================================");
        System.out.println("        HISTÓRICO DE MOVIMENTAÇÕES      ");
        System.out.println("========================================");

        System.out.println("\nData: " + dataFormatada);

        int count = 0;

        for(int i = 0; i < movimentacao.size(); i++){

            System.out.println(
                    "\n----------------------------------------" +
                    "MOVIMENTAÇÃO " + movimentacao.get(i).getCont() +
                    "----------------------------------------"
            );

            //=====================================================================//

            System.out.println(
                    "Produto: " + movimentacao.get(i).getName_produto() +
                    "\nCódigo: " + movimentacao.get(i).getCod_produto() +
                    "\nOperação: " + movimentacao.get(i).getTipoMovimentacao() +
                    "\nQuantidade: " + movimentacao.get(i).getQtd_movimentacao() +
                    "\nResponsável: " + movimentacao.get(i).getUser_responsavel() +
                    "\nData: " + movimentacao.get(i).getDataFormatada() +
                    "\nHorário: " + movimentacao.get(i).getHoraFormatada()
            );

            count++;
        }

        System.out.println("========================================");
        System.out.println("    Total de movimentações: "+ count + "    ");
        System.out.println("========================================");

    }
}
