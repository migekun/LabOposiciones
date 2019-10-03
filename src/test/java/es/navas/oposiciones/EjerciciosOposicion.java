package es.navas.oposiciones;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EjerciciosOposicion {

	@Test
	public void test() {

		assertTrue(NumerosHermanos.sonHermanos(220, 284));
		assertTrue(NumerosHermanos.sonHermanos(1184, 1210));
		
	}

}	
