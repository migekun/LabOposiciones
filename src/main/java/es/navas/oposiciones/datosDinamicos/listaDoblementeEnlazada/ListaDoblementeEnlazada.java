package es.navas.oposiciones.datosDinamicos.listaDoblementeEnlazada;

/**
 * Programa que crea la lista, inserta enteros aleatorios y los visualiza.
 *
 */
public class ListaDoblementeEnlazada {

    private Nodo primero;

    public ListaDoblementeEnlazada() {
        primero = null;
    }

    /**
     * Método que inserta un caracter en la lista
     *
     * @param c Valor a almacenar en el nodo
     */
    public void insertarFinal(char c) {
        if (estaVacio()) {
            primero = new Nodo(c);
        } else{
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }            
            Nodo nuevo = new Nodo(c);
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
    }

    /**
     * Permite eliminar un nodo de la lista
     *
     * @return Devuelve la cadena del nodo borrado
     */
    public char borrarFinal() throws Exception {
        char carBorrar;

        if (estaVacio()) {
            throw new Exception();
        }
        //Se posiciona al principio
        carBorrar = primero.caracter;
        //Si solo hay un nodo deja primero a null
        if (primero == primero.siguiente) {
            primero = null;
        } else {//Si hay más de un nodo
            Nodo actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.anterior.siguiente = null;
        }
        //Devuelve la cadena del nodo borrado
        return carBorrar;
    }

    /**
     * Comprueba si la lista está vacía
     *
     * @return True o false si está vacía o no
     */
    public boolean estaVacio() {
        return primero == null;
    }

    /**
     * Imprime los valores de los nodos de la lista
     *
     */
    public void imprimir() {
        if (estaVacio()) {
            System.out.println("Lista vacía");
        } else {
            Nodo actual = primero;
            do {
                System.out.print(actual.caracter + " ");
                actual = actual.siguiente;
            } while (actual != null);
        }
        System.out.println("\n");
    }

    
    /**
     * Permite contar el número de caracteres de un tipo de la lista
     *
     * @param letra Letra que debe ser pasada por parámetro
     * @return número de veces que se repite la letra
     */
    public int contarLetras(char letra) {
        int cont = 0;
        if (estaVacio()) {
            System.out.println("Lista vacía");
        } else {
            Nodo actual = primero;
            do {
                //No tenemos en cuenta si ha introducido los valores en minúscula
                if (actual.caracter==letra) cont++;
                
                actual = actual.siguiente;
            } while (actual != null);
        }
        return cont;
    }

    /**
     * Permite mostrar el caracter de una posición
     *
     * @param posicion Posición donde se encuentra un caracter a buscar
     * @return Caracter buscado
     */
    public char caracterPosicion(int posicion) {
        int i = 0;
        Nodo actual = primero;
        while (i<posicion && actual!=null){
            actual = actual.siguiente;
            i++;
        }
        return actual.caracter;
    }
}
