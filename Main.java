package Practica2;

import Practica2.clase.Bocatas;
import Practica2.clase.Calendario;
import Practica2.clase.Pedidos;
import Practica2.clase.User;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Menu principal de la gestion de bocadillos, usuarios y pedidos.
 * @since 12/02/2025
 * @version 21.0.4
 * @author Daniel Pmaies Teruel
 */

public class Main {

    // Array de usuarios y bocatas

    private static User[] usuarios = new User[10];
    private static Bocatas[] bocatas = new Bocatas[10];
    private static Pedidos[] pedidos = new Pedidos[5];
    private static Calendario[] calendarios = new Calendario[5];

    /**
     * Metodo donde se instancian los usuarios
     */
    public static void cargarUsuaios(){
        String[] alergias = {"Frutos secos", "Polen"};

        usuarios[0] = new User("Daniel", "Daniel Pamies Teruel", "1º ESO", "danielpameisteruel@gmail.com", "Daniel_1", false, LocalDate.of(2006, 3, 29), 0);
        usuarios[1] = new User("Javi", "Javi solemne malo", "2ºESO", "javisolemnemalo2gmail.com", "Javi_123", true, alergias ,LocalDate.of(2000, 05, 23), 0);
        usuarios[2] = new User("Lucia", "Lucia buena mala", "2ºESO", "luciabuenamala@gmail.com", "Lucia_12", false, LocalDate.of(2006,12,29), 0);
        usuarios[3] = new User("Carlos", "Carlos el grande", "2ºESO", "carlosgrande@gmail.com", "Carlos_34", true, alergias , LocalDate.of(2005, 3, 15), 0);
        usuarios[4] = new User("Ana", "Ana la sabia", "3ºESO", "analasabia@gmail.com", "Ana_45", false, LocalDate.of(2007, 7, 25), 0);
        usuarios[5] = new User("Pedro", "Pedro el valiente", "4ºESO", "pedrovaliente@gmail.com", "Pedro_78", true, alergias,LocalDate.of(2006, 11, 10), 0);
        usuarios[6] = new User("María", "María la rápida", "2ºESO", "marialarapida@gmail.com", "Maria_56", false, LocalDate.of(2006, 5, 3), 0);
        usuarios[7] = new User("Evaristo", "Evaristo el roñzas", "2ºESO", "evaristoelroñas@gmail.com", "Evaristo_1", false, LocalDate.of(1980, 05, 17), 0);
        usuarios[8] = new User("Hugo", "Hugo el deportista", "4ºBach", "hugodeporte@gmail.com", "Hugo_22", false, LocalDate.of(2004, 6, 17), 0);
        usuarios[9] = new User("Laura", "Laura la estudiosa", "2ºESO", "lauraestudios@gmail.com", "Laura_55", false, LocalDate.of(2007, 10, 11), 0);
    }

    //Metodo donde se instancian los bocatas

    public static void cargarBocatas(){
        String[] ingredientes = {"Tortilla, aceite"};
        String [] alergias = {"Gluten"};

        bocatas[0] = new Bocatas(0, "Bocadillo de tortilla", "Está hecho para la gente que quiere ser feliz", ingredientes, alergias, "Callosa", 3.5, false);
        bocatas[1] = new Bocatas(1, "Bocadillo de tortilla con jamón", "Perfecto para un almuerzo rápido", ingredientes, alergias, "Alcoy", 4.0, true);
        bocatas[2] = new Bocatas(2, "Bocadillo de tortilla con queso", "Ideal para los amantes del queso", ingredientes, alergias, "Elche", 4.2, false);
        bocatas[3] = new Bocatas(3, "Bocadillo de tortilla con atún", "Para los que prefieren el mar", ingredientes, alergias, "Alicante", 4.5, true);
        bocatas[4] = new Bocatas(4, "Bocadillo de tortilla con pimiento", "Una opción más vegetal", ingredientes, alergias, "Benidorm", 3.8, false);
        bocatas[5] = new Bocatas(5, "Bocadillo de tortilla con tomate", "Fresco y delicioso", ingredientes, alergias, "Altea", 4.0, true);
        bocatas[6] = new Bocatas(6, "Bocadillo de tortilla con chistorra", "Para los amantes de los sabores fuertes", ingredientes, alergias, "Castellón", 5.0, false);
        bocatas[7] = new Bocatas(7, "Bocadillo de tortilla con aguacate", "La combinación perfecta para los veganos", ingredientes, alergias, "Orihuela", 4.3, true);
        bocatas[8] = new Bocatas(8, "Bocadillo de tortilla con salchichón", "El clásico con un toque de sabor", ingredientes, alergias, "Elx", 4.1, false);
        bocatas[9] = new Bocatas(9, "Bocadillo de tortilla con espinacas", "Una opción saludable y deliciosa", ingredientes, alergias, "Torrevieja", 4.0, true);
    }

    //Metodo donde se instancia los pedidos

    public static void cargarPedidos(){
        pedidos[0] = new Pedidos(0, "Daniel", 0, LocalDate.now(), "Pendiente");
        pedidos[1] = new Pedidos(1, "Maria", 1, LocalDate.now().minusDays(1), "Entregado");
        pedidos[2] = new Pedidos(2, "Ana", 2, LocalDate.now().plusDays(2), "En proceso");
        pedidos[3] = new Pedidos(3, "Hugo", 3, LocalDate.now(), "Cancelado");
        pedidos[4] = new Pedidos(4, "Laura", 4, LocalDate.now().minusDays(3), "Pendiente");
    }

    public static void cargarCalendario(){
        String [] bocata_frio = {bocatas[0].getNombre(), bocatas[2].getNombre(), bocatas[4].getNombre(), bocatas[6].getNombre(), bocatas[8].getNombre()};
        String [] bocata_caliente = {bocatas[1].getNombre(), bocatas[3].getNombre(),bocatas[5].getNombre(),bocatas[7].getNombre(), bocatas[9].getNombre()};
        calendarios[0] = new Calendario(0, LocalDate.of(2025, 03,6), LocalDate.of(2025, 03,8), bocata_caliente, bocata_frio);
        calendarios[1] = new Calendario(1, LocalDate.of(2025, 03,7), LocalDate.of(2025, 03,9), bocata_caliente, bocata_frio);
        calendarios[2] = new Calendario(2, LocalDate.of(2025, 03,8), LocalDate.of(2025, 03,10), bocata_caliente, bocata_frio);
        calendarios[3] = new Calendario(3, LocalDate.of(2025, 03,9), LocalDate.of(2025, 03,11), bocata_caliente, bocata_frio);
        calendarios[4] = new Calendario(4, LocalDate.of(2025, 03,10), LocalDate.of(2025, 03,12), bocata_caliente, bocata_frio);
    }

    /**
     * Aqui es donde empiezan a ejeturse el codigo con las funciones creadas y explicadas anteriormente
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        cargarUsuaios();
        //REGISTRO

        //NOMBRE
        String nombre = "";

        //Nombre Usuario
        String nameUser = "Daniel";

        //Fecha
        String medirFecha = "";
        LocalDate fecha;
        int edad = 0;

        //Contraseña
        String contrasena = "Daniel_1";
        String compContrasena = "";
        String contrasenaNueva = "";
        String contrasenaguardada = "";

        //DNI / NIE
        String dniNum = "";
        String dniletra = "";
        String letNie = "";
        String id = "";

        //Gmail
        String gmail = "";

        //INICIO DE SESION
        String nameL;
        String contraL;

        //Para salir del do while
        boolean next = true;

        //Para los saltos
        String salto;

        //Para afirmar o elegir
        String conf;
        String elec;

        //Pregunta
        String pregunta = "";
        String respuesta = "";
        String respuestaPre = "";

        //BLOQUEO
        boolean block = false;
        boolean vete = false;

        do {
            System.out.println("== MENU INICIO ==");
            System.out.println("1. REGISTRO");
            System.out.println("2. LOGIN");
            System.out.println("3. RECUPERACIÓN DE CONTRASEÑA");
            System.out.println("4. GESTIÓN DE BLOQUEO");
            System.out.println("0. Salir");
            elec = sc.nextLine();
            System.out.println("Selecciona una opción: " + elec);

            switch (elec) {

                case "1":
                    // REGISTRO

                    //CAPTCHA
                    if (Validaciones.captcha()){
                        System.out.println("captch completado");
                    } else {
                        System.out.println("Se cancelo el registro");
                        next = true;
                        break;
                    }

                    // Creación de nombre

                    nombre = Validaciones.nombreApellidos();

                    //Pasas si validarAlfabetoLat es falso

                    nombre = Validaciones.nombreApellidos();

                    // Creación de nombre de usuario

                    nameUser = Validaciones.validarUsuario();

                    //CREACIÓN DE FECHA

                    fecha = Validaciones.validarFecha();

                    //CREACION DE CONTRASEÑA

                    contrasena = Validaciones.validarContrasena();

                    //CREAR CORREO

                    gmail = Validaciones.validarGmail();

                    //PREGUNTA IMPORTANTE

                    do {
                        System.out.println("Ahora elige entre estas preguntas de seguridad");
                        System.out.println("1. ¿Cual es tu comida favorita?");
                        System.out.println("2. ¿Cual es tu juego favorito?");
                        System.out.println("3. ¿Cual es tu numero favorito?");
                        elec = sc.nextLine();
                        switch (elec){
                            case "1":
                                System.out.println("¿Cual es tu comida favorita?");
                                respuesta = sc.nextLine();
                                pregunta = "¿Cual es tu comida favorita?";
                                next = false;
                                break;
                            case "2":
                                System.out.println("¿Cual es tu juego favorito?");
                                respuesta = sc.nextLine();
                                pregunta = "¿Cual es tu juego favorito?";
                                next = false;
                                break;
                            case "3":
                                System.out.println("¿Cual es tu numero favorito?");
                                respuesta = sc.nextLine();
                                pregunta = "¿Cual es tu numero favorito?";
                                next = false;
                                break;
                            default:
                                System.out.println("Tienes que elegir una opción");
                                next = true;
                        }
                    } while (next);


                    next = true;
                    System.out.println("Usuario registrado");
                    System.out.println("__________________");
                    System.out.println("Nombre y apellidos: " + nombre);
                    System.out.println("Name usuario: " + nameUser);
                    System.out.println("Contraseña: " + contrasena);
                    System.out.println("Fecha: " + fecha);
                    System.out.println("Gmail " + gmail);
                    System.out.println("DNI/NIF " + id);
                    System.out.println("__________________");
                    System.out.println("");
                    System.out.println("Pulsa intro cuadno quieras salirte");
                    block = false;
                    break;

                case "2":
                    //LOGIN
                    if (ServiciosUsers.login(nameUser, contrasena, block)) {

                    } else {
                        block = true;
                        next = true;
                        break;
                    }
                    next = true;
                    break;
                case "3":
                    //RECUPERACIÓN CONTRASEÑA

                    if (Validaciones.captcha()) {
                        compContrasena = ServiciosUsers.recuperacionContrasena(pregunta, respuesta);
                        /*Comprueba que el cambio de contraseña haya sido un exito, si no es el caso,
                        esta funcion te devuelve nada, haciendo que contrasena no cambie, porque
                        compContrasena no tiene ningun caracter*/
                        if (compContrasena.length() < 8) {
                            System.out.println("No se a podido cambiar la contraseña");
                        } else {
                            contrasena = compContrasena;
                        }
                    } else {
                        System.out.println("captcha no valido");
                    }
                    next = true;
                    break;
                case "4":
                    //GESTION DE BLOQUEO

                    if (ServiciosUsers.gestionBloqueo(pregunta, respuesta, block)) {
                        block = true;
                    } else {
                        block = false;
                    }
                    next = true;
                    break;
                case "0":
                    System.out.println("Adeu");
                    next = false;
                    break;
                default:
                    System.out.println("Elige una opción");
                    next = true;
                    break;
            }
        }while (next);

    }
}
