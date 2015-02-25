package May�sculas;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class May�sculas {
	public static void main(String[] args) throws IOException {

		/*
		 * Exercise: El proceso padre leer� l�neas de su entrada est�ndar y las
		 * enviar� a la entrada est�ndar del hijo (utilizando el OutputStream
		 * del hijo). El padre imprimir� en pantalla lo que recibe del hijo a
		 * trav�s del InputStream del mismo.
		 * 
		 * @author Carlos del Cerro
		 * 
		 * @param path
		 * 
		 * @return InputStream del hijo (May�sculas)
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
				// IMP: Comprueba env�o de datos
				if ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			}
			System.out.println("Finalizando");
		} catch (IOException e) {
			System.out
					.println("Error ocurri� durante la ejecuci�n. Descripci�n del error: "
							+ e.getMessage());
		}
	}
}