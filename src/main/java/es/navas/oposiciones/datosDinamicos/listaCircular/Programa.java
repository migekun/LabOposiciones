package es.navas.oposiciones.datosDinamicos.listaCircular;

import java.util.Random;
import java.util.Scanner;

public class Programa {

    private static Scanner sc;

	/**
     * Método principal
     *
     * @args Argumentos de la llamada al método principal
     */
    public static void main(String[] args) {
        Random r; //Permite crear números aleatorios
        int d; //Almacena el entero generado
        ListaCircular lista; //Lista de números enteros
        int k; //Almacena el tamaño máximo de elementos de la lista

        //Almacena un número aleatorio del 0 al 1.
        r = new Random();
        //Crea una lista vacía
        lista = new ListaCircular();
        //Genera el tamaño (número de nodos) que tendrá la lista
        k = Math.abs(r.nextInt() % 55);
        //  Son insertados elementos en la lista
        for (; k > 0; k--) {
            //Al hacer la división de un número alto entre 99, el resto como máximo será 99
            d = r.nextInt() % 99;
            //Inserta el entero por la cabeza de la lista
            lista.insertarCabezaLista(d);
        }
        
        //Llamada a métodos para comprobar el funcionamiento
        lista.insertarCabezaLista(1); //Introducimos un elemento en primer lugar
        lista.insertarUltimoLista(0); //Introducimos un elemento al final

        // Recorre la lista visualizando los elementos
        System.out.println("\nElementos de la lista generados al azar");
        lista.visualizar();
        
        //Busca un elemento en la lista
        System.out.println("\nElige el elemento a buscar");
        sc = new Scanner(System.in);
        int valor = sc.nextInt();
        Nodo buscado = lista.buscarLista(valor);
        if (buscado!=null){
            System.out.println("Es: "+buscado.dato);
        }else System.out.println("No existe");
        
        //Busca un elemento por su posición
        System.out.println("\nElige la posición a buscar");
        sc = new Scanner(System.in);
        valor = sc.nextInt();
        buscado = lista.buscarPosicion(valor);
        System.out.println("Es: "+buscado.dato);
        
        //Borra un elemento por su posición
        System.out.println("\nElige la posición a borrar");
        sc = new Scanner(System.in);
        valor = sc.nextInt();
        lista.eliminarPosicion(valor);
        lista.visualizar();
        
        //Inserta un elemento por su posición
        System.out.println("\nElige la posición a partir de la que insertar (0 para insertar por el principio)");
        sc = new Scanner(System.in);
        valor = sc.nextInt();
        System.out.println("\nIndica el entero a introducir");
        sc = new Scanner(System.in);
        int valor2 = sc.nextInt();
        lista.insertarCentro(valor, valor2);
        
        lista.visualizar();
    }

}
