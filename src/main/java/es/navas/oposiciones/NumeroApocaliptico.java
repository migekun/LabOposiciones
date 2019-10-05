package es.navas.oposiciones;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * 
 * @author manavas
 * Realiza un programa que compruebe si un número es apocalíptico o no.
 * Un número n es apocalíptico si el resultado de 2 elevado a n tiene la cifra 666.
 * Ejemplos de números apocalípticos son 157, 192, 218, 220, 222...
 */
public class NumeroApocaliptico {
	private static Logger logger = Logger.getLogger(NumeroApocaliptico.class.getName());
	public static boolean esNumeroApocaliptico(double numero) {
		double potenciaDos =  Math.pow(2, numero);
		String cadena = Double.toString(potenciaDos);
        System.out.println("2 elevado al número: " +numero+" es "+cadena);
        
        //Comprobamos si la cadena contiene el número 666
        if (cadena.contains("666")){
            logger.log(Level.ALL, "El número "+numero+" es apocalíptico");
            return true;
        }
        else{
        	logger.log(Level.ALL, "El número "+numero+" no es apocalíptico");
            return false;
        }
	} 

}
