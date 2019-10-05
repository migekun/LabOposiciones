package es.navas.oposiciones;

public class NumeroVocales {

	public static int cuentaVocales(String palabra) {
		int numeroVocales = 0;
		char[] letras = palabra.toLowerCase().toCharArray();
		for (int i = 0; i < palabra.length();i++) {
			char letra = letras[i];
			if (letra == 'a' || letra == 'e'|| letra == 'i'|| letra == 'o'|| letra == 'u') numeroVocales++;
			
		}
		return numeroVocales;
	}

}
