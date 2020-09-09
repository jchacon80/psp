package ejemplos.ud01;

import java.io.IOException;
import java.util.Arrays;

public class RunProcess {

	public static void main(String[] args) {
		//se comprueba si recibe un parámetro que indique el programa a ejecutar
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}
		
		//se crea el proceso y se inicia capturando las dos excepciones necesarias
		ProcessBuilder pb = new ProcessBuilder(args);	 
		try {
			Process process = pb.start();
			int retorno = process.waitFor();
			System.out.println("La ejecución de " + Arrays.toString(args) + " devuelve " + retorno);
		} catch (IOException ex) {
			System.err.println("Excepción de E/S");
			System.exit(-1);
		} catch (InterruptedException ex) {
			System.err.println("El proceso hijo finalizó de forma incorrecta");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}
	} 
}


