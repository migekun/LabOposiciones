package es.navas.oposiciones;

/**
 * 
 * @author manavas
 * 
 * 5! = 5*4*3*2*1=120
 * n! = n * (n-1) * (n-2)... * 1
 * 0! = 1
 */
public class NumeroFactorial {

	public static int iterativo(int numero) {
		int factorial = 1;
		if (numero == 0) return 1;
		for (int i = numero; i > 1; i--) {
			factorial *= i;
			System.out.println("factorial: " +factorial + " i:" + i);
		}
		System.out.println("factorial: " + factorial);
		return factorial;
	}
	
	public static int recursivo(int numero) {
		if (numero == 0) return 1;
		else return recursivo(numero-1) * numero;
	} 
}
