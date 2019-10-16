package es.navas.oposiciones.datosEstaticos.cadenas;

import java.util.Scanner;

public class ContadorPalabras {

	private static Scanner teclado;

	public static void main(String[] args) {
		teclado = new Scanner(System.in);
		System.out.println("Escribe una frase");
		
		String texto = teclado.nextLine();
		int numeroPalabras = cuentaPalabras(texto);
		System.out.println("La frase: " + texto + " tiene " + numeroPalabras + " palabras." );
	}

	public static int cuentaPalabras(String texto) {
		String[] palabras = texto.split(" ");
		return palabras.length;
	}

}
