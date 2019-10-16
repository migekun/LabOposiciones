package es.navas.oposiciones.datosEstaticos.arrays;

import java.util.Scanner;

public class BusquedaBinaria {
	private static Scanner sc;

	/**
	 * Método que realiza una búsqueda secuencial
     *
     * @param a: array de elementos
     * @param clave: elemento a buscar
     * @return Devuelve el número de pasos realizados en la búsqueda
     */
    public static int busquedaSecuencial(int a[], int clave) {
        int i = 0;

        while (i < a.length - 1 && a[i] != clave) {
            i++;
        }
        //Hay que sumar 1 para que considere la primera posición
        return i+1; //Devuelve el número de pasos que ha realizado (el índice encontrado o la longitud de la lista)
    }
    /**
     * Método que realiza una búsqueda binaria
     *
     * @param a: array de elementos
     * @param clave: elemento a buscar
     * @return Devuelve el número de pasos realizados en la búsqueda
     */
    public static int busquedaBinaria(int a[], int clave) {
        int central, bajo, alto, valorCentral, contador;
        contador = 1;
        bajo = 0; 
        alto = a.length - 1; 
        while (bajo <= alto) {
            central = (bajo + alto) / 2;   // Índice de elemento central 
            valorCentral = a[central];   // Valor del índice central 
            if (clave == valorCentral) {//Si encuentra el valor, devuelve el número de pasos
                return contador;
            } else if (clave < valorCentral) { //Si el valor buscado es menor buscamos en la lista inferior
                alto = central - 1;
            } else {
                bajo = central + 1; //Si el valor buscado es mayor, buscamos en la lista superior
            }
            contador++;
        }
        return contador;
    }

    /**
     * Método main
     *
     * @param args Argumentos de la llamada al método main
     */
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 6, 8, 10, 11, 12, 15, 16, 17, 19, 21, 24, 26, 29, 30, 31, 33, 39};
        sc = new Scanner(System.in);
        System.out.println("Introduzca un elemento a buscar");
        int valorBuscado = sc.nextInt();

        //Ejecutamos la búsqueda secuencial
        System.out.println("La búsqueda secuencial ha realizado "+busquedaSecuencial(array, valorBuscado)+" pasos");
        System.out.println("La búsqueda binaria ha realizado "+busquedaBinaria(array, valorBuscado)+" pasos");
    }

	
}
