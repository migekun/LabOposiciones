package es.navas.oposiciones.datosEstaticos.arrays;

import java.util.Scanner;

public class OperacionesNotas {

	private static final int MAX_NUM = 10;
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		float[] notas = obtenNotasTeclado(teclado);
		
		System.out.println("*** Menu ***");
		System.out.println("1. Listar notas");
		System.out.println("2. Ordenar notas");
		System.out.println("3. Buscar nota");
		System.out.println("4. Media de notas");
		System.out.println("5. Numero de aprovados");
		System.out.println("6. Nota mas alta");
		System.out.println("Introduzca una opcion 1-6. Pulse 0 para salir");
		int opcion = Integer.parseInt(teclado.nextLine());
		switch (opcion) {
			case 0: System.out.println("Adios!!!"); break;
			case 1: recorrer(notas); break;
			case 2: ordenar(notas); break;
			case 3: buscar(notas); break;
			case 4: media(notas); break;
			case 5: aprovados(notas); break;
			case 6: mayor(notas); break;
			default: System.err.println("Opcion no valida!!!");
				break;
		}
	}

	private static void mayor(float[] notas) {
		// TODO Auto-generated method stub
		
	}

	private static void aprovados(float[] notas) {
		// TODO Auto-generated method stub
		
	}

	private static void media(float[] notas) {
		// TODO Auto-generated method stub
		
	}

	private static void buscar(float[] notas) {
		// TODO Auto-generated method stub
		
	}

	private static void ordenar(float[] notas) {
		// TODO Auto-generated method stub
		
	}

	private static void recorrer(float[] notas) {
		for (int i = 0; i < notas.length; i++){
			System.out.println("Nota en posic: " + notas[i]);
		}
	}

	private static float[] obtenNotasTeclado(Scanner teclado) {
		float[] notas = new float[MAX_NUM];	
		for (int i = 0; i < MAX_NUM; i++) {
			System.out.println("Introduzca una nota comprendida entre 0 y 10:");
			notas[i] = Float.parseFloat(teclado.nextLine());
			while (notas[i]< 0 || notas[i]>10) {
				System.out.println("Error la nota no esta en el rango 0-10. Introduzca una nota comprendida entre 0 y 10:");
				notas[i] = Float.parseFloat(teclado.nextLine());
			}
		}
		return notas;
	}

}
