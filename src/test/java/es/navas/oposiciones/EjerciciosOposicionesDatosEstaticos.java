package es.navas.oposiciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.navas.oposiciones.datosEstaticos.CameliceFrase;
import es.navas.oposiciones.datosEstaticos.Palindromo;
import es.navas.oposiciones.datosEstaticos.ValidacionContrasenya;
import es.navas.oposiciones.datosEstaticos.ValidacionContrasenya.Validacion;

class EjerciciosOposicionesDatosEstaticos {

	@Test
	void validacion() {
		Validacion validacion = ValidacionContrasenya.validar("aaaaaaaaAAA33.");
		assertTrue(validacion.isValido());
		assertTrue(validacion.getErrorValidacion().equals(""));
		validacion = ValidacionContrasenya.validar("aaaaaaaa33.");
		assertFalse(validacion.isValido());
		assertTrue(!validacion.getErrorValidacion().equals(""));
		validacion = ValidacionContrasenya.validar("aaaaaaaa33");
		assertFalse(validacion.isValido());
		assertTrue(!validacion.getErrorValidacion().equals(""));
	}
	
	@Test
	void palindromo() {
		assertTrue(Palindromo.esPalindromo("aa"));
		assertTrue(Palindromo.esPalindromo("apa   apa"));
		assertFalse(Palindromo.esPalindromo("asfadsfaf"));
		assertTrue(Palindromo.esPalindromo("a"));
	}
	
	@Test
	void camel() {
		assertEquals("Hola Caracola", CameliceFrase.cameliza("hOLA caracola"));
	}

}
