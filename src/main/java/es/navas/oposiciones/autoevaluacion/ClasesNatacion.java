package es.navas.oposiciones.autoevaluacion;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * En un polideportivo se imparten clases de natación <b>5 días a la semana</b>, 
 * <b>4 horas al día</b>. 
 * Se desea controlar el número de niños que acuden a cada hora
 * cada día, sabiendo que puede haber 
 * un <b>mínimo de 10 y un máximo de 20</b> niños por clase.
 * 
 * Diseña una estructura de datos que permita almacenar dichos valores e
 * introduce datos aleatorios en cada posición. Realiza un programa que permita
 * realizar las siguientes operaciones: 
 * - Mostrar los valores almacenados y el
 * número total de alumnos diarios siguiendo la siguiente propuesta: 
 * o Lunes:     15 19 20 12 
 * o Martes:    16 14 12 11 
 * o Miércoles: 17 20 11 10 
 * o Jueves:    11 12 13 18
 * o Viernes:   18 19 20 19
 * 
 * • Mostrar el total de alumnos por día. 
 * • Mostrar el total de alumnos po hora. 
 * • Mostrar la media de alumnos por clase. 
 * • Mostrar el/los día/s y la/s hora/s en que hay un número determinado de alumnos introducido por el
 * usuario.
 * 
 * @author manavas
 *
 */

public class ClasesNatacion {

	private static final int MAX_NINYOS = 20;
	private static final int MIN_NINYOS = 10;

	private static final int LUNES = 0;
	private static final int MARTES = 1;
	private static final int MIERCOLES = 2;
	private static final int JUEVES = 3;
	private static final int VIERNES = 4;

	private static final Map<Integer, String> DIAS_SEMANA = new HashMap<Integer, String>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			put(LUNES, "Lunes");
			put(MARTES, "Martes");
			put(MIERCOLES, "Miercoles");
			put(JUEVES, "Jueves");
			put(VIERNES, "Viernes");
		}
	};
	
	private static Scanner teclado;

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int clasesNatacion[][] = populateClases();
		System.out.println("\n\t Matriz \n");
		visualizar(clasesNatacion);
		System.out.println("\n\tTotal alumnos por dia\n");
		mostrarTotalAlumnosPorDia(clasesNatacion);
		System.out.println("\n\tTotal alumnos por horas\n");
		mostrarTotalAlumnosPorHora(clasesNatacion);
		mostrarMediaAlumnosPorClase(clasesNatacion);
		buscarNumeroAlumnosDiaHora(clasesNatacion);
	}

	private static void buscarNumeroAlumnosDiaHora(int[][] clasesNatacion) {
		teclado = new Scanner(System.in);
		System.out.println("Introduzca numero a buscar entre 10 y 20:");
		int numero = teclado.nextInt();
		for (int i = 0; i < clasesNatacion.length; i++) {
			for (int j = 0; j < clasesNatacion[i].length; j++) {
				if (clasesNatacion[i][j] == numero) {
					System.out.println("\nEncontrado numero: " + numero + " el dia " + DIAS_SEMANA.get(i)
							+ " a la hora " + (j + 1));
				}
			}
		}
	}

	private static void mostrarMediaAlumnosPorClase(int[][] clasesNatacion) {
		int[] alumnosHora = obtenTotalAlumnosPorHora(clasesNatacion);
		int totalAlumnos = 0;
		for (int x = 0; x < alumnosHora.length; x++) {
			totalAlumnos += alumnosHora[x];
		}
		int media = totalAlumnos / clasesNatacion.length;
		media /= alumnosHora.length;
		System.out.println("\nMedia alumnos por clase: " + media);
	}

	private static void mostrarTotalAlumnosPorHora(int[][] clasesNatacion) {
		int[] alumnosHora = obtenTotalAlumnosPorHora(clasesNatacion);
		for (int x = 0; x < alumnosHora.length; x++) {
			System.out.println(DIAS_SEMANA.get(x) + ": " + alumnosHora[x]);
		}
	}

	private static int[] obtenTotalAlumnosPorHora(int[][] clasesNatacion) {
		int horasDia[] = new int[] { 0, 0, 0, 0, 0 };
		for (int i = 0; i < clasesNatacion.length; i++) {
			for (int j = 0; j < clasesNatacion[i].length; j++) {
				horasDia[i] += clasesNatacion[i][j];
			}
		}
		return horasDia;
	}

	private static void mostrarTotalAlumnosPorDia(int[][] clasesNatacion) {
		for (Map.Entry<Integer, String> entry : DIAS_SEMANA.entrySet()) {
			System.out.println(entry.getValue() + ": " + obtenTotalAlumnosPorDia(clasesNatacion[entry.getKey()]));
		}
	}

	private static int obtenTotalAlumnosPorDia(int[] clasesPorDia) {
		int totalAlumnos = 0;
		for (int i = 0; i < clasesPorDia.length; i++) {
			totalAlumnos += clasesPorDia[i];
		}
		return totalAlumnos;
	}

	private static int[][] populateClases() {
		int[][] clasesNatacion = new int[5][4];
		int i, j;
		for (i = 0; i < clasesNatacion.length; i++) {
			for (j = 0; j < clasesNatacion[i].length; j++) {
				clasesNatacion[i][j] = getRandomNumberInRange(MIN_NINYOS, MAX_NINYOS);
			}
		}
		return clasesNatacion;
	}

	private static int getRandomNumberInRange(int min, int max) {
		int range = max - min + 1;
		return (int) (Math.random() * range) + min;
	}

	private static void visualizar(int a[][]) {
		int i, j;
		// Muestra los datos introducidos en la matrid
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println(" ");
		}
	}

}
