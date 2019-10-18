package es.navas.oposiciones.datosDinamicos.listaCircularDoblementeEnlazada;

/**
 * Programa que crea la lista, inserta enteros aleatorios y los visualiza.
 *
 * @author manavas
 * @version 1.0
 */
public class ListaCircularDoblementeEnlazada {

    private Nodo primero;

    /**
     * Constructor de la lista: inicia primero a null
     *
     */
    public ListaCircularDoblementeEnlazada() {
        primero = null;
    }

    /**
     * Método que inserta una ciudad en la lista
     *
     * @param ciudad Valor a almacenar en el nodo
     */
    public void insertar(String ciudad) {
        if (estaVacio()) {
            primero = new Nodo(ciudad);
            primero.siguiente = primero;
            primero.anterior = primero;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != primero) {
                actual = actual.siguiente;
            }
            Nodo ultimoNodo = actual;

            Nodo desplazado = primero;
            primero = new Nodo(ciudad, desplazado, ultimoNodo);
            ultimoNodo.siguiente = primero;

            desplazado.anterior = primero;
        }
    }

    /**
     * Permite eliminar un nodo de la lista
     *
     * @return Devuelve la cadena del nodo borrado
     */
    public String borrar()
            throws Exception {
        Nodo NodoBorrar = primero;
        String cadenaBorrar = null;

        if (estaVacio()) {
            throw new Exception();
        }
        //Se posiciona al principio
        cadenaBorrar = primero.cadena;
        //Si solo hay un nodo deja primero a null
        if (primero == primero.siguiente) {
            primero = null;
        } else {//Si hay más de un nodo
            Nodo actual = primero;
            while (actual.siguiente != primero) {
                actual = actual.siguiente;
            }
            Nodo ultimoNodo = actual;

            primero = primero.siguiente;
            ultimoNodo.siguiente = primero;
            primero.anterior = ultimoNodo;
        }
        //Borra las referencias del nodo a borrar
        NodoBorrar.siguiente = null;
        NodoBorrar.anterior = null;
        //Devuelve la cadena del nodo borrado
        return cadenaBorrar;
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
                System.out.print(actual.cadena.toString() + " ");
                actual = actual.siguiente;
            } while (actual != primero);
        }
        System.out.println("\n");
    }

    /**
     * Imprime los valores de los nodos de la lista en sentido inverso
     *
     */
    public void imprimirReves() {
        if (estaVacio()) {
            System.out.println("Lista vacía");
        } else {

            Nodo actual = primero;

            do {
                actual = actual.anterior;
                System.out.print(actual.getCadena().toString() + " ");
            } while (actual != primero);
        }
        System.out.println("\n");
    }

    /**
     * Permite buscar una ciudad cuya inicial sea la letra pasada por parámetro
     *
     * @param letra Letra que debe ser inicial de la ciudad a buscar
     */
    public void buscarLetra(char letra) {
        System.out.println("Ciudades encontradas con la inicial " + letra + ": ");
        if (estaVacio()) {
            System.out.println("Lista vacía");
        } else {
            Nodo actual = primero;
            do {
                //No tenemos en cuenta si ha introducido los valores en minúscula
                if (actual.cadena.toLowerCase().charAt(0) == Character.toLowerCase(letra)) {
                    System.out.print(actual.cadena.toString() + " ");
                }
                actual = actual.siguiente;
            } while (actual != primero);
        }
        System.out.println("\n");
    }

    /**
     * Permite eliminar un nodo dado el valor que contiene
     *
     * @param entrada Valor que debe contener el nodo a borrar
     */
    public void borrarPorCadena(String entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        //Inicializa los apuntadores primero y anterior
        actual = primero;
        anterior = null;
        encontrado = false;

        //Recorre la lista hasta encontrar el elemento a buscar, guardando su anterior
        while ((actual != null) && !encontrado) {
            System.out.println("b"+actual.cadena);
            encontrado = (actual.cadena.equals(entrada));
            System.out.println("enc"+encontrado);
            if (!encontrado) {
                anterior = actual;
                actual = actual.siguiente;
            }
        }
        //Enlace del nodo anterior con el siguiente
        if (actual != null) {
            //Depende de la posición del nodo a borrar se realiza una u otra operación
            if (actual == primero) {
                actual.anterior.siguiente = primero.siguiente; //Modificamos el enlace siguiente del último
                primero = actual.siguiente; //Modificamos el primer nodo
            } else {
                anterior.siguiente = actual.siguiente; //Enlazamos el nodo anterior con el siguiente
            }
            actual = null;
        }

    }

}
