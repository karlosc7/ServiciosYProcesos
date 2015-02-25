package procesos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Comunic_procesos {

	public static void main(String args[]) throws IOException {
		try {
			Process process = new ProcessBuilder(args).start();
			InputStream is = process.getInputStream();
			// Incluir el parámetro “UTF-8” dentro del ImputStreamReader.
			BufferedReader br = new BufferedReader(new InputStreamReader(is,
					"UTF-8"));
			String line;
			System.out.println("Salida del proceso " + Arrays.toString(args)
					+ ":");
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			// Se cierra el descriptor de salida del hijo al terminar
			is.close();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al ejecutar. Datos del "
					+ "error: " + e.getMessage());
		}
	}
}
