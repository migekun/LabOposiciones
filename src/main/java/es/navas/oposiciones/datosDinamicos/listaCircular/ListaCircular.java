package es.navas.oposiciones.datosDinamicos.listaCircular;

public class ListaCircular {

	private Nodo primero;

    /**
     * Constructor de la lista: tiene un Nodo vacío
     *
     */
    public ListaCircular() {
        primero = null;
    }

    /**
     * Devuelve el primer nodo de la lista
     *
     * @return Nodo a devolver
     */
    public Nodo getPrimero() {
        return primero;
    }

    /**
     * Método que devuelve el último nodo de la lista, para lo que la recorre
     * por completo
     *
     * @return Nodo a devolver
     */
    public Nodo getUltimo() {
        Nodo n = primero; //Primer nodo de la lista
        if (primero != null) {
            Nodo aux = primero.enlace; //Segundo nodo de la lista
            while (aux != null) { //Hasta que el nodo auxiliar sea null (y el n sea el último)
                n = n.enlace; //Avanzamos con el nodo n
                aux = aux.enlace; //Avanzamos con el nodo auxiliar
            }
        }
        return n;
    }

    /**
     * Método que inserta un nodo por el final de la lista
     *
     * @param entrada Valor a almacenar en el último nodo
     * @return Devuelve la lista resultante
     */
    public ListaCircular insertarUltimoLista(int entrada) {
        Nodo ultimo = getUltimo();
        ultimo.enlace = new Nodo(entrada);
        ultimo = ultimo.enlace;
        return this;
    }

    /**
     * Permite crear un Nodo e insertarlo por la cabeza de la lista.
     *
     * @param entrada: contiene el entero a insertar en la lista
     * @return Devuelve la lista resultante
     */
    public ListaCircular insertarCabezaLista(int entrada) {
        //Crea un elemento que contiene el entero pasado por parámetro
        Nodo nuevo;
        nuevo = new Nodo(entrada);
        //Al campo enlace le asigna el valor del primer nodo
        nuevo.enlace = primero;
        //El nodo recién insertado pasa a ser el primero
        primero = nuevo;
        //Devuelve la lista
        return this;
    }

    /**
     * Inserta un elemento en una posición indicada
     *
     * @param posicion Posición a partir de la insertar el elemento
     * @param entrada Entero que almacenará el nodo
     * @return Devuelve la lista resultante
     */
    public ListaCircular insertarCentro(int posicion, int entrada) {
        //Creamos el nodo que contendrá el valor recibido
        Nodo nuevo = new Nodo(entrada);

        //Si insertamos en primer lugar, el nuevo nodo será el primero 
        if (posicion == 0) {
            insertarCabezaLista(entrada);
        } else {
            //En primer lugar buscamos el nodo a partir del que irá el nuevo elemento
            Nodo anterior = buscarPosicion(posicion);
            //Al elemento anterior le asignamos como enlace el nuevo, y al nuevo como enlace el enlace del anterior
            nuevo.enlace = anterior.enlace;
            anterior.enlace = nuevo;
        }
        return this;
    }

    /**
     * Método que busca en una lista un elemento y devuelve la referencia al
     * nodo
     *
     * @param destino Contiene el elemento a buscar
     * @return Devuelve el Nodo que contiene el elemento buscado
     */
    public Nodo buscarLista(int destino) {
        Nodo indice; //Se utiliza para recorrer la lista
        //Avanzamos por la lista nodo a nodo
        for (indice = primero; indice != null; indice = indice.enlace) {
            //Si el elemento en que nos encontramos coincide con el parámetro
            if (destino == indice.dato) {
                //Devolvemos el Nodo que contiene el elemento
                return indice;
            }
        }
        //Si no hemos encontrado el Nodo devuelve null
        return null;
    }

    /**
     * Método que busca una posición y devuelve el elemento que se encuentra
     * allí.
     *
     * @param posicion Entero que contiene la posición a buscar
     * @return Nodo situado en la posición buscada
     */
    public Nodo buscarPosicion(int posicion) {
        Nodo indice; //Se utiliza para recorrer la lista
        int i; //Nos permite recorrer cada posición de la lista
        //En caso de que la posición introducida sea un valor negativo
        if (posicion < 0) {
            return null;
        }
        //Tomamos como índice el primer nodo
        indice = primero;
        //Recorremos la lista hasta encontrar la posición o hasta que lleguemos al final
        for (i = 1; i < posicion && (indice != null); i++) {
            //Avanzamos de un nodo al siguiente
            indice = indice.enlace;
        }
        //Devolvemos el nodo encontrado o null si hemos llegado al final
        return indice;
    }

    /**
     * Permite recorrer la lista mostrando la información de cada nodo
     */
    public void visualizar() {
        Nodo n; //Se utiliza para recorrer la lista
        int k = 0; //Contendrá una variable que va avanzando del 0 al 15

        n = primero;
        while (n != null) {
            //Muestra el número entero del elemento
            System.out.print(n.dato + "  ");
            //Avanza en la lista al siguiente nodo
            n = n.enlace;
            //Incrementa la variable k para que se muestren los elementos en filas de 15 
            k++;
            //Muestra un espacio o un salto de línea cada 15 elementos
            System.out.print((k % 15 != 0 ? " " : "\n"));
        }
        System.out.println("");
    }

    /**
     * Permite eliminar un nodo dado el valor que contiene
     *
     * @param entrada Valor que debe contener el nodo a borrar
     */
    public void eliminarLista(int entrada) {
        Nodo actual, anterior;
        boolean encontrado;
        //Inicializa los apuntadores primero y anterior
        actual = primero;
        anterior = null;
        encontrado = false;

        //Recorre la lista hasta encontrar el elemento a buscar, guardando su anterior
        while ((actual != null) && !encontrado) {
            encontrado = (actual.dato == entrada);
            if (!encontrado) {
                anterior = actual;
                actual = actual.enlace;
            }
        }
        //Enlace del nodo anterior con el siguiente
        if (actual != null) {
            //Depende de la posición del nodo a borrar se realiza una u otra operación
            if (actual == primero) {
                primero = actual.enlace; //Modificamos el primer nodo
            } else {
                anterior.enlace = actual.enlace; //Enlazamos el nodo anterior con el siguiente
            }
            actual = null;
        }

    }

    /**
     * Permite eliminar un nodo dada su posición
     *
     * @param posicion Posición del elemento a borrar
     */
    public void eliminarPosicion(int posicion) {
        Nodo actual, anterior;
        int aux = 0;
        //Inicializa los apuntadores primero y anterior
        actual = primero;
        anterior = null;

        //Recorre la lista hasta encontrar la posición a buscar, guardando su anterior
        while ((aux < posicion - 1) && actual != null) {
            anterior = actual;
            actual = actual.enlace;
            aux++;
        }
        //Enlace del nodo anterior con el siguiente
        if (actual != null) {
            //Depende de la posición del nodo a borrar se realiza una u otra operación
            if (actual == primero) {
                primero = actual.enlace;//Modificamos el primer nodo
            } else {
                anterior.enlace = actual.enlace;//Enlazamos el nodo anterior con el siguiente
            }
            actual = null;
        }

    }

	
}
