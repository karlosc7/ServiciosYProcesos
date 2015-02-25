package Sincronizaci�n;

//
//@author Carlos del Cerro
//

//Creo la clase donde va mi hilo Habla
class Hablas extends Thread {
	String mensaje;

	public Hablas(String msg) {
		mensaje = msg;
	}

	public void run() {// C�digo que ejecuta mi hilo 1
		for (int i = 0; i < 10; i++) {
			System.out.println(mensaje + " " + i);
			// M�todo yield
			yield();
		}
	}
}

// En este ejercicio s� que he podido ver la cesi�n del uso del procesador al
// ejecutar.
// Ejecuci�n sin el m�todo yield();
// Hola 0
// Adi�s 0
// Hola 1
// Adi�s 1
// Hola 2
// Adi�s 2
// Hola 3
// Adi�s 3
// Hola 4
// Hola 5
// Hola 6
// Hola 7
// Hola 8
// Hola 9
// Adi�s 4
// Adi�s 5
// Adi�s 6
// Adi�s 7
// Adi�s 8
// Adi�s 9

// Ejecuci�n con el m�todo yield();
// Adi�s 0
// Hola 0
// Adi�s 1
// Hola 1
// Hola 2
// Hola 3
// Hola 4
// Adi�s 2
// Adi�s 3
// Adi�s 4
// Hola 5
// Adi�s 5
// Hola 6
// Adi�s 6
// Hola 7
// Adi�s 7
// Hola 8
// Adi�s 8
// Hola 9
// Adi�s 9

public class Hilos2 {
	public static void main(String[] args) {
		new Hablas("Hola").start();// Arranca el hilo 1 para ejecutarse
		new Hablas("Adi�s").start();// Arranca el hilo 1 para ejecutarse
	}
}
