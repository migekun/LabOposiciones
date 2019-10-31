package es.navas.oposiciones.autoevaluacion.retos;

import java.util.ArrayList;
import java.util.List;

public class SieteYMedio {
	/**
	 * https://stackoverflow.com/questions/4632322/finding-all-possible-combinations-of-numbers-to-reach-a-given-sum
	 * 
	 * https://es.wikipedia.org/wiki/Problema_de_la_suma_de_subconjuntos
	 */
	
	private static final List<Carta> BARAJA = new ArrayList<Carta>() {
		{
			add(new Carta("1", 1f, Baza.ORO));
			add(new Carta("1", 1f, Baza.BASTO));
			add(new Carta("1", 1f, Baza.ESPADAS));
			add(new Carta("1", 1f, Baza.COPAS));
			add(new Carta("2", 2f, Baza.ORO));
			add(new Carta("2", 2f, Baza.BASTO));
			add(new Carta("2", 2f, Baza.ESPADAS));
			add(new Carta("2", 2f, Baza.COPAS));
			add(new Carta("3", 3f, Baza.ORO));
			add(new Carta("3", 3f, Baza.BASTO));
			add(new Carta("3", 3f, Baza.ESPADAS));
			add(new Carta("3", 3f, Baza.COPAS));
			add(new Carta("4", 4f, Baza.ORO));
			add(new Carta("4", 4f, Baza.BASTO));
			add(new Carta("4", 4f, Baza.ESPADAS));
			add(new Carta("4", 4f, Baza.COPAS));
			add(new Carta("5", 5f, Baza.ORO));
			add(new Carta("5", 5f, Baza.BASTO));
			add(new Carta("5", 5f, Baza.ESPADAS));
			add(new Carta("5", 5f, Baza.COPAS));
			add(new Carta("6", 6f, Baza.ORO));
			add(new Carta("6", 6f, Baza.BASTO));
			add(new Carta("6", 6f, Baza.ESPADAS));
			add(new Carta("6", 6f, Baza.COPAS));
			add(new Carta("7", 7f, Baza.ORO));
			add(new Carta("7", 7f, Baza.BASTO));
			add(new Carta("7", 7f, Baza.ESPADAS));
			add(new Carta("7", 7f, Baza.COPAS));
			add(new Carta("S", 0.5f, Baza.ORO)); // 10
			add(new Carta("S", 0.5f, Baza.BASTO));
			add(new Carta("S", 0.5f, Baza.ESPADAS));
			add(new Carta("S", 0.5f, Baza.COPAS));
			add(new Carta("C", 0.5f, Baza.ORO));// 11
			add(new Carta("C", 0.5f, Baza.BASTO));
			add(new Carta("C", 0.5f, Baza.ESPADAS));
			add(new Carta("C", 0.5f, Baza.COPAS));
			add(new Carta("R", 0.5f, Baza.ORO));// 12
			add(new Carta("R", 0.5f, Baza.BASTO));
			add(new Carta("R", 0.5f, Baza.ESPADAS));
			add(new Carta("R", 0.5f, Baza.COPAS));
		}
	};

	public static void main(String[] args){
		suma(BARAJA, 7.5f);
	}

	private static void suma(List<Carta> baraja, float target) {
		sumaRecursiva(baraja, target, new ArrayList<Carta>());
	}

	private static void sumaRecursiva(List<Carta> baraja, float objetivo, List<Carta> barajaParcial) {
		float totalParcial = 0;

		for (Carta carta : barajaParcial) {
			totalParcial += carta.getValor();
		}
		if (objetivo == totalParcial) {
			for (Carta carta : barajaParcial) {
				System.out.print(carta.toString(true) + " ");
			}
			System.out.println("");
		} else if (totalParcial >= objetivo) {
			return;
		}
		for (int i = 0; i < baraja.size(); i++) {
			List<Carta> remaining = new ArrayList<>();
			Carta carta = baraja.get(i);
			for (int j = i + 1; j < baraja.size(); j++) {
				remaining.add(baraja.get(j));
			}

			List<Carta> partial_rec = new ArrayList<>(barajaParcial);
			partial_rec.add(carta);
			sumaRecursiva(remaining, objetivo, partial_rec);
		}
	}

	public enum Baza {
		ORO, BASTO, ESPADAS, COPAS
	}

	public static class Carta {
		private String nombre;
		private Float valor;
		private Baza baza;

		public Carta(String nombre, Float valor, Baza baza) {
			super();
			this.nombre = nombre;
			this.valor = valor;
			this.baza = baza;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Float getValor() {
			return valor;
		}

		public void setValor(Float valor) {
			this.valor = valor;
		}

		public Baza getBaza() {
			return baza;
		}

		public void setBaza(Baza baza) {
			this.baza = baza;
		}

		public String toString(boolean breve) {
			return breve ? "[N=" + nombre + "-P=" + baza.name().substring(0, 2) + "]"
					: "Carta [nombre=" + nombre + ", valor=" + valor + ", baza=" + baza + "]";
		}

	}

}
