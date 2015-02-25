package Sincronización;

//
//@author Carlos del Cerro
//

//Creo la clase donde va mi hilo Habla
class Hablas extends Thread {
	String mensaje;

	public Hablas(String msg) {
		mensaje = msg;
	}

	public void run() {// Código que ejecuta mi hilo 1
		for (int i = 0; i < 10; i++) {
			System.out.println(mensaje + " " + i);
			// Método yield
			yield();
		}
	}
}

// En este ejercicio sí que he podido ver la cesión del uso del procesador al
// ejecutar.
// Ejecución sin el método yield();
// Hola 0
// Adiós 0
// Hola 1
// Adiós 1
// Hola 2
// Adiós 2
// Hola 3
// Adiós 3
// Hola 4
// Hola 5
// Hola 6
// Hola 7
// Hola 8
// Hola 9
// Adiós 4
// Adiós 5
// Adiós 6
// Adiós 7
// Adiós 8
// Adiós 9

// Ejecución con el método yield();
// Adiós 0
// Hola 0
// Adiós 1
// Hola 1
// Hola 2
// Hola 3
// Hola 4
// Adiós 2
// Adiós 3
// Adiós 4
// Hola 5
// Adiós 5
// Hola 6
// Adiós 6
// Hola 7
// Adiós 7
// Hola 8
// Adiós 8
// Hola 9
// Adiós 9

public class Hilos2 {
	public static void main(String[] args) {
		new Hablas("Hola").start();// Arranca el hilo 1 para ejecutarse
		new Hablas("Adiós").start();// Arranca el hilo 1 para ejecutarse
	}
}
