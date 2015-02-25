package Aleatorios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hijo {
	
	/*
	 * Exercise: El proceso hijo genera un número aleatorio siempre el padre lo
	 * solicite
	 * 
	 * @author Carlos del Cerro
	 * 
	 * @param path
	 * 
	 * @return número aleatorio entre 0 y 10
	 */

	public static void main(String[] args) throws IOException {

		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			// Mientras que la petición por parte del padre no sea nula
			while ((in.readLine()) != null)
				System.out.println(Math.round(Math.random() * 10));
			// El hijo obtiene saca un número aleatorio entre 0 y 10

		} catch (IOException e) {
			System.out.println("Ha ocurrido un error al ejecutar. Datos del "
					+ "error: " + e.getMessage());
		}
	}
}
