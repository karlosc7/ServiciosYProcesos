package Tarea1_UF2;

//
//@author Carlos del Cerro
//

//Clase de la interfaz runnable para ejecutar mi hilo
class PrimerHilo implements Runnable {

	Thread t; // Declaro un hilo t y la variable que voy a utilizar
	int counter;

	PrimerHilo(int counter) {
		this.counter = counter;
		t = new Thread(this, "Hilo contador");
		t.start();// Arranca "Hilo contador"
	}

	public void run() {
		try {
			System.out.println("Comienzo de la cuenta atr�s:"); // Comienza la
																// cuenta atr�s
			for (int i = counter; i >= 0; i--) {// Recorre el cabezal hasta 0
				System.out.println(i); // Imprime cada n�mero
				Thread.sleep(1000); // Tiempo que tarda en recorrer
			}
			System.out.println("Fin de la cuenta atr�s");// Termina la cuenta
															// atr�s
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class CuentaAtras {
	public static void main(String args[]) {
		new PrimerHilo(10); // La cuenta atr�s empieza en 10
	}
}