package Practica2;
import Practica2.clase.Clase_user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Menu principal de la gestion de bocadillos, usuarios y pedidos.
 * @since 12/02/2025
 * @version 21.0.4
 * @author Daniel Pmaies Teruel
 */

public class Main {

    /**
     * Aqui es donde empiezan a ejeturse el codigo con las funciones creadas y explicadas anteriormente
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Arrays clases

        ArrayList<Clase_user> usuarios = new ArrayList<>();

        //USUARIO ADMIN

        usuarios.add(new Clase_user("admin","admin", "admin@gmail.com", "admin", "Admin_1", new ArrayList<>(), LocalDate.of(2006,03,29), 1));

        //ELECCIÓN

        String elec = "";

        //SEGUIR

        boolean next = true;

        //Aquí empieza el menu principal
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
            System.out.println("     Marcar pedidos como retirado" );
            System.out.println("5. Salir");
            elec = sc.nextLine();
            next = true;

            switch (elec) {
                case "1":
                    do {
                        System.out.println("1. Listar usuarios");
                        System.out.println("2. Añadir nuevo usuario");
                        System.out.println("3. Volver al menu princiapal");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                Validaciones.listarUsuarios(usuarios);
                                next = true;
                                break;
                            case "2":
                                Validaciones.agregarUsuarios(usuarios);
                                next = true;
                                break;
                            case "3":
                                System.out.println("Saliendo al menu principal ...");
                                next = false;
                                break;
                            default:
                                System.out.println("Tienes que elegir");
                                next = true;
                                break;
                        }
                    } while (next);
                case "2":
                    do {
                        System.out.println("1. Listar bocadillos disponibles");
                        System.out.println("2. Ver curiosidades de un bocadillo");
                        System.out.println("3. Volver al menu princiapal");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                Validaciones.listarbocadillos();
                                next = true;
                                break;
                            case "2":
                                Validaciones.curiosidaBocata();
                                next = true;
                                break;
                            case "3":
                                next = false;
                                break;
                        }
                    }while (next);
            }
            next = true;

        } while (next);
    }


}
