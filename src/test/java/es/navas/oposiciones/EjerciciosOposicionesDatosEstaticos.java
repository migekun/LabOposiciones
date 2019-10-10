package es.navas.oposiciones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import es.navas.oposiciones.datosEstaticos.CameliceFrase;
import es.navas.oposiciones.datosEstaticos.CifradoCesar;
import es.navas.oposiciones.datosEstaticos.ContadorPalabras;
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

	@Test
	void cuentaPalabras() {
		assertEquals(2, ContadorPalabras.cuentaPalabras("hOLA caracola"));
	}

	@Test
	void cifrado() {
		assertEquals("cde", CifradoCesar.cifrar("xyz", 5, true));
		assertEquals("xyz", CifradoCesar.cifrar("cde", 5, false));
		assertEquals("nuqg", CifradoCesar.cifrar("hola", 6, true));
	}

}
