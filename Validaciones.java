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
}
