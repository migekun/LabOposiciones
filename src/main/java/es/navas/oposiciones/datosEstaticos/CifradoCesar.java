package es.navas.oposiciones.datosEstaticos;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CifradoCesar {

	private static List<Character> alfabeto = Arrays.asList(
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 
			'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Escribe una frase:");
		String frase = teclado.nextLine().toLowerCase();
		
		System.out.println("Cuantos movimiento:");
		int movimientos = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Si quieres cifrar escribe S, sino introduce intro");
		boolean cifrar = "S".equals(teclado.nextLine().toUpperCase());
		
		String palabraFinal = cifrar(frase, movimientos, cifrar);
		System.out.println("La palabra es:" + palabraFinal);
	}
	
	public static String cifrar(String palabra, int movimientoCifrado, boolean cifrar) {
		String palabraFinal = "";
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == ' ') {
				palabraFinal += " ";
				continue;
			}
			int indexAlfabeto = alfabeto.indexOf(palabra.charAt(i)) ;
			System.out.println(palabra.charAt(i) + "/" + indexAlfabeto);
			indexAlfabeto += cifrar ? movimientoCifrado: (-1 * movimientoCifrado);
			indexAlfabeto = indexAlfabeto < 0 ? indexAlfabeto + alfabeto.size() : indexAlfabeto;
			System.out.println(alfabeto.get(indexAlfabeto % alfabeto.size()));
			palabraFinal += alfabeto.get(indexAlfabeto % alfabeto.size());
		}
		System.out.println(palabraFinal);
		return palabraFinal;
	}
	
}
