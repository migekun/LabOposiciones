package es.navas.oposiciones.datosDinamicos.listaDoblementeEnlazada;

/**
 * Clase Nodo que contiene un dato de tipo entero y el enlace al siguiente y anterior entero
 *
 * @author manavas
 * @version 1.0
 */
class Nodo {

    char caracter;
    Nodo siguiente;
    Nodo anterior;

    /**
     * Recibe una cadena y crea un Nodo
     *
     * @param caracter Contiene la cadena a almacenar en la lista
     */
    Nodo(char caracter) {
        this(caracter, null, null);
    }

    /**
     * Constructor de Nodo con tres parámetros
     *
     * @param c Contiene la cadena a almacenar en la lista
     * @param siguiente Contiene una referencia al siguiente nodo de la lista
     * @param anterior Contiene una referencia al anterior nodo de la lista
     *
     */
    Nodo(char car, Nodo sig, Nodo ant) {
        caracter = car;
        siguiente = sig;
        anterior = ant;
    }

    /**
     * Devuelve el valor cadena del nodo
     *
     * @return Cadena a devolver
     */
    char getCaracter() {
        return caracter;
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
