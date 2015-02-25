package MutualExclusion;

public class Parking1 {

	private static final int C = 0;
	private static Barrera barrera;

	// Clase principal Párking
	@SuppressWarnings("null")
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		int N = Integer.parseInt(args[0]); // Inicializar el párking con la
		Coche[] coches = null;
		// entrada de coches
		for (int i = 0; i < C; i++) {
			coches[i] = new Coche(i + 1, barrera);
			// Inicio de entrada de coches
			coches[i].start();
		}
		// Excepción del hilo principal, espera por término con el método join
		try {
			for (int i = 0; i < C; i++) {
				coches[i].join();
			}
		} catch (InterruptedException ex) {
			// Salida por pantalla de la interrupción
			System.out.println("Hilo principal interrumpido.");
		}
		// El programa Parking se cierra
		System.out.println("Fin del programa de parking");
	}
}
