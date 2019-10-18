package es.navas.oposiciones.datosDinamicos.pila;

/**
 * Programa que permite gestionar una pila
 *
 * @author manavas
 * @version 1.0
 */
public class Pila {

    private Nodo raiz;

    /**
     * Constructor por defecto de pila, inicializa la raíz a null
     */
    Pila() {
        raiz = null;
    }

    /**
     * Método que inserta un nodo por la raíz
     *
     * @param x Caracter que almacena el símbolo
     */
    public void insertar(char x) {
        Nodo nuevo = new Nodo(x); //Creamos el nuevo nodo
        nuevo.simbolo = x; //y le asignamos el valor
        //Si la lista está vacía el nodo nuevo tendrá como enlace null
        if (raiz == null) {
            nuevo.enlace = null;
            raiz = nuevo;
        } else //sino tendrá como enlace el nodo al que apuntaba la raíz
        {
            nuevo.enlace = raiz;
            raiz = nuevo;
        }
    }

    /**
     * Método que extrae un nodo por la raíz
     *
     * @return Caracter que había en el nodo raíz
     */
    public char extraer() {
        //Si la pila no está vacía, extraemos la información y cambiamos el enlace raíz
        if (raiz != null) {
            char informacion = raiz.simbolo;
            raiz = raiz.enlace;
            return informacion;
        } else //sino, 
        {
            return Character.MAX_VALUE;
        }
    }

    /**
     * Método que comprueba si la pila está vacía
     *
     * @return Devuelve cierto o falso
     */
    public boolean vacia() {
        if (raiz == null) { //Si la raíz es null, la pila está vacía
            return true;
        } else {
            return false;
        }
    }
}
