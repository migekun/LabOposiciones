package es.navas.oposiciones.datosEstaticos.cadenas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ahorcado {

	private static List<String> palabras = Arrays.asList("test", "otra", "dos");
	private static List<Character> letrasJugadas = new ArrayList();
	private static Scanner teclado;
	
	public static void main(String[] args) {
		teclado = new Scanner(System.in);
		System.out.println("Escribe una frase");
		boolean palabraEncontrada = false;
		String palabra = palabras.get(getRandomNumberInRange(0, palabras.size()-1));
		for (int i = 0 ; i< palabra.length() ; i++) {
			letrasJugadas.add('_');
		}
		while (!palabraEncontrada) {
			System.out.println("la palabra es:" + letrasJugadas.toString());
			System.out.println("escribe letra o palabra:");
			String texto = teclado.nextLine();
			for (int i = 0; i < palabra.length(); i++) {
				for (int j = 0; j < texto.length(); j++) {					
					if (palabra.charAt(i) == texto.charAt(j)) {
						letrasJugadas.set(i, texto.charAt(j));
					}
				}
			}
			palabraEncontrada = cuentaUndeline(letrasJugadas) == 0;
		}
		System.out.println("la palabra es:" + letrasJugadas.toString());
		System.out.println("You win!!!");
	}

	private static int cuentaUndeline(List<Character> palabra) {
		int underline = 0;
		for (Character character: palabra) {
			if (character.equals('_')) underline++;
		} 
		return underline;
	}

	private static int getRandomNumberInRange(int min, int max) {
        int range = max - min + 1; 
        return (int)(Math.random() * range) + min; 
	}
	
}
