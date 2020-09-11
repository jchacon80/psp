package ejemplos.ud01;

import java.io.IOException;
import java.util.Arrays;

public class ProcessSynchronization {

	public static void main(String[] args) {
		
		try {
			Process process = new ProcessBuilder(args).start();
			int retorno = process.waitFor();
			System.out.println("Comando " + Arrays.toString(args) + " devolvi�: " + retorno);
		} catch (IOException e) {
			System.out.println("Ocurri� un error ejecutando el comando. Descripci�n: " + e.getMessage());
		} catch (InterruptedException e) {
			System.out.println("El comando fue interrumpido. Descripci�n del error: " + e.getMessage());
			Thread.currentThread().interrupt();
		}
	}

}


