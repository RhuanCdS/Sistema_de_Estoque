package Usuarios;

import Funcionalidade.Estoque;
import Enums.ClienteOp;
import Funcionalidade.Produto;

import java.util.Scanner;

public class Cliente extends Person{

    private Estoque estoque;

    public Cliente(String name, String login, String senha) {
        super(name, login, senha);
    }

    public String getSting() {
        return "Cliente" + name;
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
        ClienteOp.imprimir();
    }

    @Override
    protected void selecionarOpcoes(int qtd) {

        Estoque list = Estoque.getInstancia();

        if (list == null) {
            System.out.println("Estoque ainda não foi criado.");
            return;
        }

        ClienteOp op = ClienteOp.selecionarOp(qtd);
        Scanner scanner = new Scanner(System.in);

        switch (op){
            case LISTA:
                list.listar();
                break;
            case BUSCAR:
                System.out.println("Digite o nome do produto: ");
                String nome = scanner.nextLine();

                list.buscar(nome);
                break;
            case COMPRAR:
                System.out.println("Digite o codigo do produto que deseja comprar e a quantidade: ");
                int cod = scanner.nextInt();
                int qtdProduto = scanner.nextInt();

                Produto produto = estoque.retornarProduto(cod);


                list.retirarQtdProduto(cod, qtdProduto);

                break;
            case SAIR:
                System.out.println("Encerrou o programa.");
                break;
        }


    }

}
