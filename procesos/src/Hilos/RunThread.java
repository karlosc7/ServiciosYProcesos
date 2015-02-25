package Hilos;

class HelloThread implements Runnable {

	Thread t;

	HelloThread() {
		t = new Thread(this, "Nuevo Thread");
		System.out.println("Creado hilo: " + t);
		t.start();
		// Arranca el nuevo hilo de ejecuci�n. Ejecuta run
	}

	public void run() {
		// C�digo a ejecutar por el hilo
		System.out.println("Hola desde el hilo creado!");
		System.out.println("Hilo finalizando.");
	}
}

public class RunThread {
	public static void main(String args[]) {
		new HelloThread();
		// Crea un nuevo hilo de ejecuci�n
		System.out.println("Hola desde el hilo principal!");
		System.out.println("Proceso acabando.");
	}
}