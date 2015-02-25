package Mayúsculas;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mayúsculas {
	public static void main(String[] args) throws IOException {

		/*
		 * Exercise: El proceso padre leerá líneas de su entrada estándar y las
		 * enviará a la entrada estándar del hijo (utilizando el OutputStream
		 * del hijo). El padre imprimirá en pantalla lo que recibe del hijo a
		 * través del InputStream del mismo.
		 * 
		 * @author Carlos del Cerro
		 * 
		 * @param path
		 * 
		 * @return InputStream del hijo (Mayúsculas)
		 */

		String line;
		try {
			Process hijo = new ProcessBuilder("java", "-jar", "Hijo.jar")
					.start();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					hijo.getInputStream()));
			PrintStream ps = new PrintStream(hijo.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in)); // Finaliza la entrada
			while ((line = in.readLine()).compareTo("fin") != 0) {
				ps.println(line);
				ps.flush();
				// IMP: Comprueba envío de datos
				if ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}
			System.out.println("Finalizando");
		} catch (IOException e) {
			System.out
					.println("Error ocurrió durante la ejecución. Descripción del error: "
							+ e.getMessage());
		}
	}
}