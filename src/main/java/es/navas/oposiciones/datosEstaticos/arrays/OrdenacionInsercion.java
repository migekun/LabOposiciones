package es.navas.oposiciones.datosEstaticos.arrays;

public class OrdenacionInsercion {

    /**
     * Método que permite ordenar por inserción
     *
     * @param array Array a ordenar
     */
    public static void ordenacionInsercion(int[] array) {
        int i, j, aux; //Índices

        for (i = 1; i < array.length; i++) {
            j = i;
            //j explora la sublista de a[i-1] a a[0] para colocar el elemento
            aux = array[i];
            // aux toma la posición del array de 1 en adelante
            // Se localiza el punto de inserción comparando el índice j
            while (j > 0 && aux < array[j - 1]) {
                // Los elementos se mueven para hacer espacio al nuevo elemento
                array[j] = array[j - 1];
                j--;
            }
            array[j] = aux;
            System.out.println("tmp:");
            for (int index = 0; index < array.length; index++) {
                System.out.print(array[index] + ", ");
            }
            System.out.println("i:" +i);
        }
    }

    /**
     * Método main
     *
     * @param args Argumentos de la llamada al método main
     */
    public static void main(String[] args) {
        //Creamos un array de elementos desordenados
        int[] array = {6, 1, 10, 3, 7, 2, 5, 9};
        System.out.println("array original: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println("");
        
        ordenacionInsercion(array);
        
        System.out.println("El array ordenado es:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }

	
}
