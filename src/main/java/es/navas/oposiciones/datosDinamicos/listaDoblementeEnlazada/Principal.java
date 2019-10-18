package es.navas.oposiciones.datosDinamicos.listaDoblementeEnlazada;

import java.util.Scanner;
/**
 * Programa que crea la lista, inserta, borra y busca elementos (caracteres)
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
        ListaDoblementeEnlazada lista = new ListaDoblementeEnlazada();
        //Solicitamos una cadena por teclado
        System.out.print("Introduce una cadena: ");
        teclado = new Scanner(System.in);
        String cadena = teclado.nextLine();
        
        //Introducimos los caracteres de la cadena en una lista
        for (int i = 0; i<cadena.length(); i++){
            lista.insertarFinal(cadena.charAt(i));
        }        

        //Mostramos la lista ordenada de principio a fin y viceversa
        System.out.println("Lista de principio a fin");
        lista.imprimir();
        
        //Borramos un caracter
        lista.borrarFinal();
        lista.imprimir();

        //Buscamos el número de ocurrencias de un caracter introducido por teclado
        System.out.print("Introduce un caracter a buscar: ");
        char buscar = teclado.nextLine().charAt(0);
        System.out.println("Hay "+lista.contarLetras(buscar)+" ocurrencias del caracter "+buscar);
        
        //Buscamos un caracter de una posición
        System.out.print("Introduce una posición para buscar un caracter: ");
        int pos = teclado.nextInt();
        System.out.println("En la posicion "+pos+" está el caracter "+lista.caracterPosicion(pos));
    }
}
