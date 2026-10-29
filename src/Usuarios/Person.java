package Usuarios;

import java.util.Scanner;

public abstract class Person {

    private String name;

    private String login;
    private String senha;

    private int tentativasSenha = 0;

    public Person(String name, String login, String senha){
        this.name = name;
        this.login = login;
        this.senha = senha;
    }

    protected String getLogin(){
        return this.login;
    }

    protected String getSenha(){
        return this.senha;
    }

    protected void recuperarSenha(String newSenha){
        this.senha = newSenha;
    }

    protected boolean verificacaoSenha(String senha) {

        if (senha.equals(this.senha)) {

            System.out.println("Senha aprovada!!!");
            this.tentativasSenha = 0;

            return true;

        } else {

            System.out.println("senha incorreta");
            this.tentativasSenha++;

            if(this.tentativasSenha >= 3){
                System.out.println("\n== Encaminhando para a recuperação de senha. ==");

                Scanner scanner = new Scanner(System.in);

                System.out.println("Digite sua nova senha: ");
                String newSenha = scanner.nextLine();

                recuperarSenha(newSenha);

                this.tentativasSenha = 0;

            }

        }

        return false;
    }

    public abstract void abrirOpcoes();

    protected abstract void opcoes();

}
