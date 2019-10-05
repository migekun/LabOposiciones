package es.navas.oposiciones;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author manavas Realiza un programa que permita calcular su descomposición en
 *         factores primos. Por ejemplo, para el número 12 deberá mostrar 2, 2, 3
 * 
 */
public class FactoresPrimos {
	private static Logger logger = Logger.getLogger(FactoresPrimos.class.getName());

	public static void calcularFactoresPrimos(int numero) {
		int aux = 2;
		logger.log(Level.INFO, "Buscando factores de : " + numero + "\n"); 
        //Si el número es mayor o igual que el factor el número va dividiéndose entre sus factores primos
        while (numero >= aux) {
            
            //Mientras el módulo (resto de una división) es 0, estamos obteniendo factores primos
            //Utilizamos while y no if porque un mismo número puede tener factores primos repetidos
            while (numero % aux == 0) {                
                //Divide el propio número entre el divisor y vuelve a realizar la operación
                numero /= aux;
                logger.log(Level.INFO, "factor: " + aux + " numero: " + numero + "\n");                             
            }
            aux++;
        }

	}
}
