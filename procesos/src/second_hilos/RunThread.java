package second_hilos;

class HelloThread extends Thread {
	public void run() {
		// C�digo a ejecutar por el hilo
		System.out.println("Hola desde el hilo creado!");
	}
}

public class RunThread {
	public static void main(String args[]) {
		new HelloThread().start();// Crea y arranca un nuevo hilo de ejecuci�n
		System.out.println("Hola desde el hilo principal!");
		System.out.println("Proceso acabando.");
	}
}