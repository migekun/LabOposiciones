package es.navas.oposiciones;

/**
 * 
 * @author manavas
 *
 */
public class Fibonacci {

	/**
	 * Time Complexity: T(n) = T(n-1) + T(n-2) exponencial. 
	 * Extra Space: O(n)
	 * TODO hacer unit test
	 * @param numero
	 * @return
	 */
	public static int recursivo(int numero) {
		//System.out.print("recursivo:" + numero + ", ");
		if (numero <= 1)
			return numero;
		return recursivo(numero - 1) + recursivo(numero - 2);
	}

	/**
	 * Time Complexity:O(n) 
	 * Extra Space: O(n)
	 * TODO hacer unit test
	 * @param numero
	 * @return
	 */
	public static int iterativo(int numero) {
		int f[] = new int[numero + 2]; // 1 extra para el caso, n = 0 y n = 1
		int i;

		/* 0 y 1 posiciones de la serie son 0 y 1 */
		f[0] = 0;
		f[1] = 1;

		for (i = 2; i <= numero; i++) {
			f[i] = f[i - 1] + f[i - 2];
			//System.out.print("f:" + f[i] + ", ");
		}

		return f[numero];
	}
}
