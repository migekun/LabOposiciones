package es.navas.oposiciones.orientadoObjetos.barco;

public class Principal {

	public static void main(String[] args) {
		Barco pasajeros = new BarcoPasajeros(20, 100);
		pasajeros.mensajeSocorro("Pasajeros salten al agua");
		
		Barco pesquero = new Pesquero(20, 200, 15);
		pesquero.mensajeSocorro("Coged las cañas de pescar");
		
		Barco portaaviones = new Portaaviones(50, 250);
		portaaviones.mensajeSocorro("Salvad los aviones");
		

	}

}
