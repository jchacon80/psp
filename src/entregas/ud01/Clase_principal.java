package entregas.ud01;

/*Clase principal encargada de invocar a la secundaria , en esta clase encontramos todo
 * lo necesaria para poder realizar un intercambio de datos entre la clase hija y la clase padre
 *@version 1.3
 *@Enrique Albors
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Clase_principal {
	
	//Mi aplicación está pensada para dar servicio a los videoclubs . 
	//Se podrá alquilar y devoler peliculas , como  consultar el estado de estas.
	
	
	public static boolean isAlive(Process p) {
		
		// cmd /c" java -jar  C:\Users\Kike\Documents\ejecutables\claseSecundaria.jar"

		// comprobamos si el proceso hijo está funcionando , falso = terminado , si no
		// crea una excepcion y devuelve true

		try {
			p.exitValue();
			return false;
		} catch (IllegalThreadStateException e) {
			return true;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {
		
		
		
		ProcessBuilder builder = new ProcessBuilder("java" ,  "-jar" , "C:/Users/Kike/Documents/ejecutables/claseSecundaria.jar" ); // definimos el proceso que se va a ejecutar 
		//builder.redirectErrorStream(true); // redirige el buffer de error a la salida estándar
		Process process = builder.start(); // iniciamos el proceso
		InputStream out = process.getInputStream(); // configuramos la salida del proceso hijo
		OutputStream in = process.getOutputStream(); // configuramos la entrada del proceso hijo

		byte[] buffer = new byte[4000]; // buffer de comunicación entre procesos hará  de puente 
		
		while (isAlive(process)) {// se comprueba el stream de salida del proceso hijo
			int no = out.available();
			if (no > 0) {

				// si el stream de salida del proceso hijo tiene información se muestra por
				// pantalla
				int n = out.read(buffer, 0, Math.min(no, buffer.length));
				System.out.println(new String(buffer, 0, n));
			}

			// se comprueba si hay información para enviar al proceso hijo
			int ni = System.in.available();
			if (ni > 0) {

				// si existe información se envía al proceso hijo
				int n = System.in.read(buffer, 0, Math.min(ni, buffer.length));
				in.write(buffer, 0, n);
				in.flush();
			}
			
			 // se introduce un retardo de 10 milisegundos para que no haya colapsos
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}

		System.out.println(process.exitValue());
	}
}