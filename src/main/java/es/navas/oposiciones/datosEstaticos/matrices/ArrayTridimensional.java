package es.navas.oposiciones.datosEstaticos.matrices;

import java.util.Scanner;

public class ArrayTridimensional {

	static final int PAGINAS = 10;
    static final int LINEAS = 45;
    static final int COLUMNAS = 80;

    /**
     * Método main
     *
     * @param args Argumentos de la llamada al método main
     */
    public static void main(String[] a) throws Exception {
        char libro[][][] = new char[PAGINAS][LINEAS][COLUMNAS];
        leer(libro);
        buscarPosicion(libro);
        buscarCaracter(libro);
    }

    /**
     * Método leer que muestra todos los caracteres del libro
     *
     * @param a: Array tridimensional.
     */
    static void leer(char a[][][]) {
        int pagina, linea, columna;

        for (pagina = 0; pagina < PAGINAS; pagina++) {
            for (linea = 0; linea < LINEAS; linea++) {
                for (columna = 0; columna < COLUMNAS; columna++) {
                    //System.out.println(a[pagina][linea][columna]);
                    System.out.println("Caracter " + pagina + "." + linea + "." + columna);
                }
            }
        }
    }

    /**
     * Método buscar que muestra el caracter que se encuentra en una posición
     *
     * @param a: Array tridimensional.
     * return Devuelve el caracter buscado
     */
    static char buscarPosicion(char a[][][]) {
        Scanner	 sc = new Scanner(System.in);
        System.out.println("\nIntroduzca la página");
        int pagina = sc.nextInt();
        System.out.println("\nIntroduzca la línea");
        int linea = sc.nextInt();
        System.out.println("\nIntroduzca la columna");
        int columna = sc.nextInt();
        return a[pagina][linea][columna];
    }

    /**
     * Método buscar que muestra las posiciones en las que se encuentra un caracter
     *
     * @param a: Array tridimensional.
     */
    static void buscarCaracter(char a[][][]) {
        int pagina, linea, columna;
        Scanner sc = new Scanner(System.in);
        System.out.println("\nIntroduzca el caracter a buscar");
        char caracter = sc.nextLine().charAt(0);
        //Buscamos por todos los caracteres indicando dónde se encuentra
        for (pagina = 0; pagina < PAGINAS; pagina++) {
            for (linea = 0; linea < LINEAS; linea++) {
                for (columna = 0; columna < COLUMNAS; columna++) {
                    if (a[pagina][linea][columna] == caracter) {
                        System.out.println("El caracter está en la página " + pagina + ", línea " + linea + ", columna" + columna);
                    }
                }
            }
        }
    }

	
}
