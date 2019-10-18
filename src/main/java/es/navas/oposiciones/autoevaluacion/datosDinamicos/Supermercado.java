package es.navas.oposiciones.autoevaluacion.datosDinamicos;

import java.util.Random;

/**
 * 
 * @author manavas
 * Para esta solucion he elegido una estrucutra dinamica en forma de cola, basicamente
 * porque el enunciado me ha parecido mas optimo para ello, tenemo que insertar productos 
 * y sacarlos en en mismo orden de insercion.
 */
public class Supermercado {

	public static void main(String[] a) {
		// generar de 1 a 10 productos aleatorios
		// generar los datos de esos productos aletoriamente: cantidad, precio, nombre1, nombre2, etc.
		// extraer todos los productos, pintarlos y hacer la suma
		Random random = new Random();
		int numeroProductos = random.nextInt(9) + 1; //avoid cero
		System.out.println("Productos aleatorios: " + numeroProductos);
		ColaTicket ticket = new ColaTicket();
		System.out.println("Inserto productos");
		for (int i = 0; i<numeroProductos; i++) {
			Producto producto = new Producto();
			producto.setCantidad(random.nextInt(4) + 1); //avoid cero
			producto.setPrecio(random.nextInt(99) + 1); // avoid cero
			producto.setNombre("Producto" + (i+1));
			ticket.insertar(producto);
//			System.out.println(producto.toString());
		}
		
		System.out.println("Producto \t Cantidad \t Precio \t Total");
		int precioFinal = 0;
		while(!ticket.colaVacia()) {
			try {
				Producto extraer = ticket.extraer();
				int subTotal = extraer.getCantidad() * extraer.getPrecio();
				precioFinal += subTotal;
				System.out.println(extraer.getNombre() + " \t " + extraer.getCantidad() + " \t \t "+ extraer.getPrecio() + " \t  \t " + subTotal);
			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
		}
		System.out.println("Precio final \t  \t  \t \t  \t " + precioFinal);
			
	}
	
}
