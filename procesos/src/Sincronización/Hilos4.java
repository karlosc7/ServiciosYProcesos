package Sincronización;

import java.util.concurrent.Semaphore;

public class Hilos4 {

	//
	// @author Carlos del Cerro
	//

	// Creo la clase donde va mi hilo
	class Letras extends Thread {
		private Semaphore semaphore;
		String name;

		public Letras(String name) {
			super();
			this.name = name;
		}

		public void run() { // código que va a ejcutar mi hilo

			// Imprimir diez letras por pantalla
			char[] letra;
			letra = new char[9];
			for (int i = 0; i < 9; i++) {
				letra[i] = (char) ('a' + i);
				try {
					semaphore.acquire();// Adquiero el método semaphore para
										// mostrar las letras
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println(letra);
				}
				semaphore.release();// Desbloquea la espera del hilo
			}

			// Imprimir diez números por pantalla
			int[] numeros;
			numeros = new int[9];
			for (int i = 0; i < 9; i++) {

				try {
					semaphore.acquire();// Adquiero el método semaphore para
										// mostrar las letras
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println(numeros);
				}
				semaphore.release(); // Desbloquea la espera del hilo
			}
		}

	}

	public class Orden {
		public void main(String[] args) {
			Letras thread1 = new Letras("thread1");
			adquire();
			Letras thread2 = new Letras("thread2");
			thread1.start();// Arranca el hilo de las letras
			thread2.start();// Arranca el hilo de los números
		}

		private void adquire() {
			// TODO Auto-generated method stub

		}
	}

}
