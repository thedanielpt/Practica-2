package Practica2;
import Practica2.clase.Calendario;
import Practica2.clase.Clase_bocatas;
import Practica2.clase.Clase_pedidos;
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
        ArrayList<Clase_bocatas> bocatas = new ArrayList<>();
        ArrayList<Clase_pedidos> pedidos = new ArrayList<>();
        ArrayList<Calendario> calendarios = new ArrayList<>();

        //USUARIO ADMIN

        usuarios.add(new Clase_user("admin","admin", "admin@gmail.com", "admin", "Admin_1",false, new String[50], LocalDate.of(2006,03,29), 1));
        usuarios.add(new Clase_user("daniel","admin", "admin@gmail.com", "admin", "Daniel_1",false, new String[50], LocalDate.of(2006,03,29), 1));

        //USUARIOS ESO

        usuarios.add(new Clase_user("daniel_1", "Carlos Pérez", "carlos4eso@email.com", "4ºESO", "Daniel_1",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2009, 5, 14), 3));
        usuarios.add(new Clase_user("user2_4ESO", "Marta López", "marta4eso@email.com", "4ºESO", "Pass_2",false, new String[50], LocalDate.of(2009, 8, 22), 3));

        usuarios.add(new Clase_user("user1_3ESO", "Luis Gómez", "luis3eso@email.com", "3ºESO", "Pass_3",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2010, 3, 10), 3));
        usuarios.add(new Clase_user("user2_3ESO", "Ana Ramírez", "ana3eso@email.com", "3ºESO", "Pass_4",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2010, 11, 5), 3));

        usuarios.add(new Clase_user("user1_2ESO", "Pedro Fernández", "pedro2eso@email.com", "2ºESO", "Pass_5",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2011, 7, 19), 3));
        usuarios.add(new Clase_user("user2_2ESO", "Lucía Sánchez", "lucia2eso@email.com", "2ºESO", "Pass_6",false, new String[50], LocalDate.of(2011, 2, 25), 3));

        usuarios.add(new Clase_user("user1_1ESO", "Daniel Ruiz", "daniel1eso@email.com", "1ºESO", "Pass_7",false, new String[50], LocalDate.of(2012, 9, 30), 3));
        usuarios.add(new Clase_user("user2_1ESO", "Sara Torres", "sara1eso@email.com", "1ºESO", "Pass_8",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2012, 6, 18), 3));

        //USUARIOS GRADO MEDIO

        usuarios.add(new Clase_user("user1_GMInfo1", "Javier Ortega", "javierinfo1@email.com", "1ºAño GM Informática", "Pass_9",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2007, 12, 1), 3));
        usuarios.add(new Clase_user("user2_GMInfo1", "Laura Medina", "laurainfo1@email.com", "1ºAño GM Informática", "Pass_10",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2007, 4, 15), 3));

        usuarios.add(new Clase_user("user1_GMInfo2", "Manuel Castillo", "manuelinfo2@email.com", "2ºAño GM Informática", "Pass_11",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2006, 8, 27), 3));
        usuarios.add(new Clase_user("user2_GMInfo2", "Paula Reyes", "paulainfo2@email.com", "2ºAño GM Informática", "Pass_12",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2006, 11, 3), 3));

        usuarios.add(new Clase_user("user1_GMJard1", "Sergio Márquez", "sergiojard1@email.com", "1ºAño GM Jardinería", "Pass_13",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2007, 1, 9), 3));
        usuarios.add(new Clase_user("user2_GMJard1", "Elena Navarro", "elenajard1@email.com", "1ºAño GM Jardinería", "Pass_14",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2007, 5, 22), 3));

        usuarios.add(new Clase_user("user1_GMJard2", "Iván Herrera", "ivanjard2@email.com", "2ºAño GM Jardinería", "Pass_15",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2006, 10, 6), 3));
        usuarios.add(new Clase_user("user2_GMJard2", "Natalia Rojas", "nataliajard2@email.com", "2ºAño GM Jardinería", "Pass_16",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(2006, 2, 14), 3));


        //USUARIOS TRABAJADOR

        usuarios.add(new Clase_user("user1_Trabajador", "Fernando Gutiérrez", "fernandotrabajo@email.com", "Trabajador", "Pass_17",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(1985, 7, 25), 3));
        usuarios.add(new Clase_user("user2_Trabajador", "Andrea Suárez", "andreatrabajo@email.com", "Trabajador", "Pass_18",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(1990, 12, 13), 3));

        //USUARIOS COCINA

        usuarios.add(new Clase_user("user1_Cocina", "Raúl Montes", "raulcocina@email.com", "Cocina", "Pass_19",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(1982, 3, 8), 2));
        usuarios.add(new Clase_user("user2_Cocina", "Isabel Domínguez", "isabelcocina@email.com", "Cocina", "Pass_20",true, new String[] {"Pan fresco", "Salchichón de alta calidad"}, LocalDate.of(1987, 9, 30), 2));

        //BOCATAS

        String[] ingredientes = {"Pan fresco", "Salchichón de alta calidad"};
        String[] alergenos = {"Gluten", "Lácteos"};

        bocatas.add(new Clase_bocatas(1, "Bocadillo de Salchichón", "Un bocadillo delicioso con salchichón de alta calidad y pan crujiente.", ingredientes, alergenos, "Madrid", 3.50, true));
        bocatas.add(new Clase_bocatas(2, "Bocadillo de Salchichón", "Un bocadillo delicioso con salchichón de alta calidad y pan crujiente.", ingredientes, alergenos, "Madrid", 3.50, false));
        bocatas.add(new Clase_bocatas(3, "Bocadillo de Merluza", "Un bocadillo delicioso con salchichón de alta calidad y pan crujiente.", ingredientes, alergenos, "Madrid", 3.50, false));
        bocatas.add(new Clase_bocatas(4, "Bocadillo de Merluza", "Un bocadillo delicioso con salchichón de alta calidad y pan crujiente.", ingredientes, alergenos, "Madrid", 3.50, true));

        int numCalientes = 0;
        int numFrios = 0;

        for (Clase_bocatas bocata : bocatas) {
            if (bocata.getcaliente()) {
                numCalientes++;
            } else {
                numFrios++;
            }
        }

        String[] bocatasCalientes = new String[numCalientes];
        String[] bocatasfrios = new String[numFrios];
        int caliente = 0;
        int frio = 0;

        for (Clase_bocatas bocata : bocatas) {
            if (bocata.getcaliente()) {
                bocatasCalientes[caliente] = bocata.getNombre();
                caliente++;
            } else {
                bocatasfrios[frio] = bocata.getNombre();
                frio++;
            }
        }
        calendarios.add(new Calendario(bocatasCalientes, bocatasfrios));

        //PEDIDO

        pedidos.add(new Clase_pedidos (1, "admin",1,LocalDate.now(),"Pendiente"));

        //ELECCIÓN

        String elec = "";

        //FECHA

        LocalDate hoy = LocalDate.now();
        int diaHoy = hoy.getDayOfMonth();

        //USUARIO REGISTRADO

        String usuario = "daniel";
        String contrasena = "Daniel_1";

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
                    if (Validaciones.loginAdmin(usuarios)) {
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
                                    usuario = "";
                                    contrasena = "";
                                    break;
                                default:
                                    System.out.println("Tienes que elegir");
                                    next = true;
                                    break;
                            }
                        } while (next);
                    } else {
                        System.out.println("No puedes loguearte si no eres administrador");
                        next = false;
                        break;
                    }
                    break;
                case "2":
                    do {
                        System.out.println("1. Listar bocadillos disponibles");
                        System.out.println("2. Ver curiosidades de un bocadillo");
                        System.out.println("3. Volver al menu princiapal");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                Validaciones.listarbocadillos(bocatas);
                                next = true;
                                break;
                            case "2":
                                Validaciones.verCuriosidaBocata(bocatas);
                                next = true;
                                break;
                            case "3":
                                next = false;
                                break;
                            default:
                                System.out.println("Tienes que elegir una de las opciones");
                                next = true;
                                break;
                        }
                    }while (next);
                case "3":
                    do {
                        System.out.println("1. Seleccionar usuario");
                        System.out.println("2. Elegir bocadillo");
                        System.out.println("3. Confirmar pedido");
                        System.out.println("4. Volver al menu princiapal");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                usuario = Validaciones.loginUser(usuarios);
                                if (5 <= usuario.length()) {
                                    break;
                                } else {
                                   System.out.println("No has podido loguearte");
                                   usuario = "";
                                  break;
                                }
                            case "2":
                                do {
                                    if (5 <= usuario.length()) {
                                        Validaciones.elegirBocata(bocatas, usuario, usuarios, pedidos, calendarios);
                                        for (int i = 0; i < 10; i++) {
                                            System.out.println("¿Quieres pedir un bocata mas?");
                                            System.out.println("SI");
                                            System.out.println("NO");
                                            elec = sc.nextLine();

                                            if (elec.equalsIgnoreCase("si")) {
                                                Validaciones.elegirBocata(bocatas, usuario, usuarios, pedidos, calendarios);
                                            } else if (elec.equalsIgnoreCase("no")) {
                                                i = 12;
                                                System.out.println("Eston son los bocatas pedidos:");
                                                for (Clase_user user : usuarios) {
                                                    if (usuario.equalsIgnoreCase(user.getUsuario())) {
                                                        for (Clase_pedidos pedido : pedidos) {
                                                            if (pedido.getId_usuario().equalsIgnoreCase(user.getUsuario()) && pedido.getFecha().getDayOfMonth() == diaHoy){
                                                                System.out.println(pedido.mostrarDetallesPedidos());
                                                                System.out.println("------------------------------");
                                                            }
                                                        }
                                                    }
                                                }
                                                next = false;
                                                break;
                                            } else {
                                                next = true;
                                                System.out.println("Tienes que seleccionar uno");
                                            }
                                        }
                                    } else {
                                        System.out.println("No te has logueado");
                                        usuario = "";
                                        break;
                                    }
                                }while (next);
                            case "3":

                            case"4":
                                next = false;
                                break;
                        }
                        next = true;
                    }while (next);
            }
            next = true;

        } while (next);

    }
}
