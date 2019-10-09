package es.navas.oposiciones.datosEstaticos;

public class CameliceFrase {

	public static String cameliza(String frase) {
		String camelFrase = "";
		String[] fraseXPartes = frase.split(" ");
		for (int i = 0; i < fraseXPartes.length; i++) {
			camelFrase += camel(fraseXPartes[i]) + (i== fraseXPartes.length - 1 ? "": " ");
		}
		return camelFrase;
	}

	private static String camel(String parte) {
		return parte.substring(0, 1).toUpperCase() + parte.substring(1, parte.length()).toLowerCase();
	}
	
}
