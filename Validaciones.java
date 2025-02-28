package Practica2;

import Practica2.clase.Calendario;
import Practica2.clase.Clase_bocatas;
import Practica2.clase.Clase_pedidos;
import Practica2.clase.Clase_user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Validaciones {

    //VALIDACIONES

    public static String rolAdmin(String curso){
        if (curso.equalsIgnoreCase("Admin")) {
            return "Admin";
        }
        return null;
    }

    /**
     * Comprueba si el curso que esta buscando es este
     * @param curso el curso que se comprueba
     * @return Devuelve nulo si no es trabajo
     */

    public static String rolCocina(String curso){
        if (curso.equalsIgnoreCase("Conina")) {
            return "Conina";
        }
        return null;
    }

    /**
     * Devuelve trabajador si es un usuario de trabajador
     * @param curso el curso que se comprueba
     * @return si el curos es eso o no
     */

    public static String rolTrabajadores(String curso){
        if (curso.equalsIgnoreCase("Trabajador")) {
            return "Trabajador";
        }
        return null;
    }

    /**
     * Sirve para ver is eres un alumno.
     * @param curo para ver que tipo de curso es
     * @return devuelve el tl numero del rol que eres
     */

    public static String rolEsoGm(String curo){
        String[] ESO = {"1ªESO","2ªESO","3ªESO","4ªESO"};
        String[] GM = {"1ºAño GM Informatica", "2ºAño GM Informatica", "1ºAño GM Jardinería", "2ºAño GM Jardinería"};

        for (int i = 0; i < ESO.length; i++) {
            if (curo.equalsIgnoreCase(ESO[i])) {
                return ESO[i];
            }
        }

        for (int i = 0; i < GM.length; i++) {
            if (curo.equalsIgnoreCase(GM[i])) {
                return GM[i];
            }
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
                        if (hayEspecial(contrasenaNueva) && contrasenaNueva.length() >= 8 && hayMayus(contrasenaNueva) &&
                                hayMinus(contrasenaNueva) && hayNum(contrasenaNueva)) {
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
            if (soloNum(respuesta)) {
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

    /**
     * Lo que hace este método es devolver la contraseña del admin sin comprometer su seguridad
     * @param claseUsers
     * @param nombreUsuario
     * @return La contraseña del usuario de administracióm
     */

    private static String contrasenaAdmin(ArrayList<Clase_user> claseUsers, String nombreUsuario){
        for (int i = 0; i < claseUsers.size(); i++) {
            Clase_user usuario = claseUsers.get(i);
            if (usuario.getUsuario().equalsIgnoreCase(nombreUsuario) && usuario.getRol() == 1) {
                return usuario.getPassword();
            }
        }
        return null;
    }

    /**
     * Comprueba aquí que tengas caracteres antes del arroba, que el ultimo punto que pongas no este detras
     * del arroba, que en medio del punto y arroba alla un caracter y que el punto tenga delante un caracter
     * @param cadena Este es el gmail que habra puesto
     * @return boolean Devolvera false si esta bien, si no te devolvera true
     */
    public static boolean noDelanteArrobPunto(String cadena){
        int arroba = cadena.indexOf('@');
        int punto = cadena.lastIndexOf('.');

        if (arroba > 0 && punto > arroba + 1 && punto < cadena.length() - 1){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Calcula si hay mas arrobas de los deberian haber
     * @param cadena Aqui esta el gmail que habra escrito
     * @return boolean Si es valido y solo tiene un @ te devolvera false, si no es el caso te devolvera true
     */
    public static boolean siTieneMasArroba(String cadena){
        int contadorArr = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '@' ){
                contadorArr++;
            }
        }
        if (contadorArr == 1){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Comprueba si hay mayusculas
     * @param cadena Cadena que se utilizara para comprobar si hay mayusculas
     * @return boolean Si hay alguna mayuscula te devolvera true, si es el caso cotrasrio te devolvera false
     */
    public static boolean hayMayus(String cadena){
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z'){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba las minusculas
     * @param caracter Cadena utilizada para ver si hay minusculas
     * @return boolean Si hay minusculas te devolvera true, en caso contrario te devolvera false
     */
    public static boolean hayMinus(String caracter){
        for (int i = 0; i < caracter.length(); i++) {
            if (caracter.charAt(i) >= 'a' && caracter.charAt(i) <='z'){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si hay numeros
     * @param cadena cadena para ver si hay algun numero
     * @return boolean Si hay algun numero te devolvera true, en caso contrario te devolvera false
     */
    public static boolean hayNum(String cadena){
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) >= '0' && cadena.charAt(i) <= '9')
                return true;
        }
        return false;
    }

    /**
     * Comprueba que solo sean numeros
     * @param num La cadena que se quiere comprobar si solo son numeros
     * @return boolean Si todos son numeros te devolvera true en caso contrario te devolvera false
     */
    public static boolean soloNum(String num){
        int cuenta = 0;
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) >= '0' && num.charAt(i) <= '9'){
                cuenta++;
            }
        }
        if (cuenta == num.length()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Comprueba si hay espacios, si hay algun espacio te devuelve true
     * @param cadena Cadena para comprobar si hay espacios
     * @return boolean Si hay espacios te devolvera true, si no te devolvera false
     */
    public static boolean hayEspacio(String cadena){
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' '){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si hay caracteres especiales
     * @param cadena Cadena que se comprueba
     * @return boolean Si hay un caracter especial te devuelve true, si no es el caso te devuelve false
     */
    public static boolean hayEspecial(String cadena){
        String caracEspecia = "!@#$%^&\\*()_+-=[]{}|;:,.<>?";
        for (int i = 0; i < cadena.length(); i++) {
            if (caracEspecia.indexOf(cadena.charAt(i)) >= 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Comprueba si hay caracteres especiales
     * @param cadena Esta variable contiene el gmail del usuario
     * @return boolean Te devolvera false si no tienes nigun caracter especial de la cadena caracEspecia y si tiene uno te
     * devolvera true
     */
    public static boolean espeGmail(String cadena){
        String caracEspecia = "!#$%^&*()_+-=\\[]{}|;:,<>¿?";
        for (int i = 0; i < cadena.length(); i++) {
            if (caracEspecia.indexOf(cadena.charAt(i)) >= 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Valida el alfabeto latino y si hay alguna letra que no es te deuelve true
     * @param cadena Cadena que valida
     * @return boolean Te devuelve true si la cadena es valida en caso contrario te devuelve false
     */

    public static boolean validarAlfabetoLat(String cadena){
        String nueboNombre=cadena.toLowerCase();
        for (int i = 0; i < nueboNombre.length(); i++) {
            if ((nueboNombre.charAt(i) < 'a' && nueboNombre.charAt(i) > 'z') &&
                    (nueboNombre.charAt(i) != 'á' ||
                            nueboNombre.charAt(i) != 'é' ||
                            nueboNombre.charAt(i) != 'í' ||
                            nueboNombre.charAt(i) != 'ó' ||
                            nueboNombre.charAt(i) != 'ú' ||
                            nueboNombre.charAt(i) != 'ñ' ||
                            nueboNombre.charAt(i) != ' '
                    )
            )
            {
                return false;
            }
        }
        return true;
    }

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
            if (nameUser.length() < 5 || hayEspacio(nameUser) || hayEspecial(nameUser)) {
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
            if (siTieneMasArroba(gmail)){
                System.out.println("Tiene que tener solo un arroba y un punto");
                next = true;
            } else {
                //Comprueba si gmail tiene caracteres especiales que no se perimiten en el gmail
                if (espeGmail(gmail)){
                    System.out.println("no puede tener caracteres especiales");
                    next = true;
                } else {
                    //Comprueba si hay espacios
                    if (hayEspacio(gmail)){
                        System.out.println("No puede tener espacios");
                        next = true;
                    } else {
                        /*
                        Comprueba aquí que tengas caracteres antes del arroba, que el ultimo punto que pongas no este detras
                        del arroba, que en medio del punto y arroba alla un caracter y que el punto tenga delante un caracter
                         */
                        if (noDelanteArrobPunto(gmail)){
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
            if (hayEspecial(contrasena) && contrasena.length() >= 8 && hayMayus(contrasena)
                    && hayMinus(contrasena) && hayNum(contrasena)) {
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

    public static String validarFecha() {
        Scanner scan = new Scanner(System.in);
        boolean next = true;
        int diaU = 0;
        int mesU = 0;
        int anoU = 0;
        int dia = 19;
        int mes = 11;
        int ano = 2024;
        String fecha = "";
        String esc;
        int anoF = 0;
        boolean mayor = false;
        boolean dudamayor = false;

        do {

            //AÑO
            do {
                System.out.println("Escribe tu año de nacimiento");
                esc = scan.nextLine();
                //Si son todos numeros  y mide cuatro caracteristicas pasa, si no no te deja pasar y volvera al bucle
                if (esc.length() == 4 && soloNum(esc)){
                    //Aqui pasa de String a Int y comprueba si es un año entre 2025 y 1950, si no esta te hace repetir el año
                    anoU = Integer.parseInt(esc);
                    if (anoU >=2025 || anoU <= 1950){
                        System.out.println("Año no valido");
                        next = true;
                    } else {
                        //Calcula la edad que tienes y se le pone la edad en la variable anoF
                        anoF = ano - anoU;
                        //Si tu edad es 17 puede que si seas mayor, por eso se te pone la variable dudamayor
                        if (anoF == 17){
                            System.out.println("Puede que seas mayor de edad");
                            dudamayor = true;
                            next = false;
                                /*
                                Dice que eres mayor, porque la variable anoF es mayor o igual a 18, pero mas adelante puede
                                que se demuestre que no eres mayor de edad porque el mes o el dia en el que nacio aun no a llegadp
                                 */
                        } else if (anoF >= 18){
                            System.out.println("Eres mayor de edad, pero puede que no lo seas");
                            mayor = true;
                            next = false;
                            //Si tu edad es menor de 17 te hecha dle bucle y te saca de la funcion poniendo que mayor es false
                        } else {
                            System.out.println("eres menor de edad");
                            next = false;
                            mayor = false;
                        }
                    }

                } else {
                    System.out.println("año no valida");
                    next = true;
                }
            } while (next);
            //Comprueban las variables de mayor y dudamayor, para ver si te hecha al registro, para que te heche al menu principal
            if (mayor || dudamayor){

            } else return fecha;

            //MES

            do {
                System.out.println("Pon tu mes de nacimiento");
                System.out.println("Si se dice tu dia con solo un numero pon 0(numero que quieras)");
                esc = scan.nextLine();
                //Si son todos numeros  y mide dos caracteristicas pasa, si no no te deja pasar y volvera al bucle
                if (esc.length() == 2 && soloNum(esc)){
                    mesU = Integer.parseInt(esc);
                    //Al convertirse de String a Int se comprueba si esta en un mes valido entre el 1 y el 12.
                    if (mesU >= 1 && mesU <= 12) {
                        //Si tienes 18 comprueba si tu mes de nacimiento es mayor al mes actual y si lo es te hecha
                        if (anoF == 18 && mesU > mes) {
                            return fecha;
                            //Si la variable mayor es verdad te deja pasar sin probblema al siguiente bucle, sacandote primero de este
                        } else  if (mayor) {
                            next = false;
                            //Si duduamayor es verdad y mesU es igual a mesdudamayor sigue estando en true y sales del bucle
                        } else if (dudamayor && mesU == mes){
                            dudamayor = true;
                            next = false;
                            //Si no es ninguna de estas sales del bucle y mesU es 0
                        } else {
                            mesU = 0;
                            mayor = false;
                            next = false;
                        }
                    } else {
                        System.out.println("no es un mes valido");
                        next = true;
                    }
                } else {
                    System.out.println("mes no valido");
                    next = true;
                }
            } while (next);

        } while (next);

        if (mayor || dudamayor) {

        } else return fecha;

        //DIA

        do {
            System.out.println("Escribe el dia en el que naciste");
            System.out.println("Si tu dia es solo un numero pon 0(numero que sea)");
            esc = scan.nextLine();
            //Si son todos numeros  y mide dos caracteristicas pasa, si no no te deja pasar y volvera al bucle
            if (esc.length() == 2 && soloNum(esc)) {
                diaU = Integer.parseInt(esc);
                //Comprueba de que este diaU entre el 0 y el 31
                if (diaU >= 0 && diaU <= 31){
                    //Si tienes 18 años y tu mes es mayor o igual y si diaU es mayor a dia te expulsa al menu principal
                    if (anoF == 18 && mesU >= mes && diaU > dia) {
                        return fecha;
                        //Si dudamayor esta en true y diaU es mayr o igual a dia es que eres mayor y te sacan del bucle
                    } else if (dudamayor && diaU >= dia) {
                        mayor = true;
                        System.out.println("eres mayor");
                        next = false;
                        //Si mayor es true te saca del bucle
                    } else if (mayor){
                        System.out.println("eres mayor");
                        next = false;
                        //Si no se hace nada de atras mayor se cnvierte en falso, haciendo de que el siguiente te hechara
                    } else {
                        mayor = false;
                        next = false;
                    }
                } else {
                    System.out.println("No es un dia valido");
                    next = true;
                }
            } else {
                System.out.println("dia no valido");
                next = true;
            }
        } while (next);

        //Si no eres mayor te saca del bucle
        if (mayor) {

        } else return fecha;


        fecha = diaU + "/" + mesU + "/" + anoU;

        return fecha;
    }
}
