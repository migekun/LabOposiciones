package es.navas.oposiciones.datosDinamicos.listaCircularDoblementeEnlazada;

import java.util.Scanner;
/**
 * Programa que crea la lista, inserta, borra y busca elementos (ciudades)
 *
 * @author manavas
 * @version 1.0
 */
public class Principal {
    private static Scanner teclado;

	/**
     * Método principal
     *
     * @args Argumentos de la llamada al método principal
     */
    public static void main(String args[]) throws Exception {
        ListaCircularDoblementeEnlazada lista = new ListaCircularDoblementeEnlazada();

        //Insertamos cuatro ciudades 
        lista.insertar("Zamora");
        lista.insertar("León");
        lista.insertar("Burgos");
        lista.insertar("Avila");

        //Mostramos la lista ordenada de principio a fin y viceversa
        System.out.println("Lista de principio a fin");
        lista.imprimir();
        System.out.println("Lista de fin a principio");
        lista.imprimirReves();

        //Buscamos una ciudad
        System.out.print("Introduce una letra para buscar ciudades: ");
        teclado = new Scanner(System.in);
        char letra = teclado.nextLine().charAt(0);
        lista.buscarLetra(letra);

        //Borramos una ciudad que indque el usuario
        String borrado;
        System.out.print("Introduce una ciudad a borrar: ");
        String ciudadBorrar = teclado.nextLine();
        lista.borrarPorCadena(ciudadBorrar);

        //Mostramos la lista ordenada de principio a fin y viceversa
        System.out.println("Lista resultante");
        lista.imprimir();

        //Borramos una ciudad por el principio
        borrado = lista.borrar();
        System.out.println(borrado.toString() + " borrado");
        lista.imprimir();

    }
}
