package es.navas.oposiciones;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NumerosAmigos {
	/*
	 * Dos números enteros positivos A y B son números amigos si la suma de los
	 * divisores propios de A es igual a B y la suma de los divisores propios de B
	 * es igual a A.
	 * 
	 * Los divisores propios de un número incluyen la unidad pero no el propio
	 * número.
	 * 
	 * Un ejemplo de números amigos son los números 220 y 284. Los divisores propios
	 * de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110. La suma de los divisores
	 * propios de 220 da como resultado 284 Los divisores propios de 284 son 1, 2,
	 * 4, 71 y 142. La suma de los divisores propios de 284 da como resultado 220.
	 * Por lo tanto 220 y 284 son amigos.
	 * 
	 * Otras parejas de números amigos son: 
	 * 1184, 1210 
	 * 2620, 2924 
	 * 5020, 5564 
	 * 6232, 6368 10744, 10856 12285, 14595 17296, 18416
	 */

	private static Logger logger = Logger.getLogger(NumerosAmigos.class.getName());
	/**
	 * Método main
	 * 
	 * @param args Argumentos de la llamada al método main
	 */
	public static boolean sonAmigos(int n1, int n2) {
		
		// Muestra los divisores propios del primer número
		logger.log(Level.INFO, "\nLos divisores propios de " + n1 + " son: ");
		int suma = sumaDivisores(n1);

		// Si la suma de los divisores de n1 es igual a n2 continuamos el programa
		if (suma == n2) {
			logger.log(Level.INFO, "\nLos divisores propios de " + n2 + " son: ");
			suma = sumaDivisores(n2);
			// Si la suma de los divisores de n2 es igual a n1, son amigos
			if (suma == n1) {
				return true;
			} 
		} 
		return false;
	}
	
	private static int sumaDivisores(int n1) {
		int suma = 0;
		for (int i = 1; i < n1; i++) { 
			if (n1 % i == 0) { 
				System.out.print(i + ",");
				suma = suma + i;
			}
		}
		return suma;
	}

}
