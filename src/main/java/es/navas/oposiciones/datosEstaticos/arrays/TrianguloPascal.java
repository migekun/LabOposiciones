package es.navas.oposiciones.datosEstaticos.arrays;

public class TrianguloPascal {

	/**
     * Método main
     * @param args Argumentos de la llamada al método main
     */
    public static void main(String[] args) {
        //Suponemos que vamos a mostrar 10 filas (podemos solicitar al usuario el número de filas)
        int nfilas = 10;
        
        int[] arrayOriginal = new int[1];
        
        //Para cada fila a mostrar
        for (int i = 1; i <= nfilas; i++) {
            
            int[] arrayProximoNivel = new int[i];
            
            for (int j = 0; j < i; j++) {
                if (limiteIzq(j) || limiteDer(i, j)) {
                    arrayProximoNivel[j] = 1;
                } else {
                    arrayProximoNivel[j] = sumaAnteriores(arrayOriginal, j);
                }
                //Mostramos la posición introducida
                System.out.print(arrayProximoNivel[j] + " ");
            }
            arrayOriginal = arrayProximoNivel;
            //Hacemos un salto de línea para cambiar de fila
            System.out.println();
        }
    }

	private static int sumaAnteriores(int[] array, int j) {
		return array[j] + array[j - 1];
	}

	private static boolean limiteDer(int i, int j) {
		return j == (i - 1);
	}

	private static boolean limiteIzq(int j) {
		return j == 0;
	}
    
}
