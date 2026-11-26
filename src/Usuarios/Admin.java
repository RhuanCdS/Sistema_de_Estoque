package Usuarios;

import Funcionalidade.Estoque;
import Funcionalidade.HistoricoMovimentacao;
import Funcionalidade.Movimentacao;
import Funcionalidade.Produto;
import Enums.AdminOp;
import Funcionalidade.HistoricoMovimentacao;

import java.util.Scanner;

public class Admin extends Person{

    private Produto produto;
    private Estoque list;

    private HistoricoMovimentacao historicoMovimentacao;
    private Movimentacao movimentacao;

    public Admin(String name, String login, String senha) {
        super(name, login, senha);
        this.historicoMovimentacao = HistoricoMovimentacao.getInstance();
        this.list = Estoque.getInstancia();
    }

    @Override
    public String getString(){
        return "Admin -> " + name;
    }

    @Override
    public void abrirOpcoes() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        boolean verif = verificacaoSenha(senha);

        while (!verif){

            System.out.println("Digite novamente sua senha: ");
            senha = scanner.nextLine();

            verif = verificacaoSenha(senha);

        }

        if(verif){

            Scanner scanOp = new Scanner(System.in);

            int op;

            do{
                opcoes();

                System.out.println("Com qual ação deseja prosseguir ?");
                op = scanOp.nextInt();

                selecionarOpcoes(op);

            }while (op != 0);


        }

    }

    @Override
    protected void opcoes() {
        AdminOp.imprimir();
    }

    @Override
    protected void selecionarOpcoes(int qtd){

        Scanner scanner = new Scanner(System.in);

        AdminOp op;

        try {

            op = AdminOp.selecionarOp(qtd);

        } catch (Exception e) {
            System.out.println("Opção inválida.");
            return;
        }

        try {
            switch (op) {
                case CADASTRAR:
                    System.out.println("Crie o produto: Ex: ( Nome, Qtd, preço ) ");
                    String name = scanner.next();
                    int qtd_op = scanner.nextInt();
                    double price = scanner.nextDouble();

                    criarProduto(name, qtd_op, price);
                    break;
                case LISTAR:

                    if (list == null) {
                        System.out.println("Estoque inexistente.");
                        return;
                    }

                    list.listar();
                    break;
                case BUSCAR:

                    if (list == null) {
                        System.out.println("Estoque inexistente.");
                        return;
                    }

                    System.out.println("Qual produto deseja procurar ?");
                    String nameProduto = scanner.nextLine();

                    list.buscar(nameProduto.toUpperCase());
                    break;
                case ATUALIZAR:

                    if (list == null) {
                        System.out.println("Estoque inexistente.");
                        return;
                    }

                    System.out.println("" +
                            "Selecione uma das opções: \n" +
                            "1 - Atualizar preço \n" +
                            "2 - Atualizar quantidade" +
                            "");

                    int select = scanner.nextInt();

                    list.listar();

                    if (select == 1) {

                        System.out.println("\nDigite o COD do produto: ");
                        int cod = scanner.nextInt();
                        System.out.println("Digite o novo preço: ");
                        double newPrice = scanner.nextDouble();

                        list.atualizarPrice(cod, newPrice);

                    } else if (select == 2) {

                        System.out.println("\nDigite o COD do produto: ");
                        int cod = scanner.nextInt();
                        System.out.println("Digite a quantidade que deseja adicionar: ");
                        int moreQtd = scanner.nextInt();

                        try {

                            list.adicionarQtdProduto(cod, moreQtd);

                            Produto produto = Estoque.getInstancia().retornarProduto(cod);

                            this.movimentacao = new Movimentacao(this, produto, moreQtd, 1);
                            historicoMovimentacao.inserirNoHistorico(movimentacao);

                        } catch (RuntimeException e) {
                            System.out.println("Codigo do produto invalido.");
                        }


                    } else {
                        System.out.println("" +
                                "Selecione uma opção existente." +
                                "O programa vai se encerrar."
                        );

                    }

                    break;
                case EXCLUIR:

                    if (list == null) {
                        System.out.println("Estoque inexistente.");
                        return;
                    }

                    System.out.println("Digite o codigo do produto que desja excluir: ");
                    int c = scanner.nextInt();

                    list.excluir(c);

                    break;
                case CONSULTAR:

                    if (list == null) {
                        System.out.println("Estoque inexistente.");
                        return;
                    }

                    System.out.println("Digite o cod para ver q qtd no estoque:  ");
                    int i = scanner.nextInt();

                    list.consultarQtdProduto(i);

                    break;
                case HISTORICOMOVIMENTACAO:

                    historicoMovimentacao.imprimirHistorico();

                    break;
                case ALERTAESTOQUE:
                    list.imprimirAlerta();
                    break;
                case ALTERAR:
                    System.out.println("Digite a nova senha: ");
                    String s = scanner.nextLine();

                    recuperarSenha(s);
                    break;
                case SAIR:
                    System.out.println("Encerrou o programa.");
                    break;

                default:

                    break;
            }
        } catch (RuntimeException e) {
            System.out.println("Opção invalidade!!!");
        }

    }

    private void criarProduto(String name, int qtd, double preco){

        if(list == null){
            System.out.println("Estoque inexistente!!!");
            return;
        }

        this.produto = new Produto(name, qtd, preco);

        inserirProdutoNoEstoque(this.produto);
    }

    private void inserirProdutoNoEstoque(Produto produto){
        list.cadastrar(produto);
    }

}
