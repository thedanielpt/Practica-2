package Practica2;

import Practica2.clase.Clase_bocatas;
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

    //1. Gestión de usuario

    /**
     * Login
     * @param nameUsers
     * @return true si el usuario se h alogueado correctamente y devuelve false en caso contrario
     */

    public static boolean login(ArrayList<Clase_user> nameUsers){

        Scanner sc = new Scanner(System.in);
        String nameL = "";
        String contraL = "";
        boolean logueo = false;
        boolean next = false;
        int cuenta = -1;

        do {
            //Comprobacion de si estas registrado
            if (Validaciones.captcha()){
                for (int i = 0; i < 3; i++) {
                    System.out.println("Pon el nombre de usuario de un administrador");
                    nameL = sc.nextLine();
                    //Recorre todo el array para ver si existe el usuario
                    for (Clase_user usuario : nameUsers) {
                        if (nameL.equals(usuario.getUsuario())) {
                            if (usuario.getRol() == 1) {
                                for (int j = 3; j > 0; j--) {
                                    System.out.println("Pon la contraseña");
                                    contraL = sc.nextLine();

                                    if (contraL.equals(usuario.getPassword())) {
                                        System.out.println("te has logueado +"+ usuario.getUsuario());
                                        return true;
                                    } else if (j == 2) {
                                        System.out.println("Numero de intentos sobrepasados");
                                        return false;
                                    } else {
                                        System.out.println("Te quedan estos intentos = "+j);
                                    }
                                }
                            } else {
                                System.out.println("usuario no valido");
                                return false;
                            }
                        }
                    }
                    //Comprueba si nameL es igual a nameUser
                }
            } else {
                System.out.println("Se cancelo el login");
                return false;
            }
        } while (next);
        return false;
    }

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

    public static String cursoUsuario(ArrayList<Clase_user> usuarios){
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
                        System.out.println("1. Crear Profesor, director, etc.");
                        System.out.println("2. Crear un admin");
                        System.out.println("3. Crear cociner@");
                        System.out.println("3. No es lo que quería seleccionar");
                        elec = sc.nextLine();

                        switch (elec) {
                            case "1":
                                curso = "Trabajador";
                                next = false;
                                break;
                            case "2":
                                System.out.println("Pon la contraseña del administrador");
                                elec = sc.nextLine();
                                for (int i = 3; i > 0; i--) {
                                    if (elec.equals(contrasenaAdmin(usuarios, "admin"))) {
                                        do {
                                            System.out.println("¿Estas seguro?");
                                            System.out.println("SI");
                                            System.out.println("NO");
                                            elec = sc.nextLine();

                                            switch (elec) {
                                                case "SI":
                                                    curso = "Admin";
                                                    return curso;
                                                case "NO":
                                                    next = true;
                                                    admin = false;
                                                    i = 0;
                                                    break;
                                                default:
                                                    System.out.println("Tienes que seleccionar una de las dos opciones");
                                                    admin = true;
                                                    break;
                                            }
                                        }while (admin);
                                    } else if (i == 0){
                                        System.out.println("Numero de intentos maximo");
                                        break;
                                    } else {
                                        System.out.println("Contraseña incorrecta, te quedan "+ i +" intentos");
                                        System.out.println("Vuelve a intentarlo");
                                        elec = sc.nextLine();
                                    }

                                }
                            case "3":
                                curso = "Conina";
                                next = false;
                                break;
                            case "4":
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

    /**
     * Esta Validación lo que hace es pedir las alergias que tiene el usuario
     * @return Devuelve las alergias qeu tiene el usuario
     */

    public static ArrayList<String> alergiasUsuario(){
        Scanner sc = new Scanner(System.in);
        boolean next = true;
        ArrayList<String> alergias = new ArrayList<String>();

        System.out.println("Ingrese sus lergias, cuando las pongas todas pon terminado");

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

    public static int rolUsuario(String curso) {
        int rol = 0;
        if (curso.equalsIgnoreCase(rolEsoGm(curso)) || curso.equalsIgnoreCase(rolTrabajadores(curso))) {
            return rol = 3;
        } else if (curso.equalsIgnoreCase(rolCocina(curso))) {
            return rol = 2;
        } else if (curso.equalsIgnoreCase(rolAdmin(curso))) {
            return rol = 1;
        }
        return 0;
    }

    /**
     * Sirve para crear a los usuarios
     * @param usuarios es el listado de usuarios
     */

    public static void agregarUsuarios(ArrayList<Clase_user> usuarios){

        //Nombre y apellidos del usuario

        String nombre = nombreApellidos();

        //Nombre de usuario

        String usuario = validarUsuario();

        //Correo de usuario

        String correo = validarGmail();

        //Curso de usuario

        String curso = cursoUsuario(usuarios);

        //Contraseña de usuario

        String contrasena = validarContrasena();

        //Alergias

        ArrayList<String> alergias_user = alergiasUsuario();

        //Fecha de usuario

        LocalDate fecha_nacimiento = validarFecha();

        //ROL

        int rol = rolUsuario(curso);

        usuarios.add(new Clase_user(nombre, usuario, correo, curso, contrasena,alergias_user,fecha_nacimiento, rol));

    }

    //2. Gestionar Bocadillos

    //2.1 Listar bocadillos disponibles

    public static void listarbocadillos(ArrayList<Clase_bocatas> bocatas){
        if (bocatas.isEmpty()) {
            System.out.println("No hay bocatas registrados.");
        } else {
            System.out.println("\n--- LISTA DE bocatas ---");
            for (Clase_bocatas bocata : bocatas) {
                bocata.mostrarinfo();
            }
        }
    }

    public static boolean buscarbocata(ArrayList<Clase_bocatas> bocatas, String nombreBocata){
        for (Clase_bocatas bocata : bocatas) {
            if (nombreBocata.equalsIgnoreCase(bocata.getNombre())) {
                return true;
            }
        }
        return false;
    }

    public static void dameCuriosidadBocata(ArrayList<Clase_bocatas> bocatas, String nombreBocata){
        for (Clase_bocatas bocata : bocatas) {
            if (nombreBocata.equalsIgnoreCase(bocata.getNombre())) {
                bocata.mostrarCuriosidades();
            }
        }
    }

    public static void verCuriosidaBocata(ArrayList<Clase_bocatas> bocatas){
        Scanner sc=new Scanner(System.in);
        String elec = "";
        System.out.println("¿Cual es el bocata que te entra curiosidad saber su curiosidad?");
         elec = sc.nextLine();

        if (buscarbocata(bocatas, elec)) {
            dameCuriosidadBocata(bocatas, elec);
        } else {
            System.out.println("El bocata no ha sido encontrado");
        }
    }

    //3 REALIZAR PEDIDO

    //3.1 SELECCIONAR USUARIO

    public static void seleccionUser(ArrayList<Clase_user> usuarios){

    }
}
