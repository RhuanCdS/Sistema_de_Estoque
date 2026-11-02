package Usuarios.Enums;

public enum ClienteOp {

    LISTA(1, "Listar produtos disponiveis"),
    BUSCAR(2, "Buscar produto"),
    COMPRAR(3, "Comprar produto"),
    SAIR(0, "Sair");

    private int cod;
    private String conteudo;

    ClienteOp(int cod, String conteudo){
        this.cod = cod;
        this.conteudo = conteudo;
    }

    private int getCod(){
        return this.cod;
    }

    private String getConteudo(){
        return this.conteudo;
    }

    public static void imprimir(){

        System.out.println("========== MENU CLIENTE ==========\n");
        for(ClienteOp op: ClienteOp.values()){

            System.out.println(op.getCod() + " - " + op.getConteudo());

        }
        System.out.println("==================================\n");

    }

    public static ClienteOp selecionarOp(int qtd){

        for (ClienteOp n: ClienteOp.values()){
            if(n.getCod() == qtd){
                return n;
            }
        }

        return null;
    }

}
