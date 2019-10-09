package es.navas.oposiciones.datosEstaticos;

import java.util.Scanner;

public class ContadorPalabras {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
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
