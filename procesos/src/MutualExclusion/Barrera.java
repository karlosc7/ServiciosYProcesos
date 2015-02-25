package MutualExclusion;

import java.util.Random;

//Clase de creaci�n de plazas
@SuppressWarnings("unused")
public class Barrera {
	private int plazas[];
	private int numplazas;
	private int libres;

	// Creaci�n de la barrera dependiendo de las plazas libres
	Barrera(int N) {
		numplazas = N;
		plazas = new int[N];

		for (int i = 0; i < numplazas; i++) {
			plazas[i] = 0;
		}
		// N�mero total de plazas
		libres = numplazas;
	}

	synchronized public int entrada(int coche) throws InterruptedException {
		int plaza = 0;
		imprimir();

		// Si no hay plazas los coches que vienen se quedan a la espera
		while (libres == 0) {
			System.out.println("Car " + coche + "waited");
			wait();
		}
		// Si hay plazas se aumenta el n�mero de plazas ocupadas
		while (plazas[plaza] != 0) {
			plaza++;
		}
		plazas[plaza] = coche;
		libres--;
		return plaza;
	}

	synchronized public void salida(int plaza) {
		plazas[plaza] = 0;
		libres++;
		// Desbloquea el hilo que est� esperando
		notify();
	}

	public void imprimir() {
		// Muestra por pantalla el n�mero de plazas que hay
		System.out.print("Parking: ");
		for (int i = 0; i < numplazas; i++) {
			System.out.print("[" + plazas[i] + "] ");
		}
		// Salto de l�nea
		System.out.println("");
	}
}
