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

        if(verif){
            opcoes();

            Scanner scanOp = new Scanner(System.in);
            System.out.println("Com qual ação deseja prosseguir ?");
            int op = scanOp.nextInt();

            selecionarOpcoes(op);

        }

    }

    @Override
    protected void opcoes() {
        System.out.println(
                "" +
                "========== MENU ADMINISTRADOR ==========\n" +
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

    private void selecionarOpcoes(int qtd){

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
                list.listar();
                break;
            case 4:
                System.out.println("Qual produto deseja procurar ?");
                String nameProduto = scanner.nextLine();
                list.buscar(nameProduto);
                break;
            case 5:
                System.out.println("Digite o cod e o novo preço: ");
                int cod = scanner.nextInt();
                double preco = scanner.nextDouble();

                list.atualizar(cod, preco);

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
                String s = scanner.next();

                recuperarSenha(s);
                break;
            case 0:
                System.out.println("Encerrou o programa.");
                break;
        }
    }

    private void criarProduto(String name, int qtd, double preco){

        if(list != null){
            this.produto = new Produto(name, qtd, preco);

            inserirProdutoNoEstoque();
        }

        System.out.println("Estoque inexistente!!!");
    }

    private void criarEstoque(int qtd){
        this.list = new Estoque(qtd);
    }

    private void inserirProdutoNoEstoque(){
        list.cadastrar(this.produto);
    }

}
