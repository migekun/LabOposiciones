package es.navas.oposiciones.datosEstaticos.matrices;

import java.util.Random;

public class MatrizTraspuesta {

	/**
     * Método main
     *
     * @param args Argumentos de la llamada al método main
     */
    public static void main(String[] a) throws Exception {
        int v[][] = new int[4][4];
        cargarMatriz(v);
        visualizar(v);
        visualizar(transponer(v));
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
     * Transpone los datos de la matriz (filas por columnas y viceversa)
     *
     * @param a: matriz bidimensional.
     * @return: matriz transpuesta resultante
     */
    static int[][] transponer(int matriz[][]) {
        int transpuesta[][] = new int[4][4];
        for (int x = 0; x < matriz.length; x++) {
            for (int y = 0; y < matriz[x].length; y++) {
                transpuesta[y][x] = matriz[x][y];
            }
        }
        return transpuesta;
    }
	
}
