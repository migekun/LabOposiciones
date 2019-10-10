package es.navas.oposiciones.datosEstaticos.cadenas;

public class Palindromo {

	public static boolean esPalindromo(String palabra) {
		int initIndex = 0;
		int endIndex = palabra.length() - 1;
		palabra = palabra.toLowerCase();
		while (initIndex < endIndex) {
			if (palabra.charAt(initIndex) != palabra.charAt(endIndex)) return false;
			initIndex++;
			endIndex--;
		}
		return true; 
	}
	
}
