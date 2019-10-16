package es.navas.oposiciones.datosEstaticos.matrices;

import java.util.Random;
import java.util.Scanner;

public class TablaNumeros {

	private static Scanner sc;

	/**
     * Método main
     *
     * @param args Argumentos de la llamada al método main
     */
    public static void main(String[] a) throws Exception {
        int v[][] = new int[5][5];
        cargarMatriz(v);
        visualizar(v);
        solicitarPosicion(v);
    }

    /**
     * Método que carga números aleatorios en una matriz
     *
     * @param a: Array bidimensional.
     */
    static void cargarMatriz(int a[][]) {
        Random r = new Random();
        int i, j;

        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                a[i][j] = r.nextInt(10); //Devuelve un número del 1 al 10 y lo carga
            }
        }
    }

    /**
     * Método visualizar: muestra los elementos introducidos en la matriz
     *
     * @param a: Array bidimensional
     */
    static void visualizar(int a[][]) {
        int i, j;
        System.out.println("Matriz cargada:");
        //Muestra los datos introducidos en la matrid
        for (i = 0; i < a.length; i++) {
            for (j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /**
     * Método que solicita posiciones al usuario para mostrar los datos
     *
     * @param a: Array bidimensional.
     */
    static void solicitarPosicion(int a[][]) {
        int f = 1, c = 1;
        boolean salida = false;
        sc = new Scanner(System.in);

        do {
            System.out.print("\nElige el elemento a buscar");
            System.out.print("\nIntroduce la fila: ");
            f = sc.nextInt();
            System.out.print("Introduce la columna: ");
            c = sc.nextInt();
            if (f >= 1 && f <= a.length && c >= 1 && c <= a.length) {
                System.out.println("El elemento buscado es " + a[f - 1][c - 1]);
            } else {
                System.out.println("Ha introducido datos incorrectos. Salida del programa");
                salida=true;
            }
            //Comprobamos que los datos introducidos están en el rango
            //Suponemos que el usuario considera la primera fila y columna como 1
        } while (!salida);
        //Podemos poner aquí también la condición del if y evitar la variable salida
    }

	
}
