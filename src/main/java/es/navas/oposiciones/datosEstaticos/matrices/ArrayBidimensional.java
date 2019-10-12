package es.navas.oposiciones.datosEstaticos.matrices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArrayBidimensional {
	/**
     * Método main
     *
     * @param args Argumentos de la llamada al método main
     */
    public static void main(String[] a) throws Exception {
        int v[][] = new int[3][5];
        leer(v);
        visualizar(v);
    }

    /**
     * Método leer: captura los elementos a introducir en la matriz
     *
     * @param a: Array bidimensional.
     */
    static void leer(int a[][]) throws Exception {
        int i, j;
        BufferedReader entrada = new BufferedReader(
                new InputStreamReader(System.in));

        //Solicita al usuario los datos de cada elemento, fila a fila
        System.out.println("Entrada de datos de la matriz");
        for (i = 0; i < a.length; i++) {
            System.out.println("Fila: " + i);
            for (j = 0; j < a[i].length; j++) {
                a[i][j] = Integer.parseInt(entrada.readLine());
            }
        }
    }

    /**
     * Método visualizar: muestra los elementos introducidos en la matriz
     *
     * @param a: Array bidimensional,
     */
    static void visualizar(int a[][]) {
        int i, j;
        System.out.println("\n\t Matriz leida\n");
        //Muestra los datos introducidos en la matrid
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(" ");
        }
    }


}
