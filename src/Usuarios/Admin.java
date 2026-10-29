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
    public void abrirOpcoes(int n) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite sua senha: ");
        String senha = scanner.nextLine();

        boolean verif = verificacaoSenha(senha);

        if(verif){
            opcoes();
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
        switch (qtd){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 0:
                break;
        }
    }

    public void criarProduto(String name, int qtd, double preco){

        if(list != null){
            this.produto = new Produto(name, qtd, preco);

            inserirProdutoNoEstoque();
        }

        System.out.println("Estoque inexistente!!!");
    }

    public void criarEstoque(int qtd){
        this.list = new Estoque(qtd);
    }

    private void inserirProdutoNoEstoque(){
        list.cadastrar(this.produto);
    }

}
