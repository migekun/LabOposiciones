package es.navas.oposiciones.orientadoObjetos.barco;

public class BarcoPasajeros extends Barco {

	private int metrosEslora;
	private int numeroCamas;

	/**
	 * @param metrosEslora
	 * @param numeroCamas
	 */
	public BarcoPasajeros(int metrosEslora, int numeroCamas) {
		super();
		this.metrosEslora = metrosEslora;
		this.numeroCamas = numeroCamas;
		System.out.println("Se ha creado un barco de pasajeros con " 
		+ this.metrosEslora + " metros de eslora y " + this.numeroCamas + " camas.");
	}

	@Override 
	String alarma() {
		return "Alarma desde un barco de pasajeros";
	}
	
}
