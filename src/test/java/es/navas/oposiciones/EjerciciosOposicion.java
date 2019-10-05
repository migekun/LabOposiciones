package es.navas.oposiciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EjerciciosOposicion {

	@Test
	public void numerosAmigos() {

		assertTrue(NumerosAmigos.sonAmigos(220, 284));
		assertTrue(NumerosAmigos.sonAmigos(1184, 1210));
		
	}
	
	@Test
	public void numerosPrimos() {
		assertTrue(NumeroPrimo.esPrimo(7));
		assertFalse(NumeroPrimo.esPrimo(14));
		assertTrue(NumeroPrimo.esPrimo(13));
		assertFalse(NumeroPrimo.esPrimo(8));
		assertTrue(NumeroPrimo.esPrimo(31));
	}
	
	@Test
	public void numeroApocaliptico() {
		//157, 192, 218, 220, 222
		assertTrue(NumeroApocaliptico.esNumeroApocaliptico(157));
		assertFalse(NumeroApocaliptico.esNumeroApocaliptico(192));
		assertTrue(NumeroApocaliptico.esNumeroApocaliptico(218));
		assertFalse(NumeroApocaliptico.esNumeroApocaliptico(3), "apocaliptico 3");	
		
	}
	@Test
	public void factoresPrimos() {
		FactoresPrimos.calcularFactoresPrimos(33);
	}

}	
