package Enums;

public enum AdminOp {

    CRIAR(1, "Criar estoque"),
    CADASTRAR(2, "Cadastrar produto"),
    LISTAR(3, "Listar produto"),
    BUSCAR(4, "Buscar produto"),
    ATUALIZAR(5, "Atualizar produto"),
    EXCLUIR(6, "Excluir produto"),
    CONSULTAR(7, "Consultar quantidade em estoque"),
    HISTORICOMOVIMENTACAO(8, "Histórico de movimentações"),
    ALTERAR(8, "Alterar senha"),
    SAIR(0, "Sair");

    private int cod;
    private String conteudo;

    AdminOp(int cod, String conteudo){
        this.cod = cod;
        this.conteudo = conteudo;
    }

    private int getCod(){
        return this.cod;
    }

    private String getConteudo(){
        return this.conteudo;
    }

    public static AdminOp selecionarOp(int qtd){

        for (AdminOp op : AdminOp.values()){

            if(op.getCod() == qtd){
                return op;
            }

        }

        return null;
    }

    public static void imprimir(){

        System.out.println("\n========== MENU ADMINISTRADOR ==========\n");

        for(AdminOp atual : AdminOp.values()){
            System.out.println(atual.getCod() + " - " + atual.getConteudo());
        }

        System.out.println("\n========================================\n");
    }
}
