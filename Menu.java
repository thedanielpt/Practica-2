package Practica2;

import java.util.Scanner;

public class Menu {

    /**
     *Metodo donde esta el menu Admin
     */
    public void menuAdmin(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

        do {
            System.out.println("Menu Principal\n");
            System.out.println("1. Gestionar usuarios:");
            System.out.println("     Listar usuarios");
            System.out.println("2. Gestionar Bocadillos:");
            System.out.println("     Listar bocadillos disponibles");
            System.out.println("     Ver curiosidades de un bocadillo");
            System.out.println("3. Realizar Pedido:");
            System.out.println("     Seleccionar usuario");
            System.out.println("     Eligir Bocadillo");
            System.out.println("     Confirmar pedido");
            System.out.println("4. Consultar Pedidos:");
            System.out.println("     Mostrar pedidos de un usuario");
            System.out.println("     Marcar pedidos como retirado");
            System.out.println("5. Salir");
            elec = sc.nextLine();
            next = true;

            switch (elec) {
                case "1":
                    adminGestionUsers();
                    next = true;
                    break;
                case "2":
                    adminGestionarBocadillos();
                    next = true;
                    break;
                case "3":
                    adminRealizarPedido();
                    next = true;
                    break;
                case "4":
                    adminConsultarPedidos();
                    next = true;
                    break;
                case "5":
                    next = false;
                    break;
                default:
                    System.out.println("Tienes que seleccionar una opción");
                    next = true;
                    break;
            }

        } while (next);
    }

    /**
     * Menu de admin de gestion de usuarios
     */

    public void adminGestionUsers(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;
        do {
            System.out.println("1. Listar usuarios");
            System.out.println("2. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    next = true;
                    break;
                case "2":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    //Menu de admin para la gestion de bocadillos

    public static void adminGestionarBocadillos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Listar bocadillos disponibles");
            System.out.println("2. Ver curiosidades de un bocadillo");
            System.out.println("3. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    next = true;
                    break;
                case "2":
                    next = true;
                    break;
                case "3":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    /**
     * Metodo para la realización de los pedidos
     */

    public void adminRealizarPedido(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Seleccionar usuario");
            System.out.println("2. Elegir bocadillo");
            System.out.println("3. Confirmar pedido");
            System.out.println("4. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    next = true;
                    break;
                case "2":
                    next = true;
                    break;
                case "3":
                    next = true;
                    break;
                case "4":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
        } while (next);
    }

    public void adminConsultarPedidos(){
        Scanner sc = new Scanner(System.in);
        String elec = "";
        boolean next = true;

        do {
            System.out.println("1. Mostrar pedidos de un usuario");
            System.out.println("2. Marcar pedidos como retirado");
            System.out.println("3. Volver al menu princiapal");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    next = true;
                    break;
                case "2":
                    next = true;
                    break;
                case "3":
                    next = false;
                    break;
                default:
                    next = true;
                    break;
            }
            next = true;
        } while (next);
    }

    /**
     * Metodo donde esta el menu de Usuario
     */

    public void menuUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";

    }
}
