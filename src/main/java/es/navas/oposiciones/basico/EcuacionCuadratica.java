package es.navas.oposiciones.basico;

public class EcuacionCuadratica {

	public static double[] execute(double a, double b, double c) throws MenorCeroException {
		double[] soluciones = new double[] { 0, 0 };

		double determinante = (b * b) - (4 * a * c);
		System.out.println("determinante:" + determinante);
		double sqrt = Math.sqrt(determinante);
		if (determinante > 0) {
			soluciones[0] = (-b + sqrt) / (2 * a);
			soluciones[1] = (-b - sqrt) / (2 * a);
			System.out.println("Roots are :: " + soluciones[0] + " and " + soluciones[1]);
		} else if (determinante == 0) {
			System.out.println("Root is :: " + (-b + sqrt) / (2 * a));
			soluciones[0] = (-b + sqrt) / (2 * a);
			soluciones[1] = (-b + sqrt) / (2 * a);
		} else {
			throw new MenorCeroException("Determinante menor de cero, sin solucion");
		}
		return soluciones;
	}

	public static class MenorCeroException extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public MenorCeroException() {
			super();
			// TODO Auto-generated constructor stub
		}

		public MenorCeroException(String message) {
			super(message);
			// TODO Auto-generated constructor stub
		}

	}
}
