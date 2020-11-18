package ejemplos.ud02;

public class Profesor extends Thread {
	String nombre;
	Bienvenida saludo;
	
	public Profesor(String nombre, Bienvenida bienvenida) {
		this.nombre = nombre;
		this.saludo = bienvenida;
	}
	
	@Override
	public void run() {
		System.out.println(nombre + " llegó");
		try {
			Thread.sleep(1000);
			saludo.llegadaProfesor(nombre);
		} catch (InterruptedException ex) {
			System.err.println("Thread profesor interrumplido!");
			Thread.currentThread().interrupt();
			System.exit(-1);
		}
	}
}


