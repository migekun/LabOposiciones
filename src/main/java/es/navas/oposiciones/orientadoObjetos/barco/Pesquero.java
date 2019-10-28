package es.navas.oposiciones.orientadoObjetos.barco;

/**
 * @author manavas
 */
public class Pesquero extends Barco {
	private int metrosEslora;
	private int potencia;
	private int pescadores;
	
	/**
	 * @param metrosEslora
	 * @param potencia
	 * @param pescadores
	 */
	public Pesquero(int metrosEslora, int potencia, int pescadores) {
		super();
		this.metrosEslora = metrosEslora;
		this.potencia = potencia;
		this.pescadores = pescadores;
		System.out.println("Se ha creado un barco pesqueto con " 
				+ this.metrosEslora + " metros de eslora, una potencia de " + this.potencia 
				+ " cv y con espacio para " + this.pescadores+" pescadores.");
	}

	@Override
	String alarma() {
		return "Alarma desde un barco de pescadores";
	}

}
