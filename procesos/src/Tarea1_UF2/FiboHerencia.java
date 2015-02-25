package Tarea1_UF2;

//
// @author Carlos del Cerro
//

//Creo la clase donde va mi hilo
class Fibo2 extends Thread {
	int numeros;

	public Fibo2(int numeros) {
		this.numeros = numeros;
	}

	public void run() {// C�digo que va a ejecutar el hilo

		// Algoritmo de la serie de Fibonacci
		System.out.println("Los " + numeros + " primeros t�rminos de "
				+ "la serie de Fibonacci son: ");

		// Creamos 2 variables para ir a�adiendo n�meros a la serie
		int number1 = 1;
		int number2 = 1;

		// Imprime el primer n�mero de la serie que es 1
		// y Recorre los dem�s n�meros mediante un for
		System.out.print(number1 + " ");

		for (int i = 2; i <= numeros; i++) {
			System.out.print(number2 + " ");
			number2 = number1 + number2;
			number1 = number2 - number1;
		}

		// Salto de l�nea
		System.out.println();
	}
}

public class FiboHerencia {
	public static void main(String args[]) throws InterruptedException {
		Thread Hilo1 = new Fibo2(10);// Crea el hilo a ejecutar
		Hilo1.start();// Arranca el hilo para ejecutar Fibonacci
	}
}