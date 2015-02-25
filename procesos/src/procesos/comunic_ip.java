package procesos;

import java.io.*;

public class comunic_ip {

	public static void main(String[ ] args) {
	Runtime runTime= Runtime.getRuntime();
	Process process=null;
	try {
	process = runTime.exec("ping " + args[0]);
	//Metemos como argumento una dirección IP (verdaderas o 
	//falsas para ver lo que devuelve en cada momento)
	BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
	for (int i=0; i< 10; i++)
	System.out.println("Saludo " + in.readLine());
	//Si la dirección introducida es adecuada imprime "Saludo 10 veces" (mientras muestra el ping)
	} catch (IOException e) {
	System.out.println("No pudimos correr el ping");
	System.exit(-1);
	}
	//Si no se puede correr el ping porque es erróneo mostramos esto por pantalla
	if (process!=null)
	process.destroy();
	//Si no introducimos nada o
	//Si introducimos una dirección que no existe se muestra "null"
	try {
	process.waitFor();
	} catch( InterruptedException e ) {
	System.out.println("No pudimos esperar por término");
	System.exit(-1);
	//No se pudo esperar
	}
	System.out.println("Estatus de término: "+process.exitValue());
	System.exit(0);
	//El programa queda abierto al no poderse ejecutar el arg. 
	//El valor estándar que se da a Estatus de término es = 1
	}
}
