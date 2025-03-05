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

    //CAPTCHA

    /**
     * El captcha esta hecho para sumar dos numeros creados por Math.random
     * @return boolean Si el usuario no hacierta la suma que se genera, pondra falso, caso contrario sera verdadero
     */
    public static boolean captcha () {
        Scanner scan = new Scanner(System.in);
        int num2 = (int) (Math.random() * 10);
        int num1 = (int) (Math.random() * 10);
        String respuesta;
        int respuestaPreg;
        int resultado;
        System.out.println("Haz esta suma");
        System.out.println(num1 + " + " + num2);
        for (int i = 0; i < 3; i++) {
            respuesta = scan.nextLine();
            //Comprueba si solo son numeros
            if (Validaciones.soloNum(respuesta)) {
                respuestaPreg = Integer.parseInt(respuesta);
                resultado = num1 + num2;
                //Comprueba si la respuesta puesta es igual al resultado, haciendo de que te saque de la funcion con un true
                if (respuestaPreg == resultado) {
                    return true;
                    //Si lo has intentado 3 veces te devuelve false
                } else if (i == 2) {
                    return false;
                } else {
                    System.out.println("Vuelve a intentarlo");
                }
            } else {
                System.out.println("Vuelve a intenarlo");
            }
        }
        return false;
    }

    //NOMBRE Y APELLIDOS

    /**
     * Este método lo que hace es devolver el nombre y apellido del usuario
     * @return String Devuelve el nombre y el apellido
     */

    public static String nombreApellidos(){

        Scanner sc = new Scanner(System.in);

        String nombre = "";
        String apellido1 = "";
        String apellido2 = "";

        do {
            System.out.println("Introduce el nombre");
            nombre = sc.nextLine();
        }while (!Validaciones.validarAlfabetoLat(nombre));

        do {
            System.out.println("Introduce el primer apellido: ");
            apellido1 = sc.nextLine();
        }while (!Validaciones.validarAlfabetoLat(apellido1));

        do {
            System.out.println("Introduce el segundo apellido: ");
            apellido2 = sc.nextLine();
        }while (!Validaciones.validarAlfabetoLat(apellido2));

        String nombreApellidos = nombre + " " + apellido1 + " " + apellido2;

        return nombreApellidos;
    }
    //NOMBRE DE USUARIO


    /**
     * Valida el nombre de usuario
     * @return nameUser Contiene el nombre de usuario
     */

    public static String validarUsuario() {
        Scanner scan = new Scanner(System.in);
        String nameUser;
        boolean next;
        // Creación de nombre de usuario
        do {
            System.out.println("Pon el nombre de usuario que quieras, pero con estas restricciones:");
            System.out.println("- No puede tener menos de 5 letras");
            System.out.println("- No puede tener caracteres especiales");
            nameUser = scan.nextLine();
            /*Valida si hay espacios, si hay caracteres especiales y si mide menos de 5 caracteres
            Si no cumple saldras del bucle  */
            if (nameUser.length() < 5 || Validaciones.hayEspacio(nameUser) || Validaciones.hayEspecial(nameUser)) {
                System.out.println("Usuario no valido");
                next = true;
            } else next = false;


        } while (next);
        return nameUser;
    }

    //GMAIL

    /**
     * valida el gmail
     * @return gmail Contiene el gmail del usuario
     */
    public static String validarGmail(){
        Scanner scan = new Scanner(System.in);
        boolean next;
        String gmail;
        do {
            System.out.println("Ahora pon tu correo electronico");
            gmail = scan.nextLine();
            //Comprueba si tienes mas de un arroba
            if (Validaciones.siTieneMasArroba(gmail)){
                System.out.println("Tiene que tener solo un arroba y un punto");
                next = true;
            } else {
                //Comprueba si gmail tiene caracteres especiales que no se perimiten en el gmail
                if (Validaciones.espeGmail(gmail)){
                    System.out.println("no puede tener caracteres especiales");
                    next = true;
                } else {
                    //Comprueba si hay espacios
                    if (Validaciones.hayEspacio(gmail)){
                        System.out.println("No puede tener espacios");
                        next = true;
                    } else {
                        /*
                        Comprueba aquí que tengas caracteres antes del arroba, que el ultimo punto que pongas no este detras
                        del arroba, que en medio del punto y arroba alla un caracter y que el punto tenga delante un caracter
                         */
                        if (Validaciones.noDelanteArrobPunto(gmail)){
                            System.out.println("Tiene que tener el arroba delante del punto y con algo en medio");
                            System.out.println("No has puesto delante del punto nada o detras del arroba");
                            next = true;
                        } else {
                            System.out.println("Este es tu gmail " + gmail);
                            next = false;
                        }
                    }
                }
            }
        } while (next);
        return gmail;
    }

    //CONTRASEÑA

    /**
     * Valida la contraseña
     * @return contrasena Contiene la contraseña del usuario
     */
    public static String validarContrasena() {
        String contrasena;
        Scanner scan = new Scanner(System.in);
        String compContrasena;
        boolean next = true;
        do {
            System.out.println("Pon la contraseña que quieras, pero con estas caracteristicas:");
            System.out.println("- Minimo tiene que tener un caracter especial");
            System.out.println("- Minimo tiene que tener ocho letras");
            System.out.println("- Minimo tiene que tener una letra mayuscula");
            System.out.println("- Minimo tiene que tener una letra miniscula");
            System.out.println("- Minimo tiene que tener un numero");
            contrasena = scan.nextLine();
            //Comprueba si contrasena tiene caracteres especiales, si mide mas de 8 caracteres, si hay mayusculas, si hay minusculas y
            //si hay numeros.
            //Si no tiene alguno de estas caracteristicas, se repite el bucle
            if (Validaciones.hayEspecial(contrasena) && contrasena.length() >= 8 && Validaciones.hayMayus(contrasena)
                    && Validaciones.hayMinus(contrasena) && Validaciones.hayNum(contrasena)) {
                System.out.println("Ponme otra vez la contraseña que has escrito");
                for (int i = 0; i < 3; i++) {
                    compContrasena = scan.nextLine();
                    if (compContrasena.equals(contrasena)) {
                        next = false;
                        break;
                    } else {
                        System.out.println("vuelve a intentarlo");
                    }
                }
            } else {
                System.out.println("Contraseña incorrecta");
                next = true;
            }
        } while (next);
        return contrasena;
    }

    //Fecha

    /**
     * Este metodo devuelve la fecha del usuario que se halla
     * @return Fecha de usuario
     */

    public static LocalDate validarFecha(){
        Scanner sc = new Scanner(System.in);
        LocalDate fecha = null;
        LocalDate hoy = LocalDate.now();
        int anoActual = hoy.getYear();

        String selec = "";
        int anoU = 0;
        int mesU = 0;
        int diaU = 0;
        boolean next = true;
        //AÑO

        do {
            System.out.println("Pon tu año de nacimiento");
            selec = sc.nextLine();

            if (Validaciones.soloNum(selec)){
                anoU = Integer.parseInt(selec);
                if (anoU < 1950 || anoU > anoActual) {
                    System.out.println("Año no valido");
                    next = true;
                } else {
                    System.out.println("Tu año es = "+anoU);
                    next = false;
                }
            } else {
                System.out.println("Tiene que ser solo números");
                next = true;
            }
        } while (next);

        //MES

        do {
            System.out.println("Pon tu mes de nacimiento");
            selec = sc.nextLine();

            if (Validaciones.soloNum(selec)){
                mesU = Integer.parseInt(selec);
                if (mesU < 1 || 12 < mesU ) {
                    System.out.println("mes no valido");
                    next = true;
                } else {
                    System.out.println("Tu mes es = "+mesU);
                    next = false;
                }
            } else {
                System.out.println("Tiene que ser solo números");
                next = true;
            }
        } while (next);

        //Esto sirve para saber la longitud del mes.
        //Primero ponemos los valores del año y el mes en fecha
        fecha = LocalDate.of(anoU,mesU,1);

        //Ahora se le pide que diga la longitud del mes
        int longitudMesActual = fecha.lengthOfMonth();

        //DÍA

        do {
            System.out.println("Pon tu día de nacimiento");
            selec = sc.nextLine();

            if (Validaciones.soloNum(selec)){
                diaU = Integer.parseInt(selec);
                if (diaU < 1 || diaU > longitudMesActual) {
                    System.out.println("Día no valido");
                    next = true;
                } else {
                    System.out.println("Tu día es = "+diaU);
                    next = false;
                }
            } else {
                System.out.println("Tiene que ser solo números");
                next = true;
            }
        } while (next);
        fecha = LocalDate.of(anoU, mesU,diaU);
        System.out.println(fecha);
        return fecha;
    }
}
