package es.navas.oposiciones.basico;

public class TorresHanoi {

	/**
	 * Take an example for 2 disks :
		Let rod 1 = 'A', rod 2 = 'B', rod 3 = 'C'.
		
		Step 1 : Shift first disk from 'A' to 'B'.
		Step 2 : Shift second disk from 'A' to 'C'.
		Step 3 : Shift first disk from 'B' to 'C'.
		
		The pattern here is :
		Shift 'n-1' disks from 'A' to 'B'.
		Shift last disk from 'A' to 'C'.
		Shift 'n-1' disks from 'B' to 'C'.
	 * @param discos
	 */
	public static void myTorresHanoi(int discos, String origen, String auxiliar, String destino) {
		if (discos == 1) {
			System.out.println("movemos disco: " + discos + " de torre origen: " +origen + " a torre destino: " + destino);
			return;
		}
		myTorresHanoi(discos-1, origen, destino, auxiliar);
		System.out.println("moviendo discos: " + discos + " origen: " + origen + " auxiliar: " + auxiliar + " destino: " + destino);
		myTorresHanoi(discos-1, auxiliar, origen, destino);
	}
}
