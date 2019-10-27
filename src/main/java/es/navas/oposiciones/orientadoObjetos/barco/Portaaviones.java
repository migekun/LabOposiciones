package es.navas.oposiciones.orientadoObjetos.barco;

public class Portaaviones extends Barco {

	private int numeroAviones;
	private int numeroMarinos; 
	
	/**
	 * @param numeroAviones
	 * @param numeroMarinos
	 */
	public Portaaviones(int numeroAviones, int numeroMarinos) {
		super();
		this.numeroAviones = numeroAviones;
		this.numeroMarinos = numeroMarinos;
		System.out.println("Se ha creado un portaavines con capacidad para " 
				+ this.numeroAviones + " aviones y " + this.numeroMarinos + " marinos.");
	}

	@Override
	String alarma() {
		return "Alarma desde un portaaviones";
	}


}
