package Usuarios;

import Funcionalidade.Estoque;
import Funcionalidade.Produto;

import java.util.Scanner;

public class Admin extends Person{

    private Produto produto;
    private Estoque list;

    public Admin(String name, String login, String senha) {
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
        System.out.println(
                "" +
                "\n========== MENU ADMINISTRADOR ==========\n" +
                "1 - Criar estoque\n" +
                "2 - Cadastrar produto\n" +
                "3 - Listar produtos\n" +
                "4 - Buscar produto\n" +
                "5 - Atualizar produto\n" +
                "6 - Excluir produto\n" +
                "7 - Consultar quantidade em estoque\n" +
                "8 - Alterar senha\n" +
                "0 - Sair\n" +
                "========================================"
        );
    }

    @Override
    protected void selecionarOpcoes(int qtd){

        Scanner scanner = new Scanner(System.in);

        switch (qtd){
            case 1:
                System.out.println("Digite o tamanho do estoque: ");
                int tamanho = scanner.nextInt();

                criarEstoque(tamanho);
                break;
            case 2:
                System.out.println("Crie o produto: Ex: ( Nome, Qtd, preço ) ");
                String name = scanner.next();
                int qtd_op = scanner.nextInt();
                double price = scanner.nextDouble();

                criarProduto(name, qtd_op, price);
                break;
            case 3:

                if(list  == null){
                    System.out.println("Estoque inexistente.");
                    return;
                }

                list.listar();
                break;
            case 4:
                System.out.println("Qual produto deseja procurar ?");
                String nameProduto = scanner.nextLine();
                list.buscar(nameProduto);
                break;
            case 5:
                System.out.println("" +
                        "Selecione uma das opções: \n" +
                        "1 - Atualizar preço \n" +
                        "2 - Atualizar quantidade" +
                        "");

                int select = scanner.nextInt();

                list.listar();

                if(select == 1){

                    System.out.println("\nDigite o COD do produto: ");
                    int cod = scanner.nextInt();
                    System.out.println("Digite o novo preço: ");
                    double newPrice = scanner.nextDouble();

                    list.atualizarPrice(cod, newPrice);

                } else if (select == 2){

                    System.out.println("\nDigite o COD do produto: ");
                    int cod = scanner.nextInt();
                    System.out.println("Digite o valor que deseja adicionar: ");
                    int newPrice = scanner.nextInt();

                    list.adicionarQtdProduto(cod, newPrice);
                }else{
                    System.out.println("" +
                            "Selecione uma opção existente." +
                            "O programa vai se encerrar."
                    );

                }

                break;
            case 6:
                System.out.println("Digite o codigo do produto que desja excluir: ");
                int c = scanner.nextInt();

                list.excluir(c);

                break;
            case 7:

                System.out.println("Digite o cod para ver q qtd no estoque:  ");
                int i = scanner.nextInt();

                list.consultarQtdProduto(i);

                break;
            case 8:
                System.out.println("Digite a nova senha: ");
                String s = scanner.nextLine();

                recuperarSenha(s);
                break;
            case 0:
                System.out.println("Encerrou o programa.");
                break;
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

    private void criarEstoque(int qtd){

        if(list != null){
            System.out.println("Já existe um estoque cadastrado nesse admin.");
            return;
        }

        this.list = new Estoque(qtd);
    }

    private void inserirProdutoNoEstoque(Produto produto){
        list.cadastrar(produto);
    }

}
