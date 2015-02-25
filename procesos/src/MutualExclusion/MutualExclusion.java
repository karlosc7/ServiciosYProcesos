package MutualExclusion;

//Creo una clase con las variables globales
class GlobalVar {
	// Inicializaci�n de las variables en 0
	public static int c1 = 0;
	public static int c2 = 0;
}

// Creo la clase con mis dos hilos
class TwoMutex extends Thread {
	private Object mutex1 = new Object();
	private Object mutex2 = new Object();

	// Creo los m�todos sincronizados que construyen de forma sencilla con java
	// una secci�n cr�tica para cada hilo mutex.
	public void inc1() {
		synchronized (mutex1) {
			// Variable global con incremento
			GlobalVar.c1++;
		}
	}

	public void inc2() {
		synchronized (mutex2) {
			// Variable global con incremento
			GlobalVar.c2++;
		}
	}

	// Ejecuto los threads
	public void run() {
		inc1();
		inc2();
	}
}

// Creo la clase Mutual
public class MutualExclusion {

	// Creo la clase principal con las excepciones
	public static void main(String[] args) throws InterruptedException {
		int N = 0;
		try {
			// Tenemos que pasar por args un n�mero entero
			N = Integer.parseInt(args[0]);
		} catch (Exception e) {
			System.err
					.println("Debes poner un n�mero como argumento antes de ejecutar");
			System.exit(-1);
		}
		// Array de hilos
		TwoMutex hilos[];
		// Muestra los hilos que se crean
		System.out.println("Creando " + N + " hilos");
		hilos = new TwoMutex[N];
		// Recorre los hilos y se ejecutan
		for (int i = 0; i < N; i++) {
			hilos[i] = new TwoMutex();
			hilos[i].start();
		}
		// Interrupci�n join para cada hilo
		for (int i = 0; i < N; i++) {
			// Espera por t�rmino de la ejecuci�n run() por el m�todo join()
			hilos[i].join();
		}

		// Muestra por pantalla el incremento que se produce por la ejecuci�n de
		// los threads
		System.out.println("C1 = " + GlobalVar.c1);
		System.out.println("C2 = " + GlobalVar.c2);
	}
}
