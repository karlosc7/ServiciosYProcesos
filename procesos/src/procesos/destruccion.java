package procesos;

import java.io.IOException;

public class destruccion {

	public static void main(String[] args) {
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(args);
			process.destroy(); //Destroyer the archive
		} catch (IOException ex) {
			System.err.println("Excepci�n de E/S!!");
			System.exit(-1);
		}
	}
}