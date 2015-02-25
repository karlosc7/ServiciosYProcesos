package Sincronización;

//
//@author Carlos del Cerro
//

// Creo la clase donde va mi hilo Hola
class Hola extends Thread {
	public void run() {// Código que ejecuta mi hilo 1
		for (int i = 0; i < 10; i++) {
			System.out.println("Hola " + i);
			yield();
		}
	}
}

// Creo la clase donde va mi hilo Adiós
class Adios extends Thread {
	public void run() {// Código que ejecuta mi hilo 2
		for (int i = 0; i < 10; i++) {
			System.out.println("Adiós " + i);
			yield();
		}
	}
}

public class Hilos1 {
	public static void main(String[] args) {
		new Hola().start();// Arranca el hilo 1 para ejecutarse
		new Adios().start();// Arranca el hilo 2 para ejecutarse
	}

	// Pruebo a ejecutar con el método yield y el resultado que veo es el mismo,
	// no veo ningún cambio. Al buscar información sobre el método yield veo que
	// pone que rara vez se usa y que es complicado obtener el efecto que desea
	// el programador y que lo que hace es que el hilo ceda su uso del
	// procesador.
	// Solución sin el método yield();
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
	// Adiós 0
	// Adiós 1
	// Adiós 2
	// Adiós 3
	// Adiós 4
	// Adiós 5
	// Adiós 6
	// Adiós 7
	// Adiós 8
	// Adiós 9
}