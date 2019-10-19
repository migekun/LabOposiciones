package es.navas.oposiciones;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import es.navas.oposiciones.autoevaluacion.Codility;

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

}
