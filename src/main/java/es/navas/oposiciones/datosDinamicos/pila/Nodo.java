package es.navas.oposiciones.datosDinamicos.pila;


/**
 * Clase Nodo que contiene un dato de tipo entero y el enlace al siguiente
 *
 * @author manavas
 * @version 1.0
 */
public class Nodo {

    char simbolo;
    Nodo enlace;

    /**
     * Recibe un entero y crea un Nodo
     * @param x Contiene el entero a almacenar en la lista
     */
    public Nodo(char x) {
        simbolo = x;
        enlace = null;
    }

}
