package es.navas.oposiciones.datosDinamicos.listaEnlazada;

/**
 * Implementa	 un	 programa	 que	 permita	 almacenar	 en	 una	 lista	 enlazada	 un	 número	
 * aleatorio	de	elementos	enteros	de	entre	-99	y	99.
 * El	programa	incluirá	los	siguientes	métodos:
 * - Obtener	el	primer	elemento.
 * - Obtener	el	último	elemento.
 * - Insertar	por	el	principio.
 * - Insertar	por	el	final.
 * - Inserción	en	una	posición	dada.
 * - Buscar	un	elemento	en	la	lista	dado	su	valor.
 * - Buscar	un	elemento	en	la	lista	dada	su	posición.
 * - Eliminar	un	elemento	en	la	lista	dado	su	valor.
 * - Eliminar	un	elemento	en	la	lista	dada	su	posición.
 * - Visualizar	la	lista	completa.
 * 
 * @author manavas
 *
 */
public class ListaEnlazada {

	private Nodo primero;
	
	public ListaEnlazada() {
		this.primero = null;
	}

	public Nodo getPrimero() {
		return primero;
	}
	
	public Nodo getUltimo() {
		Nodo nodo = primero;
		if (primero != null) {
			
			Nodo aux = primero.enlace;
		
			while (aux != null) {
				nodo = nodo.enlace;
				aux = aux.enlace;
			}
		}
		return nodo;
	}

	public ListaEnlazada insertaUltimoLista(int entrada) {
		Nodo nuevo = new Nodo(entrada);
		Nodo ultimo = getUltimo();
		ultimo.enlace = nuevo;
		ultimo = ultimo.enlace;
		return this;
		
	}
	
	public ListaEnlazada insertaCabezaLista(int entrada){
		Nodo nuevo = new Nodo(entrada);
		nuevo.enlace = primero;
		primero = nuevo;
		return this;
	}
	
	public Nodo buscarLista(int destino) {
		Nodo indice;
		for (indice = primero; indice != null; indice = indice.enlace) {
			if (destino == indice.dato) return indice;
		}
		return null;
	}
	
	public Nodo buscarPosicion(int posicion) {
		Nodo indice;
		int i;
		if (posicion < 0) return null;
		indice = primero;
		
		for (i = 1; i < posicion && (indice != null); i++) {
			indice = indice.enlace;
		}
		return indice;
	}
	
	
    public ListaEnlazada insertarCentro(int posicion, int entrada) {
        //Creamos el nodo que contendrá el valor recibido
        Nodo nuevo = new Nodo(entrada);

        //Si insertamos en primer lugar, el nuevo nodo será el primero 
        if (posicion == 0) {
            insertaCabezaLista(entrada);
        } else {
            //En primer lugar buscamos el nodo a partir del que irá el nuevo elemento
            Nodo anterior = buscarPosicion(posicion);
            //Al elemento anterior le asignamos como enlace el nuevo, y al nuevo como enlace el enlace del anterior
            nuevo.enlace = anterior.enlace;
            anterior.enlace = nuevo;
        }
        return this;
    }

    
    public void visualizar() {
        Nodo n; //Se utiliza para recorrer la lista
        int k = 0; //Contendrá una variable que va avanzando del 0 al 15

        n = primero;
        while (n != null) {
            //Muestra el número entero del elemento
            System.out.print(n.dato + "  ");
            n = n.enlace;
            k++;
            System.out.print((k % 10 != 0 ? " " : "\n"));
        }
        System.out.println("");
    }
    
    public void eliminarLista(int entrada) {
    	Nodo actual, anterior;
    	boolean encontrado = false;
    	actual = primero;
    	anterior = null;
    	
    	while ( actual != null && !encontrado) {
    		encontrado =  (actual.dato == entrada);
    		if (!encontrado) {
    			anterior = actual;
    			actual = actual.enlace;
    		}
    	}	
    	if (actual != null) {
    		if (actual == primero) {
    			primero = actual.enlace;
    		} else {
    			anterior.enlace = actual.enlace;
    		}
    		actual = null;
    	}
    }
    
    public void eliminarPosicion(int posicion) {
    	Nodo actual, anterior;
    	int aux = 0;
    	actual = primero;
    	anterior = null;
    	while (aux < posicion - 1 && actual != null) {
    		anterior = actual;
			actual = actual.enlace;
			aux++;
    	}
    	if (actual != null) {
    		if (actual == primero) {
    			primero = actual.enlace;
    		} else {
    			anterior.enlace = actual.enlace;
    		}
    		actual = null;
    	}
    }
	
}
