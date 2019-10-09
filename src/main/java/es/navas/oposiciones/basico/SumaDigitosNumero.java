package es.navas.oposiciones.basico;
/**
 * 
 * @author manavas
 * sumaDigitos(9) = 9
 * sumaDigitos(10) = 1
 * sumaDigitos(123) = 6 ...
 * 
 */
public class SumaDigitosNumero {

	public static int iterativo(int numero) {
		int suma = 0;
		while (numero > 0) {
			suma += numero%10;
			numero /= 10;
		}
		System.out.println("suma: " +suma);
		return suma;
	}

	public static int recursivo(int numero) {
		if (numero < 10) return numero;
		return numero % 10 + recursivo(numero/10);
	}	
}
