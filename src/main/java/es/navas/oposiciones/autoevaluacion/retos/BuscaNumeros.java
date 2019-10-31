package es.navas.oposiciones.autoevaluacion.retos;

import java.util.Arrays;

public class BuscaNumeros {

	public static int buscaUnicoSinOpuesto(int[] array) {
		
		int unico = 0;
		for (int i = 0; i < array.length; i++) {
			unico += array[i];
		}
		return unico;
	}
	
	public static int buscaUnicoSinPareja(int[] array) {
		
		int unico = 0;
		for (int i = 0; i < array.length; i++) {
			unico ^= array[i];
		}
		return unico;
	}
	
	public static int buscaUnicoSinOpuestoJava8(int[] array) {
		return Arrays.stream(array).sum();
	}

//	public static int buscaUnicoSinParejaJava8(int[] array) {
//		int unico = 0;
//		Arrays.stream(array).map(i-> unico^= i);
//	
////		IntStream.range(0, array.length).
////	             .forEach(i -> i^= array[i]);
//	             return unico;
//	}
//	
//	public static int buscaUnicoSinPareja
	
}
