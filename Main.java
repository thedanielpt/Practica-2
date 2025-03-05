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
        String nombre = "";

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
                        Menu.menuPrincipal();
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
