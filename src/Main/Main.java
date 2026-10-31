package Main;

import Usuarios.Admin;
import Usuarios.Cliente;
import Usuarios.Person;

public class Main {

    static void main(String[] args) {

    Person adm = new Admin("Adm", "admin@admin.com", "admin1111");
    adm.abrirOpcoes();

    Cliente gui = new Cliente("Guilherme", "gui@gamil.com", "gui123");
    gui.abrirOpcoes();

    }
}
