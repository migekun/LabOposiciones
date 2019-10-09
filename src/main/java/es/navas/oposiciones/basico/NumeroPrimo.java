package es.navas.oposiciones.basico;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NumeroPrimo {
	private static Logger logger = Logger.getLogger(NumeroPrimo.class.getName());
	public static boolean esPrimo(int numero) {
		logger.log(Level.INFO, "numero: " + numero);
		for (int i = numero - 1; i > 0; i--) { 
			System.out.println("Indice: "+ i + " modulo:" + (numero % i) );
			if (numero % i == 0 && i != 1) { 
				logger.log(Level.WARNING, "Divisor"+i + ",");
				return false;
			}	
		}
		return true;
	}
	
}
