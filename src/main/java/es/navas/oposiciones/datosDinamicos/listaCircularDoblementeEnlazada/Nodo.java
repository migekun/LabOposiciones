package es.navas.oposiciones.datosDinamicos.listaCircularDoblementeEnlazada;

/**
 * Clase Nodo que contiene un dato de tipo entero y el enlace al siguiente y anterior nodo
 *
 * @author manavas
 * @version 1.0
 */
class Nodo {

    String cadena;
    Nodo siguiente;
    Nodo anterior;

    /**
     * Recibe una cadena y crea un Nodo
     *
     * @param ciudad Contiene la cadena a almacenar en la lista
     */
    Nodo(String ciudad) {
        this(ciudad, null, null);
    }

    /**
     * Constructor de Nodo con tres parámetros
     *
     * @param c Contiene la cadena a almacenar en la lista
     * @param siguiente Contiene una referencia al siguiente nodo de la lista
     * @param anterior Contiene una referencia al anterior nodo de la lista
     *
     */
    Nodo(String c, Nodo sig, Nodo ant) {
        cadena = c;
        siguiente = sig;
        anterior = ant;
    }

    /**
     * Devuelve el valor cadena del nodo
     *
     * @return Cadena a devolver
     */
    String getCadena() {
        return cadena;
    }

    /**
     * Devuelve el nodo siguiente del nodo
     *
     * @return Nodo a devolver
     */
    Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * Devuelve el nodo anterior del nodo
     *
     * @return Nodo a devolver
     */
    Nodo getAnterior() {
        return anterior;
    }
}
