package Usuarios;

import Funcionalidade.Estoque;
import Funcionalidade.Produto;

import java.util.Scanner;

public class Cliente extends Person{

    private Estoque list;

    public Cliente(String name, String login, String senha) {
        super(name, login, senha);
    }

    @Override
    public void abrirOpcoes() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        boolean verif = verificacaoSenha(senha);

        while (verif == false){

            System.out.println("Digite novamente sua senha: ");
            senha = scanner.nextLine();

            verif = verificacaoSenha(senha);

        }

        if(verif){

            Scanner scanOp = new Scanner(System.in);

            int op = 10;

            while (op != 0){
                opcoes();

                System.out.println("Com qual ação deseja prosseguir ?");
                op = scanOp.nextInt();

                selecionarOpcoes(op);

            }


        }
    }

    @Override
    protected void opcoes() {

        System.out.println("" +
                "========== MENU CLIENTE ==========\n" +
                "1 - Listar produtos disponíveis\n" +
                "2 - Buscar produto\n" +
                "3 - Comprar produto\n" +
                "0 - Sair\n" +
                "================================="
        );

    }

    @Override
    protected void selecionarOpcoes(int qtd) {

        Scanner scanner = new Scanner(System.in);

        switch (qtd){
            case 1:
                list.listar();
                break;
            case 2:
                System.out.println("Digite o nome do produto: ");
                String nome = scanner.nextLine();

                list.buscar(nome);
                break;
            case 3:
                System.out.println("Digite o codigo do produto que deseja comprar e a quantidade: ");
                int cod = scanner.nextInt();
                int qtdProduto = scanner.nextInt();

                list.retirarQtdProduto(cod, qtdProduto);

                break;
            case 0:
                System.out.println("Encerrou o programa.");
                break;
        }


    }

}
