package es.navas.oposiciones;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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

}
