package es.navas.oposiciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.navas.oposiciones.datosEstaticos.ValidacionContrasenya;

class EjerciciosOposicionesDatosEstaticos {

	@Test
	void test() {
		ValidacionContrasenya.validar("aaaaaaaaAAA33.");
	}

}
