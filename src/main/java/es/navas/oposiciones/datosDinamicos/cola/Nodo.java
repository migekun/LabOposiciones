package es.navas.oposiciones.datosDinamicos.cola;

/**
 * Clase Nodo que contiene un dato de tipo entero y el enlace al siguiente
 *
 * @author manavas
 * @version 1.0
 */
public class Nodo      
{            
  Object elemento;    
  Nodo siguiente;

  public Nodo(Object x)
  {
    elemento = x;
    siguiente = null;
  }
}   