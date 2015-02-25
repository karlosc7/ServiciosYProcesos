package Tarea1_UF2;

//Clase de la interfaz runnable para ejecutar mi hilo
class Fibonacci implements Runnable {

	// Declaro un hilo t y la variable que voy a utilizar
	Thread t;
	int number;

	Fibonacci(int numeros) {

		t = new Thread(this, "Hilo Fibonacci");
		t.start();// Arranca "Hilo Fibonacci"
	}

	public void run() {// C�digo que va a ejecutar el hilo

		// Algoritmo de la serie de Fibonacci
		System.out.println("Los " + number + " primeros t�rminos de "
				+ "la serie de Fibonacci son:");

		// Creamos 2 variables para ir a�adiendo n�meros a la serie
		int number1 = 1;
		int number2 = 1;

		// Imprime el primer n�mero de la serie que es 1
		// y recorre los dem�s n�meros mediante un for
		System.out.print(number1 + " ");

		for (int i = 2; i <= number; i++) {
			System.out.print(number2 + " ");
			number2 = number1 + number2;
			number1 = number2 - number1;
		}

		// Salto de l�nea
		System.out.println();
	}
}

public class FiboInterface {
	public static void main(String args[]) {
		new Fibonacci(10);// Crea el hilo a ejecutar
	}
}