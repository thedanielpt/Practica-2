package Practica2;

import java.util.Scanner;

public class Menu {
    public static void menuPrincipal(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String elec = "";
        do {
            System.out.println("Menu Principal\n");
            System.out.println("1. Gestionar usuarios:");
            System.out.println("     Listar usuarios");
            System.out.println("     Añadir nuevo usario");
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
                    break;
                case "2":
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
                case "3":
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
                        }
                        next = true;
                    } while (next);
                case "4":
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
                        }
                        next = true;
                    } while (next);
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
}
