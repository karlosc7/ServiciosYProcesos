package Prioridades;

//
//@author Carlos del Cerro
//

//Creo la clase donde va mi hilo
class Letras extends Thread {
	String name;

	public Letras(String name) {
		super();
		this.name = name;
	}

	public void run() { // c�digo que va a ejcutar mi hilo

		// Imprimir diez letras por pantalla
		char[] letra;
		letra = new char[9];
		for (int i = 0; i < 9; i++) {
			letra[i] = (char) ('a' + i);
			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(letra);
			}
		}

		// Imprimir diez n�meros por pantalla
		int[] numeros;
		numeros = new int[9];
		for (int i = 0; i < 9; i++) {

			try {
				sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println(numeros);
			}
		}
	}

}

public class Orden {
	public void main(String[] args) {
		Letras thread1 = new Letras("thread1");
		thread1.setPriority(1); // M�n. Priority
		Letras thread2 = new Letras("thread2");
		thread2.setPriority(10); // M�x. Priority Second Thread
		thread1.start();// Arranca el hilo de las letras
		thread2.start();// Arranca el hilo de los n�meros
	}
}
