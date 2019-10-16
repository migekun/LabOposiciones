package es.navas.oposiciones.datosDinamicos.listaEnlazada;

import java.util.Random;
import java.util.Scanner;

public class Programa {

	private static Scanner scanner;

	public static void main(String[] args) {
		Random random = new Random();
		ListaEnlazada lista = new ListaEnlazada();

		int aleatorioGenerado;
		int maxElementosLista = Math.abs(random.nextInt() % 60);
		
		for ( ; maxElementosLista > 0; maxElementosLista--) {
			aleatorioGenerado = random.nextInt() % 99;
			lista.insertaCabezaLista(aleatorioGenerado);
		}
		System.out.println("\nLista inicial:");
		lista.visualizar();
		
		lista.insertaCabezaLista(1);
		lista.insertaUltimoLista(0);
		System.out.println("\nLista despues de insertar 1 y 0:");
		lista.visualizar();
		
		System.out.println("\nElige elemento a buscar:");
		scanner = new Scanner(System.in);
		int valor = scanner.nextInt(); 	
		Nodo buscado = lista.buscarLista(valor);
		if (buscado != null) {
			System.out.println("El elemento existe y es: " + buscado.dato);
		} else {
			System.out.println("El elemento no existe");
		}
		
		System.out.println ("\nElige la posicion a buscar");
		int posicion = scanner.nextInt(); 	
		buscado = lista.buscarPosicion(posicion);
		if (buscado != null) {
			System.out.println("El elemento buscado es: " + buscado.dato);
		} else {
			System.out.println("No existe la posicion");
		}
		
		System.out.println ("\nElige la posicion a borrar");
		posicion = scanner.nextInt(); 	
		lista.eliminarPosicion(posicion);
		lista.visualizar();
		
		System.out.println ("\nElige la posicion a partir de insertar el elemento (0 para el principio)");
		posicion = scanner.nextInt(); 	
		System.out.println ("\nIndica entero a guardar:");
		valor = scanner.nextInt(); 	
		lista.insertarCentro(posicion, valor);
		lista.visualizar();
	}

}
