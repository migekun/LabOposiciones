package es.navas.oposiciones.datosDinamicos.pila;

import java.util.Scanner;

/**
 * Programa que permite gestionar una expresión para ver si está bien balanceada
 *
 * @author manavas
 * @version 1.0
 */
public class Principal {

    static Pila pila;
	private static Scanner sc;

    /**
     * Método que comprueba si una expresión pasada por parámetro está
     * balanceada
     *
     * @param cadena: contiene la expresión a evaluar
     * @return Devuelve cierto o falso si está o no valanceada
     */
    public static boolean balanceada(String cadena) {
        //Recorremos la cadena hasta el final
        for (int i = 0; i < cadena.length(); i++) {
            //Si encuentra un caracter de comienzo de agrupación lo inserta
            if (cadena.charAt(i) == '(' || cadena.charAt(i) == '[' || cadena.charAt(i) == '{') {
                pila.insertar(cadena.charAt(i));
            } else { //Sino, si coincide que el caracter a extraer no es igual que el primero de la pila
                if (cadena.charAt(i) == ')') {
                    if (pila.extraer() != '(') { //Devuelve false
                        return false;
                    }
                } else {
                    if (cadena.charAt(i) == ']') {
                        if (pila.extraer() != '[') { //Idem
                            return false;
                        }
                    } else {
                        if (cadena.charAt(i) == '}') {
                            if (pila.extraer() != '{') {//Idem
                                return false;
                            }
                        }
                    }
                }
            }
        }
        //Si la pila se ha vaciado, estaba balanceada
        if (pila.vacia()) {
            return true;
        } else {
            return false; //Sino, no lo estaba
        }
    }

    /**
     * Método principal
     *
     * @args Argumentos de la llamada al método principal
     */
    public static void main(String[] args) {
        pila = new Pila();  //Creamos el objeto de tipo Pila  

        System.out.println("\nIntroduce la expresión a evaluar): ");
        sc = new Scanner(System.in);
        String cadena = sc.nextLine();

        if (balanceada(cadena)) {
            System.out.println("Está correctamente balanceada");
        } else {
            System.out.println("No está correctamente balanceada");
        }

    }

}
