package Prioridades;

//
//@author Carlos del Cerro
//

//Creo la clase donde va mi hilo
class CounterThread extends Thread {
	String name;

	public CounterThread(String name) {
		super();
		this.name = name;
	}

	public void run() {// Código que va a ejecutar el hilo
		int count = 0;
		while (true) {
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// Cuando el contador llegue a mil, volverá a 0
			if (count == 1000)
				count = 0;

			System.out.println(name + ":" + count++);// Salto de línea
														// aumentando en uno el
														// contador
		}
	}
}

// 1. ¿El cambio está afectando significativamente al resultado?,
// Yo he ejecutado el programa cambiando la prioridad y no veo cambios
// significativos en el resultado.
// 2. ¿A qué se debe ese comportamiento?
// Depende de nuestro procesador y los núcleos que tenga, así será el acceso a
// uno u otro hilo. En mi caso mi procesador intel core i5 tiene dos núcleos.

// Orden de prioridad de los dos threads que se van a ejecutar
public class Prioridad {
	public static void main(String[] args) {
		CounterThread thread1 = new CounterThread("thread1");
		thread1.setPriority(1); // Mín. Priority
		// Cambio de prioridad
		// thread1.setpriority(10)
		CounterThread thread2 = new CounterThread("thread2");
		thread2.setPriority(10); // Máx. Priority
		// Cambio de prioridad
		// thread2.setpriority(1)
		thread2.start();// Arranca el hilo 2 para ejecutarse
		thread1.start();// Arranca el hilo 1 para ejecutarse
	}
}
