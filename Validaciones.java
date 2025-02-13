package Practica2;

import Practica2.clase.Clase_user;

import java.lang.annotation.ElementType;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Validaciones {

    //VALIDACIONES

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

    //1. Gestión de usuario

    //1.1 Listar usuarios

    /**
     * Muesta la información de los usuarios
     * @param listarUsuarios es el listado de usurios
     * @return Te devuelve la información de los usuarios
     */

    public static void listarUsuarios (ArrayList<Clase_user> listarUsuarios){
        if (listarUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("\n--- LISTA DE USUARIOS ---");
            for (Clase_user usuario : listarUsuarios) {
                usuario.mostrarInfo();
            }
        }
    }

    //1.2 Crear usuario

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
     * Devuelve al usuario el curso que haya seleccionado
     *@return curso variable String
     */

    public static String cursoUsuario(){
        Scanner sc= new Scanner(System.in);
        String elec = "";
        String curso = "";
        boolean next = true;
        boolean admin = false;

        do {
            System.out.println("Elige al curso que perteneces");
            System.out.println("1. ESO");
            System.out.println("2. Grado Medio");
            System.out.println("3. Soy trabajador");
            elec = sc.nextLine();

            switch (elec) {
                case "1":
                    do {
                        System.out.println("Selecciona a ESO perteneces");
                        System.out.println("1. 1ºESO");
                        System.out.println("2. 2ºESO");
                        System.out.println("3. 3ºESO");
                        System.out.println("4. 4ºESO");
                        System.out.println("5. No es lo que quería seleccionar");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                System.out.println("Eres de 1ºESO");
                                curso = "1ªESO";
                                next = false;
                                break;
                            case "2":
                                System.out.println("Eres de 2ºESO");
                                curso = "2ªESO";
                                next = false;
                                break;
                            case "3":
                                System.out.println("Eres de 3ºESO");
                                curso = "3ªESO";
                                next = false;
                                break;
                            case "4":
                                System.out.println("Eres de 4ºESO");
                                curso = "4ªESO";
                                next = false;
                                break;
                            case "5":
                                next = false;
                                break;
                            default:
                                System.out.println("No has seleccionado nada");
                                next = true;
                                break;
                        }
                    } while (next);
                    break;
                case "2":
                    do {
                        System.out.println("Selecciona el año junto a su grado medio");
                        System.out.println("1. 1ºAño GM Informatica");
                        System.out.println("2. 2ºAño GM Informatica");
                        System.out.println("3. 1ºAño GM Jardinería");
                        System.out.println("4. 2ºAño GM Jardinería");
                        System.out.println("5. No es lo que quería seleccionar");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                curso = "1ºAño GM Informatica";
                                next = false;
                                break;
                            case "2":
                                curso = "2ºAño GM Informatica";
                                next = false;
                                break;
                            case "3":
                                curso = "1ºAño GM Jardinería";
                                next = false;
                                break;
                            case "4":
                                curso = "2ºAño GM Jardinería";
                                next = false;
                                break;
                            case "5":
                                next = false;
                                break;
                            default:
                                next = true;
                                break;
                        }

                    } while (next);
                    break;
                case "3":

                    do {
                        System.out.println("1. Soy trabajador del instituto");
                        System.out.println("2. Quiero crear un admin");
                        System.out.println("3. No es lo que quería seleccionar");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                curso = "Trabajador";
                                next = false;
                                break;
                            case "2":
                                do {
                                    System.out.println("¿Estas seguro?");
                                    System.out.println("SI");
                                    System.out.println("NO");
                                    elec = sc.nextLine();

                                    switch (elec) {
                                        case "SI":
                                            curso = "admin";
                                            next = false;
                                            admin = false;
                                            break;
                                        case "NO":
                                            next = true;
                                            admin = false;
                                            break;
                                        default:
                                            System.out.println("Tienes que seleccionar una de las dos opciones");
                                            admin = true;
                                            break;
                                    }
                                }while (admin);
                            case "3":
                                next = false;
                                break;
                        }
                    } while (next);
            }
        } while (curso.length()<3);

        System.out.println("Curso seleccionado = "+curso +"\n");

        return curso;
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

    //ALERGIAS

    public static ArrayList<String> alergiasUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        ArrayList<String> alergias = new ArrayList<String>();

        System.out.println("ingrese sus lergias, cuando las pongas todas pon terminado");

        while (next) {
            String alergia = sc.nextLine();
            if (alergia.equalsIgnoreCase("terminado")) {
                break;
            }
            alergias.add(alergia);
        }
        return alergias;
    }

    //Fecha

    public static LocalDate validarFecha(){
        LocalDate fecha = null;
        return fecha;
    }

    /**
     * Sirve para crear a los usuarios
     * @param usuarios es el listado de usuarios
     */

    public static void agregarUsuarios(ArrayList<Clase_user> usuarios){
        //Nombre y apellidos del usuario

        //String nombre = nombreApellidos();

        //Nombre de usuario

        //String usuario = validarUsuario();

        //Correo de usuario

        //String correo = validarGmail();

        //Curso de usuario

        String curso = cursoUsuario();

        //Contraseña de usuario

        //String contrasena = validarContrasena();

        //Alergias

        //ArrayList<String> alergias_user = alergiasUsuario();

        //Fecha de usuario

        LocalDate fecha_nacimiento;
    }
}
