package Tarea1_UF2;

//
//@author Carlos del Cerro
//

class HiloInfinito extends Thread {
	public void run() {
		int i = 1;// variable de inicio en 1

		while (true) {// mientras tanto va sumando seconds
			System.out.println(i++);
		}
	}
}

public class Descontrolado {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) throws InterruptedException {
		Thread miHilo = new HiloInfinito();
		System.out.println("Comienzo del contador descontrolado:");
		miHilo.start();// Crea y Arranca el hilo para ejecutar el contador
		Thread.sleep(1000); // Tiempo de ejecución
		miHilo.stop();
		System.out.println("Fin del contador descontrolado");// Muestra fin por
																// pantalla
	}
}
