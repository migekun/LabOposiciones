package es.navas.oposiciones.datosEstaticos.arrays;

public class OrdenacionSeleccion {

	/**
     * Método que intercambia dos elementos entre sí
     *
     * @param a Array que contiene los elementos
     * @param i Entero con la posición primera a intercambiar
     * @param j Entero con la posición segunda a intercambiar
     */
    public static void intercambiar(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

    /**
     * Método que permite ordenar por selección
     *
     * @param a Array a ordenar
     */
    public static void ordenacionSeleccion(int a[]) {
        int indiceMenor, i, j, n; 
        n = a.length; 

        for (i = 0; i < n - 1; i++) {
            indiceMenor = i;
            for (j = i + 1; j < n; j++) {
                if (a[j] < a[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            if (i != indiceMenor) {
                intercambiar(a, i, indiceMenor);
            }
        }
    }

    /**
     * Método main
     *
     * @param args Argumentos de la llamada al método main
     */
    public static void main(String[] args) {
        //Creamos un array de elementos desordenados (habría que pedírselos al usuario)
        int[] array = {6, 1, 10, 3, 7, 2, 5, 9};
        //Ejecutamos el método de ordenación por selección 
        ordenacionSeleccion(array);
        //Mostramos el array resultante
        System.out.println("El array ordenado es:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

	
}
