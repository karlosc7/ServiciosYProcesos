package Sincronización;

//
//@author Carlos del Cerro
//

//Creo la clase de mi hilo Historial
class Historial {
	String[] mensajes = new String[100];
	byte pos = 0;

	public void agregar(String msg) {
		mensajes[pos++] = msg;
	}

	public void mostrar() {
		for (int i = 0; i < mensajes.length; i++)
			System.out.println("Posición " + i + " tiene: " + mensajes[i]);
	}
}

// Creo la clase donde va mi hilo Habla
class Habla extends Thread {
	String mensaje;
	Historial historial;

	public Habla(String msg, Historial h) {
		mensaje = msg;
		historial = h;
	}

	public void run() {
		for (int i = 0; i < 50; i++) {
			historial.agregar(mensaje);
			// Método yield();
			// Este método cede el uso que tiene el hilo en el procesador y hace
			// que los msjes de Hola y Adiós se intercalen al contrario que sin
			// el uso de este método que primero muestra por pantalla los
			// "Holas" y luego los "Adiós" (mitad y mitad).
			yield();
		}
	}
}

public class Hilos3 {
	public static void main(String[] args) {
		Historial historial = new Historial();
		new Habla("Hola", historial).start();// Arranca el hilo para
												// ejecutarse
		new Habla("Adiós", historial).start();// Arranca el hilo para
												// ejecutarse
		try {
			Thread.sleep(2000); // Suspensión del hilo (ms)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		historial.mostrar(); // Muestra el historial
	}
}