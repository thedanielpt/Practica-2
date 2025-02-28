package Practica2;

import java.awt.*;
import java.time.LocalDate;
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
        //REGISTRO

        //NOMBRE
        String name = "";

        //APELLIDOS
        String apellido1 = "";
        String apellido2 = "";

        //Nombre Usuario
        String nameUser = "";

        //Fecha
        String medirFecha = "";
        LocalDate fecha;
        int edad = 0;

        //Contraseña
        String contrasena = "";
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

                    //Pasas si validarAlfabetoLat es falso
                    do {
                        System.out.println("INTRODUCD EL NOMBRE ");
                        name = sc.nextLine();
                    }while (!Validaciones.validarAlfabetoLat(name));

                    //Pasas si validarAlfabetoLat es falso
                    do {
                        System.out.println("Introduce el primer apellido: ");
                        apellido1= sc.nextLine();
                    }while (!Validaciones.validarAlfabetoLat(apellido1));

                    //Pasas si validarAlfabetoLat es falso
                    do {
                        System.out.println("Introduce el segundo apellido: ");
                        apellido2= sc.nextLine();
                    }while (!Validaciones.validarAlfabetoLat(apellido2));

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
                    System.out.println("Nombre: " + name);
                    System.out.println("Apellidos: " + apellido1 + " " + apellido2);
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

                    do {
                        //Comprobacion de si estas registrado
                        if (nameUser.length() <= 4 || contrasena.length() <= 7) {
                            System.out.println("Tienes que registrarte");
                            next = false;
                        } else {
                            if (Validaciones.captcha()){
                                //Si a fallado el login la variable block pasa de false a true
                                if (block) {
                                    System.out.println("Lo siento esta cuenta esta bloqueada");
                                    next = true;
                                    break;
                                } else {
                                    for (int i = 0; i < 4; i++) {
                                        System.out.println("Pon el nombre de usuario");
                                        nameL = sc.nextLine();
                                        //Comprueba si nameL es igual a nameUser
                                        if (nameL.equals(nameUser)) {
                                            System.out.println("Pon la contraseña");
                                            contraL = sc.nextLine();
                                            //Comprueba si contraL es igual a contrasena
                                            if (contraL.equals(contrasena)){
                                                System.out.println(" Te has logueado");
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
                                                                System.out.println("2. Añadir nuevo usuario");
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

                                                                    case "2":

                                                                    case "3":

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

                                                                    case "2":

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
                                                break;
                                            } else {
                                                System.out.println("Contraseña incorrecta");
                                                next = true;
                                                //Si falla tres veces block pasa a true y si quieres que se convierta en false, tiene
                                                //que hacer la pregusta.
                                                if (i == 2){
                                                    block = true;
                                                    next = false;
                                                    break;
                                                }
                                            }
                                        } else {
                                            System.out.println("El nombre de usuario no es el mismo");
                                            next = true;
                                            //Si falla tres veces block pasa a true y si quieres que se convierta en false, tiene
                                            //que hacer la pregusta.
                                            if (i == 2){
                                                System.out.println("Usuario bloqueado");
                                                block = true;
                                                next = false;
                                                break;
                                            }
                                        }
                                    }
                                }
                            } else {
                                System.out.println("Se cancelo el registro");
                                next = false;
                            }
                        }
                    } while (next);
                    next = true;
                    break;
                case "3":
                    //RECUPERACIÓN CONTRASEÑA

                    //Comprueba si te has registrado
                    if (nameUser.length() <= 4 || contrasena.length() <= 7) {
                        System.out.println("Tienes que registrarte");
                    } else {
                        if (Validaciones.captcha()) {
                            compContrasena = Validaciones.recuperacionContrasena(pregunta, respuesta);
                            //Comprueba que el cambio de contraseña haya sido un exito, si no es el caso, esta funcion te devuelve nada,
                            //haciendo que contrasena no cambie, porque compContrasena no tiene ningun caracter
                            if (compContrasena.length() < 8) {
                                System.out.println("No se a podido cambiar la contraseña");
                            } else {
                                contrasena = compContrasena;
                            }
                        } else {
                            System.out.println("captcha no valido");
                        }
                    }
                    next = true;
                    break;
                case "4":
                    //GESTION DE BLOQUEO

                    //Comprueba si te has registrado
                    if (nameUser.length() <= 4 || contrasena.length() <= 7) {
                        System.out.println("Tienes que loguearte");
                    } else {
                        if (Validaciones.captcha()){
                            System.out.println(pregunta);
                            for (int i = 0; i < 3; i++) {
                                respuestaPre = sc.nextLine();
                                //Comprueba si respuestaPre es igual a respuesta
                                if (respuestaPre.equals(respuesta)) {
                                    System.out.println("Se te a desbloqueado el usuario");
                                    block = false;
                                    break;
                                    //Si lo intento tres veces le saca del bucle, sin desbloquear al usuario
                                } else  if (i == 2){
                                    System.out.println("Los intentos se han agotado");
                                    break;
                                } else {
                                    System.out.println("vuelve a intenatrlo");
                                }
                            }
                        } else {
                            System.out.println("Captcha no aceptado");
                        }
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
