package es.navas.oposiciones.autoevaluacion.datosDinamicos;

/**
 * 
 * @author manavas
 *
 */
public class Nodo {
	Producto elemento;
	Nodo siguiente;

	public Nodo(Producto producto) {
		elemento = producto;
		siguiente = null;
	}
}
