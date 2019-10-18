package es.navas.oposiciones.autoevaluacion.datosDinamicos;


public class ColaTicket {

	protected Nodo frente;
    protected Nodo fin;

    /**
     * Constructor: crea la cola vacía
     */
    public ColaTicket() {
        frente = fin = null;
    }

    /**
     * Inserta un elemento en la cola por el final
     *
     * @elemento Objeto a insertar
     */
    public void insertar(Producto producto) {
        Nodo a;
        a = new Nodo(producto);
        if (colaVacia()) {
            frente = a;
        } else {
            fin.siguiente = a;
        }
        fin = a;
    }

    /**
     * Método que extrae un elemento de la cola por el frente
     *
     * @return Objeto extraido
     */
    public Producto extraer() throws Exception {
    	Producto aux;
        if (!colaVacia()) {
            aux = frente.elemento;
            frente = frente.siguiente;
        } else {
            throw new Exception("Eliminar de una cola vacía");
        }
        return aux;
    }

    /**
     * Método que permite acceder al primer elemento de la cola
     *
     * @return Objeto del frente de la cola
     */
    public Producto frenteCola() throws Exception {
        if (colaVacia()) {
            throw new Exception("Error: cola vacía");
        }
        return (frente.elemento);
    }

    /**
     * Método que permite comprobar si la cola está vacía
     *
     * @return Devuelve un valor true o false
     */
    public boolean colaVacia() {
        return (frente == null);
    }
}
