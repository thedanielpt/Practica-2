package Practica2;

import java.time.LocalDate;
import java.util.Scanner;

public class ServiciosUsers {

    /**
     * Sirve para ver is eres un alumno.
     * @param tipo para ver que tipo de curso es
     * @return devuelve el tl numero del rol que eres
     */

    public static String rolEsoGm(String tipo){
        String[] ESO = {"1ªESO","2ªESO","3ªESO","4ªESO"};
        String[] GM = {"1ºAño GM Informatica", "2ºAño GM Informatica", "1ºAño GM Jardinería", "2ºAño GM Jardinería"};
        String trabajador = "Trabajador";
        String cocina = "Cocina";
        String admin = "admin";
        for (int i = 0; i < ESO.length; i++) {
            if (tipo.equalsIgnoreCase(ESO[i])) {
                return ESO[i];
            }
        }

        for (int i = 0; i < GM.length; i++) {
            if (tipo.equalsIgnoreCase(GM[i])) {
                return GM[i];
            }
        }

        if (tipo.equalsIgnoreCase(trabajador)) {
            return trabajador;
        } else if (tipo.equalsIgnoreCase(cocina)) {
            return cocina;
        } else if (tipo.equalsIgnoreCase(admin)) {
            return admin;
        }

        return null;
    }

    // RECUPERACIÓN CONTRASEÑA

    /**
     * Recuperar la contraseña
     * @param pregunta Pregunta elegida cuando se haya hecho el registro
     * @param respuesta Respuesta escrita por el usuario, para responder a la pregunta
     * @return contrasenaNueva Contiene la nueva contraseña que se a esrito el usuario, si el usuario no a podido cambiarla, no
     * tendra ningun caracter
     */
    public static String recuperacionContrasena(String pregunta, String respuesta) {
        Scanner scan = new Scanner(System.in);
        boolean next = false;
        String contrasena = "";
        String compContrasena = "";
        String contrasenaNueva = "";
        String respuestaPre = "";
        boolean vete = false;
        do {
            for (int i = 0; i < 3; i++) {
                System.out.println(pregunta);
                respuestaPre = scan.nextLine();
                //Comprueba si la respuesta qeu a escrito es igual a la respuesta correcta
                if (respuestaPre.equals(respuesta)) {
                    System.out.println("Pon tu nueva contraseña");
                    for (int j = 0; j < 3; j++) {
                        contrasenaNueva = scan.nextLine();
                        /*
                        Comprueba si contrasena tiene caracteres especiales, si mide 8 caracteres, si hay mayusculas, si hay
                        mminusculas y si hay numeros
                         */
                        if (Validaciones.hayEspecial(contrasenaNueva) && contrasenaNueva.length() >= 8 && Validaciones.hayMayus(contrasenaNueva) &&
                                Validaciones.hayMinus(contrasenaNueva) && Validaciones.hayNum(contrasenaNueva)) {
                            System.out.println("Ponme otra vez la contraseña que  has escrito");
                            for (int e = 0; e < 3; e++) {
                                compContrasena = scan.nextLine();
                                //Devuelve a repetir que pongas la contrasena para que se canvie.
                                if (compContrasena.equals(contrasenaNueva)) {
                                    contrasena = contrasenaNueva;
                                    return contrasena;
                                    //Si lo intentas tres veces y no funciona te saca y no habras cambieado la contraseña
                                } else if (e == 2) {
                                    contrasena = "";
                                    vete = true;
                                    System.out.println("La has puesto mal demasiadas veces");
                                    return contrasena;
                                } else {
                                    System.out.println("vuelve a intentarlo");
                                }
                            }
                        } else if (j == 2) {
                            System.out.println("demasiados intentos");
                            return contrasena;
                        } else {
                            System.out.println("vuelve a intentarlo");
                        }
                    }
                    System.out.println("Confirma la nueva contraseña");
                } else {
                    System.out.println(" vuelve a intentarlo");
                    if (i == 2) {
                        return contrasena;
                    }
                }
            }
        } while (next);

        vete = false;
        return contrasenaNueva;
    }

    /**
     * Sirve para que los usuarios se logueen con su usuario
     * @param nameUser
     * @param contrasena
     * @param block
     * @return devuelve true si se han logueado y false si no se han logueado
     */

    public static boolean login(String nameUser, String contrasena, boolean block){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        String nameL = "";
        String contraL = "";

        if (Validaciones.captcha()){
            //Si a fallado el login la variable block pasa de false a true
            if (block) {
                System.out.println("Lo siento esta cuenta esta bloqueada");
                next = true;
                return false;
            } else {
                for (int i = 0; i < 4; i++) {
                    System.out.println("Pon el nombre de usuario");
                    nameL = sc.nextLine();
                    //Comprueba si nameL es igual a nameUser
                    if (nameL.equals(nameUser)) {
                        System.out.println("Pon la contraseña");
                        contraL = sc.nextLine();
                        //Comprueba si contraL es igual a contrasena
                        if (contraL.equals(contrasena)) {
                            System.out.println(" Te has logueado");
                            return true;
                        } else {
                            System.out.println("Contraseña incorrecta");
                            next = true;
                            //Si falla tres veces block pasa a true y si quieres que se convierta en false, tiene
                            //que hacer la pregusta.
                            if (i == 2) {
                                return false;
                            }
                        }
                    } else {
                        System.out.println("El nombre de usuario no es el mismo");
                        next = true;
                        //Si falla tres veces block pasa a true y si quieres que se convierta en false, tiene
                        //que hacer la pregusta.
                        if (i == 2) {
                            System.out.println("Usuario bloqueado");
                            return false;
                        }
                    }
                }
            }
        } else {
            System.out.println("Se cancelo el registro");
            next = false;
        }
        return false;
    }

    /**
     * Sirve para desbloquear a un usuario
     * @param pregunta
     * @param respuesta
     * @param block
     * @return te devuelve true si has contestado bien o false si no lo intentas demasiadas veces
     */

    public static boolean gestionBloqueo(String pregunta, String respuesta, boolean block){
        Scanner sc = new Scanner(System.in);
        String respuestaPre = "";

        //Comprueba si te has registrado
           if (Validaciones.captcha()){
               System.out.println(pregunta);
               for (int i = 0; i < 3; i++) {
                   respuestaPre = sc.nextLine();
                   //Comprueba si respuestaPre es igual a respuesta
                   if (respuestaPre.equals(respuesta)) {
                       System.out.println("Se te a desbloqueado el usuario");
                       return true;
                       //Si lo intento tres veces le saca del bucle, sin desbloquear al usuario
                   } else  if (i == 2){
                       System.out.println("Los intentos se han agotado");
                       return false;
                   } else {
                       System.out.println("vuelve a intenatrlo");
                   }
               }
           } else {
               System.out.println("Captcha no aceptado");
           }
        return false;
    }
}
