package es.navas.oposiciones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import es.navas.oposiciones.autoevaluacion.retos.BuscaNumeros;
import es.navas.oposiciones.autoevaluacion.retos.Codility;

class EjerciciosOposicionesAutoevaluacion {

	@Test
	void codify() {
		Codility codility = new Codility();
//		int[] tmpArray = new int[] {9, 4, 2, 10, 7, 8, 8, 1, 9}; //tiene que devolver 5 (1, 5)
		int[] tmpArray = new int[] {4, 2, 10, 7, 8, 8, 1, 9}; //tiene que devolver 5 (1, 5)
		
		assertEquals(5, codility.solution(tmpArray));
		assertEquals(1, codility.solution(new int[] {100}));
		assertEquals(2, codility.solution(new int[] {4, 8, 12, 16}));
		assertEquals(2, codility.solution(new int[] {4, 8}));
		assertEquals(8, codility.solution(new int[] {50, 150, 50, 150, 50, 150, 50, 150}));
	}
	
	@Test
	void contarUnico() {
		assertEquals(3, BuscaNumeros.buscaUnicoSinOpuesto(new int[] {1,3,4,-1,-4,-6,-8,6,7,8,-7}));
		assertEquals(3, BuscaNumeros.buscaUnicoSinOpuestoJava8(new int[] {1,3,4,-1,-4,-6,-8,6,7,8,-7}));
		assertEquals(2, 1 ^ 3);
		assertEquals(0, 2 ^ 2);
		assertEquals(3, BuscaNumeros.buscaUnicoSinPareja(new int[] {1,3,4,1,4,6,8,6,7,8,7}));
	}

}
