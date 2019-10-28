package es.navas.oposiciones.orientadoObjetos.barco;

public abstract class Barco {

	abstract String alarma();
	
	protected void mensajeSocorro(String mensaje) {
		System.out.println("[Alarma]: " + alarma() + " [Mensaje]: " + mensaje);
	}
	
}
