package ejemplos.ud01;

import java.io.IOException;
import java.util.Arrays;

public class ProcessSynchronization {

	public static void main(String[] args) {
		
		try {
			Process process = new ProcessBuilder(args).start();
			int retorno = process.waitFor();
			System.out.println("Comando " + Arrays.toString(args) + " devolvió: " + retorno);
		} catch (IOException e) {
			System.out.println("Ocurrió un error ejecutando el comando. Descripción: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("El comando fue interrumpido. Descripción del error: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
	}

}


