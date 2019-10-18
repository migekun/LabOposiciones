package es.navas.oposiciones.datosDinamicos.cola;

import java.util.Random;

/**
 * Programa que permite obtener números de la suerte
 *
 * @author manavas
 * @version 1.0
 */
public class Principal {

    /**
     * Método principal
     *
     * @args Argumentos de la llamada al método principal
     */
    public static void main(String[] a) {
        //Variables
        int n, n1, n2, i;
        Integer nv;
        ColaLista cola = new ColaLista();
        Random r = new Random();

        try {
            // Número inicial de elementos de la lista 
            n = 11 + r.nextInt(49);
            // Se generan n números aleatorios y se introducen en la cola
            System.out.print("Números iniciales: ");
            for (i = 1; i <= n; i++) {
                nv = new Integer(1 + r.nextInt(101));
                System.out.print(nv + " ");
                cola.insertar(nv);
            }
            // Se genera aleatoriamente el intervalo n1  
            n1 = 1 + r.nextInt(11);
            // Se retiran de la cola elementos a distancia n1
            System.out.print("\nSe elimina de la lista: ");
            while (n1 <= n) {
                Object nt;
                n2 = 0;  // Contador de elementos que quedan
                for (i = 1; i <= n; i++) {
                    nt = cola.extraer();
                    if (i % n1 == 1) {
                        System.out.print(nt + " ");
                    } else {
                        cola.insertar(nt);  // Se vuelve a meter en la cola 
                        n2++;
                    }
                }
                n = n2;
                n1 = 1 + r.nextInt(11);
            }

            System.out.println("\nLos números de la suerte son: ");
            mostrarCola(cola);
            System.out.println();

        } catch (Exception t) {
            System.out.println("ERROR: " + t);
        }
    }

    /**
     * Método que muestra la cola resultante
     *
     * @cola Objeto cola
     */
    private static void mostrarCola(ColaLista cola) throws Exception {
        while (!cola.colaVacia()) {
            Integer v;
            v = (Integer) cola.extraer();
            System.out.print(" " + v.intValue());
        }
    }
}
