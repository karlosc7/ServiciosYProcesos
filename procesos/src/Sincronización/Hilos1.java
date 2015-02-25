package Sincronizaci�n;

//
//@author Carlos del Cerro
//

// Creo la clase donde va mi hilo Hola
class Hola extends Thread {
	public void run() {// C�digo que ejecuta mi hilo 1
		for (int i = 0; i < 10; i++) {
			System.out.println("Hola " + i);
			yield();
		}
	}
}

// Creo la clase donde va mi hilo Adi�s
class Adios extends Thread {
	public void run() {// C�digo que ejecuta mi hilo 2
		for (int i = 0; i < 10; i++) {
			System.out.println("Adi�s " + i);
			yield();
		}
	}
}

public class Hilos1 {
	public static void main(String[] args) {
		new Hola().start();// Arranca el hilo 1 para ejecutarse
		new Adios().start();// Arranca el hilo 2 para ejecutarse
	}

	// Pruebo a ejecutar con el m�todo yield y el resultado que veo es el mismo,
	// no veo ning�n cambio. Al buscar informaci�n sobre el m�todo yield veo que
	// pone que rara vez se usa y que es complicado obtener el efecto que desea
	// el programador y que lo que hace es que el hilo ceda su uso del
	// procesador.
	// Soluci�n sin el m�todo yield();
	// Hola 0
	// Hola 1
	// Hola 2
	// Hola 3
	// Hola 4
	// Hola 5
	// Hola 6
	// Hola 7
	// Hola 8
	// Hola 9
	// Adi�s 0
	// Adi�s 1
	// Adi�s 2
	// Adi�s 3
	// Adi�s 4
	// Adi�s 5
	// Adi�s 6
	// Adi�s 7
	// Adi�s 8
	// Adi�s 9
}