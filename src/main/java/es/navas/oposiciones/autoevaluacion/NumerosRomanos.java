package es.navas.oposiciones.autoevaluacion;

import java.util.Scanner;

/**

Implementar una funci�n que convierta un n�mero en base decimal a su equivalente en notaci�n romana.
Consideraciones:
- El n�mero, con independencia de que est� en base decimal o no, debe ser un entero.
- La notaci�n de n�meros romanos se emplea para n�meros entre el 1 y el 3999.

 */
public class NumerosRomanos {
	private static final int LIMITE_INFERIOR = 1;
	private static final int LIMITE_SUPERIOR = 3999;
	private static final String SIGNOS_NUMEROS_ROMANOS = "MDCLXVI";
	private static final int[] VALORES_NUMEROS_ROMANOS = {1000, 500, 100, 50, 10, 5, 1};
	private static final boolean[] VALOR_NUMERO_ROMANO_BASE_10 = {true, false, true, false, true, false, true};
	private static Scanner sc;

	public static int getSiguienteBase10(int posicion){
		int siguiente = posicion + 1;

		while(!VALOR_NUMERO_ROMANO_BASE_10[siguiente]){
			siguiente++;
		}
		
		return siguiente;
	}
	public static String getNumeroRomano(int numero){
		if(numero < LIMITE_INFERIOR || numero > LIMITE_SUPERIOR){
			return "Error - El n�mero introducido no se encuentra dentro de los l�mites " + LIMITE_INFERIOR + " y " + LIMITE_SUPERIOR;
		}else{
			StringBuilder numeroRomano = new StringBuilder();
			int i = 0;
			int iguales = 0;
			int siguienteBase10;

			while(numero != 0){
				if((numero - VALORES_NUMEROS_ROMANOS[i]) >= 0){
					iguales ++;
					if((iguales == 1) || ((iguales != 4) && VALOR_NUMERO_ROMANO_BASE_10[i])){
						numero = numero - VALORES_NUMEROS_ROMANOS[i];
						numeroRomano.append(SIGNOS_NUMEROS_ROMANOS.charAt(i));
					}else{
						numeroRomano = new StringBuilder(numeroRomano.substring(0, numeroRomano.toString().length() - 2));
						numero = numero - VALORES_NUMEROS_ROMANOS[i];
						numeroRomano.append(SIGNOS_NUMEROS_ROMANOS.charAt(i-1));
						iguales = 0;
						i++;
					}
				}else{
					if((numero + 1) == VALORES_NUMEROS_ROMANOS[i]){
						siguienteBase10 = getSiguienteBase10(i);
						numero = (numero - VALORES_NUMEROS_ROMANOS[i]) + VALORES_NUMEROS_ROMANOS[siguienteBase10];
						numeroRomano.append(SIGNOS_NUMEROS_ROMANOS.charAt(siguienteBase10));
						numeroRomano.append(SIGNOS_NUMEROS_ROMANOS.charAt(i));
					}
					i++;
					iguales = 0;
				}

			}
			return numeroRomano.toString();
		}
	}

	public static void main(String[] args){
		sc = new Scanner(System.in);
		int numero;
		do{
			System.out.println("Introduzca un n�mero o pulse 0 para salir");
			numero = sc.nextInt();

			if(numero != 0){
				System.out.println("El n�mero " + numero + " en n�meros romanos es: " + getNumeroRomano(numero));
			}

		}while(numero != 0);
	}

}
