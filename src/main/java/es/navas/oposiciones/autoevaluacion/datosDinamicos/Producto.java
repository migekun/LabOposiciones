package es.navas.oposiciones.autoevaluacion.datosDinamicos;

public class Producto {
	private int cantidad;
	private int precio; 
	private String nombre;
	
	public Producto() {
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Producto [cantidad=" + cantidad + ", precio=" + precio + ", nombre=" + nombre + "]";
	}
	
	
	
}
