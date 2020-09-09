package ejemplos.ud01;

import java.io.IOException;

public class RuntimeProcess {

	public static void main(String[] args) {
		
		//se comprueba si recibe un parámetro que indique el programa a ejecutar
		if (args.length <= 0) {
			System.err.println("Se necesita un programa a ejecutar");
			System.exit(-1);
		}

		//se crea el proceso y posteriormente se destruye
		Runtime runtime = Runtime.getRuntime();
		try {
			Process process = runtime.exec(args);
			process.destroy();
		} catch (IOException ex) {
			System.err.println("Excepción de E/S");
			System.exit(-1);
		}
	}
}


